package com.athome.mapper;

import com.athome.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper{
    Admin findByUsername(String username);

    void save(Admin user);
}
