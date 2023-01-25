package 메서드2;

import java.util.Arrays;
import java.util.Scanner;

// 메서드 생성원칙 : 1. 영어로 동사로 시작 , 리턴값이 boolean 값이면 is 
// 메서드는 기능 1개만 구현한다 

class MemberManager{
	// 추가 삭제 수정
	 Scanner sc = new Scanner(System.in);
	int maxSize = 10;
	int initNum = 1001; // 맨 처음 추가 회원 번호 
	int cnt; // 현재 추가된 회원 수 
	int idx = -1;
	int num;
	 
	          // [0]번호 [1]아이디 [2]비밀번호 [3]이름
	String[][] memberList = new String[maxSize][4];
	
	//회원 추가 => 중복아이디 값이 없어야한다 
	void addMember() {
		if(cnt == maxSize) {
			System.err.println("더이상 아이디를 만들수 없습니다.");
		}else {
		
		while(true) {
		System.out.println("[ 회원 추가 ]");
		String id = getInforStr("회원가입 아이디를 작성 >>");
		String pw = getInforStr("비밀번호 입력 >> ");
		String name = getInforStr("이름 입력 >> ");
		boolean check = isDuplicate(id);
		if(check) {
			System.err.println("이미 존재하는 아이디입니다.");
			continue;
		}
		
		memberList[cnt][0] = String.valueOf(initNum+num);
		memberList[cnt][1] = id;
		memberList[cnt][2] = pw;
		memberList[cnt][3] = name;
		cnt++;
		num++;
		break;
		}
	}
	}
	//아이디 체크 
	boolean isDuplicate(String id) {
		boolean check = false;
		for(int i =0; i<cnt; i++) {
		if(memberList[i][1].equals(id)) {
			check = true;
			idx = i;
			break;
		}
		}
		
		return check;
	}
	//회원 삭제 => 아이디 입력 받아서 아이디가 있으면 회원삭제 
	void delId() {
		String id = getInforStr("삭제할 아이디 입력 >> ");
		boolean check = isDuplicate(id);
		if(check){
			for(int i =idx; i<cnt-1 ; i++) {
				for(int k =0; k<memberList[i].length; k++) {
				memberList[i][k] = memberList[i+1][k];
				}
			}
			for(int i = 0; i<memberList[i].length; i++) {
				memberList[cnt][i] = "";
			}
			cnt--;
		}else {
			System.err.println("삭제할 아이디가 옮바르지 않습니다.");
		}
	}
	
	//회원 수정 => 회원 번호 입력 받아서 아이디 수정하기 
	void changeId() {
		String id = getInforStr("아이디 입력 >> ");
		boolean check = isDuplicate(id);
		if(check) {
			String changeId = getInforStr("수정할 아이디 입력 >> ");
			for(int i =0; i<cnt; i++) {
				if(id.equals(memberList[i][1])) {
					memberList[i][1] = changeId;
				}
			}
		}else {
			System.err.println("입력하신 아이디는 없는아이디 입니다.");
		}
		
	}
	
	// 전체 회원 출력
	void print() {
		if (cnt == 0) {
			System.err.println("현재 회원가입 아이디 없음.");
		} else {
			System.out.println("[회원번호 아이디 비밀번호  이름]");
			for (int i = 0; i < cnt; i++) {
				System.out.printf(" %s  %5s %5s %3s \n",memberList[i][0],memberList[i][1],memberList[i][2],memberList[i][3]);
			}
		}
	}
	
	// 회원 번호 체크 
	
	// 회원 번호 자동으로 생성 : 자동으로 1 증가하게 
	
	// 메뉴출력 
	 void printMenu() {
		 String menu = "==== 메가 회원 === \n";
		 menu+= "[1] 회원 추가 \n";
		 menu+= "[2] 회원 출력 \n";
		 menu+= "[3] 회원 삭제 \n";
		 menu+= "[4] 회원 수정 \n";
		 menu+= "[0] 종    료 \n"+ cnt;
		 
		 System.out.println(menu);
	 }
	
	
	// 사용자에게 입력 받아오는 기능 
	 // int 번호입력
	 int getInputInt(String msg) {
		 System.out.println(msg);
		 System.out.print("입력 >> ");
		 return sc.nextInt();
	 }
	 // Str 입력
	 String getInforStr(String msg) {	 
		 System.out.print(msg);
		 return sc.next();
	 }
	
	 // 실행
	 void run() {
		 while(true) {
		 
			 printMenu();
			 int sel = getInputInt("메뉴 선택하시오");
			 
			 if(sel == 0) {
				 return;
			 }else if(sel == 1) {
				 addMember();
			 }else if(sel == 2) {
				 print();
			 }else if(sel == 3) {
				 delId();
			 }else if(sel == 4) {
				 changeId();
			 }else {
				 System.out.println("번호 입력 오류 ");
			 }
		 }
	 }
 
	
}

public class 메서드회원가입 {

	public static void main(String[] args) {

		MemberManager mg = new MemberManager();
		mg.run();
		
//		mg.printMenu();
//		int sel = mg.getInputInt("메뉴 선택하시오");
//		if(sel == 0) {
//			
//		}
		
		System.out.println("=== 프로그램 종료 ===");
	}

}