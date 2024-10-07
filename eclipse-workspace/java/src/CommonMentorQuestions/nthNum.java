package CommonMentorQuestions;

public class nthNum {
		    public static String nthNumber(int n) {
		        StringBuilder result = new StringBuilder();

		        while (n > 0) {
		            int remainder = n % 2;
		            if (remainder == 0) {
		                result.insert(0, '3');
		                n = (n / 2) - 1; 
		            } else {
		                result.insert(0, '4');
		                n /= 2;
		            }
		        }

		        return result.toString();
		    }

		    public static void main(String[] args) {
		        int n = 10; 
		        String nthNumber = nthNumber(n);
		        System.out.println("The " + n + "th number in the number system is: " + nthNumber);
		    }
		}

	