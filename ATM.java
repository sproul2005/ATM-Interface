
import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATM(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean authenticate(String enteredAccountNumber, String enteredPin) {
        return accountNumber.equals(enteredAccountNumber) && pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM("235689235689", "8520", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter account number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (atm.authenticate(enteredAccountNumber, enteredPin)) {
            System.out.println("Authentication successful");
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting.");
        }
    }
}
