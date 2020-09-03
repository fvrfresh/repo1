package com.athome.domain;

import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName Post
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/14 14:44
 * @Version 1.0
 */
public class Article {

    private int id;
    private String title;
    private String content;
    private String htmlString;
    private String description;
    private Date createdAt;
    private String category;
    private Date deletedAt;
    private String logoFile;

    public Article(){}
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content, String htmlString) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
    }

    public Article(String title, String content, String htmlString, Date createdAt) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
    }

    public Article(String title, String content, String htmlString, Date createdAt, String category) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Article(String title, String content, String htmlString, String description, Date createdAt, String category) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Article(String title, String content, String htmlString, String description, Date createdAt, String category, Date deletedAt) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
        this.deletedAt = deletedAt;
    }

    public Article(String title, String content, String htmlString, String description, Date createdAt, String category, Date deletedAt, String logoFile) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
        this.deletedAt = deletedAt;
        this.logoFile = logoFile;
    }

    public Article(int id, String title, String content, String htmlString, Date createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
    }

    public Article(int id, String title, String content, String htmlString, Date createdAt, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Article(int id, String title, String content, String htmlString, String description, Date createdAt, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Article(int id, String title, String content, String htmlString, String description, Date createdAt, String category, Date deletedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
        this.deletedAt = deletedAt;
    }

    public Article(int id, String title, String content, String htmlString, String description, Date createdAt, String category, Date deletedAt, String logoFile) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.description = description;
        this.createdAt = createdAt;
        this.category = category;
        this.deletedAt = deletedAt;
        this.logoFile = logoFile;
    }

    public Article(String title, String category, String description, String content) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", htmlString='" + htmlString + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + getTime(createdAt) +
                ", category='" + category + '\'' +
                ", deletedAt=" + deletedAt +
                ", logoFile='" + logoFile + '\'' +
                '}';
    }

    public String getTime(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(createdAt.getTime());
        return String.format("%1$tY/%1$tm/%1$te %1$tT",instance);
    }
}
