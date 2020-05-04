package petshop;

import java.util.ArrayList;

public abstract class RemainItemAbstract {
	ArrayList<String> itemCatagory = new ArrayList<String>(); // 제품 카테고리 : 고양이, 개, 기타 동물 용품 종류	등등등...
	ArrayList<String> itemName = new ArrayList<String>(); // 제품이름 : 같은 카테고리 내에서는 중복된 이름의 다른 아이템은 없도록 해야 함.
	ArrayList<String> sellerName = new ArrayList<String>(); // 제품판매상 : 판매하는 제품 판매상 저장 용도.
	ArrayList<Integer> itemCount = new ArrayList<Integer>();	// 제품 재고 : 판매하는 제품의 재고 양.
	ArrayList<Integer> itemPrice = new ArrayList<Integer>(); // 제품 가격 : 판매하는 제품의 가격.
	int haveMoney; // 보유 금액
	
	void showRemainItem() {}
	
	/*
		아이템의 재고를 보여주는 기능. 
		부가적으로 특정 아이템의 재고가 일정 개수 이하면
		구매를 권고하는 메세지를 출력하는 기능을 부가적으로 가짐.
	 */	
	
	void setItem(String itemCatagory, String itemName, String sellerName, int itemPrice, int itemCount) {}
	void soldItem(String itemName, int itemCount) {}
	void stockItem(String itemName, int itemCount, int basePrice) {}
	
}
