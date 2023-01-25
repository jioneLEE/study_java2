package 메서드2_문제연습;

import java.util.Scanner;

class Tic {
	int[] line;

	void printLine() {
		for (int i = 0; i < 3; i++) {
			if (line[i] == 0) {
				System.out.print("[ ]");
			} else if (line[i] == 1) {
				System.out.print("[o]");
			} else if (line[i] == 2) {
				System.out.print("[x]");
			}
		}
		System.out.println();
	}
}

class Game {
	Tic[] tics;
	int p1 = 1; // "O"
	int p2 = 2; // "X"
	boolean win;

	void init() {
		tics = new Tic[3];
		for (int i = 0; i < tics.length; i++) {
			tics[i] = new Tic();
		}
		int[] arr1 = { 1, 2, 1 };
		int[] arr2 = { 1, 2, 2 };

		tics[0].line = arr1;
		tics[1].line = new int[3];
		tics[2].line = arr2;

	}

	void printGameBoard() {
		for (Tic t : tics) {
			t.printLine();
		}
	}

	boolean placedPlayer(int player) {
		int y = getValue("y 좌표 ", 0, 2);
		if (y == -1) {
			return false;
		}
		int x = getValue("x 좌표 ", 0, 2);
		if (x == -1) {
			return false;
		}

		if (tics[y].line[x] != 0) {
			System.out.println("이미 선택 완료된 위치 값");
			return false;
		}

		tics[y].line[x] = player;

		return true;

	}

	boolean isWinGaro(int player) {
		int x = 0;
		for (int y = 0; y < tics.length; y++) {
			if (tics[y].line[x] == player && tics[y].line[x] == tics[y].line[x + 1]
					&& tics[y].line[x] == tics[y].line[x + 2]) {
				win = true;
				return true;
			}
		}
		return false;
	}

	boolean isWinSero(int player) {
		int y = 0;
		for (int x = 0; x < tics.length; x++) {
			if (tics[y].line[x] == player && tics[y].line[x] == tics[y + 1].line[x]
					&& tics[y].line[x] == tics[y + 2].line[x]) {
				win = true;
				return true;
			}
		}
		return false;
	}

	boolean isWinCross(int player) {

		if (player == tics[0].line[0] && player == tics[1].line[1] && player == tics[2].line[2]) {
			win = true;
			return true;
		}

		if (player == tics[0].line[2] && player == tics[1].line[1] && player == tics[2].line[0]) {
			win = true;
			return true;
		}
		return false;
	}

	void printWinner(int player) {
		System.out.printf(" player %d 승리 \n", player);
	}

	void run() {
		init();
		printGameBoard();
		int turn = p1;
		int cnt = 6;
		while (!win) {
			if (cnt == 9) {
				System.out.println(" 무승부 ");
				break;
			}
			System.out.printf(" player%d 턴 [%s] \n", turn, turn == p1 ? "O" : "X");
			if (!placedPlayer(turn)) {
				continue;
			}
			printGameBoard();
			if (isWinGaro(turn)) {
				continue;
			}
			if (isWinSero(turn)) {
				continue;
			}
			if (isWinCross(turn)) {
				continue;
			}
			turn = turn == p1 ? p2 : p1;
			cnt++;
		}
		if (cnt != 9) {
			printWinner(turn);
		}

	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + ">> ");
		int val = sc.nextInt();
		if (val < start || val > end) {
			System.out.printf(" %s 값은 %d - %d \n", msg, start, end);
			return -1;
		}
		return val;
	}

}

public class 클배문제08_틱텍토 {

	public static void main(String[] args) {
		Game tictecteo = new Game();
		tictecteo.run();
	}

}