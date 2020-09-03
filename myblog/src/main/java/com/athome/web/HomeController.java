package com.athome.web;

import com.athome.security.UserRepositoryUserDetailsService;
import com.athome.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/5 12:40
 * @Version 1.0
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepositoryUserDetailsService userDetailsService;

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("album")
    public String album(Model model){
        model.addAttribute("album","ALBUM");
        return "album";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String loginPost(){
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            return "admin";
        }
        return "redirect:login";
    }
}
