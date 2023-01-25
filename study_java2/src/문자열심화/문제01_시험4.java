package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제01_시험4 {

	public static void main(String[] args) {
		
		/*
		# 2차원 회원관리데이터 
			[1] 번호 [2] 아이디 [3] 비밀번호 [4] 이름 
			테스트를 위해 아래 기본데이터 4개를 넣고 시작한다.
	 */

			Scanner scan = new Scanner(System.in);	
			//                번호     아이디   비번       이름 
			String[] test1 = {"1001" , "aaa" ,"aaa123" , "김철수"};
			String[] test2 = {"1002" , "bbb" ,"bbb123" , "이민수"};
			String[] test3 = {"1003" , "ccc" ,"ccc123" , "박영희"};
			String[] test4 = {"1004" , "ddd" ,"ddd123" , "최민정"};		
			int cnt = 4; // 현재 맴버 수 
			int cnt1 = 4;
			String [][] mList =new String[100][4]; // 최대100명 데이타는4

	    String menu = "[회원관리] \n [1] 추가 [2] 삭제 [3] 수정 [4] 검색 [5] 출력 [0] 종료 \n";
	
		mList[0] = test1;
		mList[1] = test2;
		mList[2] = test3;
		mList[3] = test4;

		while (true) {
			System.out.print(menu);
			boolean check = true;

			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 5) {
				// 번호와 이름 출력
				for (int i = 0; i < cnt + 3; i++) {
					System.out.printf("[번호 %s] [이름 : %s] \n", mList[i][0], mList[i][3]);
				}

			}

			else if (sel == 1) {
				String id = "";
				String pw = "";
				String name = "";
				while (check) {
					System.out.print("아이디를 입력 : ");
					id = scan.next();

					// 아이디 중복검사
					for (int i = 0; i < cnt; i++) {
						if (mList[i][1].equals(id)) {
							System.err.println("중복된 아이디입니다.");
							break;
						}
						if (i == cnt - 1) {
							check = false;
						}
					}

				}
				// 비번은 숫자만 하면 에러 뜨게
				check = true;
				int count = 0;
				while (check) {
					System.out.print("비밀번호를 입력 : ");
					pw = scan.next();

					// 비밀번호 숫자검사
					for (int i = 0; i < pw.length(); i++) {
						for (int k = '0'; k <= '9'; k++) {
							if ((int) pw.charAt(i) == k) {
								count++;
								break;
							}
						}
					}
					if (count == pw.length()) {
						System.err.println("숫자만 입력할 수 없습니다.");
						count = 0;
					} else {
						check = false;
					}

				}

				// 이름은 숫자 있으면 에러뜨게
				check = true;
				count = 0;
				while (check) {
					System.out.print("이름을 입력 : ");
					name = scan.next();
					scan.nextLine();

					// 비밀번호 숫자검사
					for (int i = 0; i < name.length(); i++) {
						for (int k = '0'; k <= '9'; k++) {
							if ((int) name.charAt(i) == k) {
								count++;
								break;
							}
						}
					}
					if (count > 0) {
						System.err.println("숫자를 입력할 수 없습니다.");
						count = 0;
					} else {
						check = false;
					}

				}

				// 번호는 최대 큰 번호에서 +1 숫자 한 값
				if (!check) {

					mList[cnt][0] = 1001 + cnt1 + "";
					mList[cnt][1] = id + "";
					mList[cnt][2] = pw + "";
					mList[cnt][3] = name + "";
					System.out.println(Arrays.toString(mList[cnt]));
				}

				cnt++;
				cnt1++;

			} else if (sel == 2) {
				// 삭제할 번호 입력받아서 삭제 => 정렬 다시 해줘야함 =>
				check = true;
				String num = "";
				while (check) {
					int count = 0;
					System.out.print("번호를 입력 : ");
					num = scan.next();
					for (int i = 0; i < cnt; i++) {
						if (num.equals(mList[i][0])) {
							count++;
							for (int k = i; k <= cnt; k++) {
								for (int j = 0; j < mList[k].length; j++) {
									mList[k][j] = mList[k + 1][j];
								}
								if (k == cnt - 1) {
									for (int j = 0; j < mList[cnt].length; j++) {
										mList[k][j] = null;
									}
								}
							}
							cnt--;
							break;
						}
					}

					if (count == 0) {
						System.err.println("없는 번호입니다.");
					} else {
						check = false;
					}
				}

			} else if (sel == 3) {
				// 수정 => id 와 비번 입력받고 맞으면 해당 id의 비번 혹은 이름만 수정 가능
				check = false;
				int idx = 0;
				while (true) {
					System.out.print("아이디 입력 : ");
					String id = scan.next();
					for (int i = 0; i < cnt; i++) {
						if (id.equals(mList[i][1])) {
							idx = i;
							check = true;
						}
					}
					if (check) {
						break;
					} else {
						System.err.println("아이디가 틀렸습니다.");
					}
				}

				while (true) {
					check = false;
					System.out.print("비밀번호 입력 : ");
					String pw = scan.next();
					for (int i = 0; i < cnt; i++) {
						if (pw.equals(mList[i][2])) {
							check = true;
						}
					}

					if (check) {
						break;
					} else {
						System.err.println("비밀번호가 다릅니다.");
					}
				}

				while (true) {
					check = false;
					System.out.print("재설정 비밀번호 입력 : ");
					String pw = scan.next();
					if (mList[idx][2].equals(pw)) {
						System.err.println("현재 비밀번호로 변경 불가능.");
						continue;
					}
					mList[idx][2] = pw;
					System.out.println("==비밀번호 변경 완료==");
					break;
				}

			} else if (sel == 4) {
				// 검색 => id 검색 입력 받아서 이름 출력
				check = true;
				while (true) {
					System.out.print("id를 입력 하세요 >> ");
					String id = scan.next();
					for (int i = 0; i < cnt; i++) {
						if (mList[i][1].equals(id)) {
							System.out.printf("검색한 ID 의 이름은 : %s 입니다.\n", mList[i][3]);
							check = false;
							break;
						}
					}

					if (check) {
						System.out.println("ID를 찾을수 없습니다.");
					} else {
						break;
					}
				}

			}
		}
			
			
			
			
	}

}
