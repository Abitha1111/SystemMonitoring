package console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class products {
	private int no;
	private String name;

	products(String name, int no) {
		this.name = name;
		this.no = no;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getName() {
		return name;
	}

	public int getno() {
		return no;
	}

	public String toString() {
		return no + " " + name;
	}

}

public class InventoryManagement {

	public static void main(String[] args) {
		ArrayList<products> inventoryitem = new ArrayList<products>();
		Scanner sc = new Scanner(System.in);
		int item;
		do {
			System.out.println("---Inventory Management System---\n");
			System.out.println("1. Add new Item");
			System.out.println("2. Search Item");
			System.out.println("3. Display all Item");
			System.out.println("4. Update Item ");
			System.out.println("5. Remove Item ");
			System.out.println("6. Exit");
			System.out.print("Enter your choice : ");

			item = sc.nextInt();
			switch (item) {
			case 1:
				System.out.println();
				System.out.print("Enter Item no : ");
				int no = sc.nextInt();
				System.out.print("Enter Item name : ");
				String name = sc.next();
				inventoryitem.add(new products(name, no));
				System.out.println("Item added successfully!\n");
				break;
			case 2:
				System.out.println("--Search Item--");
				System.out.println("1. Search by Item Number");
				System.out.println("2. Search by Item Name");
				System.out.print("Enter your choice: ");
				int searchChoice = sc.nextInt();
				switch (searchChoice) {
				case 1:
					System.out.print("Enter Item Number to search: \n5");
					int searchItemNo = sc.nextInt();
					for (products prod : inventoryitem) {
						if (prod.getno() == searchItemNo) {
							System.out.println("Item found: " + prod);
							break;
						}
					}
					break;
				case 2:
					System.out.print("Enter Item Name to search: ");
					String searchItemName = sc.next();
					for (products prod : inventoryitem) {
						if (prod.getName().equalsIgnoreCase(searchItemName)) {
							System.out.println("Item found: " + prod);
							break;
						}
					}
					break;
				default:
					System.out.println("Invalid choice!");
					break;
				}
				break;

			case 3:
				System.out.println("--Display all Item--\n");
				System.out.println("------------------");
				Iterator<products> list = inventoryitem.iterator();
				while (list.hasNext()) {

					products listname = list.next();
					System.out.println(listname + "\n");

				}
				System.out.println("------------------");

				break;
			case 4:
				System.out.println("--Update Item--");
				System.out.print("Enter Item Number to update: ");
				int updateItemNo = sc.nextInt();
				boolean itemUpdated = false;
				for (products prod : inventoryitem) {
					if (prod.getno() == updateItemNo) {
						System.out.print("Enter new Item Name: ");
						String newName = sc.next();
						prod.setName(newName);
						System.out.println("Item details updated!");
						itemUpdated = true;
						break;
					}
				}
				if (!itemUpdated) {
					System.out.println("Item not found!");
				}
				break;

			case 5:
				System.out.println("--Remove Item--"); {
				System.out.println("Enter Item no : ");
				int removeitemno = sc.nextInt();
				boolean found = false;
				Iterator<products> i = inventoryitem.iterator();
				while (i.hasNext()) {
					products p = i.next();
					if (p.getno() == removeitemno) {
						i.remove();
						found = true;
					}
				}
				if (!found) {
					System.out.println("Item not found");
				} else

				{
					System.out.println("Item removed successfully");
				}
			}
				break;
			case 6:
				System.out.println("--Exit--");
			}
		} while (item != 6);
	}
}
