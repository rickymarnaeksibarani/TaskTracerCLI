package com.TaskTracker.TaskTracker.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationUtil <Inclass, Outclass>{
    private List<Outclass> data;
    private Integer currentPage;
    private long totalItems;
    private Integer lastPage;
    private Integer totalItemsPerPage;
    private Boolean hasPrev;
    private Boolean hasNext;

    public PaginationUtil(Page<Inclass> pagedResult, Class<Outclass> outCLass) {
        this.data = ObjectMapperUtil.mapAll(pagedResult.toList(), outCLass);
        this.currentPage = pagedResult.getNumber() + 1;
        this.totalItems = pagedResult.getTotalElements();
        this.lastPage = pagedResult.getTotalPages();
        this.totalItemsPerPage = pagedResult.getNumberOfElements();
        this.hasNext = pagedResult.hasNext();
        this.hasPrev = pagedResult.hasPrevious();
    }
}
