package com.athome.web.rest;

import com.athome.domain.Article;
import com.athome.domain.ArticleTransformed;
import com.athome.domain.Quote;
import com.athome.domain.Tag;
import com.athome.service.ArticleService;
import com.athome.service.SidebarService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName QuoteController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/26 18:03
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/sidebar",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class SidebarController {

    @Autowired
    SidebarService service;

    @Autowired
    ArticleService articleService;

    @PostMapping(value = "/quote", consumes = "application/json",produces = "application/json")
    public Quote getQuote(){
        List<Integer> allIds = service.getAllIds();
        int index = getRandomInt(service.count());
        return service.findOne(allIds.get(index));
    }

    @PostMapping(value = "/tags", consumes = "application/json",produces = "application/json")
    public List<String> getAllTags(){
        return service.getAllTags();
    }

    @PostMapping(value = "/tags/{tags}", consumes = "application/json",produces = "application/json")
    public Map<Object,Object> getTagPage(@PathVariable("tags") String tags){
        Set<String> individualTags = Arrays.stream(tags.split("&")).collect(Collectors.toSet());
        Set<String> collectedTitles = individualTags.stream().flatMap(tag -> {
            List<Tag> postsWithTag = service.findPostsWithTag(tag);
            postsWithTag = postsWithTag == null ? new LinkedList<>() : postsWithTag;
            return postsWithTag.stream();
        }).map(tag -> {
            return tag.getArticle_title();
        }).collect(Collectors.toSet());
        Set<ArticleTransformed> postWithGivenTags = collectedTitles.stream().map(str -> {
            Article article = articleService.findByTitle(str);
            return article;
        }).map(article -> {
            return articleService.transformArticle(article);
        }).collect(Collectors.toSet());
        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("articles",postWithGivenTags);
        resultMap.put("total",postWithGivenTags.size());
        return resultMap;
    }

    private Integer getRandomInt(int max) {
        double ranNum = Math.floor(Math.random() * Math.floor(max));
        String s = String.valueOf(ranNum);
        return Integer.valueOf(s.substring(0,s.length() - 2));
    }

}
