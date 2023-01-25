package member2;
import java.util.Scanner;

public class MemberDAO {
	Scanner scan;
	int max;
	Member[] memberList;
	int memberCount;
	
	String getValue(String msg) {
		System.out.println(msg);
		return scan.next();
	}
	
	boolean exsitData() {
		if(memberCount == 0) {
			System.out.println("[ no data ] ");
			return false;
		}
		return true;
	}
	boolean checkMax() {
		if(memberCount == max) {
			System.out.println("[더이상 추가할 수 없습니다]");
			return false;
		}
		return true;
	}
	void init(int size) {
		scan = new Scanner(System.in);
		max = size;
		memberList = new Member[max];
		memberCount = 0;
	}
	
	void insertMember(Member member) {
		memberList[memberCount] = member;
		memberCount += 1;
	}
	
	boolean checkMemberId(String id) {
		for(Member m : memberList) {
			if(m == null) return false;
			if(m.id.equals(id)) {
				return true;
			}
		}		
		return false;
	}
	boolean checkLogin(String id , String pw) {
		for(Member m : memberList) {
			if(m == null) return false;
			if(m.id.equals(id)&&m.pw.equals(pw)) {
				return true;
			}
		}		
		return false;
	}
	void updateMember(int index , Member member) {
		memberList[index] = member;		
	}
	int getMemberIdx(String id) {
		int index = -1;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	void removeMember(int index) {
		for(int i = index; i < memberCount - 1 ; i++) {
			memberList[i] = memberList[i + 1];
		}
		memberList[memberCount-1] = null; 
		memberCount -= 1;
	}
	
	Member getMember(String id) {
		int idx = getMemberIdx(id);
		if(idx == -1) return null;
		return memberList[idx];
	}
	
	void printMemberList() {
		for(Member m : memberList) {
			if(m == null) return;
			m.printMember();
		}
	}
	

	
	void join() {
		if(!checkMax()) return;
		String id = getValue("[추가] 아이디입력 : ");
		if (checkMemberId(id)) {
			System.out.println("[중복아이디]");
			System.out.println("[추가실패]");
			return;
		}
		String pw = getValue("[추가] 비밀번호입력 : ");
		String name = getValue("[추가] 이름입력 : ");
		Member member = new Member(id, pw, name);

		insertMember(member);
		System.out.println("[추가성공]");

	}
	void delete() {
		if(!exsitData()) return;
		String id =  getValue("[삭제] 아이디입력 : ");
		if(!checkMemberId(id)) {
			System.out.println("[아이디를 찾을수 없습니다]");
			return;
		}
			int index = getMemberIdx(id);
			removeMember(index);
			System.out.println("[삭제성공]");
		
	}
	void update() {
		if(!exsitData()) return;
		String id =  getValue("[수정] 아이디입력 : ");
		String pw =  getValue("[수정] 비밀번호입력 : ");
		if(!checkLogin(id , pw)) {
			System.out.println("[로그인 실패]");
			return;
		}
			String name =getValue("[수정] 이름입력 : ");
			Member member = getMember(id);
			member.name = name;
			System.out.println("[수정완료]");
		
	}
	void printAll() {
		if(!exsitData()) return;
		printMemberList();
	}
	
}
