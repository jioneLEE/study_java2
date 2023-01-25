package 제네릭클레스;

import java.io.FileNotFoundException;
import java.io.FileReader;

class Test1{
	int[] num =new int[3];
	
	// 생성자도 메서드다 
	// public Test1(){}

	public Test1() throws Exception{
		
	}
	                              // 주의사항 이미 Exception 으로 생성자에서 try-catch 로 설정했기 때문에
                                  //메서드에서 ArrayIndexOutOfBoundsException이 적용이 안된다 
						  		// Exception이 상위 에러 클래스이기 때문에 
	void printNum(int idx) throws ArrayIndexOutOfBoundsException{
		System.out.println(num[idx]);
	}
	
	
}

public class 이론07_예외처리추가주의사항 {
	public static void main(String[] args) {
		
		int[] num = new int[3];
//		System.out.println(num[4]);
		
	    try {
//			FileReader fr = new FileReader("test.txt");
			Test1 t1 = new Test1();
			t1.printNum(5);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}catch (Exception e) {
			System.out.println("111111");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
	}
}