package 메서드;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ScoreMng{
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	int sum;
	int cnt;
	int in;
	int idx = -1;
	double avg;
	
	   // answerQ1
	void printScore(int[] scores) {
		for(int i =0; i<scores.length; i++) {
			int ran = rd.nextInt(101);
			scores[i] = ran;
		}
		System.out.println(Arrays.toString(scores));
		System.out.println("======================");
	}
		// answerQ2
	void printSumAvg(int[] scores) {
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		avg = (sum+0.0)/scores.length;
		System.out.println("합계>>"+sum+" "+"평균>>"+avg);
		System.out.println("======================");
	}
		// answerQ3
	void passCnt(int[] scores) {
		for(int i=0; i<scores.length; i++) {
			if(scores[i]>=60) {
			cnt++;
			}
		}
		System.out.println("통과한 학생수 >>"+cnt);
		System.out.println("======================");
	}
		// answerQ4
		void printIdx(int[] scores) {
			
			while (true) {
				System.out.print("인덱스 입력>>");
				in = sc.nextInt();
				if (in <= 0 || in > scores.length) {
					System.err.println("인덱스 범위 오류");
					continue;
				}
				break;
			}
					System.out.println("점수는>>"+scores[in-1]);
			
		}
		// answerQ5
		void indexPrint(int[] scores) {
			while (true) {
				System.out.print("성적을 입력>>");
				in = sc.nextInt();
				for (int i = 0; i < scores.length; i++) {
					if(in == scores[i]) {
						idx = i;
					}
				}
				if(idx ==-1) {
					System.err.println("해당 점수는 없습니다.");
					continue;
				}
				break;
			}
			
			System.out.println("해당인덱스>> "+idx);
		}
		// answerQ6
		void inHakbunScorePrint(int[] scores,int[] hakbuns){
			while (true) {
				System.out.print("학번을 입력>>");
				in = sc.nextInt();
				for (int i = 0; i < hakbuns.length; i++) {
					if (in == hakbuns[i]) {

					}
				}
			}
		};
		// answerQ7
		// answerQ8
	}

public class 문제02_메서드학생배열 {

	public static void main(String[] args) {
		
	    // ScoreMng 객체 만들고 메서드 호출
		ScoreMng s = new ScoreMng();
		

	    int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
			int[] scores = new int[5];

			// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
			// 예 1) 87, 11, 92, 14, 47
			s.printScore(scores);
			// 문제2) 전교생의 총점과 평균 출력
			// 예 2) 총점(251) 평균(50.2)
			s.printSumAvg(scores);
			// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
			// 예 3) 2명
			s.passCnt(scores);
			// 문제4) 인덱스를 입력받아 성적 출력
			// 정답4) 인덱스 입력 : 1 성적 : 11점
			s.printIdx(scores);
			// 문제5) 성적을 입력받아 인덱스 출력
			// 정답5) 성적 입력 : 11 인덱스 : 1
			s.indexPrint(scores);
			// 문제6) 학번을 입력받아 성적 출력
		

			// 문제7) 학번을 입력받아 성적 출력
			// 단, 없는학번 입력 시 예외처리
			// 예 7)
			// 학번 입력 : 1002 성적 : 11점
			// 학번 입력 : 1000 해당학번은 존재하지 않습니다.

			// 문제8) 1등학생의 학번과 성적 출력

	}

}
