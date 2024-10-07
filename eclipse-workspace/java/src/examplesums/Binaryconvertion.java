package examplesums;

import java.util.Scanner;

public class Binaryconvertion {

	public static void main(String[] args) {

//		BINARY TO DECIMAL CONVERTION
//		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter binary number: ");
		String binaryNumber = scanner.nextLine();
		int decimalNumber = Integer.parseInt(binaryNumber, 2);
		System.out.println("Decimal: " + decimalNumber);
		

//		BINARY TO OCTAL

		
		String OctalNumber = Integer.toOctalString(decimalNumber);
		System.out.println("Octal: " + OctalNumber);

		
//		BINARY TO HEXADECIMAL

		
		String hexNumber = Integer.toHexString(decimalNumber);
		System.out.println("Hexadecimal: " + hexNumber);

	}

}
