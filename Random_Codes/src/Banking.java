class BankAccount{
	private String accountNumber;
	private String accountHoldersName;
	private double balance;
	
	public BankAccount(String accountNumber, String accountHoldersName, double balance) {
		this.accountNumber=accountNumber;
		this.accountHoldersName=accountHoldersName;
		this.balance=balance;
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited: $"+amount);
		}
		else {
			System.out.println("Deposit amount must be positive");
		}
	}
	public void withdraw(double amount) {
		if(amount>0) {
			if(balance>=amount) {
				balance-=amount;
				System.out.println("Withdrawn amount: $"+amount);
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		else {
			System.out.println("Withdrawl amount must be positive");
		}
	}
	public void checkbalance() {
		System.out.println("Account Balance: $"+balance);
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getAccountHoldersName() {
		return accountHoldersName;
	}
	public double getbalance() {
		return balance;
	}
}

 class SavingsAccount extends BankAccount{
	private double interestRate;
	
	public SavingsAccount(String AccountNumber, String AccountHoldersName, double balance, double interestRate) {
		super(AccountNumber, AccountHoldersName, balance );
		this.interestRate=interestRate;
	}
	
	public void applyInterest() {
		double interest = getbalance()*interestRate/100;
		deposit(interest);
		System.out.println("Interest Applied: $"+interest);
	}
	public double getInterestRate() {
		return interestRate;
	}
}

public class Banking {
   public static void main(String[]args) {
	   BankAccount acc1 = new BankAccount("1236547896", "Utkarsh Arora", 1000000);
	   acc1.checkbalance();
	   acc1.deposit(500);
	   acc1.withdraw(200);
	   acc1.checkbalance();
	   
	   System.out.println();
	   
	   SavingsAccount sa1 = new SavingsAccount("1478523698","Sarthak Arora", 1200, 2.5);
	   sa1.checkbalance();
	   sa1.applyInterest();
	   sa1.checkbalance();
	   sa1.withdraw(100);
	   sa1.checkbalance();
	   
   } 
}
