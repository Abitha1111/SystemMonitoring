package console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ATM {
	private double balance;
	private String pin;

	public ATM(double balance, String pin) {
		this.balance = balance;
		this.pin = pin;
	}

	public double checkBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("---------------------------------------------");
			System.out.println("Deposit successful...New balance: " + balance);
			System.out.println("---------------------------------------------");
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("---------------------------------------------");
			System.out.println("Withdraw successful...New balance: " + balance);
			System.out.println("---------------------------------------------");
		} else {
			System.out.println("invalid amount.");
		}
	}

	public void changePin(String oldPin, String newPin) {
		if (pin.equals(oldPin)) {
			pin = newPin;
			System.out.println("---------------------------");
			System.out.println("PIN changed successfully.");
			System.out.println("---------------------------");
		} else {
			System.out.println("Invalid old PIN.");
		}
	}
}

public class ATMSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double initialBalance = 1000;
		String initialPin = "1234";

		ATM atm = new ATM(initialBalance, initialPin);

		System.out.println("---Welcome to the ATM---");
		System.out.print("Enter your PIN: ");
		String enteredPin = scanner.nextLine();

		if (!enteredPin.equals(initialPin)) {
			System.out.println("Invalid PIN...");
			return;
		}

		boolean atmActive = true;
		List<String> transactionHistory = new ArrayList<>();

		while (atmActive) {

			System.out.println("\n1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Change PIN");
			System.out.println("5. Transfer Funds");
			System.out.println("6. Transaction History");
			System.out.println("0. Exit");
			System.out.print("Enter your choice:\n ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("-------------------------");
				System.out.println("Your balance is: " + atm.checkBalance());
				System.out.println("-------------------------");
				break;
			case 2:
				System.out.print("Enter deposit amount: ");
				double depositAmount = scanner.nextDouble();
				scanner.nextLine();
				atm.deposit(depositAmount);
				addToTransactionHistory(transactionHistory, "Deposit $" + depositAmount);
				break;
			case 3:
				System.out.print("Enter withdraw amount: ");
				double withdrawalAmount = scanner.nextDouble();
				scanner.nextLine();
				atm.withdraw(withdrawalAmount);
				addToTransactionHistory(transactionHistory, "Withdraw $" + withdrawalAmount);
				break;
			case 4:
				System.out.print("Enter your current PIN: ");
				String currentPin = scanner.nextLine();

				if (!currentPin.equals(initialPin)) {
					System.out.println("Invalid PIN. PIN change failed.");
					break;
				}

				System.out.print("Enter your new PIN: ");
				String newPin = scanner.nextLine();

				System.out.print("Confirm your new PIN: ");
				String confirmNewPin = scanner.nextLine();

				if (!newPin.equals(confirmNewPin)) {
					System.out.println("PIN change failed...");
					break;
				}

				atm.changePin(currentPin, newPin);
				initialPin = newPin;
				break;

			case 5:
				System.out.print("Enter recipient's account number: ");
				String recipientAccount = scanner.nextLine();

				System.out.print("Enter amount to transfer: ");
				double transferAmount = scanner.nextDouble();
				scanner.nextLine();

				if (transferAmount <= 0 || transferAmount > atm.checkBalance()) {
					System.out.println("Invalid transfer amount or insufficient funds.");
					break;
				}
				atm.withdraw(transferAmount);
				System.out
						.println("Transfer of " + transferAmount + " to account " + recipientAccount + " successful.");
				addToTransactionHistory(transactionHistory,
						"Transfer $" + transferAmount + " to Account " + recipientAccount);

				break;

			case 6:

				System.out.println("Transaction History:");
				if (transactionHistory.isEmpty()) {
					System.out.println("No transactions yet.");
				} else {
					for (String transaction : transactionHistory) {
						System.out.println("-------------------------");
						System.out.println("- " + transaction);

					}
					System.out.println("---------------------------");
				}

				break;
			case 0:
				System.out.println("Thank you for using the ATM!");
				atmActive = false;
				break;

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	private static void addToTransactionHistory(List<String> transactionHistory, String transaction) {
		if (transactionHistory.size() >= 10) {
			transactionHistory.remove(0);
		}
		transactionHistory.add(transaction);
	}

}