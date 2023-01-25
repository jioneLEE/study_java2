package test6;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectDAO {
	private final String[] sub = {"국어","영어","수학","과학"};
	private Scanner scan = new Scanner(System.in);
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	static ArrayList<Subject> transferArr(int num) {
		ArrayList<Subject> temp = new ArrayList<Subject>();
		
		for(Subject s : subjectList) {
			if(s.getStudentNum() == num) {
				String tem = s.getSubject()+"";
				temp.add(new Subject(tem,s.getScore()));
			}
		}
		return temp;
	}
	
	private boolean checkSubName(String sub) {
		for(int i=0; i<this.sub.length; i++) {
			if(this.sub[i].equals(sub)) {
				return true;
			}
		}
		System.out.println("[옳바르지 않은 과목명입니다.]");
		return false;
	}
	
	private boolean isDuplicationSub(int num, String sub) {
		for (Subject s : subjectList) {
			if (s.getSubject().equals(sub) && s.getStudentNum() == num) {
				System.out.println("[이미 추가된 과목명입니다.]");
				return true;
			}
		}
		return false;
	}
	
	public void insertSubject(StudentDAO studentDAO) {
		if(StudentDAO.isStudentList()){return;}
		int num = -1;
		while(num == -1) {
			num = MyUtil.getNum("과목을 추가 할 학번", studentDAO.min, studentDAO.studentList.get(studentDAO.studentList.size()-1).getStudentNum());
		}
		String subject = null;
		while(subject == null) {
			subject = MyUtil.getvalue("과목명");
			if(isDuplicationSub(num,subject)) {
				subject = null;
				continue;
			}
			if(!checkSubName(subject)) {
				subject = null;
				continue;
			}
		}
		int score = -1;
		while(score == -1) {
			score = MyUtil.getNum("점수", 0, 100);
		}
		subjectList.add(new Subject(num, subject, score));
	}
	
	private boolean isDeleteSub(int num) {
		for (Subject s : subjectList) {
			if (s.getStudentNum() == num) {
				return true;
			}
		}
		System.out.println("["+num+"학번은 어떠한 과목도 존재하지않습니다.]");
		return false;
	}
	
	private boolean checkSub(String sub) {
		for(Subject s : subjectList) {
			if(s.getSubject().equals(sub)) {
				return true;
			}
		}
		System.out.println("[추가하지않은 과목입니다.]");
		return false;
	}
	
	public void deleteSubject(StudentDAO studentDAO) {
		if(StudentDAO.isStudentList()){return;}
		int num = -1;
		while(num == -1) {
			num = MyUtil.getNum("과목을 삭제 할 학번", studentDAO.min, studentDAO.num);
			if(!isDeleteSub(num)) {
				num = -1;
				continue;
			}
		}
		
		String subject = null;
		while(subject == null) {
			subject = MyUtil.getvalue("삭제 과목명");
			if(!checkSub(subject)) {
				subject = null;
				continue;
			}
		}
		
		int idx = MyUtil.findSubIdx(num, subject);
		subjectList.remove(idx);
		System.out.println(num+","+subject +"[삭제완료]");
		
	}
}