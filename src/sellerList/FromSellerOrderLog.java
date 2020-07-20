package sellerList;

import java.util.Date;

public class FromSellerOrderLog {
	Date orderDay = null;
	int iCount=0, bPrice=0, buyCount=0;
	String bCatagory=null, sCatagory=null, iName=null, sName=null;
	
	public FromSellerOrderLog(String bCatagory, String sCatagory, String iName, String sName, int iCount, int bPrice) {
		this.bCatagory = bCatagory;
		this.sCatagory = sCatagory;
		this.orderDay = new Date(); // 생성자 호출 될 시점의 시간을 기록하도록 함.
		this.iName = iName;
		this.sName = sName;
		this.iCount = iCount;
		this.bPrice = bPrice;
	}
	
	public void showSellerOrderLog() {
		System.out.println("=============================================================================");
		System.out.println("|| 구매시간   물품-대분류   물품-소분류   물품명      판매상인    구매한 개수  매입원가.");
		System.out.println("=============================================================================");
		System.out.println("|| " + this.orderDay
							+ " " + this.bCatagory
							+ "  " + this.sCatagory
							+ "  " + this.iName
							+ "  " + this.sName
							+ "  " + this.iCount
							+ " " + this.bPrice
							+ "   ||");
		System.out.println("=============================================================================");
		System.out.println("=============================================================================");
	}
	
}
