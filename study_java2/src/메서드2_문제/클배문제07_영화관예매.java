package 메서드2_문제;

import java.util.Scanner;

class SeatVO{
	int num;
	boolean check;
}

class SeatDAO{
	SeatVO [] seatList = new SeatVO[8];
	String name;
	int cnt;
	int money;
	
	void init() {
		for(int i =0; i<seatList.length; i++) {
			seatList[i] = new SeatVO();
			seatList[i].num = i;
		}
		name="==메가박스==\n"
			+"1.예매하기\n"
			+"0.종료\n";
	}
	// 좌석 및 매뉴출력
	void printMenu() {
		for(SeatVO seat : seatList) {
			if(!seat.check) {
				System.out.printf("[%d]",seat.num);
			}else {
				System.out.print("[■]");				
			}
		}
		System.out.println();
		System.out.print(name);
	}
	// 입력 및 범위에러
	int inputNum(String msg,int min, int max) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num < min || num > max) {
			System.out.println("[==범위 에러==]");
			num = -1;
		}
		return num;
	}
	
	void reserveSeat(int idx) {
		seatList[idx].check = true;
		money += 12000;
	}
	
	
	void run(){ 
		init();
		
		while(true) {
		// 메뉴 출력
		printMenu();
		// 메뉴 선택
		int num = inputNum("메뉴입력 >>",0,1);
		
		// 예매하기
		if(num == 1) {
			int seatNum = inputNum("좌석번호 >>",0,7);
			if(seatNum == -1) {
				continue;
			}
			
			if(!seatList[seatNum].check) {
			reserveSeat(seatNum);
			}else {
				System.out.printf(" %d 번 좌석은 이미 예약되어있습니다. \n",seatNum);
			}
		}
		
		// 종료 -> 매출액 출력 
		else if(num == 0) {
			System.out.println("== 종 료 ==");
			System.out.println(money);
			break;
		}
		}
		
	} 
}
	

public class 클배문제07_영화관예매 {

	public static void main(String[] args) {
		
		SeatDAO dao = new SeatDAO();
		dao.run();
		
	}

}
