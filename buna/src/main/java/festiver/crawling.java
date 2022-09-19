package festiver;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling {
	public static void main(String[] args) {
		//크롤링 할 사이트
		String Url = "https://www.visitbusan.net/index.do?menuCd=DOM_000000201005000000";
		Document doc;
		
		try {
			//원하는 url에서 전체 구조를 받아온다
			doc  = Jsoup.connect("https://www.visitbusan.net/index.do?menuCd=DOM_000000201005000000").get();
			//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
			//==>원하는 값들이 들어있는 덩어리를 가져온다
			Elements element = doc.select(".hot-item");
			System.out.println("==========================================");
			//iterator을 사용하여 하나씩 값 가져오기
			//덩어리 안에서 필요한 부분만 가져올 수 있다.
			Iterator<Element> title = element.select("div.info .tit a").iterator();
			
			while (title.hasNext()) {
				System.out.println(title.next().attr("abs:href"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		//-----------------이미지 크롤링---------------
//				try {
//			//원하는 url에서 전체 구조를 받아온다
//			doc  = Jsoup.connect("https://www.visitbusan.net/index.do?uc_seqs=&ucMtmUcSeq=&ucMtmItemUcSeq=&file_name=&gugun_nm=&cate2_nm=&ucc1_seq=20&cate1_nm=&ucdpp_seqs=&uct_seqs=&ucum_seqs=&ucl_seq=7&ucl_use_yn=Y&exclude_uc_seq=&place=&title=&subtitl=&hash_tag=&menuCd=DOM_000000201005000000&list_type=TYPE_SMALL_CARD&order_type=NEW&listCntPerPage2=16&ucum_seq=&ub_seq=&distance=0.0&cate2_month=&favoriteThis=N&myFavoriteUserId=&sel_visit_place=N&user_id=&search_keyword=&num_room=&ulg_seq=&ucc2_seq=&ucg_seq=&ucogl_seq=&main_img_ucmf_seq=&main_title=&charger_positn=&charger_nm=&charger_tel=&tripadvisor_id=&lat=&lng=&bundle_cntnts_yn=&use_yn=Y&sort_num=&page_no=1").get();
//			//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
//			//==>원하는 값들이 들어있는 덩어리를 가져온다
//			Elements element = doc.select(".hot-item");
//			System.out.println("==========================================");
//			//iterator을 사용하여 하나씩 값 가져오기
//			//덩어리 안에서 필요한 부분만 가져올 수 있다.
//			Iterator<Element> title = element.select("div.box img").iterator();
//			
//			while (title.hasNext()) {
//				System.out.println(title.next().attr("abs:src"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
}
