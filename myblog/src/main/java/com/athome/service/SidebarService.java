package com.athome.service;

import com.athome.domain.Quote;
import com.athome.domain.Tag;
import com.athome.mapper.SidebarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/14 21:39
 * @Version 1.0
 */
@Service
public class SidebarService {

    @Autowired
    SidebarMapper mapper;

    @Transactional
    public Quote findOne(int id){
        return mapper.findOne(id);
    }

    @Transactional
    public List<Integer> getAllIds(){
        return mapper.getAllIds();
    }

    @Transactional
    public int count(){
        return mapper.count();
    }

    @Transactional
    public List<Tag> findPostsWithTag(String tag){
        return mapper.findPostsWithTag(tag);
    }

    public List<String> getAllTags() {
        return mapper.getAllTags();
    }
}
