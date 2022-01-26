package net.airene.questionnaire.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution (*  net.airene.questionnaire.api.controller..*Controller.*(..))")
    private void aspectMethod() {

    }

    @Around("aspectMethod()")
    public Object monitorAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        log.info("{} 参数：{}", classMethod, args);
        Object re = joinPoint.proceed();
        log.info("{} 返回值：{}，耗时：{}ms", classMethod, re, System.currentTimeMillis() - startTime);
        return re;
    }

}
