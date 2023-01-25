package test6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyUtil {
	static private Scanner scan = new Scanner(System.in);
	
	static String getvalue(String msg) {
		System.out.print(msg+"입력 >>");
		String id = null;
		try {
			id = scan.next();
			int cnt = 0;
			
			if (StudentDAO.isDuplicationId(id)) {
				throw new Exception("[중복"+msg+"있음]");
			}
			for (int i = 0; i < id.length(); i++) {
				if (id.charAt(i) >= '0' && id.charAt(i) <= '9') { // 48 57
					cnt++;
				}
			}
			if (cnt == id.length()) {
				throw new Exception("[숫자만으로 "+msg+"생성 불가]");
			}

		} catch (Exception e) {
			id = null;
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	static int getNum(String msg, int start, int end ) {
		System.out.printf("["+msg+" %d ~ %d] 입력 >>", start, end);
		int sel = -1;
		try {
			sel = scan.nextInt();
			if(sel < start || sel >end) {
				throw new Exception("[범위 초과에러]");
			}
			
			
		}catch(InputMismatchException e){
//			sel = -1;
			scan.nextLine();
			System.out.println("[숫자값만 넣으세요]");
		}catch(Exception e){
			sel = -1;
			System.out.println(e.getMessage());
			
//			e.printStackTrace();
		}
		
		return sel;
	}
	
	static int findStuIdx(int num) {
		int idx = 0;
		for(int i =0; i<StudentDAO.studentList.size(); i++) {
			if(StudentDAO.studentList.get(i).getStudentNum() == num) {
				idx = i;
			}
		}
		return idx;
	}
	
	static int findSubIdx(int num, String sub) {
		int idx =0;
		for(Subject s : SubjectDAO.subjectList) {
			if(s.getStudentNum() == num &&s.getSubject().equals(sub)) {
				break;
			}
			idx++;
		}
		
		return idx;
	}
	
}
