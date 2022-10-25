package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planboard.PopDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagingListBoard implements PagingBoard {

    private final PopDAO popDAO;

    @Override
    public String pageNumber(String like, String searchTag) {

        //페이지 번호 부분 초기화
        String str = "";

        //총 게시물 개수 초기화
        int count = 0;

        //쿼리스트링으로 받아오는 해시태그 이름 재정의
        if (searchTag != null) {
            switch (searchTag) {
                case "searchTag1":
                    searchTag = popDAO.popTag().get(0).getTagName();
                    break;
                case "searchTag2":
                    searchTag = popDAO.popTag().get(1).getTagName();
                    break;
                case "searchTag3":
                    searchTag = popDAO.popTag().get(2).getTagName();
                    break;
                case "searchTag4":
                    searchTag = popDAO.popTag().get(3).getTagName();
                    break;
                case "searchTag5":
                    searchTag = popDAO.popTag().get(4).getTagName();
                    break;
            }
        }

        //서치했을때와 안했을때의 게시물 개수
        if (searchTag != null) {
            count = popDAO.countSerchBoard(searchTag);
        } else {
            count = popDAO.countBoard();
        }

        log.info(String.valueOf("게시물 개수 : " + count));

        //게시물 개수에 따라서 페이지 번호 출력
        if (count % 10 == 0) {
            count /= 10;
        } else {
            count = (count / 10) + 1;
        }

        log.info(String.valueOf("페이지 개수 : " + count));

        log.info("추천순 : " + like);

        //페이지 개수만큼 페이지 번호 출력
        for (int i = 0; i < count; i++) {
            if (searchTag != null) {

                //쿼리스트링으로 받아오는 해시태그 이름 재정의
                for (int j = 0; j < 5; j++) {
                    if (searchTag.equals(popDAO.popTag().get(j).getTagName())) {
                        searchTag = "searchTag" + (j + 1);
                    }
                }

                log.info("해시태그 : " + searchTag);

                str += "<a href='popularity?startNum=" + i + "&searchTag=" + searchTag + "'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";

            } else if (like == null || like == "") {
                str += "<a href='popularity?startNum=" + i + "'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";
            } else if (like.equals("true")) {
                str += "<a href='popularity?startNum=" + i + "&like=true'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";
            }
            if (i >= count) {
                break;
            }
        }
        return str;
    }
}
