package itemList;

public class HaveItemList {
	String bigCatagory; // 대분류 - 0 : 전체 || 1 : 고양이 || 2 : 강아지
	String subCatagory; // 소분류 - 0 : 사료 || 1 : 간식 || 2 : 장난감 || 3 : 미용도 || 4 : 켄넬 || 5 : 기타용품
	String itemName; // 제품명
	String sellerName; // 판매자 이름 - 거래처정보에서 넘어와야 함.
	int itemCount; // 재고수량
	int basePrice; // 매입가격 : 상인에게서 매입 한 가격.
	int sellPrice; // 판매가격 : 매입가 * n%를 설정 한 가격을 대입하도록 로직 설계 필요함.
	Double sellRate;
	
	public HaveItemList(String bigCatagory, String subCatagory, String itemName,  String sellerName, int itemCount,  int basePrice, int sellPrice) {
		this.bigCatagory = bigCatagory;
		this.subCatagory = subCatagory;
		this.itemName = itemName;
		this.sellerName = sellerName;
		this.itemCount = itemCount;
		this.basePrice = basePrice;
		this.sellPrice = sellPrice;
	}
	
	public void showItemList() {
		System.out.println("대분류 : " + bigCatagory + " 소분류 : " + subCatagory + " 제품명 : " + itemName + " 판매가격 : " + sellPrice + " 재고수량 : " + itemCount);
	}
	
	public void showItemSellerList() {
		System.out.println("대분류 : " + bigCatagory + " 소분류 : " + subCatagory + "제품명 : " + itemName + " 매입가격 : " + basePrice + "판매자 이름 : " + sellerName);
	}
		
}