package 클래스배열;

class Subject2{
	String name;
	int score;
}

class Student2{
	Subject2[] subjects;
	String name;
}

public class 클배_메모리6_평가 {

	public static void main(String[] args) {
		
		Student2[] st = new Student2[3];
		
		st[0] = new Student2();
		st[0].subjects = new Subject2[3];
		
		for(int i = 0; i < 3; i++) {
			st[0].subjects[i] = new Subject2();
		}
		
		st[1] = new Student2();
		st[1].subjects =new Subject2[2];
		st[1].subjects[0] = new Subject2();
		st[1].subjects[1] = new Subject2();
		
		st[2] = new Student2();
		st[2].subjects = new Subject2[1];
		st[2].subjects[0] = new Subject2();
		
	}

}