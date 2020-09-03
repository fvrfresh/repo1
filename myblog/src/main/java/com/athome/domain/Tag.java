package com.athome.domain;

/**
 * @ClassName Tag
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/27 10:54
 * @Version 1.0
 */
public class Tag {
    private int id;
    private String tag;
    private String article_title;

    public Tag(String tag, String article_title) {
        this.tag = tag;
        this.article_title = article_title;
    }

    public Tag(int id, String tag, String article_title) {
        this.id = id;
        this.tag = tag;
        this.article_title = article_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getArticle_title() {
        return article_title;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", article_title='" + article_title + '\'' +
                '}';
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }
}
