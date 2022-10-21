package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagingListBoard implements PagingBoard{

	private final PopDAO popDAO;

    @Override
    public String pageNumber(int limit) {
//        int pageSize = 10;
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

		int count;

		count = popDAO.countBoard();

		if (count % 10 == 0){
			count = popDAO.countBoard() % 10;
		} else {
			count = (popDAO.countBoard() % 10) + 1 ;
		}
		System.out.println("count count count count count count = " + count);
		for(int i=0; i< count; i++) {
//			if(i == pageNum) {
//				str+="["+i+"]&nbsp;&nbsp";
//			} else {
//				if (searchTag != null) {
//					str+="<a href='PopularityPlan.jsp?pageNum="+i+"&searchTag="+searchTag+"'>["+i+"]</a>&nbsp;&nbsp;";
//				} else if(like == null) {
					str+="<a href='PopularityPlan?startNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
//				} else {
//					str+="<a href='PopularityPlan.jsp?pageNum="+i+"&like=true'>["+i+"]</a>&nbsp;&nbsp;";
//				}
			if(i >= count) {
				break;
			}

		}
//		if((startPage + limit) <= pageCount) {
//			str += "<a href='PopularityPlan.jsp?pageNum="+(startPage+limit)+"'>[다음]</a>";
//		}
        return str;
    }
}
