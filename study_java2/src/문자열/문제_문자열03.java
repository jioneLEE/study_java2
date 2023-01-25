package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 문제_문자열03 {

	public static void main(String[] args) {
		
		/*
				 * # 문자열 비교
				 * . equals() 메서드 사용없이 equals 직접구현 문자의 일치여부 비교
				 * 예)
				 * 코끼리
				 * 입력 = 티라노사우루스
				 * 출력 = false
				 */
				
				Scanner sc = new Scanner(System.in);
				String answer ="코끼리";
				
				System.out.println("코끼리 입력>> ");
				String input = sc.next();
				boolean check = true;
				
				if(answer.length() != input.length()) {
					check = false;
				}
				for(int i =0; i<answer.length(); i++) {
					if(answer.charAt(i)!=input.charAt(i)) {
						check = false;
					}
				}
				System.out.println(check);
				
				System.out.println(answer.equals(input));
				
	}

}
