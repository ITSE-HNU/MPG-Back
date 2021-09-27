package com.ghstudio.pairprogram.config;

import com.ghstudio.pairprogram.dao.repository.UserRepository;
import com.ghstudio.pairprogram.interceptor.AuthHandler;
import com.ghstudio.pairprogram.util.CurrentUserHandlerMethodArgResolver;
import com.ghstudio.pairprogram.util.Token;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Component
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Resource
    UserRepository userRepository;

    @Resource
    Token token;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthHandler(userRepository, token)).
                addPathPatterns("/**").
                excludePathPatterns("/login", "/register", "/verify");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserHandlerMethodArgResolver());
    }
}
