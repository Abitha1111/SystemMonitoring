package dailypractices;

public class oddevenlength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This is a java language";
		for(int i=0;i<=str.length()-1;i++) {
			if(i%2==0) {
				System.out.println("Even");
			}
			else {
				System.out.println("Odd");
			}
		}
	}

}
