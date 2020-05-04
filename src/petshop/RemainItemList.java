package petshop;

import java.util.Scanner;

public class RemainItemList extends RemainItemAbstract {
	
	HaveItemListAbstract haveList = HaveItemList.getInstance();
	Scanner sc = new Scanner(System.in);

	private static RemainItemList instance;
	
	private RemainItemList() {
	}
	
	public static RemainItemList getInstance() {
		if (instance == null) {
			instance = new RemainItemList();
		}
		return instance;
	}
	
	
	@Override
	void showRemainItem() {
		System.out.println("재고를 확인 할 물품의 종류를 선택하세요.");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			haveList.showRemainAllItem();
			break;
		case 2:
			haveList.showRemainCatItem();
			break;
		case 3:
			haveList.showRemainDogItem();
			break;

		}	
	}
	
	@Override
	void setItem(String itemCatagory, String itemName, String sellerName, int itemPrice, int itemCount) {
		super.setItem(itemCatagory, itemName, sellerName, itemPrice, itemCount);
		System.out.println("물품 종류 : " + itemCatagory + " / 물품 이름 : " + itemName +  " 을(를) 매입단가 : " + itemPrice + " 원 에 " + itemCount + " 개를 매입하였습니다." );
		//this.itemCatagory.add(itemCatagory);
		haveList.itemCatagory.add(itemCatagory);
		//this.itemName.add(itemName);
		haveList.itemName.add(itemName);
		//this.sellerName.add(sellerName);
		haveList.sellerName.add(sellerName);
		//this.itemPrice.add(itemPrice);
		haveList.basePrice.add(itemPrice);
		//this.itemCount.add(itemCount);
		haveList.itemCount.add(itemCount);
		haveList.sellPrice.add(itemPrice+(itemPrice/10));
	}
	
	@Override
	void soldItem(String itemName, int itemCount) {
		int beforeCount;
		super.soldItem(itemName, itemCount);
		System.out.println("debug!!!   itemName : " + itemName + "  itemCount : " + itemCount);
		for (int i = 0; i < itemCatagory.size(); i++) {
			if (itemName.equals(haveList.itemName.get(i))) {
				if (haveList.itemCount.get(i)>0) {
					beforeCount = haveList.itemCount.get(i);
					haveList.itemCount.remove(i);
					haveList.itemCount.add(i, (beforeCount-itemCount));
					this.haveMoney += (haveList.sellPrice.get(i)*itemCount);
					System.out.println(itemName + " 을(를) " + itemCount + " 개 판매하였습니다.");
					break;
				}
			}
		}
	}

	@Override
	void stockItem(String itemName, int itemCount, int basePrice) {
		int beforeCount;
		super.stockItem(itemName, itemCount, basePrice);
		System.out.println("debug!!!   itemName : " + itemName + "  itemCount : " + itemCount + "    basePrice : " + basePrice);
		for (int i = 0; i < haveList.itemCatagory.size(); i++) {
			if (itemName.equals(haveList.itemName.get(i))) {
				if ((itemCount*basePrice)<haveMoney) {
					beforeCount = haveList.itemCount.get(i);
					haveList.itemCount.remove(i);
					haveList.itemCount.add(i, (beforeCount+itemCount));
					this.haveMoney -= (basePrice*itemCount);
					System.out.println(itemName + " 을(를) " + basePrice + " 원에 " + itemCount + " 개 구매하였습니다.");
					break;
				}
			}
		}
	}
	
	void notFound() {
		System.out.println("입력 받은 물건과 일치 하는 물건을 찾지 못하였습니다.");
	}
	
	void notRemainFound() {
		System.out.println("물건의 재고가 부족하여 판매 할 수 없습니다.");
	}
	
	void noHaveMoney() {
		System.out.println("잔액이 부족하여 물건을 구매 할 수 없습니다.");
	}
	
}

/*
 		int itemTotalPrice = 0;
		ArrayList<String> needBuy = new ArrayList<String>();
		
		super.showRemainItem();
		System.out.println("=======================================================");
		System.out.println("=======================================================");
		for (int i = 0; i < haveList.itemCatagory.size(); i++) {
			System.out.println("종류 : " + haveList.itemCatagory.get(i) +
								"제품명 : " + haveList.itemName.get(i) +
								" 재고수량 : " + haveList.itemCount.get(i) +
								" 제품가격 : " + haveList.basePrice.get(i) +
								" 판매가격 : " + haveList.sellPrice.get(i)
								);
			itemTotalPrice += (haveList.basePrice.get(i) * itemCount.get(i));
			if (haveList.itemCount.get(i)<10) {
				needBuy.add(haveList.itemName.get(i));
			}
		}
		System.out.println("=======================================================");
		System.out.println("재고 총 금액 : " + itemTotalPrice + "   매장 보유 현금 : " + haveMoney);
		System.out.println("=======================================================");
		if (needBuy.size()>0) {
			System.out.println("현재 추가 구매가 필요한 물품.");
			for (int i = 0; i < needBuy.size(); i++) {
				System.out.println(needBuy.get(i) + " 물건이 재고가 부족하며 이 물건을 판매하는 상점은 " + sellerName.get(i) + " 에서 구매 가능합니다.");
			}
			System.out.println("이 물건들의 재고가 부족하여 구매가 필요합니다.");
		}

 * 
 */