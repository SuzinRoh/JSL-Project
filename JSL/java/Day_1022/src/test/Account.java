package test;

public class Account {
	String accountNo;//계좌번화
	String ownerName;//예그ㅜㅁ주
	int balance;// 잔액
	
	public Account(String no, String name, int money) {
		accountNo = no;
		ownerName = name;
		balance = money;
	}
	void deposit(int amount) {
		balance += amount;
	}
	int withdraw(int amount) {
		if(balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}
}
