package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

/*
[문제]
	1. 로그인 후, 쇼핑 메뉴를 선택하면
	   다음과 같은 상품 목록을 출력한다.
	   (1)사과 (2)바나나 (3)딸기
	2. 번호를 선택해 상품을 장바구니에 담는다.
	3. 로그인 회원의 아이디는 cartList배열의 0열에 저장한다.
	4. 해당 회원이 구매한 상품은 cartList배열의 1열에 저장한다.
	
		예)
			{qwer,  사과},
			{javaking,  바나나},
			{abcd,  사과},
			{qwer,  딸기},
			{qwer,  사과},
			...
	5. 장바구니 메뉴를 선택하면, 로그인 한 회원의 구매 물품만 출력한다.
		예)
			qwer = 사과, 딸기, 사과
*/

public class 문제05_장바구니2단계 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		String[] idList = { "1", "2", "abcd" };
		String[] pwList = { "1", "2", "3333" };

		int MAX_SIZE = 100;
		String[][] cartList = new String[MAX_SIZE][2];

		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;
		int cnt = 0;
		boolean check = false;
		while (true) {

			System.out.println("[MEGA MART]");
			if (log == -1) {
				System.out.println("[1]로 그 인");
			} else {
				System.out.println("현재 접속 ID >> " + idList[log]);
				System.out.println("[1]로그아웃");
				System.out.println("[2]쇼     핑");
				System.out.println("[3]장바구니");
				System.out.println("[4]전체 구매목록 ");
			}
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			if (log == -1 && sel > 1 || sel < 0) {
				System.err.println("===선택범위 오류===");
			} else {
				if (sel < 0 || sel > 4) {
					System.err.println("===선택범위 오류===");
				}
			}

			if (log == -1 && sel == 1) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				for (int i = 0; i < idList.length; i++) {
					if (idList[i].equals(id) && pwList[i].equals(pw)) {
						log = i;
						check = true;
					}
				}

				if (check) {
					System.out.println("[==로그인 되었습니다.==]");

				} else {
					System.err.println("[아이디 or 비밀번호가 틀립니다.]");
				}

			} else if (log != -1 && sel == 1) {
				log = -1;
				System.out.println("[로그아웃 되었습니다.]");
			} else if (sel == 2) {

				while (true) {
					if (cnt == MAX_SIZE) {
						System.err.println("==장바구니 초과==");
					}

					for (int i = 0; i < items.length; i++) {
						System.out.printf("(%d)%s ", i + 1, items[i]);
					}
					System.out.println("(0)종료");
					int num = sc.nextInt();
					if (num == 0) {
						for (int i = 0; i < cnt; i++) {
							System.out.println(Arrays.toString(cartList[i]));
						}
						break;
					}

					if (num < 0 || num > 3) {
						System.err.println("==입력범위 오류==");
						continue;
					}

					cartList[cnt][0] = idList[log];
					cartList[cnt][1] = items[num - 1];
					cnt++;
				}

			} else if (sel == 3) {
				// 장바구니
				System.out.printf("==== [%s 장바구니 ]==== \n", idList[log]);

				int itemCnt[] = new int[items.length];

				int total = 0;

				for (int i = 0; i < items.length; i++) {
					for (int k = 0; k < cnt; k++) {
						if (idList[log].equals(cartList[k][0]) && items[i].equals(cartList[k][1])) {
							itemCnt[i]++;
							total++;
						}
					}
				}

				if (total == 0) {
					System.err.println("[장바구니가 비었습니다]");
					continue;
				}

				System.out.printf("\t 총 장바구니[%d 개] \n", total);

				for (int i = 0; i < items.length; i++) {
					if (itemCnt[i] > 0) {
						System.out.printf("\t[%s][%3d개] \n", items[i], itemCnt[i]);
					}
				}
				
				System.out.println("----------------");
				System.out.println("[1]아이템 삭제 [2] 전체 삭체 ");
				System.out.println("입력 >> ");
				int num = sc.nextInt();
				if (num == 1) {
					while(true) {
					System.out.println("[삭제] 아이템 입력");
					// 아이템 이름으로 삭제
					String word = sc.next();
					check = true;
					for(int i =0; i<cartList.length; i++) {
						if(word.equals(cartList[i][1]) && idList[log].equals(cartList[i][0]) ) {
							check = false;
							break;
						}
					}
					if(check) {
						System.err.println("삭제할 아이템이 장바구니에 없습니다.");
						continue;
					}
					
					
					String[][] cartTemp = new String[cartList.length][];
					int idx = -1;
					int tempIdx = 0;
					for (int k = 0; k < cnt; k++) {
						if (idList[log].equals(cartList[k][0]) && word.equals(cartList[k][1])) {
							idx = k;
						}
					}
					
					if(idx == -1) {
						System.err.println("입력된 아이템이 장바구니에 없습니다.");
					}else {
						for(int i =0; i<cnt; i++) {
							if(idx != i) {
								cartTemp[tempIdx] = cartList[i];
								tempIdx++;
							}
						}
						cartList = cartTemp;
						cartTemp = null;
						cnt--;
						
					}
					
					break;
					}
				}else if(num == 2) {
					System.out.println("[전체 삭제 완료 ]");
					// 본인 아이디 전체 장바구니 비우기 
					// 같은 로그 아이디만 전부 지우도록 수정 중
					
					int idx = -1;
					int tempIdx = 0;
					String[][] cartTemp = new String[cartList.length][];
					for(int i =0; i<cnt; i++) {
						if(idx != i) {
							cartTemp[tempIdx] = cartList[i];
							tempIdx++;
						}
					}
					
					
					cnt = 0;
					
				}

			}else if(sel == 4) {
				System.out.println("==== [ 전 체 구 매 목 록 ] ====");
				System.out.println("[  아이디  ] [구 매 이 름]");
				for (int i = 0; i < cnt; i++) {
					System.out.printf("     %-5s     %-5s \n",cartList[i][0],cartList[i][1]);
				}
				
				
			}else if (sel == 0) {
				System.out.println("[===프로그램 종료===]");
				break;
			}
		}
		
			
			
	}

}
