package 메서드2;

import java.util.Scanner;

class Theater {

	int[] seat = new int[10];

	Scanner sc = new Scanner(System.in);
	String name = ""; // 영화관 이름

	int cnt = 0; // 예매 수
	int money = 0; // 매출액

	void showSeat() {

		System.out.println("========[좌석번호 안내도]========");
		for (int i = 0; i < seat.length; i++) {
			if (seat[i] == 1) {
				System.out.print("[ X ]" + " ");
				// 예약 안되어있으면 좌석번호로 표시
			} else {
				System.out.printf("[ %d ]" + " ", i);
			}

			if (i == 4) {
				System.out.println();
			}
		}
		System.out.println();
	}

	void showMenu() {
		name = "=====[ 메가박스 ]=====\n" + "1) 예매하기\n" + "2) 종료하기";

		System.out.println(name);
	}

	void choiceSeat() {
		while (true) {
			int idx = getIdx("좌석 인덱스 입력 >>");
			if (idx < 0 || idx > 9) {
				System.err.println("인덱스 범위를 벗어났습니다.");
				continue;
			}
			boolean check = false;
			for (int i = 0; i < seat.length; i++) {
				if (seat[idx] == 1) {
					check = true;
				}
			}

			if (check) {
				System.err.println("이미 예약된 좌석입니다");
				continue;
			}

			seat[idx] = 1;
			cnt++;
			money += 12000;
			System.out.printf("[ %d 번 좌석이 정상적으로 예매되었습니다.] \n",idx);

			break;
		}
	}

	void showSales() {
		System.out.println("총 매출 내역은 "+money+"원 입니다.");
	}

	int getIdx(String msg) {
		System.out.print(msg);
		int idx = sc.nextInt();
		return idx;
	}

}

public class 메서드문제22_좌석예매 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Theater megabox = new Theater();
//			megabox.name = "메가박스";

		while (true) {
			megabox.showSeat();
			// 메뉴 출력
			megabox.showMenu();

			// 메뉴 선택하기
			System.out.print("메뉴 선택 : ");
			int choice = scan.nextInt();
			if (choice < 1 || choice > 2) {
				System.err.println("메뉴 범위오류");
				continue;
			}

			// 예매하기
			if (choice == 1) {
				megabox.choiceSeat();
			}
			// 종료하기
			else if (choice == 2) {
				// 매출 현황 출력하기
				megabox.showSales();

				System.out.println("프로그램 종료");
				break;
			}

		}

	}

}
