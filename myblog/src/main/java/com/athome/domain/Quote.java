package com.athome.domain;

/**
 * @ClassName Quote
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/26 17:55
 * @Version 1.0
 */
public class Quote {
    private int id;
    private String content;
    private String author;

    public Quote(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Quote(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
