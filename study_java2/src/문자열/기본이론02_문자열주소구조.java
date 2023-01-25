package 문자열;

import java.util.Scanner;

public class 기본이론02_문자열주소구조 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = "박연미"; // string pool heap 메모리방에 있는 
		// 문자열 저장소에 저장 
		String name2 = new String("박연미"); // new 항상 heap 메모리 공간에 새로운 방을 만듬
		
		System.out.println("박연미 입력: ");
		String input = sc.next(); // new String("사용자가 입력한 문자열");  
		System.out.println("name => " + name);
		System.out.println("input => " + input);
		System.out.println("name2 => " + name2);
		
		System.out.println("=================================");
		
		// String 클래스 => 변수는 heap 메모리의 주소값을 가지고 있다 
		// 그래서 String == 통해서 비교를 하면 서로 주소값을 비교를 하는 것이다 
		
		System.out.println("1) " + name == input);
		System.out.println("2) " + name == name2);
		System.out.println("3) " + name2 == input);
		
		System.out.println("=================================");
		
//		int arr[] = {10,20,30,40,50};
//		int temp[]= arr;
//		int temp2[] = new int[3];
//		
//		System.out.println("4) " + (arr == temp));
//		System.out.println("5) " + (arr == temp2));
//		System.out.println("6) " + (temp == temp2));
//		
//		System.out.println(arr);
//		System.out.println(temp);
//		System.out.println(temp2);
		
		// 클래스 주소값이 아니라 순수하게 가리키는 값을 비교하기 위해서는
		// .equals(비교문자변수) => 같으면 true 다르면 false 
		
		System.out.println("7) " + name.equals(input));
		System.out.println("8) " + name2.equals(name));
		System.out.println("9) " + name2.equals(input));
		
		System.out.println("=================================");

	}

}
