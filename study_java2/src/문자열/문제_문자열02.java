package 문자열;

import java.util.Arrays;

public class 문제_문자열02 {

	public static void main(String[] args) {
		
		   //만 나이
		   String jumin1 = "890101-2012932";
			String jumin2 = "040101-3012932";
			String check = jumin1;
			String result1 = ""; // 여성 33세(성인)
			String result2 = ""; // 남성 18세(청소년)
			
		char a = check.charAt(7);
				System.out.println(a);
			
			// 문제1) 주민1 성별 출력 -> 여성
			
			// 문제2) 주민1 나이 출력 -> 33세(성인)
			
			// 문제3) 주민2 성별 출력 -> 남성
			
			// 문제4) 주민2 나이 출력 -> 18세(청소년)
			int cnt = 0;
			int age = Integer.parseInt(check.substring(0, 2));
			int gender = Integer.parseInt(check.substring(7, 8));

			while (age != 22) {
				cnt++;
				age++;
				if (age == 100) {
					age = 0;
				}
			}

			if (gender % 2 == 0) {
				result1 += "여성 ";
				result1 += cnt + "세";
			} else {
				result1 += "남성 ";
				result1 += cnt + "세";
			}

			if (cnt >= 20) {
				result1 += "(성인)";
			} else {
				result1 += "(청소년)";
			}

			System.out.println(result1);
				
				
	}

}
