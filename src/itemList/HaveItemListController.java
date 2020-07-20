package itemList;

import java.util.ArrayList;
/*
 * bigCatagory - 0 : 전체 || 1 : 고양이 || 2 : 강아지
 * subCatagory - 0 : 사료 || 1 : 간식 || 2 : 장난감 || 3 : 미용도 || 4 : 켄넬 || 5 : 기타용품
 */

public class HaveItemListController {

	ArrayList<HaveItemList> list = new ArrayList<HaveItemList>();
	private static HaveItemListController instance;

	private HaveItemListController() {
		String bigCatagory = null, subCatagory = null;
	}

	public static HaveItemListController getInstance() {
		if (instance == null) {
			instance = new HaveItemListController();
		}
		return instance;
	}
	
	public void addItem(String bigCatagory, String subCatagory, String itemName,  String sellerName, int itemCount,  int basePrice, int sellPrice) {
		list.add(new HaveItemList(bigCatagory, subCatagory, itemName, sellerName, itemCount, basePrice, sellPrice));
	}
	
	public void showRemainItem(String bigCatagory, String subCatagory) {
		ArrayList<String> needBuy = new ArrayList<String>();
		if (list.isEmpty()) {
			// List에 아무것도 저장이 안되었다면.
			System.out.println("출력 할 데이터가 없습니다.");
		} else if(bigCatagory==ItemListMenuNameInterface.ALL && subCatagory==ItemListMenuNameInterface.ALL){
			// 대분류도 ALL이고 소분류도 ALL이면.
			System.out.println("====================================================================");
			System.out.println("|                     전체 상품 목록을 출력 합니다.                        ");
			System.out.println("====================================================================");
			for (int i = 0; i < list.size(); i++) {
				// 전부 찍어버린다.
				list.get(i).showItemList();
				if (list.get(i).itemCount<=10) {
					// 만약, for문을 돌면서 물건목록을 출력해가면서 i번열의 itemCount가 10개 이하면
					needBuy.add(list.get(i).itemName);
					// 10개 이하인 아이템의 재고 목록을 찍는다.
				}
			}
		} else {
			System.out.println("====================================================================");
			System.out.println("|    대분류 : " + bigCatagory + "  소분류 : " + subCatagory + "   |");
			System.out.println("====================================================================");
			if (bigCatagory==ItemListMenuNameInterface.ALL && !(subCatagory==ItemListMenuNameInterface.ALL)) {
				// 대분류가 ALL이고 소분류가 ALL이 아니면(다른 문자열이 들어옴)
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).subCatagory.equals(subCatagory)) {
						// 만약 가져온 대분류가 전체이고 소분류가 사용자가 지정한 분류의 물품이라면
						list.get(i).showItemList();
						// 조건에 맞는 물건을 찍으면서.
						if (list.get(i).itemCount<=10) {
							// 물건목록을 출력해가면서 i번열의 itemCount가 10개 이하면
							needBuy.add(list.get(i).itemName);
							// 10개 이하인 아이템의 재고 목록을 찍는다.
						}
					}	
				}				
			}else if (!(bigCatagory==ItemListMenuNameInterface.ALL) && subCatagory==ItemListMenuNameInterface.ALL) {
				// 대분류가 ALL이 아니고, 소분류 ALL이라면
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).bigCatagory.equals(bigCatagory)) {
						// 대분류가 일치하는 모든 물건을
						list.get(i).showItemList();
						// 출력한다.
						if (list.get(i).itemCount<=10) {
							// 만약, for문을 돌면서 일치하는 물건목록을 출력해가면서 i번열의 itemCount가 10개 이하면
							needBuy.add(list.get(i).itemName);
							// 10개 이하인 아이템의 재고 목록을 찍는다.
						}
					}
				}
			}else {
				// 대분류도 ALL이 아니고, 소분류도 ALL이 아니라면
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).bigCatagory.equals(bigCatagory) && list.get(i).subCatagory.equals(subCatagory)) {
						list.get(i).showItemList();
						if (list.get(i).itemCount<=10) {
							// 만약, for문을 돌면서 물건목록을 출력해가면서 i번열의 itemCount가 10개 이하면
							needBuy.add(list.get(i).itemName);
							// 10개 이하인 아이템의 재고 목록을 찍는다.
						}
					}
				}				
			}
		}
		// 만약, needBuy가 Null이 아니라면.
		if (!needBuy.isEmpty()) {
			System.out.println("====================================================================");
			System.out.println("===================재고 추가매입이 필요한 물건이 있습니다!===================");
			System.out.println("====================================================================");
			for (int i = 0; i < needBuy.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (needBuy.get(i).equals(list.get(j).itemName)) {
						// 만약, needBuy에 들어가있는 아이템 리스트와 아이템 전체 목록의 아이템 이름과 이름을 비교하여 일치한다면.
						list.get(j).showItemSellerList();
						// 해당하는 아이템을 출력한다.
					}
				}
			}
			needBuy.clear();
			//목적이 소진되면 needBuy의 내용을 클리어 해야 한다
			//하지 않는다면 클래스가 로드 되어있는 동안에는 배열에 계속해서 자료를 가지고 있게 된다.
		}
		
	}
}
