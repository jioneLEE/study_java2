package 메서드2_문제;

import java.util.Scanner;

class GameLadder {

	Scanner scan = new Scanner(System.in);
	int ladder[][]= {
			{0,0,0,0,0},
			{1,1,0,1,1},
			{0,0,0,0,0},
			{0,0,1,1,0},
			{1,1,0,1,1},
			{0,1,1,0,0},
			{0,0,1,1,0},
			{0,0,0,1,1},
			{0,0,0,0,0}};

	int size = 5;
	String[] menu = { "", "", "", "", "" };
	// String[] menu = { "탕수육", "떡볶이", "수재비", "김밥", "짬뽕" };

	String inputValue(String msg, String val) {
		System.out.println(msg + " >> ");
		val = scan.nextLine();
		return val;
	}

	int inputValue(String msg, int val) {
		System.out.println(msg + " >> ");
		val = scan.nextInt();
		return val;
	}

	void setMenu() {

		for (int i = 0; i < size;) {
			String name = inputValue((i + 1) + " 번 메뉴 ", "");
			boolean check = true;
			for (int k = 0; k < i; k++) {
				if (menu[k].equals(name)) {
					System.out.println("중복된 메뉴이름이 있습니다");
					check = false;
					break;
				}
			}
			if (check) {
				menu[i] = name;
				i++;
			}

		}

	}

	void printMenu() {
		System.out.println("[오늘의 점심메뉴]");

		for (int i = 0; i < menu.length; i++) {
			System.out.println((i + 1) + ":" + menu[i]);
		}

	}

	void printInitLadder() {
		for (int i = 0; i < ladder.length; i++) {
			printLadder(i, -1, -1);
		}
	}

	void printNum() {
		for (int i = 0; i < ladder[0].length; i++) {
			System.out.print(" " + (i + 1) + " ");
		}
		System.out.println();
	}

	void printLadder(int y, int x, int bx) {

		for (int k = 0; k < ladder[y].length; k++) {
			if (k == x || k == bx) {
				System.out.print(" * ");
			} else if (k != ladder[y].length - 1 && ladder[y][k] == 1 && ladder[y][k + 1] == 1) {
				System.out.print(" ├─");
			} else if (k != 0 && ladder[y][k] == 1 && ladder[y][k - 1] == 1) {
				System.out.print("─┤ ");
			} else {
				System.out.print(" │ ");
			}
		}
		System.out.println();

	}

	int selectLadder() {
		printNum();
		while (true) {
			int sel = inputValue("번호 선택[1~5] ", 0) - 1;
			if (sel < 0 || sel >= ladder[0].length) {
				System.out.println("인덱스 오류");
				continue;

			}
			return sel;
		}

	}

	int moveLadder(int x) {
		int y = 0;
		for (int i = 0; i < ladder.length; i++) {
			int bx = x;

			if (bx != ladder[i].length - 1 && ladder[i][bx] == 1 && ladder[i][bx + 1] == 1) {
				x++;
			} else if (bx != 0 && ladder[i][bx] == 1 && ladder[i][bx - 1] == 1) {
				x--;
			}
			printLadder(i, x, bx);

		}

		return x;
	}

	void getMenu(int x) {
		System.out.printf("오늘은 %s 가자~ \n", menu[x]);
	}

	void run() {
		setMenu();
		printMenu();
		printInitLadder();
		int x = selectLadder();
		System.out.println(x);
		x = moveLadder(x);
		getMenu(x);
	}

}

public class 메서드문제02_사다리게임 {

	public static void main(String[] args) {

		GameLadder e = new GameLadder();
		e.run();

	}

}