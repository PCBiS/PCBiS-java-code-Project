package purchaseListManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PurchaseList {
	int purchaseIndex;	// 구매한 순번을 저장하기 위한 index값.
	Date purchaseDate;	// 구매한 년, 월, 일, 시간을 저장 하기 위한 date타입 변수 
	ArrayList<String> purchaseProduct; // 구매한 상품목록을 저장하기 위한 배열변수 
	ArrayList<Integer> purchaseAmount; // 몇 개를 구매하였는지 확인 하기 위한 배열변수 
	String userID;	// 구매한 사용자를 특정하기 위한 변수.
	SimpleDateFormat fmt_Year = new SimpleDateFormat("YYYY");
	SimpleDateFormat fmt_Month = new SimpleDateFormat("YYYY/mm");
	SimpleDateFormat fmt_Day = new SimpleDateFormat("YYYY/mm/dd");
	SimpleDateFormat fmt_Date = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat fmt_Hour = new SimpleDateFormat("HH:mm:ss");
	
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
	
	public void showPurchaseList() {
		for (int i = 0; i < purchaseProduct.size(); i++) {
			System.out.println("판매순번 : " + purchaseIndex
					+ " 판매일 : " + fmt_Date.format(purchaseDate)
					+ " 판매시간 : " + fmt_Hour.format(purchaseDate)
					+ " 판매 품목 : " + purchaseProduct.get(i)
					+ " 판매 수량 : " + purchaseAmount.get(i));
		}
	}
	
	public void showPurchaseList(String userId) {
		for (int i = 0; i < purchaseProduct.size(); i++) {
			if (!userID.isEmpty() && userID.equals(userID)) {
				System.out.println("판매순번 : " + purchaseIndex
						+ " 판매일 : " + fmt_Date.format(purchaseDate)
						+ " 판매시간 : " + fmt_Hour.format(purchaseDate)
						+ " 판매 품목 : " + purchaseProduct.get(i)
						+ " 판매 수량 : " + purchaseAmount.get(i));				
			}
		}
	}
	
	public void showPurchaseList(int selCalArray, String userID, String getDate) {
		Date convDate = null;
		if (selCalArray==1) {
			try {
				fmt_Year.parse(getDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if (selCalArray==2) {
			try {
				fmt_Month.parse(getDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if (selCalArray==3) {
			try {
				fmt_Day.parse(getDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < purchaseProduct.size(); i++) {
			if (!userID.isEmpty() && this.userID.equals(userID) && this.purchaseDate.equals(convDate)) {
				System.out.println("판매순번 : " + purchaseIndex
						+ " 판매일 : " + fmt_Date.format(purchaseDate)
						+ " 판매시간 : " + fmt_Hour.format(purchaseDate)
						+ " 판매 품목 : " + purchaseProduct.get(i)
						+ " 판매 수량 : " + purchaseAmount.get(i));				
			}
		}
	}
	
	
}
	
