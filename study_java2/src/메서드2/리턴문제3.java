package 메서드2;

import java.util.Arrays;

class Return3{
	int num;
	String name;
	String area;
	int korean;
	int math;
	int eng;
	int add;
	double avg;
	
	
	String[][] run(String[][] student , String[][] score){
		String[][] result = new String[student.length][8];
		Return3[] re = new Return3[student.length];
		
		for(int i =0; i<student.length; i++) {
			Return3 r = new Return3();
			r.num = Integer.parseInt(student[i][2]);
			r.name = student[i][0];
			r.area =	student[i][1];
			
			for(int k=0; k<score.length; k++) {
				if(student[i][2].equals(score[k][0])) {
				
				if(score[k][1].equals("국어")) {
					r.korean = Integer.parseInt(score[k][2]);
				}
				if(score[k][1].equals("수학")) {
					r.math = Integer.parseInt(score[k][2]);
				}
				if(score[k][1].equals("영어")) {
					r.eng = Integer.parseInt(score[k][2]);
				}
				}
			}
			r.add = r.math + r.korean + r.eng;
			r.avg = r.add/3.0;
			
			re[i] = r;
		
		}
	
			for(int i =0 ; i<student.length; i++) {
				System.out.print(re[i].num);
				System.out.print(" ");
				System.out.print(re[i].name);
				System.out.print(" ");
				System.out.print(re[i].area);
				System.out.print(" ");
				System.out.print(re[i].korean);
				System.out.print(" ");
				System.out.print(re[i].math);
				System.out.print(" ");
				System.out.print(re[i].eng);
				System.out.print(" ");
				System.out.print(re[i].add);
				System.out.print(" ");
				System.out.print(re[i].avg);
				System.out.println();
				System.out.println("========");
			}
			
			
		
		
		
	
		
		return result;
	}
	
}
public class 리턴문제3 {

	public static void main(String[] args) {
		
		/*
			[문제]
				아래 main() 메서드 내의 student배열은
				순서대로 이름, 지역, 번호를 의미한다.
				score배열은 번호 과목, 점수를 의미한다. 
				
				이러한 데이터를 아래 순서대로 result배열에 저장하여 리턴해주는
				run메서드를 구현하시오.
				
				[학생번호] [이름] [지역] [국어] [수학] [영어] [총합] [평균] 
		
			[정답]
			String[][] result = {
				[1001, 김철만, 신촌, 20, 65, 43, 128, 42.67], 
				[1002, 오상덕, 강남, 50, 15, 90, 155, 51.67], 
				[1003, 민철이, 대치, 60, 80, 30, 170, 56.67], 
				[1004, 유재석, 강동, 17, 70, 70, 157, 52.33]
				}
		 */
		
	  Return3 re = new Return3();
		
		String [][] student = {
				{"김철만","신촌","1001"}, 
				{"오상덕","강남","1002"},
				{"민철이","대치","1003"} ,
				{"유재석","강동","1004"}};
		String[][] score = {
				{"1001" ,"국어","20"},
				{"1002" ,"국어","50"},
				{"1003" ,"국어","60"},
				{"1004" ,"국어","17"},
				{"1001" ,"수학","65"},
				{"1002" ,"수학","15"},
				{"1003" ,"수학","80"},
				{"1004" ,"수학","70"},
				{"1001" ,"영어","43"},
				{"1002" ,"영어","90"},
				{"1003" ,"영어","30"},
				{"1004" ,"영어","70"}
		};
		
		String[][] result = re.run(student, score);
		
		
	}

}