package com.athome.service;

import com.athome.domain.Article;
import com.athome.domain.ArticleTransformed;
import com.athome.domain.Comment;
import com.athome.mapper.ArticleMapper;
import com.athome.utils.ArticleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/14 21:39
 * @Version 1.0
 */
@Service
public class ArticleService {

    @Autowired
    ArticleMapper mapper;

    @Transactional
    public Article findOne(int id){
        return mapper.findOne(id);
    }

    @Transactional
    public Article findByTitle(String title){
        return mapper.findByTitle(title);
    }

    @Transactional
    public int count(String table){
        return mapper.count(table);
    }

    @Transactional
    public boolean addArticle(Article article){
        int result = mapper.addArticle(article);
        return result > 0 ? true : false;
    }


    @Transactional
    public List<ArticleTransformed> findPartByPage(int start, int count){
        List<Article> articleList = mapper.findPartByPage(start, count);
        List<ArticleTransformed> transformedList = transformArticles(articleList);
        return transformedList;
    }

    @Transactional
    public List<ArticleTransformed> findRecycleByPage(int start, int count){
        List<Article> articleList = mapper.findRecycleByPage(start, count);
        List<ArticleTransformed> transformedList = transformRecycleArticles(articleList);
        return transformedList;
    }

    public List<ArticleTransformed> transformArticles(List<Article> articleList) {
        List<ArticleTransformed> transformedList = articleList.stream().map((Article article) -> {
            ArticleTransformed article2 = new ArticleTransformed();
            article2.setId(article.getId());
            article2.setCategory(article.getCategory());
            article2.setContent(article.getContent());
            article2.setCreatedAt(ArticleUtil.formatTime(article.getCreatedAt()));
            article2.setTitle(article.getTitle());
            article2.setHtmlString(article.getHtmlString());
            article2.setDescription(article.getDescription());
            article2.setLogoFile(article.getLogoFile());
            return article2;
        }).collect(Collectors.toList());
        return transformedList;
    }

    public ArticleTransformed transformArticle(Article article) {
        ArticleTransformed article2 = new ArticleTransformed();
        article2.setId(article.getId());
        article2.setCategory(article.getCategory());
        article2.setContent(article.getContent());
        article2.setCreatedAt(ArticleUtil.formatTime(article.getCreatedAt()));
        article2.setTitle(article.getTitle());
        article2.setHtmlString(article.getHtmlString());
        article2.setDescription(article.getDescription());
        article2.setLogoFile(article.getLogoFile());
        return article2;
    }

    private List<ArticleTransformed> transformRecycleArticles(List<Article> articleList) {
        List<ArticleTransformed> transformedList = articleList.stream().map((Article article) -> {
            ArticleTransformed article2 = new ArticleTransformed();
            article2.setId(article.getId());
            article2.setCategory(article.getCategory());
            article2.setContent(article.getContent());
            article2.setCreatedAt(ArticleUtil.formatTime(article.getCreatedAt()));
            article2.setTitle(article.getTitle());
            article2.setHtmlString(article.getHtmlString());
            article2.setDescription(article.getDescription());
            article2.setDeletedAt(ArticleUtil.formatTime(article.getDeletedAt()));
            article2.setLogoFile(article.getLogoFile());
            return article2;
        }).collect(Collectors.toList());
        return transformedList;
    }


    @Transactional
    public Article findPartByTitle(String title) {
        return mapper.findPartByTitle(title);
    }

    @Transactional
    public int deleteByTitle(String title) {
        return mapper.deleteByTitle(title);
    }

    @Transactional
    public boolean addRecycleArticle(Article article) {
        int result = mapper.addRecycleArticle(article);
        return result > 0 ? true : false;
    }

    @Transactional
    public int deleteRecycleByTitle(String title) {
        int result = mapper.deleteRecycleByTitle(title);
        return result;
    }

    @Transactional
    public Article findRecycleByTitle(String title) {
        return mapper.findRecycleByTitle(title);
    }

    @Transactional
    public int updateArticle(Article uArticle) {
        return mapper.updateArticle(uArticle);
    }

    @Transactional
    public Date getCreatedAt(String title) {
        return mapper.getCreatedAt(title);
    }

    @Transactional
    public int countByCategory(String article,String category) {
        return mapper.countByCategory(article,category);
    }

    @Transactional
    public List<ArticleTransformed> findCategoryByPage(int start, int count, String category) {
        List<Article> articleList = mapper.findCategoryByPage(start, count, category);
        return transformArticles(articleList);
    }

    @Transactional
    public List<Article> findAll() {
        return mapper.findAll();
    }

    @Transactional
    public List<Article> findAllTitles() {
        return mapper.findAllTitles();
    }

    @Transactional
    public int addComment(Comment data) {
        return mapper.addComment(data);
    }

    @Transactional
    public List<Comment> findCommentsForPost(String postTitle) {
        return mapper.findCommentsForPost(postTitle);
    }

    @Transactional
    public Comment[] findRepliesForComment(Comment comment) {
        return mapper.findRepliesForComment(comment);
    }

    @Transactional
    public List<Comment> findCommentsForPostByPage(String postTitle,int start,int count) {
        return mapper.findCommentsForPostByPage(postTitle,start,count);
    }

    @Transactional
    public int countCommentsForPost(String postTitle) {
        return mapper.countCommentsForPost(postTitle);
    }

    @Transactional
    public int addCommentReply(Comment commentRaw) {
        return mapper.addCommentReply(commentRaw);
    }

    @Transactional
    public List<ArticleTransformed> findMostRecent() {
        List<Article> articleList = mapper.findMostRecent();
        List<ArticleTransformed> transformedList = transformArticles(articleList);
        return transformedList;
    }

    @Transactional
    public List<Comment> findMostRecentComments() {
        return mapper.findMostRecentComments();
    }

    @Transactional
    public List<Map<String, Object>> findAllCategories() {
        return mapper.findAllCategories();
    }

    @Transactional
    public int countAll() {
        return mapper.countAll();
    }

    @Transactional
    public List<ArticleTransformed> findAllArticlesByPage(int start, int count) {
        List<Article> articles = mapper.findPartByPage(start,count);
        return transformArticles(articles);

    }

    public List<String> findAllImages() {

        return mapper.findAllImages();
    }

    @Transactional
    public List<Map<String, String>> findCategoryForImage() {
        return mapper.findCategoryForImage();
    }

    @Transactional
    public int addFeaturedArticle(Article post) {
        return mapper.addFeaturedArticle(post);
    }

    @Transactional
    public List<ArticleTransformed> findCarousel(int start, int count) {
        List<Article> articleList = mapper.findCarousel(start, count);
        List<ArticleTransformed> transformedList = transformArticles(articleList);
        return transformedList;
    }

    public Article findCarouselByTitle(String title) {
        return mapper.findCarouselByTitle(title);
    }
}
