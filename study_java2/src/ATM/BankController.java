package ATM;

public class BankController {
	
	private ClientDAO clientDAO;
	private AccountDAO accountDAO;
	private Util util;
	
	BankController(){
		clientDAO = new ClientDAO();
		accountDAO = new AccountDAO();
		util = new Util();
	}

	void run() {
		while (true) {
			String main = "[메인 화면]\n" + "[1] 관리자\n" + "[2] 사용자\n" + "[0] 종료";
			System.out.println(main);
			int sel = -1;
			while (sel == -1) {
				sel = util.getSel("[0 ~ 2]매뉴입력", 0, 2);
			}

			if (sel == 1) {
				while(true) {
				String manager = "[관리자 화면]\n" + "[1] 회원목록 - 전체회원 목록\n" + "[2] 회원정보 수정\n" + "[3] 회원정보 삭제\n"
						+ "[4] 회원정보 저장\n" + "[5] 회원정보 불러오기\n" + "[0] 뒤로가기";
				System.out.println(manager);
				int mgSel = -1;
				while (mgSel == -1) {
					mgSel = util.getSel("[0 ~ 5]매뉴입력", 0, 5);
				}

				if (mgSel == 1) {
				}
				if (mgSel == 2) {
				}
				if (mgSel == 3) {
				}
				if (mgSel == 4) {
				}
				if (mgSel == 5) {
				}
				if (mgSel == 0) {
					break;
				}
				}
			}
			if (sel == 2) {
				while(true) {
				String user = "[사용자 화면]\n" + "[1] 회원가입\n" + "[2] 로그인\n" + "[0] 뒤로가기";
				System.out.println(user);
				int usSel = -1;
				while (usSel == -1) {
					usSel = util.getSel("[0 ~ 2]매뉴입력", 0, 2);
				}
				if (usSel == 1) {
				}
				if (usSel == 2) {
					while(true) {
					String loginSucess = "[로그인 성공]\n" + "[1] 계좌 추가\n" + "[2] 계좌 삭제\n" + "[3] 입금\n" + "[4] 출금\n"
							+ "[5] 이체\n" + "[6] 탈퇴\n" + "[7] 마이페이지: 전체 계좌, 금액 (회원정보: 비밀번호 수정)\n" + "[0] 뒤로가기";
					System.out.println(loginSucess);

					int logSel = -1;
					while (logSel == -1) {
						logSel = util.getSel("[0 ~ 7]매뉴입력", 0, 7);
					}

					if (logSel == 1) {
					}
					if (logSel == 2) {
					}
					if (logSel == 3) {
					}
					if (logSel == 4) {
					}
					if (logSel == 5) {
					}
					if (logSel == 6) {
					}
					if (logSel == 7) {
					}
					if (logSel == 0) {
						break;
					}
					}
				}
				if (usSel == 0) {
					break;
				}
			}
		}
			if (sel == 0) {
				System.out.println("[종료 되었습니다.]");
				break;
			}
		}

	}

}
