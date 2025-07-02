package AccountOfStudent;
import java.util.Scanner;

public class AccountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account currentAccount = null;

        while (true) {
            System.out.println("\nWelcome to the Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter your PIN: ");
                    int PIN = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    currentAccount = new Account(name, email, password, phoneNumber, PIN);
                    System.out.println("Account created successfully for " + currentAccount.getName());
                }

                case 2 -> {
                    if (currentAccount == null) {
                        System.out.println("No account exists. Please create an account first.");
                        break;
                    }

                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    if (currentAccount.logIn(loginEmail, loginPassword)) {
                        System.out.println("Login successful for " + currentAccount.getName());
                        userMenu(currentAccount, scanner);
                    } else {
                        System.out.println("Login failed. Invalid email or password.");
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void userMenu(Account acc, Scanner scanner) {
        while (true) {
            System.out.println("\nWelcome, " + acc.getName());
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Log Out");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    acc.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    acc.withdraw(amount);
                }
                case 3 -> acc.checkBalance();
                case 4 -> {
                    acc.logOut();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
