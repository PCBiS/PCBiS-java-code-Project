package purchaseListManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class purchaseListController {
	ArrayList<PurchaseList> list = new ArrayList<PurchaseList>();
	private static purchaseListController instance;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat fmt_Year = new SimpleDateFormat("YYYY");
	SimpleDateFormat fmt_Month = new SimpleDateFormat("mm");
	SimpleDateFormat fmt_Day = new SimpleDateFormat("YYYY");
	SimpleDateFormat fmt_Date = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat fmt_Hour = new SimpleDateFormat("HH:mm:ss");

	private purchaseListController() {}
	
	public static purchaseListController getInstance() {
		if (instance == null) {
			instance = new purchaseListController();
		}
		return instance;
	}
	
	// 언제까지를 지정받는지에 따라서 출력하는 범위를 조정한다.
	// 1 : 년 단위, 2 : 월 단위, 3: 일 단위
	// 오버로딩을 통하여 아이디 입력 유무 판단 후 ID 입력받을경우에는 ID일치여부도 파악함.
	
	public void showPurchaseList(int selCalArray, String getDate, String userID) {
		switch (selCalArray) {
		case 0:	// 0일경우 처음부터 getDate는 신경쓰지 않아도 상관 없어짐으로 userID의 입력 여부만을 기준으로 판단.
			for (int i = 0; i < list.size(); i++) {
				if (!userID.isEmpty() && list.get(i).userID.equals(userID)) {
					list.get(i).showPurchaseList(userID);
				}else if (userID.isEmpty()) {
					list.get(i).showPurchaseList();
				}
			}
			break;
		case 1: // 1일경우 년단위만 입력받아서 자료가 넘어오게 할 것(20200000)임으로 
				// getDate의 값을 년도만 출력하게 변환하여 PurchaseList가 가진 purchaseDate를 년도만 가져와서 일치하는지 확인. 
			for (int i = 0; i < list.size(); i++) {
				
			}
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		}
					
	}		

	
}
