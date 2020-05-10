package guestManager;

import java.util.Scanner;

import exception.InputNullValueException;
import exception.OutOfExitcaseException;
import exception.OutOfNumberException;

public class GuestInterface implements GuestInfoInterface {
	public static void main(String[] args) {
		GuestInfoController info = GuestInfoController.getInstance();
		Scanner sc = new Scanner(System.in);
		String id = null, pw = null, pwCheck = null, oldPw = null, userName = null;
		int mainMenu = -1;

		while (true) {
			System.out.println("사용자 관리 기능입니다.");
			System.out.println("원하시는 기능을 선택 하세요.");
			System.out.println("1. 로그인 하기.");
			System.out.println("2. 로그아웃 하기.");
			System.out.println("3. 회 원 가 입.");
			System.out.println("4. 비밀번호 수정.");
			try {
				mainMenu = sc.nextInt();
				if (mainMenu < MAINMENU_LOGIN || mainMenu > MAINMENU_EXIT) {
					throw new OutOfExitcaseException("메뉴 선택범위 초과");
				}
			} catch (OutOfExitcaseException e) {
				System.out.println("메뉴 입력범위를 초과하였습니다.");
				System.out.println("입력 가능한 범위는 " + MAINMENU_LOGIN + " ~ " + MAINMENU_EXIT + "입니다.");
			}
			switch (mainMenu) {
			case MAINMENU_LOGIN:
				sc.nextLine();
				try {
					System.out.println("ID를 입력하세요.");
					System.out.print(">");
					id = sc.nextLine();
					System.out.println("Password를 입력하세요.");
					System.out.print(">");
					pw = sc.nextLine();
					if (id.isEmpty() || pw.isEmpty()) {
						throw new InputNullValueException("아이디, 비밀번호 빈 값 입력 됨.");
					}
				} catch (InputNullValueException e) {
					if (id.isEmpty()) {
						System.out.println("아이디가 입력 되지 않았습니다. 다시 입력해주세요.");
						id = null;
					} else if (pw.isEmpty()) {
						System.out.println("비밀번호가 입력 되지 않았습니다. 다시 입력해주세요.");
						pw = null;
					}
				}
				info.guestLogin(id, pw);
				id = null;
				pw = null;
				break;
			case MAINMENU_LOGOUT:
				sc.nextLine();
				try {
					System.out.println("ID를 입력하세요.");
					System.out.print(">");
					id = sc.nextLine();
					System.out.println("Password를 입력하세요.");
					System.out.print(">");
					pw = sc.nextLine();
					if (id.isEmpty() || pw.isEmpty()) {
						throw new InputNullValueException("아이디, 비밀번호 빈 값 입력 됨.");
					}
				} catch (InputNullValueException e) {
					if (id.isEmpty()) {
						System.out.println("아이디가 입력 되지 않았습니다. 다시 입력해주세요.");
						id = null;
					} else if (pw.isEmpty()) {
						System.out.println("비밀번호가 입력 되지 않았습니다. 다시 입력해주세요.");
						pw = null;
					}
				}
				info.guestLogout(id, pw);
				id = null;
				pw = null;
				break;
			case MAINMENU_REGISTERMEMBER:
				sc.nextLine();
				try {
					System.out.println("회원님의 성함을 입력해주세요.");
					userName = sc.nextLine();
					System.out.println("ID를 입력하세요.");
					id = sc.nextLine();
					System.out.println("Password를 입력하세요.");
					pw = sc.nextLine();
					if (id.isEmpty() || pw.isEmpty()) {
						throw new InputNullValueException("아이디, 비밀번호 빈 값 입력 됨.");
					}
				} catch (InputNullValueException e) {
					if (id.isEmpty()) {
						System.out.println("아이디가 입력 되지 않았습니다. 다시 입력해주세요.");
						id = null;
					} else if (pw.isEmpty()) {
						System.out.println("비밀번호가 입력 되지 않았습니다. 다시 입력해주세요.");
						pw = null;
					}
				}
				info.setGuestInfo(id, userName, pw);
				id = null;
				pw = null;
				userName = null;
				break;
			case MAINMENU_MODIFYPW:
				while (true) {
					sc.nextLine();
					System.out.println("ID를 입력하세요.");
					System.out.print(">");
					id = sc.nextLine();
					System.out.println("기존 Password를 입력하세요.");
					System.out.print(">");
					oldPw = sc.nextLine();
					System.out.println("새로운 Password를 입력하세요.");
					System.out.print(">");
					pw = sc.nextLine();
					System.out.println("새로운 Password를 다시 한번 입력하세요.");
					System.out.print(">");
					pwCheck = sc.nextLine();
					if (pw.equals(pwCheck)) {
						info.changePassword(id, oldPw, pw);
						id = null;
						pw = null;
						oldPw = null;
						pwCheck = null;
						break;
					} else {
						info.changePassword(id, oldPw, pw);
						id = null;
						pw = null;
						oldPw = null;
						pwCheck = null;
					}
					break;
				}
				break;
			}

		}
	}
}
