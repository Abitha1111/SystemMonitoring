package dailypractices;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeSet<String> al = new TreeSet<String>();
//		al.add("Ravi");
//		al.add("Vijay");
//		al.add("Ravi");
//		al.add("Ajay");
//		Iterator<String> itr = al.iterator();
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		
		
		 Queue<Integer> queue = new LinkedList<>();
	        queue.offer(10);
	        queue.offer(30);
	        queue.offer(20);
	        System.out.println("Dequeued Element: " + queue.poll());
	        System.out.println("Dequeued Element: " + queue.poll());
	        System.out.println("Front Element: " + queue.peek());
	    }
	}
	