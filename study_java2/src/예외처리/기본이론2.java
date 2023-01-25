package 예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

class Test{
	
//	void sample() {
//		// 발생할 수 있는 에러를 내가 처리할께 
//		try {
//			int a = 10/0;
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println(e.toString());
//			System.out.println("0으로 나눌 수 없습니다 ");
//		}
//	}
	
	// throws Exception
	void sample2() throws Exception{
		// 나를 호출한 곳에서 에러를 처리해줘
		// sample2 그냥 호출 불가 try{}catch(){} 로 호출 가능 
		int a = 10/0;
		System.out.println("test");
	}
	
}

public class 기본이론2 {

	public static void main(String[] args) {

		
		Test t = new Test();
//		t.sample();
		
		try {
			t.sample2();
		} catch (Exception e) {
			System.out.println("0 으로 나눗셈 불가");
			e.printStackTrace();
		}
		
		System.out.println("try - catch 종료 후 ");

		
		
///////////////  Throw 에러발생 시켜주는 역할		
		
//		try {
////			Exception e = new Exception("에러 그냥 발생했음");
////			throw e; // throw 에러 객체 발생
//			//int a = 10/0;
//
//			int a = 101;
//			
//			if(a < 0 || a > 100) {
////				// 위에것 한줄로 처리 
//				throw new Exception("점수값은 0 - 100 사이값 입니다");
//			}
//			System.out.println("test");
//			
//		}catch(Exception e) {
////			e.printStackTrace();
//			System.out.println("겟메세지");
//			System.out.println(e.getMessage());
//		}	
//		System.out.println("프로그램 종료");
//		
//		
		
		
	}
	
}
