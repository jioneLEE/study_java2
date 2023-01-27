package ATM;

import java.util.ArrayList;
import java.util.Random;

public class AccountDAO {
	private Random rd = new Random();
	
	static ArrayList<Account> accountList = new ArrayList<>();
	
	private boolean	haveNoAcc(Client c) {
		for(int i =0; i<accountList.size(); i++) {
			if(accountList.get(i).getClientNo() == c.getClientNo()) {
				return true;
			}
		}
		System.out.printf("[에러:%s님이 계좌를 가지고있지않습니다.]\n",c.getId());
		return false;
	}
	
	private String generateAcc() {
		String acc = "";
		for(int i =0; i<3; i++) {
			for(int k = 0; k<4; k++) {
				int rdNum = rd.nextInt(10);
				acc += rdNum+"";
			}
			if(i!=2) {
				acc+= "-";
			}
			
		}
		for(int i =0; i<accountList.size(); i++) {
			if(accountList.get(i).getAccountNumber().equals(acc)) {
				return acc = null;
			}
		}
		return acc;
	}
	
	public void addAccount(Client c) {
		String id = c.getId();
		String acc = null;
		while (acc == null) {
			acc = generateAcc();
		}
		int money = 1000;
		
		accountList.add(new Account(c.getClientNo(), acc, money));
		System.out.println(c.getClientNo()+"/"+acc+"/"+money+"--- 계좌생성 완료");
		
	}
	
	private boolean checkAcc(String acc ,Client c,String Acc) {
		boolean check1 = false;
		boolean check2 = false;
		if (Acc == "my") {
			for (int i = 0; i < accountList.size(); i++) {
				if (accountList.get(i).getAccountNumber().equals(acc)) {
					return true;
				}
			}

		}

		else if (Acc == "you") {
			for (int i = 0; i < accountList.size(); i++) {
				if (accountList.get(i).getAccountNumber().equals(acc)) {
					check1 = true;
				}
				if (c.getClientNo() != accountList.get(i).getClientNo()) {
					check2 = true;
				}
			}
		}
		if(check1&&check2) {return true;}
		System.out.println("[에러: 잘못된 계좌번호입니다.]");
		return false;
		
	}
	
	private boolean checkPw(String pw, Client c) {
		if(c.getPw().equals(pw)) {
			return true;	
		}
		System.out.println("에러: 잘못된 비밀번호입니다.");
		return false;
	}
	
	private int findaccIdx(String acc) {
		int idx = -1;
		for(int i =0; i<accountList.size(); i++) {
			if(accountList.get(i).getAccountNumber().equals(acc)) {
				return idx = i;
			}
		}
		return idx;
	}
	
	public void delAccount(Client c) {
		if(!haveNoAcc(c)) {return;}
		String delAcc = null;
		while (true) {
			delAcc = Util.getStringValue("삭제할 계좌번호를 입력하세요>>");
			if(checkAcc(delAcc, c,"my")) {break;}
		}
		while(true) {
			String delPw = Util.getStringValue("삭제할 패스워드를 입력하세요>>");
			if(checkPw(delPw, c)) {break;}
		}
		int idx = findaccIdx(delAcc);
		System.out.println(accountList.get(idx)+"-- [계좌가 삭제되었습니다.]");
		accountList.remove(idx);
		
	}
	
	public void deposit(Client c) {
		if(!haveNoAcc(c)) {return;}
		String choiceAcc = null;
		String youAcc = null;
		while (true) {
			choiceAcc = Util.getStringValue("본인의 계좌번호 입력 >>");
			if(checkAcc(choiceAcc, c,"my")) {break;}
		}
		
		while(true) {
			youAcc = Util.getStringValue("이체 계좌번호 입력 >>");
			if(checkAcc(choiceAcc, c,"you")) {break;}
		}
		int money = -1;
		while(money == -1){
		money = Util.getSel("이체금액입력>>[1,000 - 1,000,000]", 1000, 1000000);
		}
		
		
	}

	public void withdrawal(Client c) {
		if(!haveNoAcc(c)) {return;}
	}

	private boolean checkMoney(String choiceAcc, int money) {
		int idx = findaccIdx(choiceAcc);
		if(accountList.get(idx).getMoney() >= money) {
			return true;
		}
		System.out.println("[에러: 금액의 범위가 초과하였습니다.]");
		return false;
	}
	
	public void transfer(Client c) {
		if(!haveNoAcc(c)) {return;}

		String choiceAcc = null;
		String youAcc = null;
		int money = 0;
		int idx =0;
		while (true) {
			choiceAcc = Util.getStringValue("본인의 계좌번호 입력 (0 : 종료) >>");
			if(choiceAcc.equals("0")) {return;}
			idx = findaccIdx(choiceAcc);
			if (checkAcc(choiceAcc, c, "my")) {
				if(accountList.get(idx).getMoney() < 1000) {
					System.out.println("[에러 : 이체금액이 부족합니다.]");
					return;
				}
				break;
			}
		}

		while (true) {
			youAcc = Util.getStringValue("이체 계좌번호 입력 (0 : 종료) >>");
			if(youAcc.equals("0")) {return;}
			if (checkAcc(choiceAcc, c, "you")) {
				break;
			}
		}
		
		while (true) {
			money = Util.getSel("이체금액입력>>[1,000 - 1,000,000](0 : 종료)", 1000, 1000000);
			if(money == 0) {return;}
			if(checkMoney(choiceAcc, money)){ break;}
		}
		
		int choiceIdx = findaccIdx(choiceAcc);
		int youIdx = findaccIdx(youAcc);
		accountList.get(choiceIdx).setMoney(accountList.get(choiceIdx).getMoney()-money);
		
		
		
	}
	public void dropOut(Client c) {
		if(!haveNoAcc(c)) {return;}
	}
	public void myPage(Client c) {
		if(!haveNoAcc(c)) {return;}
	}

}
