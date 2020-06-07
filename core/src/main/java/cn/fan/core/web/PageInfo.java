package cn.fan.core.web;

import java.io.Serializable;

/**
 * @Description
 * @Date 2020/5/5
 * @Create By admin
 */
public class PageInfo<T> implements Serializable {
    private int currentPage;
    private int pageSize;
    private long pageCount;
    private T data;

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

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
