package examplesums;

import java.util.Scanner;

public class HexaDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a hexadecimal number: ");
		String hexNumber = sc.nextLine();
		
		// HEXADECIMAL TO DECIMAL
		
		int decimalNumber = Integer.parseInt(hexNumber, 16);
		System.out.println("Decimal: " + decimalNumber);
		
		// HEXADECIMAL TO BINARY

		String binaryNumber = Integer.toBinaryString(decimalNumber);
		System.out.println("Binary: " + binaryNumber);

		// HEXADECIMAL TO OCTAL

		String octalNumber = Integer.toOctalString(decimalNumber);
		System.out.println("Octal: " + octalNumber);
	}

}
