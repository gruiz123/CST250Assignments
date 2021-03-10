public class CheckingAccount extends BankAccount {
    private double transactionFee;

    public CheckingAccount()
    {
        super();
        transactionFee = 1.0;
    }


    public double getTransactionFee() {
        return transactionFee;
    }


    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }


    @Override
    public void withdraw(double amount) {
        if (balance >= amount)
        {
            balance -=amount;
            balance-=transactionFee;
        }
        else
            System.out.println("Insufficient funds");
    }


    @Override
    public void deposit(double amount) {
        balance+=amount;
        balance-=transactionFee;
    }

    @Override
    public String toString() {
        return super.toString()+"\nTransaction Fee: "+transactionFee;
    }
}