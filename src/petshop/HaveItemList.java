package petshop;

import java.util.ArrayList;

public class HaveItemList extends HaveItemListAbstract {

	private static HaveItemList instance;

	private HaveItemList() {
		itemCatagory = new ArrayList<String>();
		itemName = new ArrayList<String>();
		sellerName = new ArrayList<String>();
		itemCount = new ArrayList<Integer>();
		basePrice = new ArrayList<Integer>();
		sellPrice = new ArrayList<Integer>();
		sellRate = new Double(0.1);
		needBuy = new ArrayList<String>();
		
		
		//이하 요청된 더미 데이터
		itemCatagory.add("고양이"); itemCatagory.add("고양이"); itemCatagory.add("고양이"); itemCatagory.add("고양이"); itemCatagory.add("고양이"); itemCatagory.add("강아지");itemCatagory.add("강아지");itemCatagory.add("강아지");itemCatagory.add("강아지");itemCatagory.add("강아지"); 
		itemName.add("고양이사료"); itemName.add("고양이모래"); itemName.add("츄르"); itemName.add("오뎅꼬치"); itemName.add("골판지상자"); itemName.add("강아지사료"); itemName.add("대소변시트"); itemName.add("소고기개껌"); itemName.add("켄넬"); itemName.add("강아지급수기");
		sellerName.add("캣팡"); sellerName.add("캣팡"); sellerName.add("꾹꾹이네"); sellerName.add("비마이펫"); sellerName.add("비마이펫");  sellerName.add("강아지왕국"); sellerName.add("강아지왕국"); sellerName.add("갤럭시펫"); sellerName.add("갤럭시펫"); sellerName.add("논다"); 
		itemCount.add(50); itemCount.add(30); itemCount.add(30); itemCount.add(10); itemCount.add(3); itemCount.add(40);itemCount.add(4); itemCount.add(11); itemCount.add(25);itemCount.add(2);
		basePrice.add(1000); basePrice.add(400); basePrice.add(350); basePrice.add(200); basePrice.add(600); basePrice.add(800); basePrice.add(250);basePrice.add(600);basePrice.add(500);basePrice.add(1500);
		sellPrice.add((int)(basePrice.get(0)+(basePrice.get(0)*sellRate))); sellPrice.add((int)(basePrice.get(1)+(basePrice.get(1)*sellRate))); sellPrice.add((int)(basePrice.get(2)+(basePrice.get(2)*sellRate))); sellPrice.add((int)(basePrice.get(3)+(basePrice.get(3)*sellRate))); sellPrice.add((int)(basePrice.get(4)+(basePrice.get(4)*sellRate))); sellPrice.add((int)(basePrice.get(5)+(basePrice.get(5)*sellRate))); sellPrice.add((int)(basePrice.get(6)+(basePrice.get(6)*sellRate))); sellPrice.add((int)(basePrice.get(7)+(basePrice.get(7)*sellRate))); sellPrice.add((int)(basePrice.get(8)+(basePrice.get(8)*sellRate))); sellPrice.add((int)(basePrice.get(9)+(basePrice.get(9)*sellRate)));
	}

	public static HaveItemList getInstance() {
		if (instance == null) {
			instance = new HaveItemList();
		}
		return instance;
	}

