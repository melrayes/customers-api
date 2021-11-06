package com.company.customers.model.dtos;

import java.util.List;

public class CustomerResponseDTO {
    private List<CustomerDTO> content;

    private int page;

    private int pageSize;

    private long totalSize;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(int page, int size, long total) {
        this.page = page;
        this.pageSize = size;
        this.totalSize = total;
    }

    public List<CustomerDTO> getContent() {
        return content;
    }

    public void setContent(List<CustomerDTO> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}
