package 문자열;

import java.util.Scanner;

public class 기본이론04_04 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
			
			String name1 = "박연미";
			String name2 = new String("박연미");
			String name3 = name1;
			String name4 = "박연미"; 
			String name5 = new String("박연미"); 
			System.out.println("박연미 입력>> ");
			String name6 = sc.next(); // new String("박연미"); 
			
			System.out.println(name1 == name2); // false
			System.out.println(name1 == name3); // true
			System.out.println(name1 == name4); // true
			System.out.println(name1 == name5); // false
			System.out.println(name1 == name6); // false
			
			// 문자열 주소값 출력 방법 
		System.out.println(System.identityHashCode(name1));
		System.out.println(System.identityHashCode(name2));
		System.out.println(System.identityHashCode(name3));
		System.out.println(System.identityHashCode(name4));
		System.out.println(System.identityHashCode(name5));
		System.out.println(System.identityHashCode(name6));

	}

}
