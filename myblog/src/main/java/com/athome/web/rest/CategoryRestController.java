package com.athome.web.rest;

import com.athome.domain.ArticleTransformed;
import com.athome.service.ArticleService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CategoryRestController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/23 14:38
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/articles/category",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class CategoryRestController {

    @Autowired
    private ArticleService service;

    @PostMapping(consumes = "application/json",produces = "application/json")
    public Map<Object,Object> getCategory(@RequestBody JsonNode request){
        int start = request.get("data").get("start").asInt();
        int count = request.get("data").get("count").asInt();
        String category = request.get("data").get("category").asText();
        int articleNum = service.countByCategory("article",category);
        List<ArticleTransformed> articles = service.findCategoryByPage(start,count,category);
        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("articles",articles);
        resultMap.put("total",articleNum);
        return resultMap;
    }

    @PostMapping(value = "/all", consumes = "application/json",produces = "application/json")
    public List<Map<String, Object>> getAllCategories(){
        List<Map<String, Object>> allCategories = service.findAllCategories();
        return allCategories;
    }

}
