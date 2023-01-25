package 클래스배열;

import java.util.Scanner;

class Subject{
	int stuNum; // 학번 Student 클래스의 number 랑 같은 값 
	String name;// 과목 이름 
	int score; // 과목 점수
	int rank;// 그 과목 등수 
}

public class 클배문제03_기본예제2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		
		// 기존에 있는 Student 클래스 학번 이름 점수(총합 )
		String studentSample = "1001/이만수\n";
		studentSample += "1002/김철만\n";		
		studentSample += "1003/오수정\n";
		
		String subjectSample = "";
		subjectSample += "1001/국어/100/0\n";
		subjectSample += "1001/수학/32/0\n";
		subjectSample += "1002/국어/23/0\n";
		subjectSample += "1002/수학/35/0\n";
		subjectSample += "1002/영어/46/0\n";
		subjectSample += "1003/수학/60/0";	
		
		//문제1) 위 샘플문자열들을 각각 해당 클래스배열에 저장후 출력		
		//문제1) 점수가 59점이하인 과목은 전부 삭제후 다시 문자열로 저장후 출력 
		
	}

}