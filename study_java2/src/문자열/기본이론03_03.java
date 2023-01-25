package 문자열;

import java.util.Arrays;

public class 기본이론03_03 {

	public static void main(String[] args) {
		
		//String 문자열 => 읽기전용 배열 
		
				String name = "박연미"; 
				char name2[] = {'박','연','미'};
				
				System.out.println(name);
				System.out.println(Arrays.toString(name2));
				
				// 공통점 
				System.out.println("1) " + name2.length); // 3
				System.out.println("2) " + name.length()); // 3 
				
			    System.out.println(name2[1]); // '연'
			    System.out.println(name.charAt(1)); // '연'
			    
			    // 차이점
			    // 배열 한방의 요소를 수정 삭제 가능 
			    name2[1] = '현';
				System.out.println(name2);
				
				// 문자열은 한개의 인덱스 값을 불러올 수 는 있어도 수정 불가능 
				name.charAt(2);
				
			    name ="박현미"; // 새로운 주소값으로 전체를 수정해야한다 
			    
			    char copyName[] = new char[name.length()];
			    
			    for(int i =0; i < copyName.length; i++) {
			    	
			    	copyName[i] = name.charAt(i);
			    	
			    }
			    
			    System.out.println(copyName);

	}

}
