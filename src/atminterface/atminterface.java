package atminterface;

import java.util.Scanner;

class BankAccount {
 private double balance;
 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }
 public double getBalance() {
     return balance;
 }
 
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit successful. New balance: " + balance);
     } else {
         System.out.println("Invalid deposit amount. Please enter a positive value.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful. New balance: " + balance);
     } else if (amount <= 0) {
         System.out.println("Invalid withdrawal amount. Please enter a positive value.");
     } else {
         System.out.println("Insufficient funds. Withdrawal unsuccessful.");
     }
 }
}

class ATM {
 private BankAccount bankAccount;
 private Scanner scanner;

 public ATM(BankAccount bankAccount, Scanner scanner) {
     this.bankAccount = bankAccount;
     this.scanner = scanner;
 }
 public void displayMenu() {
     System.out.println("ATM Menu:");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
     System.out.println("3. Withdraw");
     System.out.println("4. Exit");
 }
 public void performTransaction(int option) {
     switch (option) {
         case 1:
             System.out.println("Current Balance: " + bankAccount.getBalance());
             break;

         case 2:
             System.out.println("Enter deposit amount:");
             double depositAmount = scanner.nextDouble();
             bankAccount.deposit(depositAmount);
             break;

         case 3:
             System.out.println("Enter withdrawal amount:");
             double withdrawalAmount = scanner.nextDouble();
             bankAccount.withdraw(withdrawalAmount);
             break;

         case 4:
             System.out.println("Exiting. Thank you!");
             System.exit(0);
             break;

         default:
             System.out.println("Invalid option. Please choose a valid option.");
     }
  }
}
public class  atminterface{
 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(1000);
     Scanner scanner = new Scanner(System.in);
     ATM atmMachine = new ATM(userAccount, scanner);
     while (true) {
         atmMachine.displayMenu();
         System.out.println("Enter your choice (1-4):");
         int userOption = scanner.nextInt();
         atmMachine.performTransaction(userOption);
     }
   }
}
