import java.util.Scanner;

class BankAccount {
    // Attributes
    String accountHolder;
    int accountNumber;
    double balance;
    String accountType;

    // Parameterized Constructor
    BankAccount(String name, int accNo, double bal, String type) {
        accountHolder = name;
        accountNumber = accNo;
        balance = bal;
        accountType = type;
    }

    // Deposit
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
            return;
        }
        balance = balance + amount;
        System.out.println("Amount Deposited: " + amount);
        checkBalance();
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient Funds!");
        } else {
            balance = balance - amount;
            System.out.println("Amount Withdrawn: " + amount);
            checkBalance();
        }
    }

    // Check Balance
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Calculate Interest
    double calculateInterest(float rate) {
        return (balance * rate) / 100;
    }

    // Display Account Details
    void display() {
        System.out.println("Name: " + accountHolder);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("------------------------");
    }
}

public class Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create multiple accounts
        BankAccount[] acc = new BankAccount[2];
        acc[0] = new BankAccount("Ravi", 101, 1000, "Saving");
        acc[1] = new BankAccount("Sita", 102, 2000, "Current");

        int choice;

        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Display Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int accNo;
            double amount;
            float rate;

            switch (choice) {

                case 1:
                    for (int i = 0; i < acc.length; i++) {
                        acc[i].display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();

                    boolean depositFound = false;
                    for (int i = 0; i < acc.length; i++) {
                        if (acc[i].accountNumber == accNo) {
                            acc[i].deposit(amount);
                            depositFound = true;
                        }
                    }
                    if (!depositFound) System.out.println("Account not found!");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();

                    boolean withdrawFound = false;
                    for (int i = 0; i < acc.length; i++) {
                        if (acc[i].accountNumber == accNo) {
                            acc[i].withdraw(amount);
                            withdrawFound = true;
                        }
                    }
                    if (!withdrawFound) System.out.println("Account not found!");
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    boolean balanceFound = false;
                    for (int i = 0; i < acc.length; i++) {
                        if (acc[i].accountNumber == accNo) {
                            acc[i].checkBalance();
                            balanceFound = true;
                        }
                    }
                    if (!balanceFound) System.out.println("Account not found!");
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    System.out.print("Enter Interest Rate: ");
                    rate = sc.nextFloat();

                    boolean interestFound = false;
                    for (int i = 0; i < acc.length; i++) {
                        if (acc[i].accountNumber == accNo) {
                            double interest = acc[i].calculateInterest(rate);
                            System.out.println("Interest: " + interest);
                            interestFound = true;
                        }
                    }
                    if (!interestFound) System.out.println("Account not found!");
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
