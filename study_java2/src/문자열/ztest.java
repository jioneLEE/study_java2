package 문자열;

public class ztest {

	public static void main(String[] args) {
		
		
//        String str = "abcd";
//
//        // 1) 비교대상에 문자열이 포함되어있을 경우
//        System.out.println( str.compareTo("abcd") );  // 0 (같은 경우는 숫자나 문자나 0을 리턴)
//        System.out.println( str.compareTo("ab") );  //  2
//        System.out.println( str.compareTo("a") );  //  3
//        System.out.println( str.compareTo("c") );  //  -2       
//        System.out.println( "".compareTo(str) );  //  -4
//
//        System.out.println("===================");
//        
//        // 2) 비교대상과 전혀 다른 문자열인 경우
//        System.out.println( str.compareTo("zefd") );  //  -25
//        System.out.println( str.compareTo("zEFd") );  //  -25
//        System.out.println( str.compareTo("ABCD") );  //  32
		
		// 시작시간 14:20

		// 만나이
		String jumin1 = "890101-2012932";
		String jumin2 = "040101-3012932";
		String result1 = ""; // 여성 33세(성인)
		String result2 = ""; // 남성 18세(청소년)

		// 문제1) 주민1 성별 출력 -> 여성
//		String a = jumin1.charAt(7);
//		System.out.println(a);
		
		System.out.println(jumin1.charAt(7));
		
		if (jumin1.charAt(7) % 2 == 0) {
			result1 += "여성 ";
		} else {
			result1 += "남성 ";
		}

		// 문제2) 주민1 나이 출력 -> 33세(성인)
		
		String year_jumin1 = "19" + jumin1.substring(0, 2);
		int age_jumin1 = 2022 - Integer.parseInt(year_jumin1);
		result1 += age_jumin1 + "세";
		if (age_jumin1 >= 19) {
			result1 += "(성인)";
		} else {
			result1 += "(청소년)";
		}
		
		// 문제3) 주민2 성별 출력 -> 남성

		if (jumin2.charAt(7) % 2 == 0) {
			result2 += "여성 ";
		} else {
			result2 += "남성 ";
		}
		
		// 문제4) 주민2 나이 출력 -> 18세(청소년)
		
		String year_jumin2 = "20" + jumin2.substring(0, 2);
		System.out.println(year_jumin2);
		int age_jumin2 = 2022 - Integer.parseInt(year_jumin2);
		System.out.println();
		result2 += age_jumin2 + "세";
		if (age_jumin2 >= 19) {
			result2 += "(성인)";
		} else {
			result2 += "(청소년)";
		}

		System.out.println(result1);
		System.out.println(result2);

		// 종료시간 14:31



	}

}
