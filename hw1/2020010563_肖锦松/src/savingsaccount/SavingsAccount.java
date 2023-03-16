package savingsaccount;

public class SavingsAccount {
    static double annualInterestRate = 0.06; // 存款年利率
    private double savingsBalance; // 用户余额

    SavingsAccount(int balance) {
        this.savingsBalance = balance;
    }

    public double calculateMonthlyInterest() {
        double interest = (this.savingsBalance * SavingsAccount.annualInterestRate) / 12;
        this.savingsBalance += interest;
        return interest;
    }

    public void modifyInterestRate(double new_rate) {
        SavingsAccount.annualInterestRate = new_rate;
    }

}
