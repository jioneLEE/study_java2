package 클래스배열;

import java.util.Random;

//class Student {
//int number;
//String id;
//String pw;
//String name = "무명이";
//int score;
//}

import java.util.Scanner;

public class 클배문제02_학생컨트롤러1단계 {

	public static void main(String[] args) {

		int max = 10;
		Student[] stList = new Student[max];
		int cnt = 0; // 현재 생성한 학생 숫자
		int num = 0;

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		while (true) {
			if (cnt > 0) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s \n", "학번", "id", "pw", "이름", "점수");
				for (Student s : stList) {
					if (s == null) {
						break;
					}
					System.out.printf("%-10d %-10s %-10s %-13s %-10d \n", s.number, s.id, s.pw, s.name, s.score);
				}

				System.out.println("====================");
			}
			System.out.println("[1]학생추가 [2]학생 삭제 [3]수정 [4]검색 [5] 전체출력 [0]종료");

			int sel = sc.nextInt();
			if (sel < 0 || sel > 5) {
				System.err.println("메뉴선택 오류");
			}

			if (sel == 0) {
				break;
			} else if (sel == 1) {
				if (max == cnt) {
					System.err.println("더이상 추가 할 수 없습니다.");
					continue;
				}
				// 추가
				stList[cnt] = new Student();
				while (true) {
					boolean check = true;
					System.out.print("ID 입력>>");
					String id = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (stList[i].id.equals(id)) {
							System.err.println("이미 존재하는 아이디입니다.");
							check = false;
							break;
						}
					}
					if (check) {
						stList[cnt].id = id;
						break;
					}
				}

				System.out.print("PW 입력>>");
				String pw = sc.next();
				stList[cnt].pw = pw;

				System.out.print("이름 입력>>");
				String name = sc.next();
				stList[cnt].name = name;

				// 맨처음 학번은 1001
				stList[cnt].number = 1001 + num;

				int score = rd.nextInt(71) + 30;
				stList[cnt].score = score;
				cnt++;
				num++;

				// 최대학번 + 1 로 자동으로 학번값 넣어주기 : 학번은 입력받지 않는다
				// 이름 아이디(중복 금지) 비번 점수(30-100 랜덤하게 가져오기 )

			} else if (sel == 2) {
				if (cnt == 0) {
					System.err.println("학생 데이터가 존재 하지 않습니다.");
					continue;
				}
				// 삭제 아이디 검색해서 삭제
				boolean check = true;
				int idx = 0;
				while (check) {
					System.out.print("삭제 ID 입력 >>");
					String id = sc.next();
					for (int i = 0; i < cnt; i++) {
						if (stList[i].id.equals(id)) {
							idx = i;
							check = false;
							break;
						}
					}
					if (check) {
						System.err.println("삭제 할 아이디가 존재하지 않습니다.");
					}
				}

				for (int i = idx; i < cnt; i++) {
					if (i != cnt - 1 && i < cnt - 1) {
						stList[i] = stList[i + 1];
					} else if (i == cnt - 1) {
						stList[i] = null;
					}

				}
				cnt--;

			} else if (sel == 3) {
				if (cnt == 0) {
					System.err.println("학생 데이터가 존재 하지 않습니다.");
					continue;
				}
				// 수정 학번으로 검색 => 점수 수정
				int number = 0;
				boolean check = false;
				int idx = 0;
				while (true) {
					System.out.print("점수 수정 할 학번입력>>");
					number = sc.nextInt();
					for (int i = 0; i < cnt; i++) {
						if (stList[i].number == number) {
							idx = i;
							check = true;
							break;
						}
					}
					if (check) {
						break;
					}
					System.err.println("옮바른 학번이 아닙니다.");
				}

				while (true) {
					System.out.println("수정 할 점수 입력( 0~100 ) >>");
					number = sc.nextInt();
					if (stList[idx].score == number) {
						System.err.println("같은 점수 입력불가");
						continue;
					}
					if (number < 0 || number > 100) {
						System.err.println("입력 점수 범위오류");
						continue;
					}
					break;
				}
				stList[idx].score = number;

			} else if (sel == 4) {
				if (cnt == 0) {
					System.err.println("학생 데이터가 존재 하지 않습니다.");
					continue;
				}
				// 검색 -> 이름으로 검색 , 학번 점수 출력 (동명이인 일경우까지 생각)
				int idx =-1;
				while (true) {
					System.out.print("이름을 입력해 주세요>>");
					String name = sc.next();
					for (int i = 0; i < cnt; i++) {
						if(stList[i].name.equals(name)) {
							idx = i;
							break;
						}
					}
					if(idx != -1) {
						for(int i =0; i<cnt ; i++) {
							if(stList[idx].name.equals(stList[i].name)) {
								System.out.printf("학번[%d] 점수[%d]\n", stList[i].number,stList[i].score);
							}
						}
						break;
					}
					System.err.println("등록된 이름이 없습니다.");
				}
				

			} else if (sel == 5) {
				if (cnt == 0) {
					System.err.println("학생 데이터가 존재 하지 않습니다.");
					continue;
				}

			}
		}

	}

}
