package com.athome.handler;

import com.athome.security.UserRepositoryUserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TokenClearLogoutHandler
 * @Description TODO
 * @Author zhang
 * @Date 2020/9/2 11:20
 * @Version 1.0
 */
public class TokenClearLogoutHandler implements LogoutHandler {

    private UserRepositoryUserDetailsService jwtUserService;

    public TokenClearLogoutHandler(UserRepositoryUserDetailsService jwtUserService) {
        this.jwtUserService = jwtUserService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        clearToken(authentication);
    }

    protected void clearToken(Authentication authentication) {
        if(authentication == null)
            return;
        UserDetails user = (UserDetails)authentication.getPrincipal();
        if(user!=null && user.getUsername()!=null)
            jwtUserService.deleteUserLoginInfo(user.getUsername());
    }

}
