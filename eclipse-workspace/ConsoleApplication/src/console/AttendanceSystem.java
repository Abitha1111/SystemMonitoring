package console;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

class Employee {
	private int id;
	private String name;
	private String role;
	private String mobileno;
	private String address;
	private String date;
	private boolean isPresent;
	private LocalDateTime attendanceDateTime;

	Employee(int Id, String Name, String role, String mobileno, String address) {
		this.id = Id;
		this.name = Name;
		this.role = role;
		this.mobileno = mobileno;
		this.address = address;
		this.date=date;
		this.isPresent = false;
		this.attendanceDateTime = null;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getrole() {
		return role;
	}

	public String getmobileno() {
		return mobileno;
	}

	public String getaddress() {
		return address;
	}
	public String getdate() {
		return date;
	}

	public String setName() {
		return name;
	}

	public String setrole() {
		return role;
	}

	public String setmobileno() {
		return mobileno;
	}

	public String setaddress() {
		return address;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public LocalDateTime getAttendanceDateTime() {
		return attendanceDateTime;
	}

	public void markAttendance() {
		isPresent = !isPresent;
		if (isPresent) {
			attendanceDateTime = LocalDateTime.now();
		} else {
			attendanceDateTime = null;
		}
	}
}

public class AttendanceSystem {
	private static Scanner sc = new Scanner(System.in);
	private static List<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {
		int choice;
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Admin Panel");
			System.out.println("2. Employee Panel");
			System.out.println("3. Manager Panel");
			System.out.println("0. Exit");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				adminPanel();
				break;
			case 2:
				employeePanel();
				break;
			case 3:
				managerPanel();
				break;
			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 0);
	}

	private static void adminPanel() {
		int adminChoice;
		do {
			System.out.println("Admin Panel:");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("0. Back to Main Menu");
			System.out.println("Enter your choice :");
			adminChoice = sc.nextInt();
			sc.nextLine();
			switch (adminChoice) {
			case 1:
				System.out.println("--Add Employee Details--\n");
				System.out.println("Employee Id ");
				int id = sc.nextInt();
				System.out.println("Name ");
				String name = sc.next();
				System.out.println("Role ");
				String role = sc.next();
				System.out.println("Mobile Number ");
				String mobileno = sc.next();
				System.out.println("Address ");
				String address = sc.next();
				employees.add(new Employee(id, name, role, mobileno, address));
				System.out.println("Employee added Successfully...\n");
				break;
			case 2:
				 System.out.println("--Update Employee Details--\n");
			        System.out.println("Enter employee Id to update:");
			        int updateId = sc.nextInt();
			        boolean found = false;

			        for (Employee emp : employees) {
			            if (emp.getId() == updateId) {
			                found = true;
			                System.out.println("Employee found...\nWhat do you want to update?");
			                System.out.println("1. Name");
			                System.out.println("2. Role");
			                System.out.println("3. Mobile Number");
			                System.out.println("4. Address");
			                System.out.println("0.Back to Main Menu");
			                int choice = sc.nextInt();

			                switch (choice) {
			                    case 1:
			                        System.out.println("Enter new name:");
			                        String newName = sc.next();
			                        emp.setName();
			                        System.out.println("Name updated successfully...");
			                        break;
			                    case 2:
			                        System.out.println("Enter new role:");
			                        String newRole = sc.next();
			                        emp.setrole();
			                        System.out.println("Role updated successfully...");
			                        break;
			                    case 3:
			                        System.out.println("Enter new mobile number:");
			                        String newMobileNo = sc.next();
			                        emp.setmobileno();
			                        System.out.println("Mobile number updated successfully...");
			                        break;
			                    case 4:
			                        System.out.println("Enter new address:");
			                        String newAddress = sc.next();
			                        emp.setaddress();
			                        System.out.println("Address updated successfully...");
			                        break;
			                    default:
			                        System.out.println("Invalid option.");
			                        break;
			                }
			               
			            }
			        }

			        if (!found) {
			            System.out.println("Employee not found.");
			        }
			        break;
			    
			case 3:
				System.out.println("--Delete Employee Details--\n");
				System.out.println("--Enter employee Id to delete:");
				int deleteId = sc.nextInt();
				boolean deleted = false;
				Iterator<Employee> iterator = employees.iterator();
				while (iterator.hasNext()) {
					Employee emp = iterator.next();
					if (emp.getId() == deleteId)
						iterator.remove();
					deleted = true;
					System.out.println("Employee Details Deleted Successfully...");
					break;
				}
			case 0:
				System.out.println("Returning to Main Menu...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (adminChoice != 0);
	}

	private static void employeePanel() {
		System.out.println("-- Employee Panel --");
		System.out.println("1. Mark your attendance");
		System.out.println("0. Exit");
		System.out.print("Enter your choice: ");
		int empChoice = sc.nextInt();
		sc.nextLine();
		switch (empChoice) {
		case 1:
			System.out.println("Mark your attendance :");
			System.out.println("Enter your Id:");
			int empId = sc.nextInt();
			boolean found = false;
			for (Employee emp : employees) {
				if (emp.getId() == empId) {
					emp.markAttendance();
					found = true;
					System.out.println("Attendance marked for this Id :" + emp.getId()+" \n"+emp.getAttendanceDateTime());
					break;
				}
			}
			if (!found) {
				System.out.println("Employee not found.");
			}
			break;
		case 0:
			System.out.println("Returning to Main Menu...");
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
	}

	private static void managerPanel() {
		System.out.println("Manager Panel:");
		System.out.println("1. View Employees Attendance");
		System.out.println("2. Generate Reports");
		System.out.println("0. Back to Main Menu");
		int managerChoice = sc.nextInt();
		sc.nextLine();

		switch (managerChoice) {
		case 1:
			viewAttendance();
			break;
		case 2:
			generateAttendanceReport();
			break;
		case 0:
			System.out.println("Returning to Main Menu...");
			break;
		default:
			System.out.println("Invalid choice. Please try again.");
			break;
		}
	}

	private static void viewAttendance() {
		System.out.println("Employees Attendance:");
		for (Employee emp : employees) {
			System.out.println("EmpId: " + emp.getId() + "\nName: " + emp.getName() + "\nRole: " + emp.getrole()
					+ "\nMobile Number: " + emp.getmobileno() + "\nAddress: " + emp.getaddress() + "\nPresent: "
					+ (emp.isPresent() ? "In" : "Out") + "\nAttendance Date & Time: "
					+ (emp.getAttendanceDateTime() != null ? emp.getAttendanceDateTime() : "N/A") + "\n");
		}
	}

	private static void generateAttendanceReport() {
		System.out.println("Generate Attendance Report:");
		System.out.println("Enter year (YYYY):");
		int year = sc.nextInt();
		System.out.println("Enter month (MM):");
		int month = sc.nextInt();

		System.out.println("Attendance Report for " + month + "/" + year + ":");

		System.out.printf("%-10s %-20s %-25s%n", "EmpId", "Name", "Attendance Date & Time");
		List<Employee> presentEmployees = new ArrayList<>();
		List<Employee> absentEmployees = new ArrayList<>();

		for (Employee emp : employees) {
			if (emp.isPresent() && emp.getAttendanceDateTime() != null && emp.getAttendanceDateTime().getYear() == year
					&& emp.getAttendanceDateTime().getMonthValue() == month) {
				presentEmployees.add(emp);
				System.out.printf("%-10s %-20s %-25s%n", emp.getId(), emp.getName(), emp.getAttendanceDateTime());
			} else {
				absentEmployees.add(emp);
			}
		}
		System.out.println("\nPresent Employees:");
		for (Employee emp : presentEmployees) {
			System.out.println("EmpId: " + emp.getId() + ", Name: " + emp.getName());
		}
		System.out.println("\nAbsent Employees:");
		for (Employee emp : absentEmployees) {
			System.out.println("EmpId: " + emp.getId() + ", Name: " + emp.getName() + "\n");
		}
	}

}
