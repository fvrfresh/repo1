package com.athome.web.rest;

import com.athome.domain.AuthenticationRequest;
import com.athome.domain.AuthenticationResponse;
import com.athome.security.UserRepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author zhang
 * @Date 2020/9/1 11:18
 * @Version 1.0
 */

@RequestMapping("/login")
@CrossOrigin("*")
public class LoginRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepositoryUserDetailsService userDetailsService;

    /*@Autowired
    private JwtUtil jwtUtil;*/



    /*@PostMapping
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return "admin";
    }*/

}
