package sellerList;

import java.util.ArrayList;
import java.util.Scanner;

public class SellerListUserInterface {
	public static void main(String[] args) {
		SellerListController listCon = SellerListController.getInstance();
		OrderLogController logCon = OrderLogController.getInstance();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int frontSelect = -1, subSelect = -1, inputIntBuffer = 0, itemCount = 0,bPrice = 0,sellPrice = 0;
		String sellerName = null, modifySellerName = null, callNumber = null, sellerAddress = null, inputStringBuffer = null, bCatagory = null, sCatagory = null, itemName = null;
		ArrayList<String> bigCatagory = new ArrayList<String>();
		ArrayList<String> subCatagory = new ArrayList<String>();
		ArrayList<String> sellList = new ArrayList<String>();
		ArrayList<Integer> basePrice = new ArrayList<Integer>();
		
		while (flag) {
			sellerMainText();
			frontSelect = sc.nextInt();
			switch (frontSelect) {
			//거래처 입력
			case 1:
				sc.nextLine();
				System.out.println("거래처명을 입력하세요.");
				sellerName = sc.nextLine();
				System.out.println("거래처의 연락처를 입력하세요.");
				callNumber = sc.nextLine();
				System.out.println("거래처의 주소를 입력해주세요.");
				sellerAddress = sc.nextLine();

				while (true) {
					System.out.println("물품목록 입력입니다.");
					System.out.println("물건의 대분류를 선택해주세요.");
					System.out.println("1. 강아지 / 2. 고양이");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer < 1 || inputIntBuffer > 2) {
						System.out.println("입력 범위를 초과하였습니다.");
						continue;
					}
					switch (inputIntBuffer) {
						case 1:
							bigCatagory.add("강아지");
							System.out.println("대분류 선택을 하였습니다.");
							inputIntBuffer = 0;
							break;
	
						case 2:
							bigCatagory.add("고양이");
							System.out.println("대분류 선택을 하였습니다.");
							inputIntBuffer = 0;
							break;
						}

					System.out.println("물건의 소분류를 선택해주세요.");
					System.out.println("1. 사     료");
					System.out.println("2. 간     식");
					System.out.println("3. 장  난  감");
					System.out.println("4. 미 용 도 구");
					inputIntBuffer = sc.nextInt();
					// 선택된 번호를 기반으로 스위치문으로 선택.
					if (inputIntBuffer < 1 || inputIntBuffer > 4) {
						System.out.println("입력범위를 초과하였습니다. 다시 입력해주세요!");
						continue;
					}
					switch (inputIntBuffer) {
						case 1:
							subCatagory.add("사료");
							inputIntBuffer = 0;
							break;
						case 2:
							subCatagory.add("간식");
							inputIntBuffer = 0;
							break;
						case 3:
							subCatagory.add("장난감");
							inputIntBuffer = 0;
							break;
						case 4:
							subCatagory.add("미용도구");
							inputIntBuffer = 0;
							break;
					}

					sc.nextLine();
					System.out.println("제품명을 입력해주세요.");
					inputStringBuffer = sc.nextLine();
					if (inputStringBuffer.isEmpty()) {
						System.out.println("제품명이 입력되지 않았습니다.");
					} else {
						System.out.println("제품명을 입력하였습니다.");
						sellList.add(inputStringBuffer);
						inputStringBuffer = null;
					}

					inputIntBuffer = 0;
					// sc.nextLine();
					System.out.println("물건의 매입가를 입력해주세요.");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer <= 0) {
						System.out.println("0이 입력됨. 가격은 1원이상이여야 합니다.");
					} else {
						System.out.println("물건 매입가를 입력하였습니다.");
						basePrice.add(inputIntBuffer);
						inputIntBuffer = 0;
					}
					// 위에서 입력을 무사히 입력받고 오면 각 배열들에 추가로 입력을 시도할 것인지 질문하고 돌아갈지 말지를 결정.
					sc.nextLine();
					System.out.println("입력이 성공적으로 완료되었습니다.");
					System.out.println("상품들을 추가로 더 입력하시겠습니까?");
					System.out.println("추가입력 : 1 / 입력종료 : 2");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer == 1) {
						System.out.println("상품을 추가입력하기 위해 돌아갑니다.");
					} else if (inputIntBuffer == 2) {
						System.out.println("추가 입력을 종료합니다.");
						listCon.addSeller(sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList,
								basePrice);
						sellerName = null;
						callNumber = null;
						sellerAddress = null;
						bigCatagory.clear();
						subCatagory.clear();
						sellList.clear();
						basePrice.clear();
						break;
					}
				}
				break;
			// 거래처 목록 내역	
			case 2:
				sellerShowMenuText();
				subSelect = sc.nextInt();
				switch (subSelect) {
				case 1:
					System.out.println("거래처 전체 내역을 출력합니다!");
					sc.nextLine();
					listCon.showSellerList();
					break;
				case 2:
					sc.nextLine();
					System.out.println("특정 거래처의 판매품목 정보를 보여드립니다.");
					System.out.println("확인 할 거래처명을 입력해주세요.");
					System.out.print(">");
					inputStringBuffer = sc.nextLine();
					listCon.showSellerList(inputStringBuffer);
					inputStringBuffer = null;
					break;
				case 3:
					sc.nextLine();
					break;
				}
				break;
				
