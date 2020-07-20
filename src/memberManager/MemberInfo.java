package memberManager;

public class MemberInfo {
	String id = null;
	String userName = null;
	String password = null;
	int userPoint = 0;
	int absoultePoint = 0;
	boolean isLogin = false;
	boolean isAdmin = false;
	
	public MemberInfo(String id, String userName, String password, int userPoint, int absoultePoint) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userPoint = userPoint;
		this.absoultePoint = absoultePoint;
	}
	
	public MemberInfo(String id, String userName, String password, int userPoint, int absoultePoint, boolean isAdmin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userPoint = userPoint;
		this.absoultePoint = absoultePoint;
		this.isAdmin = isAdmin;
	}
	
	public void showUserInfo() {
		System.out.println("사용자 이름 : " + this.id + " 사용자 ID : " + this.userName + " 사용자 보유 포인트 : " + this.userPoint);
	}
}
