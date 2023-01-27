package ATM;

public class Client {
	private int clientNo = 1000;
	private String id;
	private String pw;
	private String name;
	
	public Client(int num, String id, String pw, String name) {
		super();
//		this.clientNo = clientNo;
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
		setClientNo(num);
		setId(id);
		setPw(pw);
		setName(name);
		
	}
	
	public int getClientNo() {
		return clientNo;
	}
	private void setClientNo(int num) {
		this.clientNo += num;
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
		return clientNo + "/" + id + "/" + pw + "/" + name ;
	}
	
	
}
