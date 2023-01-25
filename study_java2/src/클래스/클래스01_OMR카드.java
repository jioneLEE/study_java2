package 클래스;

import java.util.Arrays;
import java.util.Random;

// 클래스 - 설계도 : 미리 메모리방에 방을 만들지 않는다 
// 그렇기 때문에 우리가 new 를 통해서 해당 클래스의 설계대로 만들어진 객체를 메모리방에 생성한다 

class OMR {
	// 클래스의 멤버 변수(클래스변수, 인스턴스변수 )
	// 인스턴스변수 -> new 객체를 생성했을때 : heap 메모리방에 방이 만들어진다 
	
	// OMR 클래스는 인스턴스 변수를 4개를 가지고 있고 answer, hgd, cnt, score
	
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] hgd = new int[5];				// 홍길동 학생답안	
	int cnt;						// 정답 맞춘 개수
	int score;						// 성적
}

/*
[문제]
	1. 배열 answer는 시험문제의 정답지이다.
	2. 배열 hgd에 1~5 사이의 랜덤 숫자 5개를 저장한다.
	3. answer와 hgd 값을 비교해 정오표를 출력한다.
	4. 한 문제당 20점이다.
	
	answer = {1, 3, 4, 2, 5}
	hgd    = {1, 1, 4, 4, 3}
	성적    = 40점		 
*/
public class 클래스01_OMR카드 {

	public static void main(String[] args) {

		OMR card = new OMR();
	
		Random rd = new Random();
		int idx =0;
		for(int answer : card.answer) {
			card.hgd[idx] = rd.nextInt(5)+1;
			if(answer == card.hgd[idx]) {
				card.cnt++;
			}
			idx++;
		}
		card.score=card.cnt*20;
		
		System.out.println("hgd    =" +Arrays.toString(card.hgd));
		System.out.println("answer ="  + Arrays.toString(card.answer));
		System.out.printf("성적    = %d점\n", card.score);
		
		
	}

}