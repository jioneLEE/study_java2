package 문자열;

public class 기본이론05_문자열비교equals {

	public static void main(String[] args) {
		
		// 문자열 비교 2가지 방법 
		
				String str1 ="가"; //"가나다라"; // "abcd";
				String str2 ="나"; //"가나다"; // "abef";
				String str3 ="다"; //"가나라"; // "a";
				
				// 1. equals 메서드 사용 => true / false
				System.out.println(str1.equals(str2));
				
				// 2. compareTo => 양수 0 음수 
				         // "가"         "나" 
				int rs1 = str1.compareTo(str2); 
				System.out.println("1) " + rs1); //1) -1176
				        // "나"           "가"
				int rs2 = str2.compareTo(str1);
				System.out.println("2) " + rs2); // 2) 1176
				int rs3 = str1.compareTo(str3);
				System.out.println("3) " + rs3); // 3) -1764
				int rs4 = str1.compareTo("가");
				System.out.println("4) " + rs4); // 4) 0
				
				System.out.println(str1.compareTo(str2) == 0);
				
				// 음수 : 기준 문자열이 비교문자열에 비해 사전적으로 앞순위이다 
				// 양수 : 기준 문자열이 비교문자열에 비해 사전적으로 후순위이다
				// 0 : 기준 문자열이랑 비교문자열이 같다 
				
			    char a1 = '가';
			    char a2 = '나';
			    char a3 = '다';
				
			    System.out.println((int)a1);
			    System.out.println((int)a2);
			    System.out.println((int)a3);
			    
			    System.out.println((int)a1 - (int)a2 );
			    System.out.println((int)a2 - (int)a1 );
			    System.out.println((int)a1 - (int)a3);
			    
			   System.out.println("=========================");
			   System.out.println(str1.compareTo(str3));

	}

}
