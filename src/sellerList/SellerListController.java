package sellerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import itemList.HaveItemListController;

public class SellerListController {
	ArrayList<SellerList> seller;
	HaveItemListController haveItemListCon;
	OrderLogController logger;
	private static SellerListController instance;

	private SellerListController() {
		seller = new ArrayList<SellerList>();
		haveItemListCon = HaveItemListController.getInstance();
		logger = OrderLogController.getInstance();
		dummyDataAdd();
	}

	public static SellerListController getInstance() {
		if (instance == null) {
			instance = new SellerListController();
		}
		return instance;
	}

	public void addSeller(String sellerName, String callNumber, String sellerAddress, ArrayList<String> bigCatagory,
			ArrayList<String> subCatagory, ArrayList<String> sellList, ArrayList<Integer> basePrice) {
		switch (addSellerEmptyCheck(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList,
				basePrice)) {
		case 123:
			System.out.println("판매자 이름 or 연락처 or 주소가 누락되었습니다!");
			break;
		case 4567:
			System.out.println("물품의 대,소분류 혹은 물품명이나 물품의 원가가 누락되었습니다!");
			break;
		default:
			System.out.println("정상적으로 판매자 등록이 되었습니다.");
			seller.add(new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList,
					basePrice));
			break;
		}
	}

	public void modifySeller(String modifySellerName, String sellerName, String callNumber, String sellerAddress, ArrayList<String> bigCatagory,
			ArrayList<String> subCatagory, ArrayList<String> sellList, ArrayList<Integer> basePrice) {
		if (seller.isEmpty()) {
			System.out.println("등록된 거래처 정보가 없습니다. 거래처를 등록해주세요!");
		} else {
			for (int i = 0; i < seller.size(); i++) {
				if (seller.get(i).sellerName.equals(modifySellerName)) {
					switch (addSellerEmptyCheck(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory,
							sellList, basePrice)) {
					case 123:
						System.out.println("판매자 이름 or 연락처 or 주소가 누락되었습니다!");
						break;
					case 4567:
						System.out.println("물품의 대,소분류 혹은 물품명이나 물품의 원가가 누락되었습니다!");
						break;
					default:
						System.out.println("정상적으로 판매자 등록이 되었습니다.");
						seller.set(i, new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory,
								sellList, basePrice));
						break;
					}
				}
			}
		}
	}
	
	public void deleteSeller(String sellerName) {
		if (seller.isEmpty()) {
			System.out.println("등록된 거래처 정보가 없습니다. 거래처를 등록해주세요!");
		}else {
			for (int i = 0; i < seller.size(); i++) {
				if (seller.get(i).sellerName.equals(sellerName)) {
					System.out.println(sellerName + " 거래처의 등록정보를 삭제하였습니다.");
					seller.remove(i);
					break;
				}
			}
		}
	}

	public void showSellerList() {
		if (this.seller.isEmpty()) {
			System.out.println("거래처가 등록 된 것이 없습니다. 거래처를 등록해주세요!");
		}else{	// 셀러 이름을 입력받은 것이 없으면.
			for (int i = 0; i < seller.size(); i++) {
				seller.get(i).showSellerList();				
			}
		}
	}

	public void showSellerList(String sellerName) {
		// sellerName의 유무로 기능의 선택지가 갈림.
		if (this.seller.isEmpty()) { // 컨트롤러의 셀러 리스트가 비어있으면.
			System.out.println("거래처가 등록 된 것이 없습니다. 거래처를 등록해주세요!");
		} else { // 입력받은것이 있으면 셀러 네임을 받아서 일치하는 셀러의 정보를 출력.
			for (int i = 0; i < seller.size(); i++) {
				if (seller.get(i).sellerName.equals(sellerName)) {
					seller.get(i).showSellerList();
				}
			}
		}
	}
	
	public void orderItemFromSeller(String sellerName) {
		HashMap<Integer, String> listMap = new HashMap<Integer, String>();
		Scanner sc = new Scanner(System.in);
		int numBuffer = -1; 
		int iCount=0, bPrice=0, sPrice=0, buyCount=0;
		String bCatagory=null, sCatagory=null, iName=null, sName=null;
				
		showSellerList(sellerName);
		for (int i = 0; i < seller.size(); i++) {
			if (seller.get(i).sellerName.equals(sellerName)) {
				for (int j = 0; j < seller.get(i).sellList.size(); j++) {
					listMap.put(j, seller.get(i).sellList.get(j));
				}
			}
		}
		System.out.println("어떤 상품을 발주하시겠습니까?");
		for (int i = 0; i < listMap.size(); i++) {
			System.out.println(i+1 + "번 상품 " + listMap.get(i));
		}
		System.out.println("=========================");
		numBuffer = sc.nextInt();
		sc.nextLine();
		System.out.println(listMap.get(numBuffer-1) + " 상품을 몇개 주문하시겠습니까?");
		buyCount = sc.nextInt();
		
		for (int i = 0; i < seller.size(); i++) {
			for (int j = 0; j < seller.get(i).bigCatagory.size(); j++) {
				if (seller.get(i).sellList.get(j).equals(listMap.get(numBuffer-1).toString())) {
					bCatagory = seller.get(i).bigCatagory.get(j).toString();
					sCatagory = seller.get(i).subCatagory.get(j).toString();
					iName = seller.get(i).sellList.get(j).toString();
					sName = seller.get(i).sellerName.toString();
					iCount = buyCount;
					bPrice = seller.get(i).basePrice.get(j);
					sPrice = (int) (seller.get(i).basePrice.get(j)+(seller.get(i).basePrice.get(j)*0.1));
					break;
				}				
			}
		}
		haveItemListCon.addItem(bCatagory, sCatagory, iName, sName, iCount, bPrice, sPrice);
		logger.addLog(bCatagory, sCatagory, iName, sName, iCount, bPrice);
		System.out.println("발주가 성공적으로 진행되었습니다.");
		bCatagory=null; sCatagory=null; iName=null; sName=null; iCount=0; bPrice=0; sPrice=0; buyCount=0;
	}

	private int addSellerEmptyCheck(String sellerName, String callNumber, String sellerAddress,
			ArrayList<String> bigCatagory, ArrayList<String> subCatagory, ArrayList<String> sellList,
			ArrayList<Integer> basePrice) {
		int emptyNum = -1;
		if (sellerName.isEmpty()) {
			emptyNum = 1;
		} else if (callNumber.isEmpty()) {
			emptyNum = 2;
		} else if (sellerAddress.isEmpty()) {
			emptyNum = 3;
		} else if (bigCatagory.isEmpty()) {
			emptyNum = 4;
		} else if (subCatagory.isEmpty()) {
			emptyNum = 5;
		} else if (sellList.isEmpty()) {
			emptyNum = 6;
		} else if (basePrice.isEmpty()) {
			emptyNum = 7;
		}
		return emptyNum;
	}
	
	private void dummyDataAdd() {
		String sellerName; 
		String callNumber;
		String sellerAddress;
		ArrayList<String> bigCatagory = new ArrayList<String>();
		ArrayList<String> subCatagory = new ArrayList<String>();
		ArrayList<String> sellList = new ArrayList<String>();
		ArrayList<Integer> basePrice = new ArrayList<Integer>();
		// 가을이네 라는 가상의 상점의 정보를 더미데이터로 입력.
		sellerName = "가을이네";
		callNumber = "010-1234-5678";
		sellerAddress = "서울시 어딘가";
		bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");
		subCatagory.add("사료");subCatagory.add("사료");subCatagory.add("사료");subCatagory.add("사료");subCatagory.add("사료");subCatagory.add("사료");
		sellList.add("퍼피 사료");sellList.add("일반 사료");sellList.add("시니어 사료");sellList.add("키티 사료");sellList.add("일반 사료");sellList.add("시니어 사료");
		basePrice.add(25000);basePrice.add(35000);basePrice.add(45000);basePrice.add(28000);basePrice.add(32000);basePrice.add(40000);
		// 입력된 정보를 배열에 Add
		seller.add(new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList, basePrice));
		
		// 배열 초기화 안해주면 당연히 기존 정보 남아있음.
		bigCatagory.clear(); subCatagory.clear(); sellList.clear(); basePrice.clear();
		
		// 배열이 아닌 일반 인스턴스 변수는 새 값을 대입해주면 새 값으로 치환됨.
		sellerName = "키티마을";
		callNumber = "010-3232-8178";
		sellerAddress = "강원도 어딘가";
		bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");
		subCatagory.add("간식");subCatagory.add("간식");subCatagory.add("간식");subCatagory.add("장난감");subCatagory.add("장난감");subCatagory.add("장난감");
		sellList.add("츄르");sellList.add("참치볼");sellList.add("연어볼");sellList.add("3단 낚시대");sellList.add("냥냥펀치 토이볼");sellList.add("스크래처");
		basePrice.add(3500);basePrice.add(11500);basePrice.add(12000);basePrice.add(12000);basePrice.add(22000);basePrice.add(12000);
		
		seller.add(new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList, basePrice));
		
		bigCatagory.clear(); subCatagory.clear(); sellList.clear(); basePrice.clear();
		
		sellerName = "댕댕이와 껄룩이";
		callNumber = "010-7123-6680";
		sellerAddress = "대전시 어딘가";
		bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("고양이");bigCatagory.add("고양이");bigCatagory.add("고양이");
		subCatagory.add("미용도구");subCatagory.add("미용도구");subCatagory.add("미용도구");subCatagory.add("미용도구");subCatagory.add("미용도구");subCatagory.add("미용도구");
		sellList.add("이발기");sellList.add("브러쉬");sellList.add("목욕장갑");sellList.add("천연 샴푸");sellList.add("브러쉬");sellList.add("귀 세정제");
		basePrice.add(16000);basePrice.add(9900);basePrice.add(5000);basePrice.add(20000);basePrice.add(8000);basePrice.add(14000);

		seller.add(new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList, basePrice));
		
		bigCatagory.clear(); subCatagory.clear(); sellList.clear(); basePrice.clear();
		
		sellerName = "Puppy Land";
		callNumber = "010-9932-9063";
		sellerAddress = "경기도 어딘가";
		bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");bigCatagory.add("강아지");
		subCatagory.add("간식");subCatagory.add("간식");subCatagory.add("간식");subCatagory.add("장난감");subCatagory.add("장난감");subCatagory.add("장난감");
		sellList.add("개껌");sellList.add("육포");sellList.add("비프맛 치약");sellList.add("이갈이 탱탱볼");sellList.add("노즈워크 담요");sellList.add("소리나는 이갈이 인형");
		basePrice.add(8000);basePrice.add(12000);basePrice.add(14000);basePrice.add(23000);basePrice.add(37000);basePrice.add(9000);
		
		seller.add(new SellerList(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList, basePrice));
		
		bigCatagory.clear(); subCatagory.clear(); sellList.clear(); basePrice.clear();
	}

}
