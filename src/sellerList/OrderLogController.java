package sellerList;

import java.util.ArrayList;

public class OrderLogController {
	ArrayList<FromSellerOrderLog> log;
	private static OrderLogController instance;
	
	private OrderLogController() {
		log = new ArrayList<FromSellerOrderLog>();
	}
	
	public static OrderLogController getInstance() {
		if (instance == null) {
			instance = new OrderLogController();
		}
		return instance;
	}
	
	public void addLog(String bCatagory, String sCatagory, String iName, String sName, int iCount, int bPrice) {
		log.add(new FromSellerOrderLog(bCatagory, sCatagory, iName, sName, iCount, bPrice));
	}
	
	public void showLog() {
		for (int i = 0; i < log.size(); i++) {
			log.get(i).showSellerOrderLog();
		}
	}
}
