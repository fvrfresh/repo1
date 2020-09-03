package com.athome;

import com.athome.storage.StorageProperties;
import com.athome.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MyblogApplication implements WebMvcConfigurer{

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/archive/images/**","/archive/js/**","/archive/css/**").addResourceLocations("classpath:/static/images/","classpath:/static/js/","classpath:/static/css/");
        registry.addResourceHandler("/category/images/**","/articles/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/tags/queryTags/images/**").addResourceLocations("classpath:/static/images/");

    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
