package com.athome.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName Post
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/14 14:44
 * @Version 1.0
 */
public class ArticleTransformed {

    private int id;
    private String title;
    private String content;
    private String htmlString;
    private String createdAt;
    private String category;
    private String description;
    private String deletedAt;
    private String logoFile;

    public ArticleTransformed(){}
    public ArticleTransformed(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleTransformed(String title, String content, String htmlString) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
    }

    public ArticleTransformed(String title, String content, String htmlString, String createdAt) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
    }

    public ArticleTransformed(String title, String content, String htmlString, String createdAt, String category) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
    }

    public ArticleTransformed(String title, String content, String htmlString, String createdAt, String category, String description) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
    }

    public ArticleTransformed(String title, String content, String htmlString, String createdAt, String category, String description, String deletedAt) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
        this.deletedAt = deletedAt;
    }

    public ArticleTransformed(int id, String title, String content, String htmlString, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
    }

    public ArticleTransformed(int id, String title, String content, String htmlString, String createdAt, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
    }

    public ArticleTransformed(int id, String title, String content, String htmlString, String createdAt, String category, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
    }

    public ArticleTransformed(String title, String content, String htmlString, String createdAt, String category, String description, String deletedAt, String logoFile) {
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
        this.deletedAt = deletedAt;
        this.logoFile = logoFile;
    }

    public ArticleTransformed(int id, String title, String content, String htmlString, String createdAt, String category, String description, String deletedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
        this.deletedAt = deletedAt;
    }

    public ArticleTransformed(int id, String title, String content, String htmlString, String createdAt, String category, String description, String deletedAt, String logoFile) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmlString = htmlString;
        this.createdAt = createdAt;
        this.category = category;
        this.description = description;
        this.deletedAt = deletedAt;
        this.logoFile = logoFile;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
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
        return "ArticleTransformed{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", htmlString='" + htmlString + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                ", logoFile='" + logoFile + '\'' +
                '}';
    }
}
