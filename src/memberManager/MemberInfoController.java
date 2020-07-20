package memberManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberInfoController {
	
	
	private static MemberInfoController instance;
	
	List<MemberInfo> info;
	
	private MemberInfoController() {
		info = new ArrayList<MemberInfo>();
	}
	public static MemberInfoController getInstance() {
		if (instance==null) {
			instance = new MemberInfoController();
		}
		return instance;
	}
	
	public void setGuestInfo(String id, String userName, String password) {
		if (id.isEmpty()||userName.isEmpty()||password.isEmpty()) {
			System.out.println("ID나 Password 혹은 사용자 이름이 누락되었습니다!");
		}else if(overlapIDCheck(id)){
			System.out.println("중복된 아이디가 존재합니다. 다시 확인 바랍니다.");
		}else {
			info.add(new MemberInfo(id, userName, password, 0, 0));
			System.out.println(userName + " 님 께서 신규 회원으로 가입하셨습니다. 가입하신 id는 " + id + " 입니다.");
		}
	}
	
	public void setAdminInfo(String id, String userName, String password) {
		if (id.isEmpty()||userName.isEmpty()||password.isEmpty()) {
			System.out.println("ID나 Password 혹은 사용자 이름이 누락되었습니다!");
		}else if(overlapIDCheck(id)){
			System.out.println("중복된 아이디가 존재합니다. 다시 확인 바랍니다.");
		}else {
			info.add(new MemberInfo(id, userName, password, 0, 0));
			System.out.println(userName + " 님 께서 관리자 회원으로 가입하셨습니다. 가입하신 id는 " + id + " 입니다.");
		}
	}
	
	public void showGuestInfo() {
		for (int i = 0; i < info.size(); i++) {
			info.get(i).showUserInfo();
		}
	}
	
	public void showGuestInfo(String id) {
		for (int i = 0; i < info.size(); i++) {
			if (id.equals(info.get(i).id)) {
				info.get(i).showUserInfo();
				break;
			}
		}
	}
	
	public void findMyID(String name) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < info.size(); i++) {
			if (name.equals(info.get(i).userName)) {
				info.get(i).showUserInfo();
				break;
			}
		}
		System.out.println("이름과 일치하는 회원명을 찾지 못하였습니다. 회원 가입 하시겠습니까?");
		if (sc.nextLine()=="Y" || sc.nextLine()=="y") {
			
		}
	}
	
	
	public boolean isLoginCheck(String id) {
		boolean isLogin = false;
		for (int i = 0; i < info.size(); i++) {
			if (id.equals(info.get(i).id) && info.get(i).isLogin==true) {
				isLogin = true;
			}else {
				isLogin = false;
			}
		}
		return isLogin;
	}
	
	
	public void guestLogin(String id, String pw) {
		for (int i = 0; i < info.size(); i++) {
			if (!id.equals(info.get(i).id) || !pw.equals(info.get(i).password)) {
				System.out.println("로그인이 실패하였습니다, ID나 Password를 다시한번 확인해주십시요.");
			}else if (id.equals(info.get(i).id) && pw.equals(info.get(i).password) && info.get(i).isLogin==true) {
				System.out.println("로그인이 실패하였습니다, 이미 로그인이 되어 있는 상태입니다.");
			}else{
				System.out.println("사용자 " + info.get(i).userName + " 님이 로그인 하셨습니다.");
				info.get(i).isLogin = !false;
				break;	
			}
		}
	}

	public void guestLogout(String id, String pw) {
		for (int i = 0; i < info.size(); i++) {
			if (!id.equals(info.get(i).id) || !pw.equals(info.get(i).password)) {
				System.out.println("로그아웃이 실패하였습니다, ID나 Password를 다시한번 확인해주십시요.");
			} else if (id.equals(info.get(i).id) && pw.equals(info.get(i).password) && info.get(i).isLogin==false) {
				System.out.println("로그아웃이 실패하였습니다, 이미 로그아웃이 되어 있는 상태입니다.");
			} else if (id.equals(info.get(i).id) || pw.equals(info.get(i).password)){
				info.get(i).isLogin = false;
				System.out.println("사용자 " + info.get(i).userName + " 님이 로그아웃 하셨습니다.");
				break;
			}
		}
	}
	
	public void changePassword(String id, String oldPw, String changePw) {
		for (int i = 0; i < info.size(); i++) {
			if (!id.equals(info.get(i).id) || !oldPw.equals(info.get(i).password)) {
				System.out.println("비밀번호 변경에 실패하였습니다, ID나 Password를 다시한번 확인해주십시요.");
			}else if (id.equals(info.get(i).id) && oldPw.equals(info.get(i).password)) {
				info.get(i).password = changePw;
				System.out.println("비밀번호 변경에 성공하였습니다.");
				break;
			}
		}
		
	}
	
	public void usePoint(String id, String pw, int point) {
		for (int i = 0; i < info.size(); i++) {
			if (!id.equals(info.get(i).id) || !pw.equals(info.get(i).password) || !info.get(i).isLogin==true) {
				System.out.println("포인트 사용에 실패하였습니다, ID나 Password를 다시한번 확인해주십시요.");
			}else if(id.equals(info.get(i).id) && !pw.equals(info.get(i).password) && info.get(i).isLogin==true && info.get(i).userPoint < point){
				System.out.println("포인트가 부족하여 포인트 사용에 실패하였습니다.");
				System.out.println("현재 남은 포인트 : " + info.get(i).userPoint);
				System.out.println("사용하려 한 포인트 : " + point);
				System.out.println(" 부족한 포인트 : " + Math.abs(info.get(i).userPoint - point));
			}else if (id.equals(info.get(i).id) && !pw.equals(info.get(i).password) && info.get(i).isLogin==true) {
				System.out.println(info.get(i).userName + " 님께서 보유하신 현재 포인트 " + info.get(i).userPoint);
				System.out.println("에서 " + point + " 를 차감하였습니다.");
				info.get(i).userPoint -= point;
				System.out.println("현재 남은 포인트는 " + info.get(i).userPoint + " 입니다.");
				break;
			}
		}
	}
	
	public void setPoint(String id, String pw, int point) {
		for (int i = 0; i < info.size(); i++) {
			if (id.equals(info.get(i).id) && pw.equals(info.get(i).password) && info.get(i).isLogin==true) {
				info.get(i).userPoint += point;
				info.get(i).absoultePoint += point;
				System.out.println("이번 구매로 " + point + " 가 적립되었습니다.");
				System.out.println(info.get(i).userName + " 님의 현재 총 적립포인트는 " + info.get(i).userPoint + " 입니다.");
				break;
			}else {
				System.out.println("포인트 적립 실패하였습니다, ID나 Password를 다시한번 확인해주십시요.");				
			}
		}
	}
	
	//내부 사용 전용기능.
	private boolean overlapIDCheck(String id) {
		boolean isOverlapID = false;
		for (int i = 0; i < info.size(); i++) {
			if (info.get(i).id.contains(id)) {
				isOverlapID = true;
			}
		}
		return isOverlapID;
	}
}
