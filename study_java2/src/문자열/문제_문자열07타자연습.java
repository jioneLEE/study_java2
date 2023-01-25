package 문자열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 문제_문자열07타자연습 {

	public static void main(String[] args) {
		
		/*
		 * # 타자연습 게임[1단계] 1. 문제를 섞는다.(shuffle) 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료 예) 문제 :
		 * mysql 입력 : mydb 문제 : mysql 입력 : mysql <--- 정답을 맞추면, 다음 문제 제시 문제 : jsp
		 */

		String[] words = { "java", "mysql", "jsp", "spring" };
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int ran = rd.nextInt(3);
			String buff = words[ran];
			words[ran] = words[ran + 1];
			words[ran + 1] = buff;
		}
		System.out.println(Arrays.toString(words));

		for (int i = 0; i < words.length; i++) {
			System.out.println("문제 : " + words[i]);
			System.out.print("입력 : ");
			String in = sc.next();
			if (!(words[i].equals(in))) {
				i--;
				continue;
			}
		}
		System.out.println("==종료==");
		
		
		
	}

}
