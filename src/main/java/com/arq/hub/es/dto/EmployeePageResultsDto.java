package com.arq.hub.es.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeePageResultsDto {

    private List<EmployeeRequestDto> emps = new ArrayList<>();
    private long offset;
    private Integer totalPages;
    private long totalElements;
    private boolean isFirst;
    private boolean isLast;
    private int currentPage;
    private int pageSize;

    public EmployeePageResultsDto() {
    }

    public List<EmployeeRequestDto> getEmps() {
        return emps;
    }

    public void setEmps(List<EmployeeRequestDto> emps) {
        this.emps = emps;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
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
}
