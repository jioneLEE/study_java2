package 문자열;

import java.util.Arrays;

public class 기본이론07_형변환 {

	public static void main(String[] args) {
		
	String str ="떡볶이,피자,치킨,탕수육. ";
			
	//		for(int i =0; i <str.length(); i++) {
	//			System.out.printf("i = %d , char=> %c , code => %d \n", i, str.charAt(i), (int)str.charAt(i)  );
	//		}
	//		
			char a1 = 'a'; // 97 -> 0011100100110111
			// 형변환 : type casting 
			System.out.println((int)a1);
			
			
			// 1) 문자열 -> 숫자 
			String num1 = "10"; 
			int num2 = 20; 
			
			System.out.println(num1 + num2); // 1020 
			
			int num3 = Integer.parseInt(num1); // 10
			int num4 = Integer.parseInt("20"); // 20
			
			System.out.println(num3 + num4);
			
			// 2) 숫자 -> 문자열 
			
			int num5 = 100;
			// 방법 1) 꼼수 => 추천
			String num6 = num5 +""; // "100"
			
			// 방법 2) 정식 
			String num7 = String.valueOf(num5); // "100"
			
			System.out.println(num6 + 10); // 10010
			System.out.println(num7 + 20); // 10020
		System.out.println(String.valueOf(num1.charAt(0)));
				
	}

}
