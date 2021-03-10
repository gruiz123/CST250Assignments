public class BankAccount {

    protected int acctNum;
    protected String name;
    protected double balance;


    public BankAccount() {
        acctNum = 0;
        name = "unknown";
        balance = 0;

    }


    public BankAccount(int aNum, String aName, double amount) {

        acctNum = aNum;
        name = aName;
        balance = amount;
    }


    public void setAcctNum(int aNum) {
        acctNum = aNum;
    }


    public void setName(String aName) {
        name = aName;
    }



    public int getAcctNum() {
        return acctNum;
    }



    public String getName() {
        return name;
    }



    public double getBalance() {
        return balance;
    }


    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }


    public void deposit(double amount) {
        balance += amount;
    }


    public String toString() {
        return "\tName:\t\t" + name + "\n\tAccount Number:\t" + acctNum + "\n\tBalance:\t" + balance;
    }

}