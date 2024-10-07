package examplesums;

import java.util.Scanner;

public class DecimalConvertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		DECIMAL TO BINARY

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number Decimal: ");
		int decimalnumber = scanner.nextInt();
		String binaryNumber = Integer.toBinaryString(decimalnumber);
		System.out.println("Decimal --> Binary : " + binaryNumber);

//		DECIMAL TO OCTAL

		String octalNumber = Integer.toOctalString(decimalnumber);
		System.out.println("Decimal --> Octal : " + octalNumber);

//		DECIMAL TO HEXADECIMAL

		String hexNumber = Integer.toHexString(decimalnumber);
		System.out.println("Decimal --> Hexadecimal : " + hexNumber);

	}

}
