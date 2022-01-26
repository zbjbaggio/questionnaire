package net.airene.questionnaire.api.controller;

import net.airene.questionnaire.common.data.PrivateException;
import net.airene.questionnaire.common.data.ResponseResult;
import net.airene.questionnaire.common.enums.ErrorInfoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Nullable;

@ControllerAdvice(basePackages = {"net.airene.questionnaire.api.controller.advice"})
@Slf4j
public class ResponseBaseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @ExceptionHandler
    @ResponseBody
    public Object handler(PrivateException e) {
        log.error("错误返回：", e);
        return ResponseResult.build(e.getCode(), e.getMsg());
    }

    @ExceptionHandler
    @ResponseBody
    public Object handler(Exception e) {
        log.error("系统异常！", e);
        return ResponseResult.build(ErrorInfoEnum.ERROR);
    }

    @ExceptionHandler
    @ResponseBody
    public Object handler(MethodArgumentNotValidException e) {
        StringBuilder messages = new StringBuilder();
        for (ObjectError allError : e.getBindingResult().getAllErrors()) {
            if (allError instanceof FieldError) {
                FieldError fieldError = (FieldError) allError;
                messages.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage());
            } else {
                messages.append(allError.getDefaultMessage());
            }
        }
        log.error("参数错误：{}", messages.toString());
        return ResponseResult.build(ErrorInfoEnum.PARAMS_ERROR);
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResponseResult.ok(body);
    }
}
