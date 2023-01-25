package 예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 문제04_예제파일읽기쓰기연습 {

	public static void main(String[] args) {

		// ctrl + shift + o
		Scanner scan = new Scanner(System.in);

		String nameData = "김철수,이만수,이영희";
		String ageData = "20,30,40";
		String fileName = "src/예외처리/file05.txt";
		String data = "";

		String[] nameList = nameData.split(",");
		String[] ageList = ageData.split(",");
		
		
//		int[] ageList = new int[temp.length];
//		ageList[0] = Integer.parseInt(temp[0]);

		FileWriter fw = null;
		FileReader fr = null;

		while (true) {

			System.out.println("[0] 종료 [1] 저장 [2] 로드");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
//						[저장] 김철수/20\n이만수/30\n이영희/40 이렇게 데이터를 만들어 파일 생성후 저장하시오. 
				for(int i =0; i<nameList.length; i++) {
					data += nameList[i]+ "/" + ageList[i] + "\n";
				}
				data = data.substring(0, data.length()-1);
				
				System.out.println(data);
				try {
					fw = new FileWriter(fileName);
					fw.write(data);
					System.out.println("data 저장성공");
				} catch (IOException e) {

					e.printStackTrace();
				}finally{
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

			} else if (sel == 2) {
//						[로드] 파일을 불러와서 nameList, ageList 배열에 저장하시오 
				try {
					fr= new FileReader(fileName);
					int read =0;
					while(read != -1) {
						read = fr.read();
						data += (char)read;
					}
					System.out.println(data);
					data = data.substring(0, data.length()-10);
					String dataList[] = data.split("\n");
					String[] tem1 = new String[dataList.length];
					int[] tem2 = new int[dataList.length];
					
					int idx = 0;
					for(String data1 : dataList) {
						String[] temp = data1.split("/");
						System.out.println(Arrays.toString(temp));
//						tem1[idx] = temp[0];
//						tem2[idx] = Integer.parseInt(temp[1]);
						idx++;
					}
					
					System.out.println(Arrays.toString(tem1));
					System.out.println(Arrays.toString(tem2));
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}
}