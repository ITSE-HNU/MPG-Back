package com.ghstudio.pairprogram.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghstudio.pairprogram.dao.entity.User;
import com.ghstudio.pairprogram.dao.repository.UserRepository;
import com.ghstudio.pairprogram.util.Result;
import com.ghstudio.pairprogram.util.ResultEnum;
import com.ghstudio.pairprogram.util.Token;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * AuthHandler 资源访问权限拦截器
 */
public class AuthHandler implements HandlerInterceptor {
    UserRepository userRepository;
    Token token;

    /**
     * AuthHandler constructor
     *
     * @param userRepository userRepository
     * @param token          token
     */
    public AuthHandler(UserRepository userRepository, Token token) {
        this.userRepository = userRepository;
        this.token = token;
    }

    /**
     * getAuthorizationFromHeader 获取 Http 请求头中携带的 token
     *
     * @param request http request
     * @return token string
     */
    private String getAuthorizationFromHeader(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("mpg ")) {
            return null;
        }

        final String[] tokenArray = token.split(" ");
        if (tokenArray.length < 2) {
            return null;
        }

        return tokenArray[1];
    }

    /**
     * parseTokenError token 解析失败
     *
     * @param response HttpServletResponse http 响应
     * @throws IOException IO 异常
     */
    private void parseTokenError(HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter printWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        printWriter.append(mapper.writeValueAsString(Result.error(ResultEnum.PARSE_TOKEN_ERROR)));
        printWriter.flush();
    }

    /**
     * preHandle 拦截 token 设置 currentUser
     *
     * @param request  http request
     * @param response http response
     * @param handler  指 controller 的 @RestController 注解下的"完整"方法名, 包含exception等字段信息
     * @return boolean
     * @throws Exception token 解析失败
     */
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        final String tokenString = getAuthorizationFromHeader(request);
        if (tokenString == null) {
            parseTokenError(response);
            return false;
        }

        try {
            final int id = token.verify(tokenString);
            User user = userRepository.getUserByID(id);
            request.getSession().setAttribute("currentUser", user);
            return true;
        } catch (Exception e) {
            parseTokenError(response);
            return false;
        }
    }
}
