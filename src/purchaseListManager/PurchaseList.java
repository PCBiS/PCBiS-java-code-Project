package purchaseListManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class PurchaseList implements PurchaseListAbstract {
	int purchaseIndex;	// 구매한 순번을 저장하기 위한 index값.
	Date purchaseDate;	// 구매한 년, 월, 일, 시간을 저장 하기 위한 date타입 변수 
	ArrayList<String> purchaseProduct = new ArrayList<String>(); // 구매한 상품목록을 저장하기 위한 배열변수 
	ArrayList<Integer> purchaseAmount = new ArrayList<Integer>(); // 몇 개를 구매하였는지 확인 하기 위한 배열변수 
	String userID;	// 구매한 사용자를 특정하기 위한 변수.
	
	private static PurchaseList instance;
	
	public PurchaseList(int purchaseIndex, Date purchaseDate, ArrayList<String> purchaseProduct, ArrayList<Integer> purchaseAmount, String userID) {
		this.purchaseIndex = purchaseIndex;
		this.purchaseDate = purchaseDate;
		this.purchaseProduct = purchaseProduct; 
		this.purchaseAmount = purchaseAmount; 
		this.userID = userID;
	}
	
	public static PurchaseList getInstance(int purchaseIndex, Date purchaseDate, ArrayList<String> purchaseProduct, ArrayList<Integer> purchaseAmount, String userID) {
		if (instance==null) {
			instance = new PurchaseList(purchaseIndex, purchaseDate, purchaseProduct, purchaseAmount, userID);
		}
		return instance;
	}
		
	public void showPurchaseList(int selCalArray, String userID, String getDate) throws ParseException {
		Date convDate=null;
		if (selCalArray==1) {
				convDate = fmtYear.parse(getDate);
		}else if (selCalArray==2) {
				convDate = fmtMonth.parse(getDate);
		}else if (selCalArray==3) {
				convDate = fmtDay.parse(getDate);
		}
		
		for (int i = 0; i < purchaseProduct.size(); i++) {
			if (!userID.isEmpty() && this.userID.equals(userID) 
				&& selCalArray==3?fmtDay.format(getDate).equals(convDate)
				:selCalArray==2?fmtMonth.format(getDate).equals(convDate)
				:selCalArray==1?fmtYear.format(getDate).equals(convDate)
				:null) {
				
				System.out.println("판매순번 : " + purchaseIndex
						+ " 판매일 : " + fmtDate.format(purchaseDate)
						+ " 판매시간 : " + fmtHour.format(purchaseDate)
						+ " 판매 품목 : " + purchaseProduct.get(i)
						+ " 판매 수량 : " + purchaseAmount.get(i));				
			}
		}
	}
	
	
}
	
