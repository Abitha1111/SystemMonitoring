package dailypractices;

import java.util.ArrayList;
import java.util.Iterator;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("Abitha");
		list.add("Kirthi");
		list.add("Kalpana");
		list.add("Thangavi");
		Iterator<String> list1 = list.iterator();
		while (list1.hasNext()) {
			String name = list1.next();
			System.out.println(name);
		}
	}

}
