package 문자열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 문제_문자열08타자연습2풀이방법 {

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
		
		for(int i =0; i < 100; i++) {
			int idx = rd.nextInt(words.length);
			String temp = words[0];
			words[0] = words[idx];
			words[idx] = temp;
		}
		
		System.out.println(Arrays.toString(words));
		
		int idx = 0;
		boolean check = true;
		for(int i =0; i < words.length;) {
			if(check) {
				idx = rd.nextInt(words[i].length());
			}
			System.out.print( i+1 +" ");
			
			for(int k =0; k < words[i].length();k++) {
				if(idx == k) {
					System.out.print("*");
				}else {
					System.out.print(words[i].charAt(k));
				}
			}
			System.out.println("=>");
			
			String input = sc.next();
			if(words[i].equals(input)) {
				System.out.println("정답");
				check = true;
				i++;
			}else {
				System.out.println("오답");
				check = false;
			}
			
		}

	}

}
