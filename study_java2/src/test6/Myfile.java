package test6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Myfile {

	
	private String stufile = "src/test6/stufile.txt";
	private String subfile = "src/test6/subfile.txt";
	private FileWriter fw;
	private FileReader fr;
	
	void saveAll() {
		dataSave("Stu", stufile);
		dataSave("Sub", subfile);
	}
	
	void readExcute() {
		setData(stufile);
		setData(subfile);
	}
	
	private void setData(String path) {
		String data = readAll(path);
		String[] temp = data.split("\n");
		
		
		if (path.equals(stufile)) {
			for (String t : temp) {
				String[] temp1 = t.split(",");
				StudentDAO.studentList.add(new Student(Integer.parseInt(temp1[0]), temp1[1]));
			}
		}

		if (path.equals(subfile)) {
			for (String t : temp) {
				String[] temp1 = t.split(",");
				SubjectDAO.subjectList.add(new Subject(Integer.parseInt(temp1[0]), temp1[1], Integer.parseInt(temp1[2])));
			}
		}
		
	}
	
	private String readAll(String path) {
		String data = "";
		try {
			fr = new FileReader(path);
			int read = -1;
			while(true) {
				read = fr.read();
				if(read != -1) {
					data += (char)read;
				}else {
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.print(path+" 파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return data;
	}
	
	private String getData(String saveName) {
		String data = "";
		
		if (saveName.equals("Stu")) {
			if (StudentDAO.studentList.size() == 0) {
				System.out.println("[학생 데이터가 없습니다.]");
				return data = null;
			}
			for (Student s : StudentDAO.studentList) {
				data += s.getStudentNum() + "," + s.getStudentId() + "\n";
			}
		}
		//
		else if (saveName.equals("Sub")) {
			if (SubjectDAO.subjectList.size() == 0) {
				System.out.println("[과목 데이터가 없습니다.]");
				return data = null;
			}
			for (Subject s : SubjectDAO.subjectList) {
				data += s.getStudentNum() + "," + s.getSubject() + "," + s.getScore() + "\n";
			}
		}
		
		data.substring(0, data.length()-1);
		return data;
	}
	
	private void dataSave(String saveName ,String path) {
		String data = getData(saveName);
		if(data == null) {return;}
		
		try {
			fw = new FileWriter(path);
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(path+"저장 완료");
		
	}
	
	
}
