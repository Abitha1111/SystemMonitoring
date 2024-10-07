package dailypractices;

public class stringsplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "SASIabitha@12354*$%";
		String Uppercase = "";
		String Lowercase = "";
		String Number = "";
		String Special = "";
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				Uppercase += ch;
			} else if (Character.isLowerCase(ch)) {
				Lowercase += ch;
			} else if (Character.isDigit(ch)) {
				Number += ch;
			} else {
				Special += ch;
			}
		}
		System.out.println("Uppercase :" + Uppercase);
		System.out.println("Lowercase :" + Lowercase);
		System.out.println("Number :" + Number);
		System.out.println("Special:" + Special);
	}

}



/* ANOTHER WAY:
for (char ch : str.toCharArray()) {
    if (ch >= 'A' && ch <= 'Z') {
        uppercase += ch;
    } else if (ch >= 'a' && ch <= 'z') {
        lowercase += ch;
    } else if (ch >= '0' && ch <= '9') {
        number += ch;
    } else {
        special += ch;
    }
}
*/