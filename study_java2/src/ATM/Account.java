package ATM;

public class Account {
	private int clientNo;
	private String accountNumber;
	private int money;
	
	public Account(int clientNo, String accountNumber, int money) {
		super();
//		this.clientNo = clientNo;
//		this.accountNumber = accountNumber;
//		this.money = money;
		
		setClientNo(clientNo);
		setAccountNumber(accountNumber);
		setMoney(money);
		
	}
	
	public int getClientNo() {
		return clientNo;
	}
	private void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	private void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return clientNo + "/" + accountNumber + "/" + money;
	}
	
	
}
