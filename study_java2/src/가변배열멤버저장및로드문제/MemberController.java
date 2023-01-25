package 가변배열멤버저장및로드문제;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberController {
	MemberDAO memberDAO;

	MemberController() {
		memberDAO = new MemberDAO();
	}

	int getValue(String msg, int start, int end) {
		// 예외처리 적용해보세요 : 숫자 아닌값, 숫자 범위 오류
		Scanner sc = new Scanner(System.in);
		System.out.println(msg + "["+start +"~"+ +end+ "] 입력" +  ">" );
		int num = -1;
			try {
				num = sc.nextInt();
				if (num < start || num > end) {
//			Exception e = new Exception("입력범위 에러");
//			throw e;
					throw new Exception("[err 범위 오류]");
				}
				
			} catch (InputMismatchException e) {
//			e.printStackTrace();
				System.out.println("[err 숫자만 입력가능]");
			} catch (Exception e) {
//			e.printStackTrace();
				num = -1;
				System.out.println(e.getMessage());
			}
		return num;
	}

	void mainMenu() {
		
		while (true) {
			System.out.println("[1]추가");
			System.out.println("[2]수정");
			System.out.println("[3]삭제");
			System.out.println("[4]전체출력");
			System.out.println("[5]파일저장");
			System.out.println("[6]파일로드");
			System.out.println("[0]종료");

			int sel = -1;
			while(sel == -1) {
			sel = getValue("메뉴 ", 0, 6);
			}
			if (sel == 0) {
				System.out.println("종료되었습니다.");
				break;
			} else if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.update();
			} else if (sel == 3) {
				memberDAO.remove();
			} else if (sel == 4) {
				memberDAO.printMember();
			} else if (sel == 5) {
				memberDAO.saveData();
			} else if (sel == 6) {
				memberDAO.loadData();
			}
		}

	}
}