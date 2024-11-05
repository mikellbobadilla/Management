package com.ar.mikellbobadilla.app.utils;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;

    private Pagination pagination;

    public PaginatedResponse(List<T> data, Page<?> page) {
        this.data = data;
        this.pagination = new Pagination(page);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    private static class Pagination {
        private String page;
        private String size;
        private String totalPages;
        private String totalItems;
        private boolean hasNext;
        private boolean hasPrevious;

        public Pagination(Page<?> page) {
            this.page = String.valueOf(page.getPageable().getPageNumber());
            this.size = String.valueOf(page.getPageable().getPageSize());
            this.totalPages = String.valueOf(page.getTotalPages());
            this.totalItems = String.valueOf(page.getTotalElements());
            this.hasNext = page.hasNext();
            this.hasPrevious = page.hasPrevious();
        }
    }
}
