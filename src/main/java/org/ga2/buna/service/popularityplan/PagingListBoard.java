package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planboard.PopRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagingListBoard implements PagingBoard {

    private final PopRepository popRepository;

    @Override
    public String pageNumber(String like, String searchTag) {

        //페이지 번호 부분 초기화
        String str = "";

        //총 게시물 개수 초기화
        int count;

        //태그 검색을 했을때 이름 재정의
        if (searchTag != null) {
            switch (searchTag) {
                case "searchTag1":
                    searchTag = popRepository.popTag().get(0).getTagName();
                    break;
                case "searchTag2":
                    searchTag = popRepository.popTag().get(1).getTagName();
                    break;
                case "searchTag3":
                    searchTag = popRepository.popTag().get(2).getTagName();
                    break;
                case "searchTag4":
                    searchTag = popRepository.popTag().get(3).getTagName();
                    break;
                case "searchTag5":
                    searchTag = popRepository.popTag().get(4).getTagName();
                    break;
                case "searchTag6":
                    searchTag = popRepository.popTag().get(5).getTagName();
                    break;
                case "searchTag7":
                    searchTag = popRepository.popTag().get(6).getTagName();
                    break;
                case "searchTag8":
                    searchTag = popRepository.popTag().get(7).getTagName();
                    break;
                case "searchTag9":
                    searchTag = popRepository.popTag().get(8).getTagName();
                    break;
                case "searchTag10":
                    searchTag = popRepository.popTag().get(9).getTagName();
                    break;
            }
        }

        //서치했을때와 안했을때의 게시물 개수
        if (searchTag != null) {
            count = popRepository.countSerchBoard(searchTag);
        } else {
            count = popRepository.countBoard();
        }

        log.debug("게시물 개수 : " + count);

        //게시물 개수에 따라서 페이지 번호 출력
        if (count % 10 == 0) {
            count /= 10;
        } else {
            count = (count / 10) + 1;
        }

        log.debug("페이지 개수 : " + count);

        log.debug("추천순 : " + like);

        //페이지 개수만큼 페이지 번호 출력
        for (int i = 0; i < count; i++) {
            if (searchTag != null) {

                //쿼리스트링으로 받아오는 해시태그 이름 재정의
                for (int j = 0; j < 5; j++) {
                    if (searchTag.equals(popRepository.popTag().get(j).getTagName())) {
                        searchTag = "searchTag" + (j + 1);
                    }
                }

                log.debug("해시태그 : " + searchTag);

                str += "<a href='popularity?page=" + i + "&searchTag=" + searchTag + "'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";

            } else if (like == null || like == "") {
                str += "<a onclick='pagingAjax(" + i + ")'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";

            } else if (like.equals("true")) {
                str += "<a onclick='pagingAjax(" + i + "," + true + ")'>[" + (i + 1) + "]</a>&nbsp;&nbsp;";
            }
            if (i >= count) {
                break;
            }
        }
        return str;
    }
}
