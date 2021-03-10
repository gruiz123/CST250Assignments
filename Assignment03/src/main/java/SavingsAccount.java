public class SavingsAccount 
    
{
    private double balance;
    private double annualInterestRate;
    private double totalDeposits;
    private double totalWithdraws;
    private double totalInterest;

    
    public SavingsAccount(double startBalance, double annualInterestRate)
    {
        balance = startBalance;
        this.annualInterestRate = annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate; 
    }


    public void deposit(double amount)
    {
        balance += amount; 
        totalDeposits += amount; 
    }


    public void withdraw(double amount)
    {
        balance -= amount; 
        totalWithdraws += amount; 
    }


    public void accrueMonthlyInterest()
    {
        double monthlyInterest = balance * getMonthlyInterestRate();
        totalInterest += monthlyInterest; 
        balance += monthlyInterest; 
    }

    public double getBalance()
    {
        return balance; 
    }


    public double getAnnualInterestRate()
    {
        return annualInterestRate; 
    }


    public double getMonthlyInterestRate()
    {
        return annualInterestRate / 12; 
    }


    public double getTotalDeposits()
    {
        return totalDeposits; 
    }


    public double getTotalWithdraws()
    {
        return totalWithdraws; 
    }


    public double getTotalnterest()
    {
        return totalInterest; 
    }

    void setDeposit(double depositAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setWithdraw(double withdrawAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    double getTotalInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
