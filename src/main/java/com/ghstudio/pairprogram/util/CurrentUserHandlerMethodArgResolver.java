package com.ghstudio.pairprogram.util;


import com.ghstudio.pairprogram.dao.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class CurrentUserHandlerMethodArgResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(CurrentUser.class) != null && methodParameter.getParameterType() == User.class;
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        return request.getSession().getAttribute("currentUser");
    }
}
