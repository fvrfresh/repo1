package com.athome.mapper;

import com.athome.domain.Quote;
import com.athome.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SidebarMapper {
    List<Integer> getAllIds();
    Quote findOne(int id);

    int count();

    List<Tag> findPostsWithTag(String tag);

    List<String> getAllTags();
}
