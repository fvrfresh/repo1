package com.athome.web.rest;

import com.athome.domain.Article;
import com.athome.domain.ArticleTransformed;
import com.athome.service.ArticleService;
import com.athome.utils.ArticleUtil;
import com.athome.utils.FilesUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName ArticlesController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/17 18:36
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/admin/articles",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class AdminArticlesController {

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

    @PostMapping(value = "/recycled",consumes = "application/json",produces = "application/json")
    public Map<Object,Object> articleRecycled(@RequestBody JsonNode request){
        int articleNum = service.count("article_deleted");
        List<ArticleTransformed> articles = service.findRecycleByPage(request.get("data").get("start").asInt(),request.get("data").get("count").asInt());
        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("articles",articles);
        resultMap.put("total",articleNum);
        return resultMap;
    }

    @PostMapping(value = "/validateTitle",consumes = "application/json")
    public boolean validateTitle(@RequestBody JsonNode title){
        Optional<Article> article = Optional.ofNullable(service.findByTitle(title.get("data").asText()));
        return article.isPresent() ? false : true;
    }

    @PostMapping(value = "/edit",consumes = "application/json",produces = "application/json")
    public Article getArticle(@RequestBody JsonNode title){
        Article article = service.findPartByTitle(title.get("data").asText());
        article = ArticleUtil.buildArticle(article);
        return article;
    }

    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public boolean updateArticle(@RequestBody JsonNode article){
        JsonNode data = article.get("data");
        String articleTitle = data.get("title").asText();
        String category = data.get("category").asText();
        String description = data.get("description").asText();
        String content = data.get("content").asText();
        Article uArticle = new Article(articleTitle, category, description, content);
        Date createdAt = service.getCreatedAt(uArticle.getTitle());
        uArticle.setCreatedAt(createdAt);
        String articleFile = filesUtil.writePostToFile(uArticle);
        uArticle = ArticleUtil.buildArticleHtml(uArticle);
        uArticle.setContent(articleFile);
        int result = service.updateArticle(uArticle);
        return result == 0 ? false : true;
    }

    @PostMapping(value = "/delete",consumes = "application/json",produces = "application/json")
    public boolean deleteArticle(@RequestBody JsonNode title){
        String text = title.get("data").asText();
        Article article = service.findByTitle(text);
        article.setDeletedAt(new Date());
        int result = service.deleteByTitle(text);
        service.addRecycleArticle(article);
        return result == 0 ? false : true;
    }

    @PostMapping(value = "/restore",consumes = "application/json",produces = "application/json")
    public boolean restoreArticle(@RequestBody JsonNode title){
        Article article = service.findRecycleByTitle(title.get("data").asText());
        article.setDeletedAt(null);
        service.addArticle(article);
        int result = service.deleteRecycleByTitle(title.get("data").asText());
        return result == 0 ? false : true;
    }



    @PostMapping(value = "/deleteRecycle",consumes = "application/json",produces = "application/json")
    public boolean deleteRecycleArticle(@RequestBody JsonNode title){
        int result = service.deleteRecycleByTitle(title.get("data").asText());
        return result == 0 ? false : true;
    }



}
