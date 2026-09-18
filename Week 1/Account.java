import java.util.Scanner;

class BankAccount {
    String accountHolder, accountType; int accountNumber; double balance;
    BankAccount(String holder, int number, double balance, String type) { accountHolder = holder; accountNumber = number; this.balance = balance; accountType = type; }
    void deposit(double amount) { if (amount > 0) { balance += amount; System.out.println("Amount Deposited: " + amount); } }
    void withdraw(double amount) { if (amount <= 0 || amount > balance) System.out.println("Insufficient Funds!"); else { balance -= amount; System.out.println("Amount Withdrawn: " + amount); } }
    void checkBalance() { System.out.println("Current Balance: " + balance); }
    double calculateInterest(float rate) { return balance * rate / 100; }
    void display() { System.out.printf("Name: %s%nAccount No: %d%nType: %s%nBalance: %.2f%n------------------------%n", accountHolder, accountNumber, accountType, balance); }
}

public class Account {
    static BankAccount find(BankAccount[] accounts, int number) { for (BankAccount a : accounts) if (a.accountNumber == number) return a; return null; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); BankAccount[] accounts = {new BankAccount("Ravi", 101, 1000, "Saving"), new BankAccount("Sita", 102, 2000, "Current")}; int choice;
        do { System.out.println("\n--- Bank Menu ---\n1. Display Accounts\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Calculate Interest\n6. Exit"); System.out.print("Enter choice: "); choice = sc.nextInt();
            if (choice == 1) for (BankAccount a : accounts) a.display();
            else if (choice >= 2 && choice <= 5) { System.out.print("Enter Account Number: "); BankAccount a = find(accounts, sc.nextInt()); if (a == null) { System.out.println("Account not found."); continue; }
                if (choice == 2) { System.out.print("Enter Amount: "); a.deposit(sc.nextDouble()); }
                else if (choice == 3) { System.out.print("Enter Amount: "); a.withdraw(sc.nextDouble()); }
                else if (choice == 4) a.checkBalance();
                else { System.out.print("Enter Interest Rate: "); System.out.println("Interest: " + a.calculateInterest(sc.nextFloat())); }
            } else if (choice == 6) System.out.println("Thank You!"); else System.out.println("Invalid Choice!");
        } while (choice != 6); sc.close();
    }
}
