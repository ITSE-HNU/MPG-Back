package com.ghstudio.pairprogram.interceptor;

import com.ghstudio.pairprogram.util.Result;
import com.ghstudio.pairprogram.util.ResultEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ExceptionHandler Http 异常监控
 */
@ControllerAdvice
public class ExceptionHandler {
    /**
     * HttpMessageNotReadableExceptionHandler Http 请求处理异常
     *
     * @param e HttpMessageNotReadableException
     * @return Result<errorMessage> 返回体
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public Result<String> HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        return Result.error(ResultEnum.ARGUMENT_ERROR, e.getMessage());
    }

    /**
     * argumentExceptionHandler 参数异常
     *
     * @param e MethodArgumentNotValidException 参数不匹配异常
     * @return Result<errorMessage> 返回体
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<String> argumentExceptionHandler(MethodArgumentNotValidException e) {
        return Result.error(ResultEnum.ARGUMENT_ERROR, e.getMessage());
    }
}
