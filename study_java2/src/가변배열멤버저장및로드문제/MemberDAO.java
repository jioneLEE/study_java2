package 가변배열멤버저장및로드문제;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MemberDAO {
	int num; // 학번 1001 시작 
	Member[] memberList;
	String path;
	int cnt;
	
	MemberDAO(){
		num = 1000;
		path = "src/가변배열멤버저장및로드문제/memberList.txt";
	}

	String getValue(String msg) {
		// id 입력 받을 때 숫자값만 입력받으면 id 는 적어도 한개 문자값 포함이라는
		// 예외처리 적용해보세요
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " > ");
		String val = "";
		int cnt =0;
		val = sc.next();
		for (int i = 0; i < val.length(); i++) {
			if (val.charAt(i) >= '0' && val.charAt(i) <= '9') {
				cnt++;
			}
		}
		try {
			if (val.length() == cnt) {
				throw new Exception("[err 아이디는 숫자만으로 구성할 수 없습니다.]");
			}
		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
			return val = null;
		}
		return val;
	}
	
	boolean isMemberList() {
		if(memberList == null) return false;
		return true;
	}
	
	boolean checkId(String id) {
		if(!isMemberList()) return false;
		
		for(Member m : memberList) {
			if(m.id.equals(id))
				return true;
		}
		
		return false;
	}
	
	int getNum() {
		num++;
		return num;
	}
	
   void join() {
		while (true) {
			String id = null;
			while(id == null) {
				id = getValue("아이디 입력");
			}
			if(checkId(id)) {
				System.out.println("이미 존재하는 아이디입니다.");
				continue;
			}
			
			Member m = new Member(id, getNum());
			insertMember(m);
			System.out.println("[학생추가 완료] " + m);
			
			break;
		}
	  
   }
   
	void insertMember(Member m) {
		int cnt = isMemberList()? memberList.length : 0;
		if(cnt == 0) {
			memberList = new Member[1];
		}else {
			Member[] temp = memberList;
			memberList = new Member[cnt+1];
			for(int i =0; i<temp.length; i++) {
				memberList[i] = temp[i];
			}
		}
		memberList[cnt] = m;
	}
	
	int checkhakbeonIdx(int num) {
		for(int i =0; i<memberList.length; i++) {
			if(memberList[i].num == num) {
				return i;
			}
		}
		System.out.println("[학번이 존재하지않습니다.]");
		return -1;
	}
   
	void update() {
		
		if (isMemberList()) {
			MemberController mc = new MemberController();
			
			int num = -1;
			int idx = -1;
			while(num == -1) {
				num = mc.getValue("학번입력", 1001, 9999);

				if (idx == -1) {
					idx = checkhakbeonIdx(num);
				}
				if (idx == -1) {
					num = -1;
					continue;
				}
			}

			String newId = null;
			while (newId == null) {
				newId = getValue("바꿀 아이디 >>");
			}
			memberList[idx].id = newId;
			System.out.println("[아이디가 변경되었습니다.]");
			
		} else {
			System.out.println("[멤버리스트가 존재하지 않습니다.]");
		}
		
	} // 수정 하고자 하는 학번입력하면 아이디 수정 
	void remove() {
		if(!isMemberList()) {System.out.println("[멤버리스트가 존재하지 않습니다.]"); return;}
		MemberController mc = new MemberController();
		int num = -1;
		int idx = -1;
		while(num == -1) {
			num = mc.getValue("학번입력", 1001, 9999);
			if(num ==-1) {
				continue;
			}
			if (idx == -1) {
				idx = checkhakbeonIdx(num);
			}
			if (idx == -1) {
				num = -1;
				continue;
			}
		}
		int cnt = memberList.length;
		System.out.println(idx +"+"+ cnt);
		Member[] temp = memberList;
		memberList = new Member[cnt-1];
		int idxList=0;
		for(int i =0; i<temp.length; i++) {
			if(idx != i) {
			memberList[idxList] = temp[i];
			idxList++;
			}
		}
	} // 삭제하고자 하는 학번 입력 
	void printMember(){
		if(!isMemberList()) {System.out.println("[멤버리스트가 존재하지 않습니다.]"); return;}
		
		System.out.println("[멤버 리스트 현황]");
		for(Member m : memberList) {
			System.out.println(m);
		}
	}
	void saveData() {
		FileWriter fw = null;
		String save = "";
		for(Member m : memberList) {
			save += m.id+","+m.num+"\n";
		}
		save = save.substring(0, save.length()-1);
		try {
			fw = new FileWriter(path);
			fw.write(save);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 저장패턴 memberList.text
		// 아이디,학번\n 이렇게 한줄로 저장 
		
		// 저장예시
		// 1001,test1\nl002,test2
		
	}
	void loadData() {
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			String save ="";			
			int read = 0;
			while (true) {
				read = fr.read();
				if(read!= -1) {
					save += (char) read; // save = save + read;
				}else {
					break;
				}
			}
			
			String[] temp = save.split("\n");	
			memberList = new Member[temp.length];

			for (int i = 0; i < memberList.length; i++) {
				String[] temp1 = temp[i].split(",");
				System.out.println(Arrays.toString(temp1));
				Member m = new Member(temp1[0],Integer.parseInt(temp1[1]));
				memberList[i] = m;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}