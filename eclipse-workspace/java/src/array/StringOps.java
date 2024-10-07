package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class StringOps {
	public static void main(String[] args) {
	 LinkedList obj=new LinkedList();
	 Vector obj1=new Vector();
	 obj.add("alice");
	 obj.add(10);
	 obj.add(0.4f);
	 obj.add(0.23456789d);
	 obj.addFirst("abi");
	 obj.addLast("kavi");
	 obj.remove(0);
	 System.out.println(obj);
	 obj.push(98);
	 System.out.println(obj);
	 System.out.println(obj);
	    Iterator i=obj.descendingIterator();  
        while(i.hasNext())  
        {  
            System.out.println(i.next());  
        }  

	
//	 Iterator Ir=obj.iterator();
//	 while(Ir.hasNext()) {
//		System.out.println(Ir.next()); 
//	 }
	}
}
