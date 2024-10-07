package examplesums;

import java.util.Scanner;

public class OctalConvertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an octal number: ");
		String octalNumber = sc.next();

		// DECIMAL TO BINARY

		int decimalNumber = Integer.parseInt(octalNumber, 8);
		System.out.println("Decimal: " + decimalNumber);

		// DECIMAL TO OCTAL

		String binaryNumber = Integer.toBinaryString(decimalNumber);
		System.out.println("Binary: " + binaryNumber);

		// DECIMAL TO HEXADECIMAL

		String hexNumber = Integer.toHexString(decimalNumber);
		System.out.println("Hexadecimal: " + hexNumber);
	}

}
