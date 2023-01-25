package 클래스;

import java.util.Arrays;
import java.util.Scanner;

class Tictactoe{
	
	String[][] game = new String[3][3];
	
	int turn = 1;
	int win = 0;		
}

public class 클래스05_틱텍토 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tictactoe e = new Tictactoe();
		int a[] = null;
		int[] b = new int[1];
		for (int i = 0; i < e.game.length; i++) {
			for (int j = 0; j < e.game[i].length; j++) {
				e.game[i][j] = "[ ]";
			}
		}

		int o = 0;
		int x = 0;
		int oo = 0;
		int xx = 0;
		int cnt = 0;
		int cnt1 = 0;
		boolean check = true;

		while (check) {
			System.out.printf("[player%d] 입력 >> ", e.turn);
			int in = scan.nextInt();
			if (in <= 0 || in > 9) {
				System.out.println("입력 범위에러");
				continue;
			}
			int idx = -1;
			for (int i = 0; i < b.length; i++) {
				if (in == b[i]) {
					idx = i;
					break;
				}
			}
			if (idx != -1) {
				System.err.println("같은곳 다시 선택불가");
				continue;
			}

			cnt++;
			a = new int[cnt];
			for (int i = 0; i < b.length; i++) {
				a[i] = b[i];
			}
			a[cnt - 1] = in;
			b = a;

			int share = (in - 1) / 3;
			int remainder = (in - 1) % 3;
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));

			if (e.turn == 1) {
				for (int i = 0; i < e.game.length; i++) {
					for (int k = 0; k < e.game[i].length; k++) {
						if (i == share && k == remainder) {
							e.game[i][k] = String.valueOf("[O]");
						}
					}
				}
				e.turn = 2;
			} else {
				for (int i = 0; i < e.game.length; i++) {
					for (int k = 0; k < e.game[i].length; k++) {
						if (i == share && k == remainder) {
							e.game[i][k] = String.valueOf("[X]");
						}
					}
				}
				e.turn = 1;
			}

			for (int i = 0; i < e.game.length; i++) {
				System.out.println(Arrays.toString(e.game[i]));
			}

			// 가로조건
			if (check) {
				for (int i = 0; i < e.game.length; i++) {
					o = 0;
					x = 0;
					for (int k = 0; k < e.game[i].length; k++) {
						if (e.game[i][k] == "[O]") {
							o++;
							if (o == 3) {
								i = 100;
								check = false;

								break;
							}
						}
						if (e.game[i][k] == "[X]") {
							x++;
							if (o == 3) {
								i = 100;
								check = false;

								break;
							}
						}

					}

				}
			}
			// 세로조건
			if (check) {
				for (int i = 0; i < e.game.length; i++) {
					o = 0;
					x = 0;

					for (int k = 0; k < e.game.length; k++) {

						if (e.game[k][i] == "[O]") {
							o++;
							if (o == 3) {
								i = 100;
								check = false;

								break;
							}
						}
						if (e.game[k][i] == "[X]") {
							x++;
							if (o == 3) {
								i = 100;
								check = false;

								break;
							}
						}

					}

				}
			}

			// 크로스 조건
			if (check) {
				o = 0;
				x = 0;
				oo = 0;
				xx = 0;
				for (int i = 0, j = e.game.length - 1; i < e.game.length; i++, j--) {
					for (int k = i; k == i; k++) {

						if (e.game[i][k] == "[O]") {
							o++;
							if (o == 3) {
								i = 100;
								check = false;

								break;
							}
						}

						if (e.game[k][j] == "[O]") {
							oo++;
							if (oo == 3) {
								i = 100;
								check = false;

								break;
							}

							if (e.game[i][k] == "[X]") {
								x++;
								if (o == 3) {
									i = 100;
									check = false;

									break;
								}
							}

							if (e.game[k][j] == "[X]") {
								xx++;
								if (xx == 3) {
									i = 100;
									check = false;

									break;
								}

							}

						}
					}

				}
				System.out.println();
				System.out.println("=== 경기종료 ===");
				System.out.println(o == 3 || oo == 3 ? "P1 승리" : "P2 승리");
			
			
			
			
			
			
			
			
		}
}
	}
}

