package 메서드2_문제연습;

import java.util.Arrays;

class Subject {
	String name;
	String stuNo;
	int score;

	public Subject(String name, String stuNo, int score) {
		super(); //Object
		this.name = name;
		this.stuNo = stuNo;
		this.score = score;
	}

	String getInfo() {
		return name + "\t" + score + "\t\n";
	}

	// 부몬클래스인 Object 클래스의 메서드를 자식클래스인 Subject 클래스가 재정의({}부분만 수정가능) 하겟다
	@Override
	public String toString() {
		return "" + name + "\t" + score + "점";
	}
	
}

class Student {
	String stuNo;
	Subject[] subjects;
	String name;

	String getData() {
		String data = name + " \n";
		for (Subject sub : subjects) {
			if (sub == null)
				return data;
			data += sub.getInfo();
		}
		return data;
	}
	void printInfo() {
		System.out.println(getData());
	}

	public Student(String stuNo, String name) {
		this.stuNo = stuNo;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", subjects=" + Arrays.toString(subjects) + ", name=" + name + "]";
	}

}

class StudentDAO {
	Student[] list;

	void printAllStudent() {
		for (Student stu : list) {
			stu.printInfo();
		}
	}

	void init() {
		String stuData = "1001/이만수\n";
		stuData += "1002/김철만\n";
		stuData += "1003/오수정\n";
		String subData = "";
		subData += "1001/국어/10\n";
		subData += "1001/수학/32\n";
		subData += "1002/국어/23\n";
		subData += "1002/수학/35\n";
		subData += "1002/영어/46\n";
		subData += "1003/수학/60\n";
		subData += "1003/영어/100\n";
		
		String[] data1 = stuData.split("\n");
		list = new Student[data1.length];
		
		for(int i =0; i < list.length;i++) {
			String info[] = data1[i].split("/");
			list[i] = new Student(info[0], info[1]);
		}
		
		String[] data2 = subData.split("\n");
		Subject[] subList = new Subject[data2.length];
		
		for(int i =0; i < subList.length;i++) {
			String info[] = data2[i].split("/");
			subList[i] = new Subject(info[1],info[0], Integer.parseInt(info[2]) );
			// Subject sub = new Subject();
			// sub.stuNo = info[0] .. 
		}
//		
//		for(Student s : list) {
//			System.out.println(s);
//		}
//		
//		System.out.println("================");
//		for(Subject s : subList) {
//			System.out.println(s);
//		}
//		System.out.println("================");
		addStudent(subList);
		
	}
	
	void addStudent(Subject[] subList) {
		for(Subject sub : subList) {
			for(Student stu : list) {
				if(sub.stuNo.equals(stu.stuNo)) {
					addSubject(stu , sub);
				}
			}
		}
		
	}
	
	void addSubject(Student stu , Subject sub) {
		int cnt =0;
		if(stu.subjects == null) {
			stu.subjects = new Subject[1];
		}else {
			cnt = stu.subjects.length;
			Subject[] temp = stu.subjects;
			stu.subjects = new Subject[cnt+1];
			for(int i =0; i < cnt;i++) {
				stu.subjects[i]=temp[i];
			}
		}
		stu.subjects[cnt] = sub;
	}

	void run() {
		init();
		printAllStudent();
	}
}

public class 클배문제13_학생컨트롤러3단계 {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();
		dao.run();

	}

}