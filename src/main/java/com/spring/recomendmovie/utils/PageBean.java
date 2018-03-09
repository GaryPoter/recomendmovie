package com.spring.recomendmovie.utils;

import java.util.List;

public class PageBean {
    private int currentPage;//当前页
    private int pageSize;//每页显示多少条记录

    private List recordList;//本页的数据列表
    private int recordCount;//总记录数

    private int pageCount;//总共多少页
    private int beginPageIndex;//页码的开始索引
    private int endPageIndex;//页码的结束索引

    public PageBean(int currentPage, int pageSize, List recordList, int recordCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordList = recordList;
        this.recordCount = recordCount;
        pageCount=(recordCount+pageSize-1)/pageSize;
        if(pageCount<=10){
            beginPageIndex=1;
            endPageIndex=pageCount;
        }else{
            beginPageIndex=currentPage-4;
            endPageIndex=currentPage+5;
            if(beginPageIndex-4<1){
                beginPageIndex=1;
                endPageIndex=10;
            }
            if(endPageIndex>pageCount){
                beginPageIndex=currentPage-10+1;
                endPageIndex=pageCount;
            }
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }
}
