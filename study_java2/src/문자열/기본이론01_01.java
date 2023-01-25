package 문자열;

import java.util.Scanner;

public class 기본이론01_01 {

	public static void main(String[] args) {
		
		// 클래스 : 대문자로 시작 
				// 클래스 => 공장을 만들어야지 => new 클래스이름();
				// 공장 안에 있는 기능을 사용할 수 있다 : 기능 ==> 메서드 : 함수 
				// 공장의 기능에 접근을 하는 방식 => . 안에 기능을 사용가능하다 
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("숫자입력: ");
				System.out.println();
				
				int num = sc.nextInt();
				System.out.println("입력 숫자 : " + num);
				
				System.out.println("이름 입력: ");
				
				// 문자열 next() 메서드는 공백을 인식못한다 
				// 박연미 바보 
				// 박연미만 저장 
				
				// next() 모든 키보드 값(공백 전까지)을 다 "" 안에 넣어서 저장한다 
				String name = sc.next(); // 20
				System.out.println("입력 이름 : " + name); // "20"
				
				// 10 + "20" ==> 1020
				System.out.println(num + name);

	}

}
