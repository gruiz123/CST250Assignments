import java.util.Scanner; 

public class SavingsAccountTest
{
    public static void main(String[] args)
    {
        double startBalance; 
        double annualInterestRate; 
        int months; 
        double depositAmount; 
        double withdrawAmount; 

        Scanner input = new Scanner(System.in); 

        System.out.print("Enter starting balance: $"); 
        startBalance = input.nextDouble(); 

        System.out.print("Enter annual interest rate: "); 
        annualInterestRate = input.nextDouble(); 

        System.out.print("Enter the number of months: ");
        months = input.nextInt(); 

        SavingsAccount sa = new SavingsAccount(startBalance, annualInterestRate); 

        for (int i = 1; i <= months; i++)
        {
            System.out.print("Enter amount to deposit for the month " + i + ":$"); 
            depositAmount = input.nextDouble(); 

            sa.setDeposit(depositAmount); 

            System.out.print("Enter amount to withdraw for the month " + i + ":$"); 
            withdrawAmount = input.nextDouble(); 

            sa.setWithdraw(withdrawAmount); 

            sa.accrueMonthlyInterest();

        }

        displayData(sa); 
    }


    public static void displayData(SavingsAccount sa)
    {
        double balance = Math.round(sa.getBalance() * 100.0) / 100.0; 
        double totalInterest = Math.round(sa.getTotalInterest() * 100.0) / 100.0; 
        System.out.println(); 
        System.out.println("The ending balance is: $" + balance); 
        System.out.println("Total amount of deposits: $" + sa.getTotalDeposits());
        System.out.println("Total amount of withdraws: $" + sa.getTotalWithdraws());
        System.out.println("Total interest earned: $" + totalInterest);
    }
}