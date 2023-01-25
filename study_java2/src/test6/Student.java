package test6;

public class Student {
	private int studentNum; // 1씩 자동증가 1001~  
	private String studentId; // 중복금지
	private double avg;
	public Student(int studentNum, String studentId) {
		super();
//		this.studentNum = studentNum;
//		this.studentId = studentId;
		setStudentNum(studentNum);
		setStudentId(studentId);
	}
	
	public Student(int studentNum, double avg) {
		super();
		setStudentNum(studentNum);
		setAvg(avg);
	}
	
	

	public int getStudentNum() {
		return studentNum;
	}

	private void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentId() {
		return studentId;
	}

	private void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public double getAvg() {
		return avg;
	}

	private void setAvg(double avg) {
		this.avg = avg;
	}



	@Override
	public String toString() {
		return  studentNum + "  " + studentId;
	}
	
	
	
}