package 문자열;

import java.util.Arrays;

public class 기본이론06_여러기능메서드 {

	public static void main(String[] args) {
		
		// 문자열 => 클래스 => 여러 기능(메서드)들을 사용할 수 있다 
		
				// 문자열에 가장 많이 쓰이는 메서들 종류 
				          // 0 1 2
				String str = "박연미선생님";
				System.out.println("str => " + str);
				
				// 1) 문자열 길이 추출 .length()
				
				System.out.println(str.length()); // 3 
				
				// 2) 문자 한개 추출 .charAt(int index)
				// 해당 문자열의 인덱스 번호에 있는 => char 값 추출 
				System.out.println(str.charAt(0)); // '박'
				
				// 3) 문자열 여러개 추출 (슬라이싱) substring
				String str2 = str.substring(1); // 1번 인덱스부터 끝까지 
				System.out.println("str2 => " + str2);
				
				                    //(시작인덱스 , 끝인덱스-1) // 1 2
				String str3 = str.substring(1,3);  // (시작인덱스 , 끝인덱스 )
				                                    // 끝 인덱스 전까지 
				System.out.println("str3 => " + str3);
				
				// 4) split(구분자) => 구분자를 기준으로 String 배열로 변경 
				String str4 ="떡볶이,피자,치킨,탕수육";
				String array[] = str4.split(",");
				System.out.println("str4 => "+ Arrays.toString(array));
				System.out.println(array[0]); // "떡볶이"
				System.out.println(array[1]);// "피자"
				System.out.println(array[2]);// "치킨"
				System.out.println(array[3]);// "탕수육"
				
				// 5) trim 앞뒤 공백 문자열을 제거한 문자열 
				
				String str5 ="     박 연미     ";
			    System.out.println("str5 => " + str5);
			    System.out.println("str5 => " + str5.trim());
				
			    // 6) replaceAll =>  
			    
			    String str6="helloHellohelloHello";
			    
			    System.out.println("str6 => " + str6);
			    System.out.println("str6 => " + str6.replaceAll("Hello", "World"));
			    
			    // 7) 문자열 사이 공백 제거 
			    
			    String str7 = " hello hello hello ";
			    String str8 = str7.replaceAll(" ", "");
			   // str7 =  str7.replaceAll(" ", "");
			    System.out.println("str7 => " + str7);
			    System.out.println("str8 => " + str8);
		
				
	}

}