			// 거래처 물품 발주 기능
			case 3:
				sellerOrderMenuText();
				subSelect = sc.nextInt();
				switch (subSelect) {
				case 1:
					sc.nextLine();
					System.out.println("물품을 발주 할 거래처명을 입력해주세요.");
					System.out.print(">");
					inputStringBuffer = sc.nextLine();
					listCon.orderItemFromSeller(inputStringBuffer);
					inputStringBuffer = null;
					break;
				case 2:
					sc.nextLine();
					System.out.println("거래내역들을 출력합니다.");
					logCon.showLog();
					break;
				case 3:
					System.out.println("발주 메뉴를 빠져나갑니다.");
					sc.nextLine();
					break;
				}
				break;
				
			// 거래처 수정	
			case 4:
				sc.nextLine();
				System.out.println("변경 할 거래처명을 입력하세요.");
				sellerName = sc.nextLine();
				System.out.println("거래처명을 새로 입력하세요.");
				sellerName = sc.nextLine();
				System.out.println("거래처의 연락처를 새로 입력하세요.");
				callNumber = sc.nextLine();
				System.out.println("거래처의 주소를 새로 입력해주세요.");
				sellerAddress = sc.nextLine();

				while (true) {
					System.out.println("물품목록 입력입니다.");
					System.out.println("물건의 대분류를 선택해주세요.");
					System.out.println("1. 강아지 / 2. 고양이");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer < 1 || inputIntBuffer > 2) {
						System.out.println("입력 범위를 초과하였습니다.");
						continue;
					}
					switch (inputIntBuffer) {
						case 1:
							bigCatagory.add("강아지");
							System.out.println("대분류 선택을 하였습니다.");
							inputIntBuffer = 0;
							break;
	
						case 2:
							bigCatagory.add("고양이");
							System.out.println("대분류 선택을 하였습니다.");
							inputIntBuffer = 0;
							break;
						}

					System.out.println("물건의 소분류를 선택해주세요.");
					System.out.println("1. 사     료");
					System.out.println("2. 간     식");
					System.out.println("3. 장  난  감");
					System.out.println("4. 미 용 도 구");
					inputIntBuffer = sc.nextInt();
					// 선택된 번호를 기반으로 스위치문으로 선택.
					if (inputIntBuffer < 1 || inputIntBuffer > 4) {
						System.out.println("입력범위를 초과하였습니다. 다시 입력해주세요!");
						continue;
					}
					switch (inputIntBuffer) {
						case 1:
							subCatagory.add("사료");
							inputIntBuffer = 0;
							break;
						case 2:
							subCatagory.add("간식");
							inputIntBuffer = 0;
							break;
						case 3:
							subCatagory.add("장난감");
							inputIntBuffer = 0;
							break;
						case 4:
							subCatagory.add("미용도구");
							inputIntBuffer = 0;
							break;
					}

					sc.nextLine();
					System.out.println("제품명을 입력해주세요.");
					inputStringBuffer = sc.nextLine();
					if (inputStringBuffer.isEmpty()) {
						System.out.println("제품명이 입력되지 않았습니다.");
					} else {
						System.out.println("제품명을 입력하였습니다.");
						sellList.add(inputStringBuffer);
						inputStringBuffer = null;
					}

					inputIntBuffer = 0;
					// sc.nextLine();
					System.out.println("물건의 매입가를 입력해주세요.");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer <= 0) {
						System.out.println("0이 입력됨. 가격은 1원이상이여야 합니다.");
					} else {
						System.out.println("물건 매입가를 입력하였습니다.");
						basePrice.add(inputIntBuffer);
						inputIntBuffer = 0;
					}
					// 위에서 입력을 무사히 입력받고 오면 각 배열들에 추가로 입력을 시도할 것인지 질문하고 돌아갈지 말지를 결정.
					sc.nextLine();
					System.out.println("입력이 성공적으로 완료되었습니다.");
					System.out.println("상품들을 추가로 더 입력하시겠습니까?");
					System.out.println("추가입력 : 1 / 입력종료 : 2");
					inputIntBuffer = sc.nextInt();
					if (inputIntBuffer == 1) {
						System.out.println("상품을 추가입력하기 위해 돌아갑니다.");
					} else if (inputIntBuffer == 2) {
						System.out.println("추가 입력을 종료합니다.");
						listCon.modifySeller(modifySellerName, sellerName, callNumber, sellerAddress, bigCatagory, subCatagory, sellList,
								basePrice);
						sellerName = null;
						callNumber = null;
						sellerAddress = null;
						bigCatagory.clear();
						subCatagory.clear();
						sellList.clear();
						basePrice.clear();
						break;
					}
				}
				break;
				
			//거래처 삭제
			case 5:
				sc.nextLine();
				System.out.println("삭제 할 거래처 이름을 입력하세요.");
				System.out.print(">");
				inputStringBuffer = sc.nextLine();
				listCon.deleteSeller(inputStringBuffer);
				inputStringBuffer = null;
				break;
				
			// 거래처 관리 기능 종료를 위해 flag를 false로 처리 함.
			case 6:
				flag = false;
				break;
			}
		}
	}

	private static void sellerMainText() {
		System.out.println("거래처 등록 기능.");
		System.out.println("1. 거래처 등록.");
		System.out.println("2. 거래처 조회.");
		System.out.println("3. 거래처 발주.");
		System.out.println("4. 거래처 수정.");
		System.out.println("5. 거래처 삭제.");
		System.out.println("6. 기 능 종 료.");
	}

	private static void sellerShowMenuText() {
		System.out.println("1. 거래처 전체 보기.");
		System.out.println("2. 특정 거래처 조회.");
	}

	private static void sellerOrderMenuText() {
		System.out.println("1. 거래처 발주 요청.");
		System.out.println("2. 거래처 발주 내역.");
	}
}
