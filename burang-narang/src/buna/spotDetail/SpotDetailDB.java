package buna.spotDetail;

import java.util.ArrayList;

public class SpotDetailDB extends SpotDetail {
	
	
	public ArrayList<SpotDetail> getSpot() {
		ArrayList<SpotDetail> spot = new ArrayList<SpotDetail>();
		
		
		
		for (int i = 1; i < 6; i++) {
			SpotDetail sd = new SpotDetail();
			String sn = "re0"+i;
			String name = "맛0"+i;
			
			sd.setS_serial_num(sn);
			sd.setS_name(name);
			
			spot.add(sd);
		}
		
		for (int i = 1; i < 6; i++) {
			SpotDetail sd = new SpotDetail();
			String sn = "acc0"+i;
			String name = "숙0"+i;
			
			sd.setS_serial_num(sn);
			sd.setS_name(name);
			
			spot.add(sd);
		}
		
		for (int i = 1; i < 6; i++) {
			SpotDetail sd = new SpotDetail();
			String sn = "eve0"+i;
			String name = "행사0"+i;
			
			sd.setS_serial_num(sn);
			sd.setS_name(name);
			
			spot.add(sd);
		}
		
		
		return spot;
	}
}
