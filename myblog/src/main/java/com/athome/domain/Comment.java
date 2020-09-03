package com.athome.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/24 10:29
 * @Version 1.0
 */
public class Comment {
    private int id;
    private String username;
    private String content;
    private String email;
    private String website;
    private String articleTitle;
    private String replying;
    private Date createdAt;

    public Comment() {
    }

    public Comment(String username, String content, String email, String website, String articleTitle, Date createdAt) {
        this.username = username;
        this.content = content;
        this.email = email;
        this.website = website;
        this.articleTitle = articleTitle;
        this.createdAt = createdAt;
    }

    public Comment(String username, String content, String email, String website, String articleTitle, String replying, Date createdAt) {
        this.username = username;
        this.content = content;
        this.email = email;
        this.website = website;
        this.articleTitle = articleTitle;
        this.replying = replying;
        this.createdAt = createdAt;
    }

    public Comment(int id, String username, String content, String email, String website, String articleTitle, String replying, Date createdAt) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.email = email;
        this.website = website;
        this.articleTitle = articleTitle;
        this.replying = replying;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getReplying() {
        return replying;
    }

    public void setReplying(String replying) {
        this.replying = replying;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", replying='" + replying + '\'' +
                ", createdAt=" + getTime(createdAt) +
                '}';
    }

    public String getTime(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(createdAt.getTime());
        return String.format("%1$tY/%1$tm/%1$te %1$tT",instance);
    }
}
