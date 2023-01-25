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

public class 문제02_장바구니1단계 {
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
			}
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			if (log == -1 && sel > 1 || sel < 0) {
				System.err.println("===선택범위 오류===");
			} else {
				if (sel < 0 || sel > 3) {
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
				check = true;
				for (int i = 0; i < cnt; i++) {
					if (idList[log].equals(cartList[i][0])) {
						check = false;
					}
				}

				if (check) {
					System.err.println("등록된 ID 장바구니에 물건이 없습니다");
					continue;
				}

				int apple = 0;
				int banana = 0;
				int strawberry = 0;

				for (int i = 0; i < cnt; i++) {
					if (idList[log].equals(cartList[i][0])) {
						// 사과
						if (cartList[i][1].equals(items[0])) {
							apple++;
						}
						// 바나나
						if (cartList[i][1].equals(items[1])) {
							banana++;
						}
						// 딸기
						if (cartList[i][1].equals(items[2])) {
							strawberry++;
						}
					}
				}

				System.out.printf("=======[ %s 님의 장바구니  %d 개 ]========\n", idList[log], apple + banana + strawberry);
				if (apple != 0) {
					System.out.println("[ 애 플 ] [" + apple + "]");
				}
				if (banana != 0) {
					System.out.println("[ 바나나 ] [" + banana + "]");
				}
				if (strawberry != 0) {
					System.out.println("[ 딸 기 ] [" + strawberry + "]");
				}

			} else if (sel == 0) {
				System.out.println("[===프로그램 종료===]");
				break;
			}
		}
		
		
		
		
	}
}