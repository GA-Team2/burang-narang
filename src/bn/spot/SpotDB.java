package bn.spot;

public class SpotDB extends Spot {
	// 객체 인스턴스, DB 연결
	
	// Spot의 정보를 Spot의 이름이나 아이디를 통해 불러 옴
	public Spot getSpot(String s_name) {
		Spot s = new Spot();
		
		// select where s_name is s_name
		// data 임의 구성
		s.setS_name(s_name);
		s.setS_type("숙소");
		s.setS_content("스팟 정보");
		// 인기 정보
		s.setS_pop(10);
		
		return s;
	}
}
