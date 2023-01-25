package 클래스;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 영화관 좌석예매 : 클래스 + 변수
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = 0 0 0 0 0 0 0
 * 
 * 좌석선택 : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * 좌석선택 : 3
 * seat = 0 1 0 1 0 0 0
 * 이미 예매가 완료된 자리입니다.
 * ----------------------
 * 매출액 : 24000원
 */

class Movie{
	String name = "MEGA MOVIE";
	int[] seat = new int[7];
	int money = 0;
}


public class 클래스02_좌석예매 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Movie m = new Movie();
		
		while(true) {
			
			System.out.println("["+m.name+"]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.print("예매 좌석 자리를 입력하십시오 >> ");
				int in = sc.nextInt();
				if(in<1 || in>7) {
					System.err.println("==입력 범위오류==");
					continue;
				}
				if(m.seat[in-1]== 0) {
					m.seat[in-1] = 1;
					System.out.println(Arrays.toString(m.seat));
				}else {
					System.err.println("이미 예약된 좌석입니다.");
					continue;
				}
				
			}
			else if(sel == 2) {
				int cnt = 0;
				for(int i =0; i<m.seat.length ; i++) {
					if(m.seat[i]==1) {
						cnt++;
					}
				}
				System.out.printf("매출액 : %,d원", 12000*cnt);
				break;
			}
		}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}