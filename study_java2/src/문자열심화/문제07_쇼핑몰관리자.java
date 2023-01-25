package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제07_쇼핑몰관리자 {

	public static void main(String[] args) {
			
		/*
		 * # 쇼핑몰 [관리자]
		 * 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다.
		 * 2. 카테고리는 각 행의 첫번째 열에 저장한다.
		 * 3. 아이템은 각 행의 두번째 열에 저장한다.
		 *    단, 아이템은 여러개를 추가할 수 있도록 슬러시(/)를 구분자로 연결해준다.
		 * 예)
		 * {
		 * 		{"과일", "사과/포도/"},
		 * 		{"과자", "홈런볼/쪼리퐁/"},
		 * 		{"음료", "콜라/"},
		 * 		{"육류", "소고기/"}
		 * 		...
		 * } 
		 */

		   String data = "과일,사과/포도\n";
				data+= "과자,홈런볼/조리퐁\n";
				data+= "음료,콜라/사이다/나랑드\n";
				data+= "육류,소고기/돼지고기/오리고기/닭고기\n";

				Scanner scan = new Scanner(System.in);
				
				String[][] items = new String[100][2];
				for(int i=0; i<items.length; i++) {
					items[i][0] = "";
					items[i][1] = "";
				}
				
				int itemCount = 0;
				
				while(true) {

					System.out.println("[관리자 모드]");
					System.out.println("[1]카테고리 관리"); // 카데고리 추가 삭제 구현 
					System.out.println("[2]아 이 템  관리"); // 아이템 추가 삭제 구현 
					System.out.println("[3]전체품목 출력");
					
					System.out.print(": ");
					int sel = scan.nextInt();
					
					if(sel == 1) {}
					else if(sel == 2) {}
					else if(sel == 3) {}
					
				}

			}
			
			
	}


