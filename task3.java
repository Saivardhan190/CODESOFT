import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {
        bankaccount myAccount = new bankaccount();

        Scanner opt = new Scanner(System.in);

        while (true) { // Keep the ATM running until the user chooses to exit
            System.out.println("\nATM Machine");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check bank balance");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");

            int n = opt.nextInt();

            switch (n) {
                case 1 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = opt.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= myAccount.getBalance()) {
                        myAccount.withdraw(withdrawAmount);
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Invalid withdrawal amount or insufficient balance.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = opt.nextDouble();
                    if (depositAmount > 0) {
                        myAccount.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                }
                case 3 -> myAccount.checkBalance();
                case 4 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    opt.close();
                    return; // Exit the program
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class bankaccount {
    private double account_balance = 0;

    public void withdraw(double amount) {
        if (amount > account_balance) {
            System.out.println("Insufficient balance.");
        } else {
            account_balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("New balance: " + account_balance);
        }
    }

    public void deposit(double amount) {
        account_balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New balance: " + account_balance);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account_balance);
    }

    public double getBalance() {
        return account_balance;
    }
}
