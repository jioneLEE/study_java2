package 가변배열멤버저장및로드문제;

public class Member {

	String id;
	int num;
	
	public Member(String id, int num) {
		super();
		this.id = id;
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		return "num : " + num + ", id : " + id;
	}

	
}