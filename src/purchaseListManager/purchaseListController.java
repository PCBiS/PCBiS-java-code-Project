package purchaseListManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class purchaseListController implements PurchaseListAbstract {
	ArrayList<PurchaseList> list = new ArrayList<PurchaseList>();
	private static purchaseListController instance;
	Scanner sc = new Scanner(System.in);

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
	
	public void showPurchaseList(int selCalArray, String getDate, String userID) throws ParseException {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).showPurchaseList(selCalArray, userID, getDate);
		}		
	}		

	
}
