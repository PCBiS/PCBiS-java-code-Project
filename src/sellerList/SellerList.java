package sellerList;

import java.util.ArrayList;

public class SellerList extends SellerListAbstract{

	private static SellerList instance;
	
	private SellerList(String sellerName, String callNumber, String sellerAddress, ArrayList<String> bigCatagory, ArrayList<String> subCatagory, ArrayList<String> sellList, ArrayList<Integer> basePrice) {
		this.sellerName = sellerName;
		this.callNumber = callNumber;
		this.sellerAddress = sellerAddress;
		this.bigCatagory = bigCatagory;
		this.subCatagory = subCatagory;
		this.sellList = sellList; 
		this.basePrice = basePrice;
	}
	
	public static SellerList getInstance(String sellerName, String callNumber, String sellerAddress, ArrayList<String> bigCatagory, ArrayList<String> subCatagory, ArrayList<String> sellList, ArrayList<Integer> basePrice) {
		if (instance==null) { instance = new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList, basePrice); }
		return instance;
	}

	@Override
	void showSellerList() {
		System.out.println("판매자 이   름 : " + this.sellerName);
		System.out.println("판매자 전화번호 : " + this.callNumber);
		System.out.println("판매자 주   소 : " + this.sellerAddress);
		for (int i = 0; i < this.sellList.size(); i++) {
			System.out.println("대분류 : " + this.bigCatagory.get(i) + " 소분류 : " + this.subCatagory.get(i) + " 판 매 품 목 : " + this.sellList.get(i) + " 판 매 단 가 : " + this.basePrice.get(i));
		}
	}
}
