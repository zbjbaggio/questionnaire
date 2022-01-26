package net.airene.questionnaire.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.ResponseResult;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/**
 * 异常处理
 * Created by eason on 2016-10-25.
 */
@ControllerAdvice(basePackages = "net.airene.questionnaire.admin.controller.advice")
@Slf4j
public class ExceptionControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResponseResult.ok(body);
    }

    @ExceptionHandler()
    @ResponseBody
    public ResponseResult handler(MethodArgumentNotValidException e) {
        if (e.getBindingResult().hasErrors()) {
            List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
            log.info("参数错误:{}", allErrors);
        }
        return ResponseResult.build(ErrorInfoEnum.PARAMS_ERROR);
    }


    @ExceptionHandler()
    @ResponseBody
    public ResponseResult handler(PrivateException e) {
        log.info(e.toString());
        return ResponseResult.build(e.getCode(), e.getMsg());
    }

    @ExceptionHandler()
    @ResponseBody
    public ResponseResult handler(UnauthorizedException e) {
        log.info(e.getMessage());
        return ResponseResult.build(ErrorInfoEnum.NO_AUTHORITY);
    }

    @ExceptionHandler()
    @ResponseBody
    public ResponseResult handler(Exception e) {
        log.error("系统异常！", e);
        return ResponseResult.build(ErrorInfoEnum.ERROR);
    }
}
