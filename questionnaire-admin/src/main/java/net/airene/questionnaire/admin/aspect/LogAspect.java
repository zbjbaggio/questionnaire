package net.airene.questionnaire.admin.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.annotation.LogRecord;
import net.airene.questionnaire.admin.utils.ValueHolder;
import net.airene.questionnaire.common.data.entity.system.SystemOperationLog;
import net.airene.questionnaire.common.mapper.system.SystemOperationLogMapper;
import net.airene.questionnaire.common.util.ExecutorUtils;
import net.airene.questionnaire.common.util.IpVerifyUtils;
import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class LogAspect {

    private long startTime = 0; // 开始时间

    private final ValueHolder valueHolder;

    private final SystemOperationLogMapper systemOperationLogMapper;

    @Pointcut("execution (public * net.airene.questionnaire.admin.controller..*.*(..)) && !execution(* net.airene.questionnaire.admin.controller.ExceptionControllerAdvice.*(..))  ")
    private void aspectMethod(){}

    @Around("aspectMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        log.info("日志【请求】－－－－－userId : " + valueHolder.getUserIdHolder() + "－－－－－－方法为:" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "      参数为：" + Arrays.toString(point.getArgs()));
        Object returnValue = new Object();
        try {
            returnValue = point.proceed();
        } catch (Throwable throwable) {
            log.error("日志【异常】－－－－－－－－－－－方法为:" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "      返回值为：" + returnValue + "【共耗时-" + (System.currentTimeMillis() - startTime) + "-毫秒】");
            throw throwable;
        }
        log.info("日志【返回】－－－－－－－－－－－方法为:" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName() + "      返回值为：" + returnValue + "【共耗时-" + (System.currentTimeMillis() - startTime) + "-毫秒】");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Long userId = valueHolder.getUserIdHolder();
        ExecutorUtils.async(() -> {
            recordLog(point, request, userId);
        });
        return returnValue;
    }

    private void recordLog(JoinPoint point, HttpServletRequest request, Long userId) {
        try {
            CodeSignature signature = (CodeSignature) point.getSignature();
            String className = signature.getDeclaringTypeName();
            String methodName = signature.getName();
            Class[] argsClass = signature.getParameterTypes();
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, argsClass);
            LogRecord logRecord = method.getAnnotation(LogRecord.class);
            if (logRecord != null) {
                Object[] args = point.getArgs();
                List<Object> objects = Arrays.asList(args);
                List<Object> params = new ArrayList<>();
                String url = request.getRequestURI();
                String ip = IpVerifyUtils.getIp(request);
                for (Object object : objects) {
                    if (object instanceof RequestFacade || object instanceof BindingResult) {
                        continue;
                    }
                    params.add(object);
                }
                //记录操作日志
                SystemOperationLog systemOperationLog = new SystemOperationLog();
                systemOperationLog.setUserId(userId);
                systemOperationLog.setOperationName(logRecord.value());
                systemOperationLog.setUrl(url);
                systemOperationLog.setIp(ip);
                systemOperationLog.setParams(JSONObject.toJSONString(params));
                systemOperationLog.setCreateTime(LocalDateTime.now());
                systemOperationLogMapper.insertSystemOperationLog(systemOperationLog);
            }
        } catch (Throwable e) {
            log.error("{},Throwable 日志记录失败！", point.getSignature().getName(), e);
        }
    }

}
