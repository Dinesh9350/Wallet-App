import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Wallet bankAccount = new Wallet();
		bankAccount.showMenu();
	}
}

class Wallet{
	private int balance;
	private int previousTransaction;
	

	

	public void deposit(int amount){
		if (amount != 0) {
			this.balance += amount;
			this.previousTransaction = amount;
		}
	}

	public void withDraw(int amount){
		if(amount != 0){
			this.balance -= amount;
			this.previousTransaction = -amount;
		}
	}

	public void getPreviousTransaction(){
		if(this.previousTransaction > 0){
			System.out.println("Deposited: " + this.previousTransaction);
		}else if(this.previousTransaction < 0){
			System.out.println("WithDrawed: " + this.previousTransaction);
		}else{
			System.out.println("No Transaction occured");
		}
	}

	public void showMenu(){
		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("!!!Please use Capital Letters only in Option, if an error occured then please Compile Again!!! ");
		System.out.println("Enter an option in below:");
		System.out.println("A.Check Balance");
		System.out.println("B.Deposit");
		System.out.println("C.WithDraw");
		System.out.println("D.Previous transaction");
		System.out.println("E. EXIT");

		do{
			System.out.println("Enter an option:");
			option = scanner.next().charAt(0);
			System.out.println("\n");

			switch (option){
				case 'A':
					System.out.println("Balance = " + this.balance);
					break;
				case 'B':
					System.out.println("Enter an amount to deposit: ");
					int amount = scanner.nextInt();
					this.deposit(amount);
					System.out.println("\n");
					break;
				case 'C':
					System.out.println("Enter an amount to withdraw: ");
					int amount2 = scanner.nextInt();
					this.withDraw(amount2);
					System.out.println("\n");
					break;
				case 'D':
					this.getPreviousTransaction();
					break;
				case 'E':
					System.out.println("Thank you for using our services!");
					break;
				default:
					System.out.println("Invalid Option! Please enter again!");
					break;
			}
		} while (Character.isAlphabetic(option));

		System.out.println("Thank you for using our services!");
	}
}