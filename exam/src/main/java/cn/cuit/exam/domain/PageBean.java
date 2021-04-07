package cn.cuit.exam.domain;

import java.util.List;

public class PageBean<T> {
    private int totalCount; // 总记录条数
    private int rows;       // 每页数据条数
    private int totalPage;  // 总页码
    private int currentPage;// 当前页码
    private List<T> list;   // 当前页面数据

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        totalPage = totalCount % rows == 0 ?
                totalCount / rows : totalCount / rows + 1;
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", rows=" + rows +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}
