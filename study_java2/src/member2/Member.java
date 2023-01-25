package member2;
public class Member {
	String id;
	String pw;
	String name;
	void printMember() {
		System.out.println(id + " : " + pw + " : " + name);
	}
	
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	@Override
	public String toString() {
		return id + " : " + pw + " : " + name;
	}
	
	
	
}
