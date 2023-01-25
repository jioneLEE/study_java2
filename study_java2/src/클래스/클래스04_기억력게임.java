package 클래스;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MemoryGame{
	String[] front = {"O", "O","□", "□", "■", "■", "☎", "☎", "♠", "♠"};
	String[] back = new String[10];
	
	int cnt = 0;		// 정답을 맞춘 횟수
}


public class 클래스04_기억력게임 {

	public static void main(String[] args) {
		
		/*
		 * # 기억력 게임 : 클래스 + 변수
		 * 1. front 배열 카드 10장을 섞는다.
		 * 2. front 배열에서 같은 카드를 골라 카드의 위치를 입력한다.
		 * 3. 선택한 2장의 카드가 같은 카드이면, back 배열에 표시한다.
		 * 4. 모든 카드가 뒤집히면(back배열의 0이 사라지면) 게임은 종료된다. 
		 */
		MemoryGame g = new MemoryGame();
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		String temp = "";
		for(int i =0; i<50 ; i++) {
			int rand = rd.nextInt(g.front.length-1);
			temp = g.front[rand];
			g.front[rand] = g.front[rand+1];
			g.front[rand+1] = temp; 
		}
		System.out.println(" 0  1  2  3  4  5  6  7  8  9 ");
		System.out.println(Arrays.toString(g.front));
		
		int in =0;
		int in1 =0;
		boolean check = true;
		while (check) {
			boolean check1 = true;

			while (true) {
				System.out.print("첫번째 인덱스 입력 >>");
				in = sc.nextInt();
				if (in < 0 || in > g.front.length - 1) {
					System.err.println("입력오류 재입력");
					continue;
				}
				break;
			}
			while (true) {
				System.out.print("두번째 인덱스 입력 >>");
				in1 = sc.nextInt();
				if (in1 < 0 || in1 > g.front.length - 1) {
					System.err.println("입력오류 재입력");
					continue;
				}
				break;
			}
			if (in == in1) {
				System.err.println("같은 인덱스 입력불가 ");
				continue;
			}
		
			if(g.front[in].equals(g.front[in1])) {
				g.back[in] = g.front[in];
				g.back[in1] = g.front[in1];
				
			}else {
				System.out.println("틀렸습니다.");
				g.cnt++;
			}
			
			System.out.println(Arrays.toString(g.back));
			
			for(int i =0; i<g.back.length; i++) {
				if(g.back[i]==null) {
					check1=false;
				}
			}

			if(check1) {
				System.out.printf("==종료 되었습니다.== 틀린횟수 %d \n", g.cnt);
				check= false;
			}
			
		}
		

	}

}
