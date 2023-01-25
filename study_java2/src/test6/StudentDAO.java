package test6;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
	
	public final int min = 1001;
	public int num = 1000;
	private Student s = null;
	
	static ArrayList<Student> studentList = new ArrayList<Student>();

	private int addnum() {
		num++;
		return num;
	}
	
	static boolean isStudentList() {
		if(studentList.size() == 0) { System.out.println("[학생목록이 없습니다.]");return true;}
		return false;
	}
	
	static boolean isDuplicationId(String id) {
//		if (!isStudentList()) {
			for (Student s : studentList) {
				if (s.getStudentId().equals(id))
					return true;
			}
//		}
		return false;
	}
	
	public void join() {
		String id = null;
		while(id == null) {
			id = MyUtil.getvalue("아이디");
		}
		studentList.add(s = new Student(addnum(), id));
	}
	
	

	public void deleteStudent(SubjectDAO subjectDAO) {
		if(isStudentList()) {return;}
		
		int num = -1;
		while(num == -1) {
		num = MyUtil.getNum("학번입력", min, this.num);
		}
		int idx = MyUtil.findStuIdx(num);
		System.out.println(idx);
		studentList.remove(idx);
		
	}

	public void printStudentList(SubjectDAO subjectDAO) {
		if(isStudentList()) {return;}
		
		for(Student s : studentList) {
			System.out.print(s);
			ArrayList<Subject> aStuList = SubjectDAO.transferArr(s.getStudentNum());
			for(Subject a: aStuList) {
				System.out.print(a);
			}
			System.out.println();
		}
		
	}

	private double getAvg(ArrayList<Subject> List) {
		double avg = 0.0;
		for(Subject s : List) {
		avg += s.getScore(); 
		}
		if(avg == 0.0) {
			avg = 10.0;
		}else {
			avg /= List.size();
		}
		System.out.println(avg);
		return avg;
	}
	
	public void rearrange() {
		if(isStudentList()) {return;}
		
		
		ArrayList<Subject> aStuList = null;
		ArrayList<Double> rearrange = new ArrayList<>();
		
		for(int i =0; i<studentList.size(); i++) {
			aStuList = SubjectDAO.transferArr(studentList.get(i).getStudentNum());
			double avg = getAvg(aStuList);
			rearrange.add(avg);
		}
		
		for(int i =0; i<rearrange.size(); i++) {
			int maxIdx = i;
			for(int k =i; k<rearrange.size(); k++) {
				if(rearrange.get(maxIdx) < rearrange.get(k)) {
					System.out.println("ttest");
				}
				
			}
		}
		
		
		
	}

		
		



	
	
}