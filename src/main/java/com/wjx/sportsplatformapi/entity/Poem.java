package com.wjx.sportsplatformapi.entity;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/18 上午10:29
 */
public class Poem {

    public int id ;
    public String title ;
    public String author ;
    public String dynasty ;
    public String content ;
    public String comment ;
    public String create_time ;
    public String update_time ;

    public Poem() {
    }

    public Poem(String title, String author, String dynasty, String content, String comment, String create_time, String update_time) {
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.content = content;
        this.comment = comment;
        this.create_time = create_time;
        this.update_time = update_time;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", content='" + content + '\'' +
                ", comment='" + comment + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
