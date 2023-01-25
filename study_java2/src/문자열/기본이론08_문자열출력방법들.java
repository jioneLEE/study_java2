package 문자열;

import java.util.Arrays;

public class 기본이론08_문자열출력방법들 {

	public static void main(String[] args) {
		
		// 문자열 출력 방법들 
		
				System.out.println("======롯데리아========");
				System.out.println("1) 버\t거\t");
				System.out.println("2) 콜\t라\t");
				System.out.println("3) 튀\t김\t");
				
				String menu = "======롯데리아========";
				menu+="\n";
				menu+="1) 버\t거\t";
				menu+="\n";
				menu+="2) 콜\t라\t";
				menu+="\n";
				menu+="3) 튀\t김\t";
				
				System.out.println(menu);
				
				String names[] = {"aaa", "bbbbbb", "cc"};
				int total[] = {271, 313, 24};
				double avg[] = new double[3];
				
				for(int i =0; i < names.length;i++) {
					avg[i] = total[i] / 3.0;
				}
				
				System.out.println(Arrays.toString(avg));
				
				for(int i =0; i < 3; i++) {
					System.out.printf("[%6s] [%-5d] [%-3.2f] \n"
							, names[i] , total[i], avg[i]);
				}
				
				String strArr[] = new String[5];
				// heap 메모리는 자동 초기값 숫자 => 0 boolean => false , 
				// 숫자도 아니고 논리값도 아니면 => null 
				// null 비어있는 주소값 => 어떤한기능도 사용할 수없다 
				
				System.out.println(Arrays.toString(strArr));
				
		  // null: 비어있는 주소값 /  "" => 비어있는 문자열 
				for(int i =0; i <strArr.length; i++) {
					strArr[i] = "";
				}
				
				System.out.println(strArr[0].length()); // 0
				
				
				// 일반 for문 
				System.out.println("================");
				for(int i =0; i < names.length; i++) {
					System.out.println(names[i]);
				}
				System.out.println("================");
				
				// 향상된 for문 => 단순하다 : 인덱스가 없다 
				// 자동으로 0부터 끝번째 방까지 요소를 ()안에 선언된 이름으로
				// 순서대로 가져온다 
				
				for(String element : names) {
					System.out.println(element);
				}
				System.out.println("================");
				
				for(int val : total) {
					System.out.println(val);
				}
				
	}

}
