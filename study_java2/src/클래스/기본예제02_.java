package 클래스;

import java.util.Scanner;

//기본메모리그림3 에 있는 sample03 클래스를 이용하세요 
//class Sample03 {
//	int[] hakbun = {1001, 1002, 1003, 1004, 1005};
//	int[] score  = {  92,   38,   87,  100,   11};
//}


public class 기본예제02_ {

	public static void main(String[] args) {

		Sample03 Sam = new Sample03();

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		int sum  =0;
		int q =0;
		for(int scores :Sam.score) {
			sum+= Sam.score[q];
					q++;
		}
		System.out.printf("총점(%d) 평균(%.1f) \n", sum , sum/(Sam.score.length+0.0));

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		q =0;
		sum =0;
		for(int scores :Sam.score) {
			if(Sam.score[q] >= 60) {
				sum++;
			}
					q++;
		}
		System.out.println("총 >>"+ sum);

		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		Scanner sc = new Scanner(System.in);
		System.out.print("인덱스 입력 >>");
		int in = sc.nextInt();
		
		if(in>Sam.score.length-1 ||in<0) {
			System.out.println("에러");
		}else {
			System.out.println(Sam.score[in]);
		}
		
		
		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		// 문제6) 학번을 입력받아 성적 출력
		// 정답6) 학번 입력 : 1003 성적 : 92점
		System.out.print("성적 or 학번 입력 >>");
		in = sc.nextInt();
		q=0;
		boolean check = false;
		for(int score : Sam.score) {
			if(in==Sam.score[q]) {
				System.out.println(q);
				check = true;
			}
			else if(in==Sam.hakbun[q]) {
				System.out.println(Sam.score[q]);
				check = true;
			}
			
			
			q++;
		}
		if(!check) {
			System.out.println("값을 찾지 못했음");
		}
		
		
		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.

		// 문제8) 1등학생의 학번과 성적 출력
		// 정답8) 1003번(92점)
		
	}

}
