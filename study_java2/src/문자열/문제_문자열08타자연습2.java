package 문자열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 문제_문자열08타자연습2 {

	public static void main(String[] args) {
		
		
		/*
		 * # 타자연습 게임[2단계]
		 * 1. 문제를 섞는다.(shuffle)
		 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
		 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *(랜덤 위치 )로 출력 
		 * 예)
		 * 문제 : mys*l
		 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
		 * 문제 : *sp
		 * 입력 : jap
		 * 문제 : j*p (x) : 문제 틀릴시 별 고정 
		 * 문제 : *sp (0)
		 */
		String[] words = {"java", "mysql", "jsp", "spring"};
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		String a = null;
		
		
		for (int i = 0; i < 30; i++) {
			int rand = rd.nextInt(words.length);
			String buff = words[0];
			words[0] = words[rand];
			words[rand] = buff;

		}
		System.out.println(Arrays.toString(words));
		String wordsC[] = words;

		for (int i = 0; i < words.length; i++) {
			int rand1 = rd.nextInt(words[i].length());
			for (int k = 0; k < words[i].length(); k++) {
//				if(rand1)
				a += String.valueOf(wordsC[i].charAt(k));
				
			}
		}

	}

}
