package com.athome.service;

import com.athome.domain.Admin;
import com.athome.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/31 15:53
 * @Version 1.0
 */

@Service
public class AdminService {

    @Autowired
    AdminMapper mapper;

    @Transactional
    public Admin findByUsername(String username){
        return mapper.findByUsername(username);
    }

    public void save(Admin user) {
        mapper.save(user);
    }
}
