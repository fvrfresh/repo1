package com.athome.mapper;

import com.athome.domain.Article;
import com.athome.domain.Comment;
import com.athome.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ArticleMapper {

    int count(@Param("tableName") String table);
    Article findOne(int id);
    Article findByTitle(String title);
    int addArticle(Article article);
    List<Article> findPartByPage(int start, int count);
    List<Article> findRecycleByPage(int start, int count);

    Article findPartByTitle(String title);

    int deleteByTitle(String title);

    int addRecycleArticle(Article article);

    int deleteRecycleByTitle(String title);

    Article findRecycleByTitle(String title);

    int updateArticle(Article uArticle);

    Date getCreatedAt(String title);

    int countByCategory(@Param("article") String article, @Param("category") String category);

    List<Article> findCategoryByPage(@Param("start") int start,@Param("count") int count,@Param("category") String category);

    List<Article> findAll();

    List<Article> findAllTitles();

    int addComment( Comment data);

    List<Comment> findCommentsForPost(String postTitle);

    Comment[] findRepliesForComment(Comment comment);

    List<Comment> findCommentsForPostByPage(@Param("postTitle") String postTitle, @Param("start") int start, @Param("count") int count);

    int countCommentsForPost(String postTitle);

    int addCommentReply(Comment commentRaw);

    List<Article> findMostRecent();

    List<Comment> findMostRecentComments();

    List<Map<String,Object>> findAllCategories();

    int countAll();

    List<String> findAllImages();

    List<Map<String,String>> findCategoryForImage();

    int addFeaturedArticle(Article post);

    List<Article> findCarousel(int start, int count);

    Article findCarouselByTitle(String title);
}