	@Override
	void showRemainCatItem() {
		super.showRemainCatItem();
		if (itemCatagory.isEmpty()) {
			System.out.println("출력 할 데이터가 없습니다.");
		} else {
			System.out.println("============================================================");
			System.out.println("| 종류 |        제품명        | 재고 | 매입가격 | 판매가격 |");
			System.out.println("============================================================");
			for (int i = 0; i < itemCatagory.size(); i++) {
				if (itemCatagory.get(i).equals("고양이")) {
					System.out.println("| " + itemCatagory.get(i) + " | " + itemName.get(i) + " | " + itemCount.get(i)
							+ " | " + basePrice.get(i) + " | " + sellPrice.get(i));
					if (itemCount.get(i) < 5) {
						needBuy.add(itemName.get(i));
					}
				}
			}
			System.out.println("============================================================");
			if (!needBuy.isEmpty()) {
				System.out.println("============ 이 물건들의 추가 구매가 필요합니다. ===========");
				System.out.println("============================================================");
				System.out.println("| 종류 |        제품명        | 재고 | 매입가격 |  판매상  |");
				System.out.println("============================================================");
				for (int i = 0; i < needBuy.size(); i++) {
					for (int j = 0; j < itemName.size(); j++) {
						if (needBuy.get(i).equals(itemName.get(j))) {
							System.out.println("| " + itemCatagory.get(j) + " | " + itemName.get(j) + " | "
									+ itemCount.get(j) + " | " + basePrice.get(j) + " | " + sellerName.get(j));
						}						
					}
				}
				System.out.println("============================================================");
				needBuy.clear();
			}
		}
	}

	@Override
	void showRemainDogItem() {
		super.showRemainDogItem();
		if (itemCatagory.isEmpty()) {
			System.out.println("출력 할 데이터가 없습니다.");
		} else {
			System.out.println("============================================================");
			System.out.println("| 종류 |        제품명        | 재고 | 매입가격 | 판매가격 |");
			System.out.println("============================================================");
			for (int i = 0; i < itemCatagory.size(); i++) {
				if (itemCatagory.get(i).equals("강아지")) {
					System.out.println("| " + itemCatagory.get(i) + " | " + itemName.get(i) + " | " + itemCount.get(i)
							+ " | " + basePrice.get(i) + " | " + sellPrice.get(i));
					if (itemCount.get(i) < 5) {
						needBuy.add(itemName.get(i));
					}
				}
			}
			System.out.println("============================================================");
			if (!needBuy.isEmpty()) {
				System.out.println("============ 이 물건들의 추가 구매가 필요합니다. ===========");
				System.out.println("============================================================");
				System.out.println("| 종류 |        제품명        | 재고 | 매입가격 |  판매상  |");
				System.out.println("============================================================");
				for (int i = 0; i < needBuy.size(); i++) {
					for (int j = 0; j < itemName.size(); j++) {
						if (needBuy.get(i).equals(itemName.get(j))) {
							System.out.println("| " + itemCatagory.get(j) + " | " + itemName.get(j) + " | "
									+ itemCount.get(j) + " | " + basePrice.get(j) + " | " + sellerName.get(j));
						}						
					}
				}
				System.out.println("============================================================");
				needBuy.clear();
			}
		}
	}

	@Override
	void showRemainAllItem() {
		super.showRemainAllItem();
		if (itemCatagory.isEmpty()) {
			System.out.println("출력 할 데이터가 없습니다.");
		} else {
			System.out.println("============================================================");
			System.out.println("| 종류 |        제품명        | 재고 | 매입가격 | 판매가격 |");
			System.out.println("============================================================");
			for (int i = 0; i < itemCatagory.size(); i++) {
				System.out.println("| " + itemCatagory.get(i) + " | " + itemName.get(i) + " | " + itemCount.get(i)
						+ " | " + basePrice.get(i) + " | " + sellPrice.get(i));
				if (itemCount.get(i) < 5) {
					needBuy.add(itemName.get(i));
				}

			}
			System.out.println("============================================================");
			if (!needBuy.isEmpty()) {
				System.out.println("============ 이 물건들의 추가 구매가 필요합니다. ===========");
				System.out.println("============================================================");
				System.out.println("| 종류 |        제품명        | 재고 | 매입가격 |  판매상  |");
				System.out.println("============================================================");
				for (int i = 0; i < needBuy.size(); i++) {
					for (int j = 0; j < itemName.size(); j++) {
						if (needBuy.get(i).equals(itemName.get(j))) {
							System.out.println("| " + itemCatagory.get(j) + " | " + itemName.get(j) + " | "
									+ itemCount.get(j) + " | " + basePrice.get(j) + " | " + sellerName.get(j));
						}						
					}
				}
				System.out.println("============================================================");
				needBuy.clear();
			}
		}
	}
}
