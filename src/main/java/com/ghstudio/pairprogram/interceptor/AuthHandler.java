package com.ghstudio.pairprogram.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghstudio.pairprogram.dao.entity.Route;
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
import java.util.List;

public class AuthHandler implements HandlerInterceptor {
    UserRepository userRepository;
    Token token;

    public AuthHandler(UserRepository userRepository, Token token) {
        this.userRepository = userRepository;
        this.token = token;
    }

    // TODO 设置 token start with
    private String getAuthorizationFromHeader(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("HERE ")) {
            return null;
        }

        final String[] tokenArray = token.split(" ");
        if (tokenArray.length < 2) {
            return null;
        }

        return tokenArray[1];
    }

    private void parseTokenError(HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter printWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        printWriter.append(mapper.writeValueAsString(Result.error(ResultEnum.PARSE_TOKEN_ERROR)));
        printWriter.flush();
    }

    private void authError(HttpServletResponse response) throws IOException {
        response.setStatus(403);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        PrintWriter printWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        printWriter.append(mapper.writeValueAsString(Result.error(ResultEnum.AUTH_ERROR)));
        printWriter.flush();
    }

    private boolean judgeUserAuth(Route route, String path, String method) {
        return path.matches("^" + route.getPath() + "$") && method.equalsIgnoreCase(route.getMethod());
    }

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
            final List<Route> routes = user.getRole().getRouteList();
            final String path = request.getRequestURI();
            final String method = request.getMethod();

            boolean flag = false;
            for (Route route : routes) {
                if (judgeUserAuth(route, path, method)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                authError(response);
                return false;
            }

            request.getSession().setAttribute("currentUser", user);
            return true;
        } catch (Exception e) {
            parseTokenError(response);
            return false;
        }
    }
}
