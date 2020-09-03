package com.athome.security;

import com.athome.domain.Admin;
import com.athome.service.AdminService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private AdminService adminService;

    @Autowired
    public UserRepositoryUserDetailsService(AdminService adminService){
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminService.findByUsername(username);
        if (user != null){
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    public String saveUserLoginInfo(UserDetails user) {
        String salt = "123456ef"; //BCrypt.gensalt();  正式开发时可以调用该方法实时生成加密的salt
        /**
         * @todo 将salt保存到数据库或者缓存中
         * redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
         */
        Algorithm algorithm = Algorithm.HMAC256(salt);
        Date date = new Date(System.currentTimeMillis()+3600*1000*10);  //设置1小时后过期
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    public UserDetails getUserLoginInfo(String username) {
        String salt = "123456ef";
        UserDetails user = loadUserByUsername(username);
        //将salt放到password字段返回
        return User.builder().username(user.getUsername()).password(salt).authorities(user.getAuthorities()).build();
    }

    public void deleteUserLoginInfo(String username) {
    }
}
