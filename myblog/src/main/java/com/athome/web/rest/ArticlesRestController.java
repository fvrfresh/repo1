package com.athome.web.rest;

import com.athome.domain.Article;
import com.athome.domain.ArticleTransformed;
import com.athome.domain.Comment;
import com.athome.domain.CommentTransformed;
import com.athome.service.ArticleService;
import com.athome.utils.ArticleUtil;
import com.athome.utils.FilesUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName ArticlesController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/17 18:36
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/articles",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class ArticlesRestController {

    @Autowired
    private ArticleService service;

    @Autowired
    private FilesUtil filesUtil;

    @PostMapping(value = "/outline",consumes = "application/json",produces = "application/json")
    public Map<Object,Object> articleOutline(@RequestBody JsonNode request){
        int start = request.get("data").get("start").asInt();
        int count = request.get("data").get("count").asInt();
        int articleNum = service.count("article");
        List<ArticleTransformed> articles = service.findPartByPage(start,count);
        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("articles",articles);
        resultMap.put("total",articleNum);
        return resultMap;
    }


    @PostMapping(value = "/carousel",consumes = "application/json",produces = "application/json")
    public List<ArticleTransformed> articleOutline(){
        List<ArticleTransformed> articles = service.findCarousel(0,3);
        return articles;
    }

    @PostMapping(value ="/all",consumes = "application/json", produces = "application/json")
    public Map<String, Object> getAllPostsByPage(@RequestBody JsonNode request){
        int start = request.get("data").get("start").asInt();
        int count = request.get("data").get("count").asInt();
        int totalArticleNum = service.countAll();
        List<ArticleTransformed> articles = service.findAllArticlesByPage(start,count);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("articles",articles);
        resultMap.put("total",totalArticleNum);
        return resultMap;
    }

    @PostMapping(value = "/mostRecent",consumes = "application/json",produces = "application/json")
    public List<ArticleTransformed> mostRecent(@RequestBody JsonNode request){
        List<ArticleTransformed> articles = service.findMostRecent();
        return articles;
    }

    @PostMapping(value = "/mostRecentComments",consumes = "application/json",produces = "application/json")
    public HashMap<String, Object> mostRecentComments(@RequestBody JsonNode request){
        List<Comment> mostRecentComments = service.findMostRecentComments();
        ArrayList<String> logos = new ArrayList<>();
        List<CommentTransformed> collect = mostRecentComments.stream().map(el -> {
            String logoFile = service.findPartByTitle(el.getArticleTitle()).getLogoFile();
            logos.add(logoFile);
            CommentTransformed transformed = new CommentTransformed();
            transformed.setUsername(el.getUsername());
            transformed.setWebsite(el.getWebsite());
            transformed.setCreatedAt(ArticleUtil.formatTime(el.getCreatedAt()));
            transformed.setArticleTitle(el.getArticleTitle());
            return transformed;
        }).collect(Collectors.toList());
        HashMap<String, Object> resultMaps = new HashMap<>();
        resultMaps.put("comments", collect);
        resultMaps.put("articleLogos", logos);
        return resultMaps;
    }

    @PostMapping("/hasPreOrNext")
    public Map<String, Object> hasPrevious(@RequestBody JsonNode title){
        List<Article> articleList = service.findAllTitles();
        String articleTitle = title.get("data").asText();
        int index = 0;
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getTitle().equals(articleTitle)){
                index = i;
            }
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("previous",null);
        resultMap.put("next", null);
        if ((index -1) >= 0){
            resultMap.put("previous", articleList.get(index - 1));
        }
        if ((index + 1) <= articleList.size() - 1){
            resultMap.put("next", articleList.get(index + 1));
        }
        return resultMap;
    }

}
