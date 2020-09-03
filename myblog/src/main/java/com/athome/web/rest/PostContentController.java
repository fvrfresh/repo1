package com.athome.web.rest;

import com.athome.domain.*;
import com.athome.service.ArticleService;
import com.athome.utils.ArticleUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName PostContentController
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/22 19:51
 * @Version 1.0
 */
@RestController
@RequestMapping(path = "/posts",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class PostContentController {

    private ArticleService service;

    private StringRedisTemplate template;

    @Autowired
    public PostContentController(ArticleService service,StringRedisTemplate template) {
        this.service = service;
        this.template = template;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ArticleTransformed getPostContent(@RequestBody JsonNode title){
        System.out.println(title);
        Article rawArticle = service.findByTitle(title.get("data").asText());
        ArticleTransformed article = service.transformArticle(rawArticle);
        return article;
    }

    @PostMapping(value = "/carousel/{title}", consumes = "application/json",produces = "application/json")
    public ArticleTransformed getCarouselContent(@PathVariable("title") String title){
        Article rawArticle = service.findCarouselByTitle(title);
        ArticleTransformed article = service.transformArticle(rawArticle);
        return article;
    }

    @PostMapping(value = "/{postTitle}/comments/add",consumes = "application/json",produces = "application/json")
    public boolean addComment(@RequestBody JsonNode user, @PathVariable("postTitle") String postTitle){
        JsonNode data = user.get("data");
        Comment commentRaw = new Comment();
        commentRaw.setUsername(data.get("username").asText());
        commentRaw.setEmail(data.get("email").asText());
        commentRaw.setWebsite(data.get("website").asText());
        commentRaw.setContent(data.get("content").asText());
        commentRaw.setArticleTitle(postTitle);
        commentRaw.setCreatedAt(new Date());
        int result = service.addComment(commentRaw);
//        CommentTransformed comment = transformComment(commentRaw);
        return result > 0 ? true : false;
    }

    @PostMapping(value = "/{postTitle}/comments/addReply",consumes = "application/json",produces = "application/json")
    public boolean addReply(@RequestBody JsonNode user, @PathVariable("postTitle") String postTitle){
        JsonNode data = user.get("data");
        Comment commentRaw = new Comment();
        commentRaw.setUsername(data.get("username").asText());
        commentRaw.setEmail(data.get("email").asText());
        commentRaw.setWebsite(data.get("website").asText());
        commentRaw.setContent(data.get("content").asText());
        commentRaw.setArticleTitle(postTitle);
        commentRaw.setReplying(data.get("replying").asText());
        commentRaw.setCreatedAt(new Date());
        int result = service.addCommentReply(commentRaw);
        return result > 0 ? true : false;
    }



    @PostMapping(value = "/{postTitle}/comments/",consumes = "application/json",produces = "application/json")
    public Map<String, Object> getComments(@RequestBody JsonNode request, @PathVariable("postTitle") String postTitle){
        int start = request.get("data").get("start").asInt();
        int count = request.get("data").get("count").asInt();
        List<Comment> commentsForPost = service.findCommentsForPostByPage(postTitle,start,count);
        int total = service.countCommentsForPost(postTitle);
//        List<Comment> commentsForPost = service.findCommentsForPost(postTitle);
        List<CommentWrapper> commentWrappers = commentsForPost.stream().map(comment -> {
            Comment[] repliesForComment = service.findRepliesForComment(comment);
            CommentWrapper wrapper = new CommentWrapper();
            wrapper.setComment(transformComment(comment));
            wrapper.addAll(transformComments(repliesForComment));
            return wrapper;
        }).collect(Collectors.toList());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("comments",commentWrappers);
        resultMap.put("total",total);
        return resultMap;
    }

    @PostMapping(value = "/{postTitle}/increaseViewCount",consumes = "application/json",produces = "application/json")
    public boolean increaseViewCount(@RequestBody JsonNode request,@PathVariable("postTitle") String postTitle){
        Double count = request.get("data").asDouble();
        if (count.toString().equals("0.0")){
            return false;
        }

        Boolean isAdded = template.opsForZSet().add("viewCounter", postTitle, count);
        return isAdded;
    }

    @PostMapping(value = "/mostPopular",produces = "application/json")
    public List<ArticleTransformed> getMostViewedPosts(){
        Set<ZSetOperations.TypedTuple<String>> tuples = template.opsForZSet().reverseRangeByScoreWithScores("viewCounter", 0,Double.MAX_VALUE);
        List<Article> collect = tuples.stream().sorted(Comparator.comparing(ZSetOperations.TypedTuple::getScore, (el1, el2) -> {
            return el1 < el2 ? 1 : el1 > el2 ? -1 : 0;
        })).map(ZSetOperations.TypedTuple::getValue).map(str -> {
            return service.findByTitle(str);
        }).limit(3).collect(Collectors.toList());
        return service.transformArticles(collect);
    }



    private CommentTransformed transformComment(Comment comment){
        CommentTransformed transformed = new CommentTransformed();
        transformed.setId(comment.getId());
        transformed.setArticleTitle(comment.getArticleTitle());
        transformed.setContent(comment.getContent());
        transformed.setCreatedAt(ArticleUtil.formatTime(comment.getCreatedAt()));
        transformed.setEmail(comment.getEmail());
        transformed.setReplying(comment.getReplying());
        transformed.setWebsite(comment.getWebsite());
        transformed.setUsername(comment.getUsername());
        return transformed;
    }
    private List<CommentTransformed> transformComments(Comment[] comments){
        List<CommentTransformed> transformedList = Arrays.stream(comments).map(comment -> {
            CommentTransformed transformed = new CommentTransformed();
            transformed.setId(comment.getId());
            transformed.setArticleTitle(comment.getArticleTitle());
            transformed.setContent(comment.getContent());
            transformed.setCreatedAt(ArticleUtil.formatTime(comment.getCreatedAt()));
            transformed.setEmail(comment.getEmail());
            transformed.setReplying(comment.getReplying());
            transformed.setWebsite(comment.getWebsite());
            transformed.setUsername(comment.getUsername());
            return transformed;
        }).collect(Collectors.toList());

        return transformedList;
    }
}
