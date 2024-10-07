package Geometricshapes;
import java.util.Scanner;
public class shapes {

	public static double rectangle(int l, int b) {
		double area = l * b;
		return area;
	}

	public static double square(int a) {
		double area = a * a;
		return area;
	}

	public static double triangle(int l, int b) {
		double area = 0.5 * l * b;
		return area;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length and breadth");
		int length = in.nextInt();
		int breadth = in.nextInt();

		System.out.println("Area of Rectangle:"+rectangle(length,breadth));
		System.out.println("Area of Square:"+square(length));
		System.out.println("Area of Trianle:"+triangle(length,breadth));

	}

}

	
