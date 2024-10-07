package puzzsums;
import java.util.ArrayList;
import java.util.List;

public class BridgeCrossing {

	public static void main(String[] args) {
		// TODO Auto-generated method stud
		        int A = 1;
		        int B = 2;
		        int C = 5;
		        int D = 8;
		        int totalTime = 0;
		        List<String> steps = new ArrayList<>();
		        steps.add("A and B cross->Time taken: " + B + " minutes");
		        totalTime += B;
                // Step 2: A returns
		        steps.add("A returns -> Time taken: " + A + " minutes");
		        totalTime += A;
      	        // Step 3: C and D cross
		        steps.add("C and D cross -> Time taken: " + D + " minutes");
		        totalTime += D;
		        // Step 4: B returns
		        steps.add("B returns -> Time taken: " + B + " minutes");
		        totalTime += B;
		        // Step 5: A and B cross again
		        steps.add("A and B cross again -> Time taken: " + B + " minutes");
		        totalTime += B;
		        if (totalTime <= 15) {
		            System.out.println("All the four people can cross the bridge in " + totalTime + " minutes.");
		        } else {
		            System.out.println("It's not possible for all four people to cross the bridge in 15 minutes.");
		        }
		        System.out.println("Steps taken:");
		        for (String step : steps) {
		            System.out.println(step);
		        }
		    }
		}


	
