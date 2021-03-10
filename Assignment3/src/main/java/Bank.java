import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        CheckingAccount checkingAccount = new CheckingAccount();

        int choice = 0;
        int iValue = 0;
        String name = "unknown";
        Scanner scan = new Scanner(System.in);

        do {
            displayMenu();
            choice = scan.nextInt();
            System.out.println();
            switch (choice)
            {
                case 1 : System.out.print( "Deposit amount. " );
                    checkingAccount.deposit(getValidData());
                    break;
                case 2 : System.out.print( "Withdraw amount. "); ;
                    checkingAccount.withdraw(getValidData());
                    break;
                case 3 : System.out.print( "Enter the name: ");
                    scan.nextLine(); 
                    name= scan.nextLine();
                    checkingAccount.setName(name);
                    break;
                case 4 : System.out.print( "Account number. ") ;
                    checkingAccount.setAcctNum( (int)(getValidData( )) );
                    break;
                case 5: System.out.print("Enter transaction fee: ");
                        checkingAccount.setTransactionFee(getValidData());
                    break;
                case 6 : System.out.println(checkingAccount.toString());
                    break;
                case 7 : System.out.println( "\nBank is closed.\n") ;
                    break;
                default : System.out.println( "Invalid entry.");
            }

        }while (choice != 7);



    }
    public static void displayMenu()
    {
        System.out.println( "\n Welcome to your bank \n");
        System.out.println( "1. Make a deposit");
        System.out.println( "2. Make a withdrawal");
        System.out.println( "3. Set the account name");
        System.out.println( "4. Set the account number");
        System.out.println( "5.Set the transaction Fee");
        System.out.println( "6. Display account information");
        System.out.println( "7. Exit");
        System.out.print( "Please enter your choice: ");
    }



    public static double getValidData()
    {
        double amount = 0;
        Scanner scan = new Scanner (System.in);
        System.out.print( "Enter value: " );
        amount = scan.nextDouble();
        while (amount < 0 )
        {
            System.out.print( "Enter value: (0 or greater): " );
            amount = scan.nextDouble();
        }
        return amount;
    }


}