package org.ga2.buna.service.popularityplan;

import org.springframework.stereotype.Service;

@Service
public class pagingList {

    public static int pageSize = 10;
    public static int pageCount = 1;
    public static int pageNum = 1;

    public static String pageNumber(int limit, String like, String searchTag) {

        String str = "";
        int temp = (pageNum - 1) % limit;
        int startPage = pageNum - temp;

        if ((startPage - limit) > 0) {
            str = "<a href='PopularityPlan.jsp?pageNum7=" + (startPage - 1) + "'>[이전]</a>&nbsp;&nbsp;";
        }

        for (int i = startPage; i < (startPage + limit); i++) {
            if (i == pageNum) {
                str += "[" + i + "]&nbsp;&nbsp";
            } else {
                if (searchTag != null) {
                    str += "<a href='PopularityPlan.jsp?pageNum=" + i + "&searchTag=" + searchTag + "'>[" + i + "]</a>&nbsp;&nbsp;";
                } else if (like == null) {
                    str += "<a href='PopularityPlan.jsp?pageNum=" + i + "'>[" + i + "]</a>&nbsp;&nbsp;";
                } else {
                    str += "<a href='PopularityPlan.jsp?pageNum=" + i + "&like=true'>[" + i + "]</a>&nbsp;&nbsp;";
                }
            }
            if (i >= pageCount) {
                break;
            }

        }
        if ((startPage + limit) <= pageCount) {
            str += "<a href='PopularityPlan.jsp?pageNum=" + (startPage + limit) + "'>[다음]</a>";
        }
        return str;
    }
}
