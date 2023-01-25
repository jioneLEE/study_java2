package 클래스;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예) 
 *  0 0 0 0 0 0 0 2 
 *  왼쪽(1) 오른쪽(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */

class MovingGame{
	int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
}

public class 클래스03_캐릭터이동 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MovingGame m = new MovingGame();
		System.out.println(Arrays.toString(m.game));

		while (true) {
			int idx = 0;
			for (int i = 0; i < m.game.length; i++) {
				if (m.game[i] == 2) {
					idx = i;
				}
			}
			System.out.println(idx);

			System.out.print("왼쪽(1) 오른쪽(2) 격파(3) : ");
			int num = sc.nextInt();

			if (num != 1 && num != 2 && num != 3) {
				System.err.println("입력 오류입니다.");
			} else if (num == 1) {

				if (idx != 0 && m.game[idx - 1] == 0) {
					m.game[idx - 1] = m.game[idx];
					m.game[idx] = 0;
				} else if (idx == 0) {
					m.game[m.game.length - 1] = m.game[idx];
					m.game[idx] = 0;
				} else if (m.game[idx] != 0 && m.game[idx - 1] == 1) {
					System.err.println("벽을 파괴전까지 왼쪽으로 이동 불가능");
				}

			} else if (num == 2) {

				if (idx != m.game.length - 1 && m.game[idx + 1] == 0) {
					m.game[idx + 1] = m.game[idx];
					m.game[idx] = 0;
				} else if (idx == m.game.length - 1) {
					m.game[0] = m.game[idx];
					m.game[idx] = 0;
				} else if (m.game[idx] != 0 && m.game[idx + 1] == 1) {
					System.err.println("벽을 파괴전까지 오른쪽으로 이동 불가능");
				}

			} else {
				if (m.game[idx - 1] == 1 || m.game[idx + 1] == 1) {
					if (idx != 0) {
						m.game[idx - 1] = 0;
					}
					if (idx != m.game.length - 1) {
						m.game[idx + 1] = 0;
					}
					System.err.println("벽을 파괴하였습니다.");
				} else {
					System.err.println("주변에 벽이 없어 파괴할 수 없습니다.");
				}
			}

			System.out.println(Arrays.toString(m.game));

		}

	}

}
