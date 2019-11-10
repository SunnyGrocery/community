package com.sust.community.dto;

import com.github.pagehelper.PageInfo;
import com.sust.community.model.Note;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunnyGrocery on 2019/10/29 20:02
 */
@Data
public class PageInfoDTO {
    private boolean showFirst = true;
    private boolean showPre = true;
    private boolean showNext = true;
    private boolean showEnd = true;
    private Integer currentPage;
    private PageInfo<Note> pageHelpInfo;
    private List<Integer> pages;

    private PageInfoDTO() {
    }

    public static PageInfoDTO of(PageInfo<Note> pageInfo) {
        PageInfoDTO ofThis = new PageInfoDTO();
        ofThis.pageHelpInfo = pageInfo;

        final int pageNum = pageInfo.getPageNum();

        ofThis.setCurrentPage(pageNum);
        int leftPage = 1;
        int rightPage = pageInfo.getPages();
        if (pageNum > 4) {
            leftPage = pageNum - 3;
        }

        if (pageInfo.getPages() - pageNum >= 4) {
            rightPage = pageNum + 3;
        }


        if (pageNum == 1) {
            ofThis.showPre = false;
        }
        if (pageNum == pageInfo.getPages()) {
            ofThis.showNext = false;
        }

        if (leftPage == 1) {
            ofThis.showFirst = false;
        }
        if (rightPage == pageInfo.getPages()) {
            ofThis.showEnd = false;
        }

        ofThis.pages = new ArrayList<>();
        for (int i = leftPage; i <= rightPage; i++) {
            ofThis.pages.add(i);
        }

        return ofThis;
    }
}
