package ATM;

public class Client {
	int clientNo;
	String id;
	String pw;
	String name;
	
	public Client(int clientNo, String id, String pw, String name) {
		super();
//		this.clientNo = clientNo;
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
		setClientNo(clientNo);
		setId(id);
		setPw(pw);
		setName(name);
		
	}
	
	public int getClientNo() {
		return clientNo;
	}
	private void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}
	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	private void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return clientNo + "  " + id + "  " + pw + "  " + name ;
	}
	
	
}
