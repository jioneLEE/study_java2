package ATM;

import java.util.ArrayList;

public class ClientDAO {
	
	private int num;
	
	static ArrayList<Client> clientList = new ArrayList<>();
	
	static boolean anyMembers() {
		if(clientList.size() == 0) {System.out.println("[에러:회원이 존재하지않습니다.]");return false;}
		return true;
	}

	private String checkId(String id) {
		int cnt =0;
		for(int i=0; i<id.length(); i++) {
			if(id.charAt(i) >'0' && id.charAt(i) <'9') {
				cnt++;
			}
			
		}
		if(cnt == id.length()) {
			System.out.println("[에러:숫자만으로 아이디 생성 불가]");
			return id = null;
		}
		
		for(int i =0; i<clientList.size(); i++) {
			if(clientList.get(i).getId().equals(id)) {
				System.out.println("[에러:중복아이디가 있습니다.]");
				return id = null;	
			}
		}
		
		
		return id;
	}
	
	private String checkName(String name) {
		int cnt =0;
		for(int i=0; i<name.length(); i++) {
			if(name.charAt(i) >'0' && name.charAt(i) <'9') {
				cnt++;
			}
		}
		if(cnt != 0) {
			System.out.println("[에러: 이름에 숫자가 포함되어있습니다.]");
			return name = null;
		}
		
		
		return name;
	}
	
	public void membershipRegistration() {
		String id = null;
		while(id == null) {
			
			id = Util.getStringValue("아이디를 입력하세요 >>");
			id = checkId(id);
		}
		String pw = null;
		while(pw == null) {
			pw = Util.getStringValue("패스워드를 입력하세요>>");
		}
		
		String name = null;
		while(name == null) {
			name = Util.getStringValue("이름을 입력하세요>>");
			name = checkName(name);
		}
		
		num++;
		
		clientList.add(new Client(num,id, pw, name));
		System.out.println(id+"/"+pw+"/"+name+" [생성완료]");
	}
	
	private int ClientNo(String id) {
		int No = -1;
		for(int i =0; i<clientList.size(); i++) {
			if(clientList.get(i).getId().equals(id)) {
				No = i;
			}
		}
		return No;
	}
	
	public Client CheckLogin() {
		int idx = -1;
		boolean idCheck = false;
		boolean pwCheck = false;
		String id = Util.getStringValue("[login] ID 입력>>");
		String pw = Util.getStringValue("[login] PW 입력>>");
		
		for(int i =0; i<clientList.size(); i++) {
			if(clientList.get(i).getId().equals(id)) {
				idCheck = true;
			}
			if(clientList.get(i).getPw().equals(pw)) {
				pwCheck = true;
			}
		}
		
		if(idCheck && pwCheck) {
		System.out.println("[Login Sucess]");
		idx = ClientNo(id);
		
		return clientList.get(idx);
		}
		System.out.println("[Login Failed]");
		return null;
		
	}
	
	
}
