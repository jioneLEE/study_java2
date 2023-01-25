package 예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 문제04_예제파일읽기쓰기 {

	public static void main(String[] args) {

		// ctrl + shift + o 
				Scanner scan = new Scanner(System.in);

				String nameData = "김철수,이만수,이영희";
				String ageData ="20,30,40";
				String fileName = "src/예외처리/file03.txt";
				String data = "";		
				
				String[] nameList = null;
				int [] ageList = null;	
				
				FileWriter fw  = null;
				FileReader fr = null;		
				
				while(true) {
								
					System.out.println("[0] 종료 [1] 저장 [2] 로드");
					int sel = scan.nextInt();
					if(sel == 0) {
						break;
					}
					else if(sel == 1) {
//						[저장] 김철수/20\n이만수/30\n이영희/40 이렇게 데이터를 만들어 파일 생성후 저장하시오. 
						String[] temp = nameData.split(",");
						String[] temp1 = ageData.split(",");
						for(int i =0; i<temp.length; i++) {
							data+= temp[i]+"/"+temp1[i]+"\n";
						}
						try {
							fw = new FileWriter(fileName);
							fw.write(data);
							System.out.println("data 저장 성공");
						} catch (IOException e) {
							e.printStackTrace();
						}finally {
							try {
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					}
					else if(sel == 2) {
//						[로드] 파일을 불러와서 nameList, ageList 배열에 저장하시오 
						data = "";
						
						try {
							fr = new FileReader(fileName);
							while(true) {
								int read = fr.read();
								if(read != -1) {
									data+= (char)read;
								}else{
									break;
								}
							}
							System.out.println(data);
							String[] tem = data.split("\n");
							nameList = new String[tem.length];
							ageList = new int[tem.length];
							int idx = 0;
							for(String tem1 : tem) {
								String[] te = tem1.split("/");
								nameList[idx] = te[0];
								ageList[idx] = Integer.parseInt(te[1]);
								idx++;
							}
							
							System.out.println(Arrays.toString(nameList));
							System.out.println(Arrays.toString(ageList));
							
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch(IOException e) {
							System.out.println("파일 불러오기 실패");
						}
						
					}
					
				}

	}

}
