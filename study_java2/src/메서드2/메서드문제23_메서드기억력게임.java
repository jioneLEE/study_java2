package 메서드2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MemoryGame{
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	int[] back = new int[10];
	
	int cnt = 0;		// 정답을 맞춘 횟수
	
	void shuffle() {
		int temp = 0;
		for(int i =0; i<100; i++) {
			int rand = ran.nextInt(front.length-1);
			temp = front[rand];
			front[rand] = front[rand+1];
			front[rand+1] = temp;
		}
	}
	
	void printCard() {
		System.out.println(Arrays.toString(back));
	}
	
	void choiceCard() {
		int in1 = getidx("첫 카드 인덱스 입력 >>");
		int in2 = getidx("두번째 카드 인덱스 입력 >>");
		
		if (front[in1] == front[in2] && back[in1] == 0 && back[in2] == 0) {

			if (front[in1] == front[in2]) {
				back[in1] = front[in1];
				back[in2] = front[in2];
				cnt++;

			} else {
				System.err.println("정답을 못 마췄습니다.");
			}
		}else {
			System.err.println("이미 정답을 맟췄습니다.");
		}
	}
	
	int getidx(String msg) {
		System.out.print(msg);
		int idx = scan.nextInt();
		return idx;
	}
	
	void run() {
		
		// 셔플(카드 섞기)
		shuffle();
		System.err.println(" 0  1  2  3  4  5  6  7  8  9 ");
		System.out.println(Arrays.toString(front));
		while(true) {
			// 카드 출력
			printCard();
			
			// 종료하기
			if(cnt == 5) {
				System.out.println("게임 종료");
				break;
			}			
			
			// 카드 선택하기
			choiceCard();
			
			
		}
	}
}

public class 메서드문제23_메서드기억력게임 {

	public static void main(String[] args) {
		
		MemoryGame mg = new MemoryGame();
	
		mg.run();

	}

}
