package 메서드2_문제연습;

import java.util.Arrays;
import java.util.Scanner;

// 메서드 생성원칙 : 1. 영어로 동사로 시작 , 리턴값이 boolean 값이면 is 
// 메서드는 기능 1개만 구현한다 

class MemberManager{
	// 추가 삭제 수정 
	int maxSize = 10;
	int initNum = 1001; // 맨 처음 추가 회원 번호 
	int cnt; // 현재 추가된 회원 수 
	 
    // [0]번호 [1]아이디 [2]비밀번호 [3]이름
	int no = 0;
	int id = 1;
	int pw = 2;
	int name=3;
	String[][] memberList = new String[maxSize][4];
	
	
	 int checkValue(int idx , String val  ) {
		 for(int i =0; i < cnt; i++) {
			 if(memberList[i][idx].equals(val)) {
	
				 return i;
			 }
		 }
		 return -1;
	 }
	
//	// 체크 
//	 int checkId(String id) {
//		 for(int i =0; i < cnt; i++) {
//			 if(memberList[i][this.id].equals(id)) {
//	
//				 return i;
//			 }
//		 }
//		 return -1;
//	 }
//	// 회원 번호 체크 
//	 int checkNum(String num) {
//		 for(int i =0; i < cnt; i++) {
//			 if(memberList[i][no].equals(num)) {
//	
//				 return i;
//			 }
//		 }
//		 return -1;
//	 }
//	 
	
	//회원 추가 => 중복아이디 값이 없어야한다 
	void addMember() {
		if(cnt == maxSize) {
			System.out.println("[정원 초과 : 추가 실패]");
			return;
		}
		System.out.println("[ 회원 추가 ]");
		String id = getInput("ID 입력");
		
		if(checkValue(this.id,id)!= -1) {
			 System.out.println("아이디가 이미 존재합니다");
			return;
		}
		memberList[cnt][this.id] = id;
		
		String pw = getInput("PW 입력");
		memberList[cnt][this.pw] = pw;
		
		String name = getInput("이름 입력");
		memberList[cnt][this.name] = name;
		memberList[cnt][no] = generatorNum();
		System.out.println(Arrays.toString(memberList[cnt]));
		cnt++;

		System.out.println("회원 추가 완료");

	}
	
	// 회원 번호 자동으로 생성 : 자동으로 1 증가하게 
	String generatorNum() {
		String num ="";
		if(cnt == 0) {
			return initNum +"";
		}
		num = Integer.parseInt(memberList[cnt-1][no])+1 +"";
	
		return num;
	}
	
	// 사용자에게 입력 받아오는 기능  
	 int getInput(String msg ,int val) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print(msg +"  >> ");
		  val = sc.nextInt();
		 return val;
	 }
	 
		// 메서드 오버로딩 
	 String getInput(String msg) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print(msg +"  >> ");
		 return sc.next();
	 }

	
	//회원 삭제 => 아이디 입력 받아서 아이디가 있으면 회원삭제 
	
	 void deleteMember() {
			if(cnt == 0) {
				System.out.println("[데이터 없음 : 삭제 실패]");
				return;
			}
			//String id = getInput("아이디 입력");
			//int idx = checkId(id);
			int idx = checkValue(id,getInput("아이디 입력"));
			if(idx == -1) {
				System.out.println("해당 아이디가 존재하지 않습니다");
				return;
			}
			
			for(int i =idx; i < cnt-1; i++) {
				memberList[i] = memberList[i+1];
			}
			memberList[cnt-1] = new String[4];
			cnt--;
			System.out.println("[ 회원 삭제 성공 ]");
			
	 }
	 
	 
	//회원 수정 => 회원 번호 입력 받아서 아이디 수정하기 
	 void modifyMember() {
			int idx = checkValue(no,getInput("회원 번호 입력"));
			if(idx == -1) {
				System.out.println("[없는 회원 번호]");
				return;
			}
			String newId = getInput("수정할 아이디 입력");
			if(newId.equals(memberList[idx][id])) {
				System.out.println("기존 아이디값과 다른 값 입력하세요");
				return;
			}
			memberList[idx][id] = newId;
			System.out.println("[ 회원 수정 성공 ]");
			
	 }
	
	// 전체 회원 출력 
	 
	 void printAllMember() {
		 System.out.println("[  전체 회원 출력  ]");
		 for(String[] member: memberList) {
			 if(member[no] == null) {
				 break;
			 }
			 System.out.println(Arrays.toString(member));
		 }
		 System.out.println();
	 }


	
	// 메뉴출력 
	 void printMenu() {
		 String menu = "==== 메가 회원 === \n";
		 menu+= "[1] 회원 추가 \n";
		 menu+= "[2] 회원 출력 \n";
		 menu+= "[3] 회원 삭제 \n";
		 menu+= "[4] 회원 수정 \n";
		 menu+= "[0] 종    료 \n";
		 
		 System.out.println(menu);
	 }
	

	
	 void run() {
		 printMenu();
		 
		 while(true) {
			 int sel = getInput("메뉴 선택하시오" , 0);
			 if(sel == 0) {
					System.out.println("=== 프로그램 종료 ===");
				 return;
			 }else if(sel == 1) {
				 addMember();
			 }else if(sel == 2) {
				 printAllMember();
			 }else if(sel == 3) {
				 deleteMember();
			 }else if(sel == 4) {
				 modifyMember();
			 }else {
				 System.out.println("번호 입력 오류 ");
			 }
		 }
	 }
 
	
}

public class 메서드문제04_회원가입_정답1 {

	public static void main(String[] args) {

		MemberManager mg = new MemberManager();
		mg.run();


	}

}