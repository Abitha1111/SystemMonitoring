package dailypractices;

public class addmatrix {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int b[][] = { { 2, 1, 3 }, { 4, 3, 2 }, { 6, 3, 8 } };
//		int c[][] = new int[3][3];
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				c[i][j] = a[i][j] + b[i][j];
//				System.out.print(c[i][j] + " ");
//			}
//
//			System.out.println();
//		}
//	}
//
//}

	

//	    public static int add(int a, int b) {
//	        while (b != 0) {
//	            // Carry contains common set bits of a and b
//	            int carry = a & b;
//
//	            // Sum of bits of a and b where at least one of the bits is not set
//	            a = a ^ b;
//
//	            // Carry is shifted by one so that adding it to a gives the required sum
//	            b = carry << 1;
//	        }
//	        return a;
//	    }
//
//	    public static void main(String[] args) {
//	        int num1 = 5;
//	        int num2 = 7;
//	        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + add(num1, num2));
//	    }
//	}
//
//
//
//
//

    public static int add(int n1, int n2) {
        // Subtracting the negative value of n2 from n1
        while (n2 != 0) {
            int borrow = (~n1) & n2;
            n1 = n1 ^ n2;
            n2 = borrow << 1;
        }
        return n1;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 7;
        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + add(num1, num2));
    }
}