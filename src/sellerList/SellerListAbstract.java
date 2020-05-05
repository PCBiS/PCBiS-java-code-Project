package sellerList;

import java.util.ArrayList;

public abstract class SellerListAbstract {
	String sellerName;	// 판매자 이름.
	String callNumber;	// 판매자 연락처.
	String sellerAddress;	// 판매자 주소.
	ArrayList<String> bigCatagory; // 대분류 - 0 : 전체 || 1 : 고양이 || 2 : 강아지
	ArrayList<String> subCatagory; // 소분류 - 0 : 사료 || 1 : 간식 || 2 : 장난감 || 3 : 미용도 || 4 : 켄넬 || 5 : 기타용품
	ArrayList<String> sellList; // 판매자가 파는 물건목록
	ArrayList<Integer> basePrice;	// 판매 원가.
	int haveMoney;	// 상인이 보유 하는 돈.
	
	abstract void showSellerList();
}
