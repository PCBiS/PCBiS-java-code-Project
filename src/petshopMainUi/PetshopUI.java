package petshopMainUi;

import java.util.Scanner;

import guestManager.GuestInterface;
import itemList.ItemListUserInterface;
import sellerList.SellerListUserInterface;

public class PetshopUI {
	public static void main(String[] args) {
		SellerListUserInterface sellerUI = new SellerListUserInterface();
		GuestInterface guestUI = new GuestInterface();
		ItemListUserInterface itemListUI = new ItemListUserInterface();
		Scanner sc = new Scanner(System.in);
		int mainSelect = -1;
		
		
		while (true) {
			System.out.println("펫샵 에버그린에 어서오세요.");
			System.out.println("원하시는 기능을 선택해주세요.");
			System.out.println("=========================");
			System.out.println("1. 회원 관리 기능");
			System.out.println("2. 거래처 관리 기능.");
			System.out.println("3. 재고 관리 기능.");
			System.out.println("4. 종  료  하  기");
			mainSelect = sc.nextInt();
			
			switch (mainSelect) {
			case 1:
				guestUI.main(args);
				break;
			case 2:
				sellerUI.main(args);
				break;
			case 3:
				itemListUI.main(args);
				break;
			case 4:
				System.out.println("펫샵을 방문해주셔서 감사합니다.");
				sc.close();
				System.exit(0);
			}
			
		}
	}
}
