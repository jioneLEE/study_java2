package 메서드;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ScoreMng2 {

	// answerQ1
	void answerQ1(int[] arr) {
		System.out.println("문제 1 ");
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100) + 1;
		}

		System.out.println(Arrays.toString(arr));
	}
	// answerQ2

	void answerQ2(int[] arr) {
		System.out.println("문제  2");
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		double avg = sum * 1.0 / arr.length;

		System.out.printf("총점(%d) 평균(%.2f) \n", sum, avg);
	}

	void answerQ3(int[] arr) {
		System.out.println("문제  3");
		int cnt = 0;
		for (int num : arr) {
			if (num >= 60) {
				cnt++;
			}
		}
		System.out.println(cnt + "명");
	}

	void answerQ4(int[] arr) {
		System.out.println("문제  4");
		int num = getIntValue("인덱스");

//		if(num <0 || num >= arr.length) {
//			System.err.println("인덱스 입력 오류");
//			return;
//		}
//		
		boolean check = IsIndex(arr, num);
		if (check) {
			System.out.println("인덱스 : " + num + "성적 : " + arr[num]);
		}

	}

	void answerQ5(int[] arr) {
		System.out.println("문제  5");
		int score = getIntValue("성적");
		int idx = checkValue(arr, score);

		if (idx == -1) {
			System.out.println(" 배열에 성적 없음 ");
		} else {
			System.out.println("인덱스 " + idx);
		}

	}

	void answerQ6(int[] hakbun, int[] score) {
		System.out.println("문제  6");
		int hak = getIntValue("학번");
		int idx = checkValue(hakbun, hak);

		if (idx == -1) {
			System.out.println("해당 학번 없음");
		} else {
			System.out.printf("학번 %d => 성적 %d \n", hak, score[idx]);
		}
	}

	void answerQ7(int[] hakbun, int[] score) {
		int hak = getIntValue("학번");
		int idx = -1;
		for (int i = 0; i < hakbun.length; i++) {
			if (hak == hakbun[i]) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("해당 학번 없음");
		} else {
			System.out.printf("학번 %d => 성적 %d \n", hak, score[idx]);
		}
	}

	void answerQ8(int[] hak, int[] scores) {
		System.out.println("문제  8");
		int max = scores[0];
		int maxIdx = 0;
		for (int i = 0; i < hak.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
				maxIdx = i;
			}
		}
		System.out.printf(" 1등 학생 %d 번 %d 점 \n", hak[maxIdx], max);
	}

	int getIntValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " 입력 :");
		int val = sc.nextInt();
		return val;
	}

	int checkValue(int[] arr, int value) {
		int idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (value == arr[i]) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	/*
	 * boolean IsIndex(int[] arr, int idx) { boolean check = true; if(idx <0 || idx
	 * >= arr.length) { check = false; }
	 * 
	 * return check; }
	 */
	boolean IsIndex(int[] arr, int idx) {
		if (idx < 0 || idx >= arr.length) {
			System.err.println("인덱스 입력 오류");
			return false;
		}
		return true;
	}

}

public class 문제02_메서드타입1234전부사용 {

	public static void main(String[] args) {

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];

		// ScoreMng 객체 만들고 메서드 호출
		ScoreMng2 sm = new ScoreMng2();
		// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47

		sm.answerQ1(scores);

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		sm.answerQ2(scores);

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		sm.answerQ3(scores);

		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		sm.answerQ4(scores);

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1

		// 문제6) 학번을 입력받아 성적 출력
		sm.answerQ6(hakbuns, scores);

		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리

		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.

		// 문제8) 1등학생의 학번과 성적 출력
		sm.answerQ8(hakbuns, scores);
	}

}