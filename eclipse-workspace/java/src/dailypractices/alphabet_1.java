package dailypractices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//public class alphabet_1 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<Integer> v=new ArrayList();
//		v.add(4);
//		v.add(5);
//		v.set(1,6);
//		v.remove(0);
//		for(Integer i:v)
//			System.out.print(i);
//		
		
		
		
		
//		List<Integer> l =Arrays.asList(10,4,-1,5);
//		Collections.sort(l);
//		Integer array[]=l.toArray(new Integer[4]);
//		System.out.println(array[0]);
		
		
		
//		List<Integer> l=new ArrayList<Integer>();
//		l.add(2);
//		l.add(7);
//		l.add(null);
//		for(int x: l)
//		System.out.println(x);

		
		
		
//		ArrayList l1=new ArrayList(10);
//		l1.add(2);
//		ArrayList l2=new ArrayList(10);
//		l2.add(2);
//		if(l1==l2)
//		   System.out.println("A");
//		else if(l1.equals(l2))
//			System.out.println("B");
//		else
//			System.out.println("C");

		
		
		
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class alphabet_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first date (YYYY-MM-DD): ");
            String date1String = scanner.next();

            System.out.print("Enter the second date (YYYY-MM-DD): ");
            String date2String = scanner.next();

            LocalDate date1 = LocalDate.parse(date1String);
            LocalDate date2 = LocalDate.parse(date2String);

            long daysBetween = ChronoUnit.DAYS.between(date1, date2);
            System.out.println("Total number of days between the two dates: " + daysBetween);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter dates in the format 'YYYY-MM-DD'.");
        } finally {
            scanner.close(); // Closing the scanner
        }
    }
}

		    