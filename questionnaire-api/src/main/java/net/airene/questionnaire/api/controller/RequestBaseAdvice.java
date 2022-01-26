package net.airene.questionnaire.api.controller;

import net.airene.questionnaire.common.data.DTO.AllInOneDTO;
import net.airene.questionnaire.common.data.DTO.BaseRequestDTO;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import net.airene.questionnaire.common.service.RedisService;
import net.airene.questionnaire.common.util.JwtUtil;
import net.airene.questionnaire.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

@ControllerAdvice(basePackages = {"net.airene.questionnaire.api.controller.advice"})
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RequestBaseAdvice implements RequestBodyAdvice {

    private final HttpServletRequest request;

    private final RedisService redisService;

    private final JwtUtil jwtUtil;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (Objects.isNull(body) || !(body instanceof BaseRequestDTO)) {
            log.error("入参为空或者类未继承BaseRequestDTO！");
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }

        String methodName = parameter.getMethod().getName();
        String token = request.getHeader("token");
        BaseRequestDTO baseRequestDTO = (BaseRequestDTO) body;
        checkBaseRequestDTO(baseRequestDTO, token, methodName);
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    private void checkBaseRequestDTO(BaseRequestDTO baseRequestDTO, String token, String methodName) {
        if (StringUtils.isEmpty(baseRequestDTO.getApiVersion()) || StringUtils.isEmpty(baseRequestDTO.getCode())
                || StringUtils.isEmpty(baseRequestDTO.getVersion())) {
            log.error("入参参数为空！");
            throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
        }
        if (!"login".equals(methodName)) {
            if (StringUtils.isEmpty(token)) {
                log.error("token为空！");
                throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
            }
            String code = jwtUtil.getCODE(token);
            if (StringUtils.isEmpty(code)) {
                throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
            }
            if (!code.equals(baseRequestDTO.getCode())) {
                log.error("token:{}与code:{}不匹配", token, baseRequestDTO.getCode());
                throw new PrivateException(ErrorInfoEnum.PARAMS_ERROR);
            }
            // 校验渠道号
            AllInOneDTO allInOneInfo = redisService.getAllInOne(baseRequestDTO.getCode());
            if (Objects.isNull(allInOneInfo)) {
                log.error("token失效！");
                throw new PrivateException(ErrorInfoEnum.TOKEN_ERROR);
            }
            redisService.saveAllInOne(allInOneInfo);
        }
        // 校验ip地址
       /* String ip = IpVerifyUtils.getIp(request);
        if (!allInOneInfo.getIp().equals(ip)) {
            log.error("ip地址错误！");
            throw new PrivateException(ErrorInfo.PARAMS_ERROR);
        }*/
    }
}
