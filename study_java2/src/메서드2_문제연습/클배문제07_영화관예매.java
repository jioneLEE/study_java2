package 메서드2_문제연습;

import java.util.Scanner;

class SeatVO {
	int num; // 0
	boolean check; // false
}

class SeatDAO {
	SeatVO[] seatList = new SeatVO[8]; // null
	String name;
	int cnt;
	int money;

	void init() {
		name = "메가박스";
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new SeatVO();
			seatList[i].num = i + 1;
		}
	}

	void printSeats() {
		System.out.println("1 2 3 4 5 6 7 8");
		for (SeatVO seat : seatList) {
			if (seat.check) {
				System.out.print("■ ");
			} else {
				System.out.print("□ ");
			}
		}
		System.out.println();
	}

	void printMenu() {
		System.out.println("[1]예매하기");
		System.out.println("[2]종료");
	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " > ");
		int num = sc.nextInt();
		if (num < start || num > end) {
			return -1;
		}
		return num;
	}

	int getMenu() {

		int select = getValue("메뉴 입력", 1, 2);
		if (select == -1) {
			System.out.println("없는 번호 입니다");
			return -1;
		}
		return select;
	}

	void getMoney() {
		System.out.println("매출액은 " + money + "원 입니다");
	}

	void getSeat() {
		printSeats();
		int no = getValue("좌석 선택 ", 1, 8) - 1;
		if (no == -2) {
			System.out.println(" 좌석번호 선택 오류");
			return;
		}
		if (seatList[no].check) {
			System.out.println("좌석이 이미 예매되었습니다");
			return;
		}
		seatList[no].check = true;
		money += 12000;
		System.out.println(seatList[no].num + "번 자리 예매 완료 되었습니다 ");

	}

	void run() {
		// 초기값 
		init();
		// 메뉴 출력
		printMenu();
		int input = 0;
		while (true) {
			// 메뉴 선택
			input = getMenu();
			if (input == -1) {
				continue;
			}
			// 예매하기
			if (input == 1) {
				getSeat();

			} else {
				// 종료 -> 매출액 출력
				getMoney();
				return;
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