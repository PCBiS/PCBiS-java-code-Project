package sellerList;

import java.util.ArrayList;

public class SellerList {
	
	String sellerName;
	String callNumber;
	String sellerAddress;
	ArrayList<String> bigCatagory = new ArrayList<String>();
	ArrayList<String> subCatagory = new ArrayList<String>();
	ArrayList<String> sellList = new ArrayList<String>();
	ArrayList<Integer> basePrice = new ArrayList<Integer>();
	
	public SellerList(String sellerName, String callNumber, String sellerAddress, ArrayList<String> bigCatagory, ArrayList<String> subCatagory, ArrayList<String> sellList, ArrayList<Integer> basePrice) {
		this.sellerName = sellerName;
		this.callNumber = callNumber;
		this.sellerAddress = sellerAddress;
		this.bigCatagory.addAll(bigCatagory);
		this.subCatagory.addAll(subCatagory);		
		this.sellList.addAll(sellList);
		this.basePrice.addAll(basePrice);
	}
	
	public void showSellerList() {
		System.out.println("=============================================================================");
		System.out.println("||	판매자 상 호 명 : " + this.sellerName);
		System.out.println("||	판매자 전화번호 : " + this.callNumber);
		System.out.println("||	판매자 주   소 : " + this.sellerAddress);
		System.out.println("=============================================================================");
		System.out.println("||	대분류	소분류		판매품목		판매단가");
		System.out.println("=============================================================================");
		for (int i = 0; i < this.sellList.size(); i++) {
			System.out.println(
					"||	" + this.bigCatagory.get(i).toString()
					+ "    " + this.subCatagory.get(i).toString()
					+ "           " + this.sellList.get(i).toString()
					+ "         " + this.basePrice.get(i).toString()
					+ "       ||");
		}
		System.out.println("=============================================================================");
		System.out.println("=============================================================================");
	}
}
