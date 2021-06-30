package com.wjx.sportsplatformapi.entity;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/27 上午11:28
 */
public class PoemQueryInfo {

    public int id;
    public String title;        //  诗歌名称
    public String author;       //  诗歌作者
    public String dynasty;       //  作者朝代
    public String category;       //  诗歌类别
    public String content;       //  内容
    public String comment;       //  注释
    public String create_time;       // 创建时间
    public String update_time;       //  更新时间
    private int pageNum  ;     //  当前页
    private int pageSize  ;  //  每页最大数
    private int pageStart  ;  //  每页起始数量

    public PoemQueryInfo() {
    }

    public PoemQueryInfo(String title, String author, String dynasty, String category, String content, String comment, String create_time, String update_time, int pageNum, int pageSize, int pageStart) {
        this.title = title;
        this.author = author;
        this.dynasty = dynasty;
        this.category = category;
        this.content = content;
        this.comment = comment;
        this.create_time = create_time;
        this.update_time = update_time;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageStart = pageStart;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageIndex(int pageStart) {
        this.pageStart = pageStart;
    }

    @Override
    public String toString() {
        return "PoemQueryInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", comment='" + comment + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageStart=" + pageStart +
                '}';
    }
}
