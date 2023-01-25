package 메서드2_문제연습;

import java.util.Scanner;

class User {
	String id;
	String pw;
	int money;

	void printInfo() {
		System.out.printf("%s \t %s \t %d원 \t \n", id, pw, money);
	}
}

class UserDAO {
	User list[];
	int cnt;
	int log = -1;

	void init() {
		User u1 = new User();
		u1.id = "aaaa";
		u1.pw = "1234";
		u1.money = 10000;
		User u2 = new User();
		u2.id = "bbbb";
		u2.pw = "1234";
		u2.money = 10000;
		User u3 = new User();
		u3.id = "cccc";
		u3.pw = "1234";
		u3.money = 10000;
		User u4 = new User();
		u4.id = "dddd";
		u4.pw = "1234";
		u4.money = 10000;
		User[] temp = { u1, u2, u3, u4 };
		list = temp;
	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " > ");
		int val = sc.nextInt();
		if (val < start || val > end) {
			System.out.printf("%s 값은 %d - %d \n", msg, start, end);
			return -1;
		}
		return val;
	}

	String getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + " > ");
		return sc.next();
	}

	void printMenu() {
		System.out.println("0.종료");
		if (log == -1) {
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.전체 회원 목록");
			return;
		}
		System.out.println("1.탈퇴(비번 일치시 탈퇴)");
		System.out.println("2.수정(금액 수정)");
		System.out.println("3.로그아웃");
	}

	boolean isValidId(String id) {
		int idx = 0;
		for (User u : list) {
			if (u == null)
				return true;
			if (u.id.equals(id)) {
				log = idx;
				return false;
			}
			idx++;
		}
		return true;
	}

	void addUser() {
		System.out.println("[ 회원 가입 ]");
		// if(cnt == 0)
		if (list == null) {
			list = new User[1];
		} else {
			User[] temp = list;
			list = new User[cnt + 1];
			for (int i = 0; i < cnt; i++) {
				list[i] = temp[i];
			}

		}
		User u = new User();
		String id = getValue("아이디 ");
		if (!isValidId(id)) {
			System.out.println("이미 존재하는 아이디 입니다");
			return;
		}
		u.id = id;
		u.pw = getValue("비밀번호 ");
		while (true) {
			int money = getValue("충전 금액 ", 1000, 1000000);
			if (money == -1) {
				continue;
			}
			u.money = money;
			break;
		}
		u.printInfo();

		list[cnt] = u;
		// printAllUser();

		System.out.println(" [ 회원가입 완료 ] ");
	}

	void logIn() {

		System.out.println(" [ 로그인 ] ");

		String id = getValue("아이디 ");
		if (isValidId(id)) {
			System.out.println("존재 하지 않는 아이디 입니다");
		} else {
			String pw = getValue("비밀번호 ");
			if (list[log].pw.equals(pw)) {
				System.out.println("[ 로그인 성공 ]");
				return;
			}

			System.out.println("비밀번호 불일치");
			log = -1;
		}

		if (log == -1) {
			System.out.println("로그인 실패");
		}

	}

	void printAllUser() {
		System.out.println("-----------------------");
		System.out.println(" [ 전체 회원 목록 ] ");
		for (User u : list) {
			u.printInfo();
		}
		System.out.println();
	}

	void deleteUser() {
		System.out.printf(" [ %s 회원 탈퇴 ]\n ", list[log].id);
		String pw = getValue("비밀번호 ");
		if (!list[log].pw.equals(pw)) {
			System.out.println("비밀번호 불일치 ");
			return;
		}

		if (cnt == 1) {
			list = null;
		} else {
			User[] temp = list;
			list = new User[cnt - 1];
			int idx = 0;
			for (int i = 0; i < cnt; i++) {
				if (i != log) {
					list[idx] = temp[i];
					idx++;
				}
			}
		}
		System.out.println("[ 회원 삭제 성공 ]");
		log = -1;
	}

	void modifyUser() {
		int money = getValue("수정할 금액 ", 1000, 10000);
		if (money == -1) {
			return;
		}
		if (money == list[log].money) {
			System.out.println("기존 금액과 다른 금액을 입력하세요");
			return;
		}
		list[log].money = money;
		System.out.printf("[ 회원 %s 의 금액 수정 : %d 원] \n", list[log].id, money);
	}

	void run() {
		init();
		while (true) {
			printMenu();
			cnt = list.length;
			int sel = getValue("메뉴 번호", 0, 3);
			if (sel == -1) {
				continue;
			} else if (sel == 0) {
				System.out.println("프로그램 종료");
				return;
			}
			if (log == -1) {
				if (sel == 1) {
					addUser();
				} else if (sel == 2 && cnt != 0) {
					logIn();
				} else if (sel == 3 && cnt != 0) {
					printAllUser();
				} else {
					System.out.println(" 데이터 없음 ");
				}
			} else {
				if (sel == 1) {
					deleteUser();
				} else if (sel == 2) {
					modifyUser();
				} else if (sel == 3) {
					System.out.println("[ 로그아웃 완료 ]");
					log = -1;
				}
			}
		}
	}
}

public class 클배문제10_회원관리 {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		dao.run();
	}

}