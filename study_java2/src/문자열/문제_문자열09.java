package 문자열;



import java.util.Date;
import java.util.Locale;

public class 문제_문자열09 {

	public static void main(String[] args) {
		
		
		double n = 123.45678;

//		System.out.println(3.4);
//		System.out.println(n);
//		System.out.println();

//		System.out.println(String.format("%f_", 3.4));
//		System.out.println(String.format("%f_", n));
//		System.out.println(String.format("%.6f_", n));
//		System.out.println(String.format("%15f_", n));
//		System.out.println(String.format("%-15f_", n));
//		System.out.println(String.format("%.3f_", n));
//		System.out.println(String.format("%.2f_", n));
//		System.out.println(String.format("%15.2f_", n));
//		System.out.println(String.format("%-15.2f_", n));
//		System.out.println(String.format("%015f_", n));
//		System.out.println(String.format("%015.2f_", n));
				
		int money = 35000;
		Date today = new Date();

		System.out.println(String.format("￦ %,d", money));
		System.out.println(String.format(Locale.GERMANY, "%,d €", money));
		System.out.println(String.format("%tp", today));
		System.out.println(String.format(Locale.ENGLISH, "%tp", today));
				

	}

}
