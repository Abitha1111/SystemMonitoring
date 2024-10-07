package dailypractices;

public class reversestring {
	public static void main(String[] args) {
		String str = ("This is a java language");
		String reversestr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reversestr = reversestr + str.charAt(i);
		}
		System.out.println("Original string :" + str);
		System.out.println("Reverse string :" + reversestr);

	}

}
