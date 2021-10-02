package com.ghstudio.pairprogram.util;


import com.ghstudio.pairprogram.dao.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * CurrentUserHandlerMethodArgResolver 自定义参数解析器实现 @CurrentUser
 */
public class CurrentUserHandlerMethodArgResolver implements HandlerMethodArgumentResolver {
    /**
     * supportsParameter 支持参数
     *
     * @param methodParameter 实参
     * @return boolean
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null && methodParameter.getParameterType() == User.class;
    }

    /**
     * resolveArgument 分解实参 从 Session 中获取对应 User 信息
     *
     * @param methodParameter       methodParameter
     * @param modelAndViewContainer modelAndViewContainer
     * @param nativeWebRequest      nativeWebRequest
     * @param webDataBinderFactory  webDataBinderFactory
     * @return Object
     */
    @Override
    public Object resolveArgument(@NotNull MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        return request.getSession().getAttribute("currentUser");
    }
}
