import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        while (!exit) {
            System.out.println("""
                        1. Create a new account

                        2. Deposit money

                        3. Withdraw money

                        4. Display account details

                        5. Exit
                    """);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("What is your name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Create an account number");
                    int accountNumber = sc.nextInt();
                    System.out.println("What is your initial deposit");
                    double balance = sc.nextDouble();
                    BankAccount user = new BankAccount(accountNumber, name, balance);
                    accounts.add(user);
                    break;
                case 2:
                    if (accounts.size() > 0) {
                        System.out.println("What account number would you like to deposit money?");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println("Account number:" + (i + 1));
                            System.out.println(accounts.get(i).toString());
                            System.out.println();
                        }

                        int number = sc.nextInt();
                        System.out.println("How much do you want to deposit");
                        double amount = sc.nextDouble();
                        accounts.get(number - 1).deposit(amount);
                    } else {
                        System.out.println("You have no accounts to deposit money");
                    }

                    break;
                case 3:
                    if (accounts.size() > 0) {
                        System.out.println(
                                "What account number would you like to withdraw from to?(Select the index number)");
                        for (int i = 0; i < accounts.size(); i++) {
                            System.out.println("Account number:" + (i + 1));
                            System.out.println(accounts.get(i).toString());
                        }
                        int number = sc.nextInt();
                        System.out.println("How much do you want to withdraw");
                        double amount = sc.nextDouble();
                        accounts.get(number - 1).withdraw(amount);
                    } else {
                        System.out.println("You have no accounts to withdraw money from");
                    }

                    break;
                case 4:
                    System.out.print("Details for account number: ");
                    int number = sc.nextInt();
                    System.out.println(accounts.get(number - 1).toString());
                    break;

                case 5:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
