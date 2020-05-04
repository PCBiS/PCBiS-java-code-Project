package petshop;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		RemainItemList item = RemainItemList.getInstance();
		item.haveMoney = 1000000; // 초기 테스트를 위여 1만의 초기 값을 부여함.
		String itemName, itemCatagory=null, sellerName;
		int itemCount, itemPrice, select, subSelect;
		Scanner sc = new Scanner(System.in);
		while (true) {
			mainText();
			select = sc.nextInt();
			switch (select) {
			case 1:
				sc.nextLine();
				System.out.println("추가 할 제품의 종류를 입력하세요.");
				System.out.println("1. 고양이 / 2. 강아지 / 3. 기타 동물");
				subSelect = sc.nextInt();
				switch (subSelect) {
				case 1:
					itemCatagory = "고양이";
					sc.nextLine();
					break;
				case 2:
					itemCatagory = "강아지";
					sc.nextLine();
					break;
				case 3:
					itemCatagory = "기타동물";
					sc.nextLine();
					break;
				}
				System.out.println("추가 할 제품명을 입력해주세요.");
				itemName = sc.nextLine();
				System.out.println("판매하는 상점명을 입력해주세요.");
				sellerName = sc.nextLine();
				System.out.println("추가 할 물건의 제품단가를 입력하세요.");
				itemPrice = sc.nextInt();
				System.out.println("추가 할 물건의 매입 개수를 입력해주세요.");
				itemCount = sc.nextInt();
				item.setItem(itemCatagory, itemName, sellerName, itemPrice, itemCount);
				break;
			case 2:
				sc.nextLine();
				System.out.println("판매 할 아이템의 이름을 입력하세요.");
				itemName = sc.nextLine();
				System.out.println("판매 할 아이템의 개수를 입력하세요.");
				itemCount = sc.nextInt();
				item.soldItem(itemName, itemCount);
				break;
			case 3:
				sc.nextLine();
				System.out.println("매입 한 아이템의 이름을 입력해주세요.");
				itemName = sc.nextLine();
				System.out.println("몇개를 매입하셨나요?");
				itemCount = sc.nextInt();
				System.out.println("매입 단가는 얼마인가요?");
				itemPrice = sc.nextInt();
				item.stockItem(itemName, itemCount, itemPrice);
				break;
			case 4:
				item.showRemainItem();
				break;
			case 5:
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("잘못된 입력입니다!");
				break;
			}
		}
	}

	static void mainText() {
		System.out.println("기능 테스트용 메인.");
		System.out.println("1. 아이템 추가.");
		System.out.println("2. 아이템 판매.");
		System.out.println("3. 아이템 매입.");
		System.out.println("4. 아이템 재고 보기.");
		System.out.println("5. 종 료 하 기.");
	}
}
