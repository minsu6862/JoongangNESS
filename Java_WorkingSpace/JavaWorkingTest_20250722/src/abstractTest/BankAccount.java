package abstractTest;

public class BankAccount {
	
	private double balance;
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("음수는 허용하지 않습니다");
        }
    }
}
