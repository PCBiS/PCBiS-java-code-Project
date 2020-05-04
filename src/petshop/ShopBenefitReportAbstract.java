package petshop;

import java.util.ArrayList;

public abstract class ShopBenefitReportAbstract {
	ArrayList<String> itemName;	// 판매한 아이템 목록.
	ArrayList<Integer> itemCount; // 판매한 아이템의 개수.
	ArrayList<Integer> itemPrice; // 판매한 아이템의 가격.
	int shopTotalMoney; // 판매한 금액의 총계.
	
	void showBenefit() {}
	
}
