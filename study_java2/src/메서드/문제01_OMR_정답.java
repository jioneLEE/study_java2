package 메서드;

import java.util.Arrays;
import java.util.Random;

class OMRMng1{
	// 필드 => 멤버변수(인스턴스변수, 클래스변수)
	Random ran = new Random();
	int[] omr = {1, 4, 3, 2, 2};  // 모범답안
	int[] me = new int[5];		 // 학생답안
	int cnt = 0;				  // 정답 맞춘 개수
	int score = 0;				 // 성적
	
	
	// 1.me 답안 완성하기
		void makeAnswer() {
			for(int i =0; i < omr.length;i++) {
				me[i] = ran.nextInt(5)+1;
			}
		}
		// 2.정답 출력하기
		void showAnswer(int[] arr) {
			for(int i =0; i < arr.length;i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		// 3.정답 비교하기
		void checkAnswer() {
			System.out.println("===정오표===");
			System.out.print("[");
			for(int i =0; i < omr.length;i++) {
				if(me[i] == omr[i]) {
					System.out.print("O ");
					cnt++;
				}else {
					System.out.print("X ");
				}
			}
			System.out.println("]");
			score = cnt*20;
			System.out.println("총 점수 " + score +" 점");
		}
		
		
		void printThis() {
			System.out.println("this=" + this);
		}
		
}
public class 문제01_OMR_정답 {

	public static void main(String[] args) {
/*
		 * [문제] 1. 배열 answer는 시험문제의 정답지이다. 2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다. 3. answer와
		 * hgd 값을 비교해 정오표를 출력한다. 4. 한 문제당 20점이다.
		 * 
		 * 예) answer = {1, 3, 4, 2, 5} hgd = {1, 1, 4, 4, 3} 정오표 = {O, X, O, X, X} 성적 =
		 * 40점
		 */
		OMRMng1 sm = new OMRMng1();

		// this => 메서드와 객체 맴버들간의 소통하는 방식
		// 객체의 주소값을 의미한다
		System.out.println("sm = " + sm);
		sm.printThis();

		int num = sm.ran.nextInt(10) + 1;
		System.out.println(num);

		sm.showAnswer(sm.me);
		sm.makeAnswer();
		sm.showAnswer(sm.me);
		sm.showAnswer(sm.omr);
		sm.checkAnswer();

	}

}