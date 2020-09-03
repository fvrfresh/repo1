package com.athome.handler;

import com.athome.security.UserRepositoryUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName JsonLoginSuccessHandler
 * @Description TODO
 * @Author zhang
 * @Date 2020/9/2 10:23
 * @Version 1.0
 */
public class JsonLoginSuccessHandler implements AuthenticationSuccessHandler {

    private UserRepositoryUserDetailsService jwtUserService;

    public JsonLoginSuccessHandler(UserRepositoryUserDetailsService jwtUserService) {
        this.jwtUserService = jwtUserService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //生成token，并把token加密相关信息缓存，具体请看实现类
        String token = jwtUserService.saveUserLoginInfo((UserDetails)authentication.getPrincipal());
        response.setHeader("Authorization", token);
    }

}

