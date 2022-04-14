package com.wjx.sportsplatformapi.entity;

import java.io.Serializable;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/11/2 上午11:33
 */
public class QueryInfo implements Serializable {

    private String query ;    //  查询信息的关键字
    private int pageNum = 1 ;     //  当前页
    private int pageSize = 1 ;  //  每页最大数

    public QueryInfo() {
    }

    public QueryInfo(String query, int pageNum, int pageSize) {
        this.query = query;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getQuery() {
        return query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "query='" + query + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
