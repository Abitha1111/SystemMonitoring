package dailypractices;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        // Example 1
		        LocalDate dt1 = LocalDate.of(2000, 2, 10);
		        LocalDate dt2 = LocalDate.of(2000, 3, 10);
		        System.out.println("Difference in days: " + daysBetween(dt1, dt2));
		        
		        // Example 2 (Leap year case)
		        dt1 = LocalDate.of(2000, 2, 10);
		        dt2 = LocalDate.of(2000, 2, 10);
		        System.out.println("Difference in days: " + daysBetween(dt1, dt2)); 
		        
		        // Example 3 (Same date)
		        dt1 = LocalDate.of(2000, 2, 10);
		        dt2 = LocalDate.of(2000, 3, 10);
		        System.out.println("Difference in days: " + daysBetween(dt1, dt2)); 
		    }
		    
		    public static long daysBetween(LocalDate dt1, LocalDate dt2) {
		        return ChronoUnit.DAYS.between(dt1, dt2);
		    }
		}
	