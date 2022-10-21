package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planboard.PopDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagingListBoard implements PagingBoard{

	private final PopDAO popDAO;

	@Override
	public String pageNumber(String like, String searchTag) {
//		int pageSize = 10;
//    	int pageCount = 1;
//    	int pageNum = 1;
		String str="";
//
//		int temp = (pageNum - 1) % limit;
//		int startPage = pageNum - temp;
//
//		if((startPage - limit) > 0) {
//			str = "<a href='PopularityPlan.jsp?pageNum7="+(startPage-1)+"'>[이전]</a>&nbsp;&nbsp;";
//		}

		//총 게시물 개수
		int count = 0;
		
		//쿼리스트링으로 받아오는 태그이름 재정의
		if (searchTag != null) {
			switch (searchTag){
				case "searchTag1" : searchTag = popDAO.popTag().get(0).getTagName();
					break;
				case "searchTag2" : searchTag = popDAO.popTag().get(1).getTagName();
					break;
				case "searchTag3" : searchTag = popDAO.popTag().get(2).getTagName();
					break;
				case "searchTag4" : searchTag = popDAO.popTag().get(3).getTagName();
					break;
				case "searchTag5" : searchTag = popDAO.popTag().get(4).getTagName();
					break;
			}
		}

		//서치했을때와 안했을때의 게시물 개수 구하는 분기 처리
		if (searchTag != null){
			count = popDAO.countSerchBoard(searchTag);
		} else {
			count = popDAO.countBoard();
		}

		log.info(String.valueOf(count));


		if (count % 10 == 0){
			count /= 10;
		} else {
			count = (count / 10) + 1 ;
		}

		log.info(String.valueOf(count));

		log.info(like);

		for(int i=0; i< count; i++) {
				if (searchTag != null) {
					str+="<a href='PopularityPlan?startNum="+i+"&searchTag="+searchTag+"'>["+(i+1)+"]</a>&nbsp;&nbsp;";
				} else if(like == null || like == "") {
					str+="<a href='PopularityPlan?startNum="+i+"'>["+(i+1)+"]</a>&nbsp;&nbsp;";
				} else if(like.equals("true")) {
					str+="<a href='PopularityPlan?startNum="+i+"&like=true'>["+(i+1)+"]</a>&nbsp;&nbsp;";
				}
			if(i >= count) {
				break;
			}

		}
		log.info(str);
//		if((startPage + limit) <= pageCount) {
//			str += "<a href='PopularityPlan.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
//		}
		return str;
	}
}
