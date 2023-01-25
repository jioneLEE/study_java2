package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 문제_문자열05 {

	public static void main(String[] args) {
		
		/*
				 * # 끝말잇기 게임을 만들어보세요.
				 * 
				 * 제시어 : 자전거
				 * 입력 : 거미
				 * 제시어 : 거미
				 * 입력 : 미술
				 * ...
				 
				 1. 한자리 단어 안되요 
				 2. 기러기 -> 기러기 하면안됨 
				 3. 끝을 입력 받으면 반복문 종료 
				 
				 */
				
				Scanner sc = new Scanner(System.in);
				String start ="자전거";
				
				while(true) {
					System.out.println("제시어 : " + start );
					System.out.print("입력 : ");
					String in = sc.next(); 
					
					if(in.length()<=1 || start.equals(in)) {
						System.out.println("다시입력");
						continue;
					}
					
					
					if(in.equals("끝")) {
						System.out.println("종료");
						break;
					}
				}
				
				
//				Scanner sc = new Scanner(System.in);
//				String start = "자전거";
//				while (true) {
//
//					System.out.println("제시어 : " + start);
//					String input = sc.next();
//					if (input.equals("끝")) {
//						System.out.println("====게임종료===");
//						break;
//					}
//					if (input.length() == 1) {
//						System.err.println("한자리 단어 안되요");
//						continue;
//					}
//					if (input.equals(start)) {
//						System.err.println("제시어랑 같으면 안되요 ");
//						continue;
//					}
//					if (input.charAt(0) == start.charAt(start.length() - 1)) {
//						start = input;
//					}
//
//				}
				
				
	}

}
