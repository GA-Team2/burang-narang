package org.ga2.buna.dto.board;

import lombok.Getter;
import lombok.Setter;

/**
 * 페이징 정보를 담을 DTO
 */
@Getter
@Setter
public class Pagination {
    private int startPage;
    private int endPage;
    private int currentPage;
    private int lastPage;
    private int pageCount;
    private int rowCount;
    private int displayRow;
    private int offset;
}
