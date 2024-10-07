package dailypractices;

public class submatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 3, 2 }, { 4, 3, 2 }, { 6, 4, 3 } };
		int b[][] = { { 6, 4, 3 }, { 3, 7, 2 }, { 9, 1, 4 } };
		int c[][] = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}

}
