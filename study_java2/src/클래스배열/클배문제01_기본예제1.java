package 클래스배열;

import java.util.Arrays;

//class Student {
//	int number;
//	String id;
//	String pw;
//	String name = "무명이";
//	int score;
//}

public class 클배문제01_기본예제1 {

	public static void main(String[] args) {

		String data = "";
		data += "1001,qwer,1234,김철민,10\n";
		data += "1002,asdf,2345,우중현,3\n";
		data += "1003,zxcv,3456,이만수,30";

		// stList 클래스배열에 데이터를 넣고 1등 출력
		String dt[] = data.split("\n");

//		String da[] = dt[0].split(",");
//		String da1[] = dt[1].split(",");
//		String da2[] = dt[2].split(",");
		String[][] a = new String[dt.length][];
		
		System.out.println(Arrays.toString(dt));
		
		for(int i =0 ; i<dt.length; i++) {
			a[i] = dt[i].split(","); // new String[갯수]
		}
		
		for(int i =0; i<a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
		Student[] stList = new Student[3];
		for(int i =0; i<a.length ; i++) {
		Student s = new Student();			      	
		s.number = Integer.parseInt(a[i][0]);
		s.id = a[i][1];
		s.pw = a[i][2];
		s.name = a[i][3];
		s.score = Integer.parseInt(a[i][4]);
		stList[i] = s;
		}
		int idx= 0;
		for(int i = 1 ; i<stList.length; i++) {
			int max = stList[0].score;
			if(max < stList[i].score) {
				max = stList[i].score;
				idx = i;
			}
		}
		
		System.out.printf("1등[%s] 점수[%d점] \n",stList[idx].name , stList[idx].score );
		
		
		for(int i =0; i<a.length; i++) {
			System.out.println(stList[i].name +" "+ stList[i].score);
		}
		

	}

}