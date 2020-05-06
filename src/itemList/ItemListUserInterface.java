package itemList;

import java.util.Scanner;

import itemList.Exception.OutOfExitcaseException;
import itemList.Exception.OutOfNumberException;

public class ItemListUserInterface implements ItemListInterface {
	public static void main(String[] args) {
		HaveItemListController listCon = HaveItemListController.getInstance();
		int bigCatagory=-1, subCatagory=-1;
		boolean menuExitFlag = true;
		char exitFlag =' ';
		Scanner sc = new Scanner(System.in);		
		
		//listCon.list.add(new HaveItemList(bigCatagory, subCatagory, itemName, sellerName, itemCount, basePrice, sellPrice));
		
		while (menuExitFlag) {
			try {
				mainCatagoryMenu();
				bigCatagory = sc.nextInt();
				if(bigCatagory<AllList||bigCatagory>ExitList) {
					throw new OutOfNumberException("");
				}
			} catch (OutOfNumberException e) {
				System.out.println("숫자는 " + AllList + " ~ " + ExitList + " 이내에서 입력되어야 합니다.");
				System.out.println("만약 종료를 원하신다면 '4' 번을 입력해주세요.");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("입력범위를 초과하였습니다.");
				System.out.println("숫자는 " + AllList + " ~ " + ExitList + " 이내에서 입력되어야 합니다.");
				sc.nextLine();
			} catch (NullPointerException e) {
				System.out.println("아무것도 입력 받지 못하였습니다.");
				System.out.println("숫자는 " + AllList + " ~ " + ExitList + " 이내에서 입력되어야 합니다.");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("알 수 없는 예외가 발생하였습니다.");
				System.out.println("숫자를 다시 입력해주십시요.");
				sc.nextLine();
			}
			
			switch (bigCatagory) {
			case AllList:
				try {
					subCatagoryMenu();
					sc.nextLine();
					subCatagory = sc.nextInt();
					if(subCatagory<AllShowNum||subCatagory>ExitSubList) {
						throw new OutOfNumberException("");
					}

				} catch (OutOfNumberException e) {
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					System.out.println("만약 종료를 원하신다면 '" + ExitSubList + "' 번을 입력해주세요.");
					sc.nextLine();
				} catch (ArithmeticException e) {
					System.out.println("입력범위를 초과하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (NullPointerException e) {
					System.out.println("아무것도 입력 받지 못하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("알 수 없는 예외가 발생하였습니다.");
					System.out.println("숫자를 다시 입력해주십시요.");
					sc.nextLine();
				}				
				switch (subCatagory) {
				case AllShowNum:
					listCon.showRemainItem(ALL, ALL);
					break;
				case FoodNum:
					listCon.showRemainItem(ALL, FOOD);
					break;
				case SnackNum:
					listCon.showRemainItem(ALL, SNACK);
					break;
				case ToyNum:
					listCon.showRemainItem(ALL, TOY);
					break;
				case BeautyNum:
					listCon.showRemainItem(ALL, BEAUTY);
					break;
				case CannelNum:
					listCon.showRemainItem(ALL, CANNEL);
					break;
				case OtherNum:
					listCon.showRemainItem(ALL, OTHER);
					break;
				case ExitSubList:
					System.out.println("이전 선택지로 돌아갑니다.");
					break;
				}
				break;
			case CatList:
				try {
					subCatagoryMenu();
					sc.nextLine();
					subCatagory = sc.nextInt();
					if(subCatagory<AllShowNum||subCatagory>ExitSubList) {
						throw new OutOfNumberException("");
					}

				} catch (OutOfNumberException e) {
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					System.out.println("만약 종료를 원하신다면 '" + ExitSubList + "' 번을 입력해주세요.");
					sc.nextLine();
				} catch (ArithmeticException e) {
					System.out.println("입력범위를 초과하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (NullPointerException e) {
					System.out.println("아무것도 입력 받지 못하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("알 수 없는 예외가 발생하였습니다.");
					System.out.println("숫자를 다시 입력해주십시요.");
					sc.nextLine();
				}

				switch (subCatagory) {
				case AllShowNum:
					listCon.showRemainItem(CAT, ALL);
					break;
				case FoodNum:
					listCon.showRemainItem(CAT, FOOD);
					break;
				case SnackNum:
					listCon.showRemainItem(CAT, SNACK);
					break;
				case ToyNum:
					listCon.showRemainItem(CAT, TOY);
					break;
				case BeautyNum:
					listCon.showRemainItem(CAT, BEAUTY);
					break;
				case CannelNum:
					listCon.showRemainItem(CAT, CANNEL);
					break;
				case OtherNum:
					listCon.showRemainItem(CAT, OTHER);
					break;
				case ExitSubList:
					System.out.println("이전 선택지로 돌아갑니다.");
					break;
				}
				break;
			case DogList:
				try {
					subCatagoryMenu();
					sc.nextLine();
					subCatagory = sc.nextInt();
					if(subCatagory<AllShowNum||subCatagory>ExitSubList) {
						throw new OutOfNumberException("");
					}

				} catch (OutOfNumberException e) {
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					System.out.println("만약 종료를 원하신다면 '" + ExitSubList + "' 번을 입력해주세요.");
					sc.nextLine();
				} catch (ArithmeticException e) {
					System.out.println("입력범위를 초과하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (NullPointerException e) {
					System.out.println("아무것도 입력 받지 못하였습니다.");
					System.out.println("숫자는 " + AllShowNum + " ~ " + OtherNum + " 이내에서 입력되어야 합니다.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("알 수 없는 예외가 발생하였습니다.");
					System.out.println("숫자를 다시 입력해주십시요.");
					sc.nextLine();
				}

				switch (subCatagory) {
				case AllShowNum:
					listCon.showRemainItem(DOG, ALL);
					break;
				case FoodNum:
					listCon.showRemainItem(DOG, FOOD);
					break;
				case SnackNum:
					listCon.showRemainItem(DOG, SNACK);
					break;
				case ToyNum:
					listCon.showRemainItem(DOG, TOY);
					break;
				case BeautyNum:
					listCon.showRemainItem(DOG, BEAUTY);
					break;
				case CannelNum:
					listCon.showRemainItem(DOG, CANNEL);
					break;
				case OtherNum:
					listCon.showRemainItem(DOG, OTHER);
					break;
				case ExitSubList:
					System.out.println("이전 선택지로 돌아갑니다.");
					break;
				}
				case ExitList:
					try {
						sc.nextLine();
						System.out.println("정말 종료하고 이전 메뉴로 돌아가시겠습니까?");
						System.out.print("Yes or No - Y/N : ");
						exitFlag = sc.next().charAt(0);
						if (exitFlag=='Y'||exitFlag=='y') {
							menuExitFlag=false;
							break;
						}else if (exitFlag=='N'||exitFlag=='n'){
							System.out.println("상위 메뉴로 돌아갑니다.");
							sc.nextLine();
							break;
						}else{
							throw new OutOfExitcaseException("Y or N 을 입력해주십시요, 대/소문자는 구분하지 않습니다.");
						}
					}catch (OutOfExitcaseException e) {
						sc.nextLine();
						System.err.println(e);
					}
					catch (Exception e) {
						sc.nextLine();
						System.err.println("알 수 없는 에러가 발생하였습니다. 다시 입력해주세요.");
					}
				break;
			}			
		}
	}
	
	static void mainCatagoryMenu() {
		System.out.println("==========상 품 목 록 보 기===========");
		System.out.println("| 1 : 전       체 || 2 :  고  양  이 |");
		System.out.println("| 3 : 강   아  지 || 4 : 종 료 하 기  |");
		System.out.println("===================================");
	}
	
	static void subCatagoryMenu() {
		System.out.println("=================상품 세부 목록 보기==================");
		System.out.println("|1 : 전 체 보 기 || 2 : 사      료 || 3 : 간      식 |");
		System.out.println("|4 : 장  난  감 || 5 : 미 용 도 구 || 6 : 켄      넬  |");
		System.out.println("|7 : 기 타 목 록 || 8 : 세부목록 나가기                |");
		System.out.println("==================================================");
	}
}
