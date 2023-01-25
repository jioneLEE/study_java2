package 메서드;

import java.util.Random;

//클래스 구성요소 : 필드(변수):값 저장 , 메서드(= 함수): 기능 

//메서드 : 동작, 기능 구현 

class Test01{
	int x;
	// type1 유산 x: void  외부값 x () : 비어있는 가로 
	
	void type1() {
		int x = 10; 
		System.out.println("test01 tpye1 실행");
		System.out.println("x= " + x);
	
	}
	
	
	
}

public class 기본이론01 {
	

	public static void main(String[] args) {
    Random rd = new Random();
    
		// 변수 : 한가지 자료형 1개저장
		// 배열 : 한가지 자료형 여러개 저장 
		// 클래스 :여러개 자료형 여러개 저장 (사용자 정의 자료형) 
		
		// 배열과 클래스 공통점 : heap 메모리방에 생성, 기본 초기값 있음
		// 배열 => new String[3]; 
		// 클래스 => new Student();
		
		// 배열 클래스 값 접근 차이 
		// 배열이름[1] 
		// 클래스객체이름.변수이름 
		
		// 클래스 배열 => 클래스 객체주소가 여러개 들어가는 배열 
		// new Student[3]; // {null,null,null}
		// Student 객체 아직 만들어지지않았다 
		
		// stuList[0] = new Student(); // 객체 생성후
		// stuList[0].name = "홍길동" // 객체 안에 변수(필드)의 값 접근 
		int x = 100; 
	
		System.out.println("main x= " + x);
		Test01 t = new Test01(); // 클래스 객체 생성 
		System.out.println(t.x);
		t.type1(); // 메서드 호출 
		
		
		System.out.println("main x= " + x);

		
	
	}

}