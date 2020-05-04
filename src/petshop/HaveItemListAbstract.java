package petshop;

import java.util.ArrayList;

public abstract class HaveItemListAbstract {
	ArrayList<String> itemCatagory;
	ArrayList<String> itemName;
	ArrayList<String> sellerName;
	ArrayList<Integer> itemCount;
	ArrayList<Integer> basePrice; // 매입가격 : 상인에게서 매입 한 가격.
	ArrayList<Integer> sellPrice; // 판매가격 : 매입가 * n%를 설정 한 가격을 대입하도록 로직 설계 필요함.
	Double sellRate;
	ArrayList<String> needBuy;
	
	void showRemainCatItem() {}
	void showRemainDogItem() {}
	void showRemainAllItem() {}
}