import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Faculty{
	public static void main(String[] args){
		try{
			// Get the references of exported object from RMI Registry...

			//locate the registry.
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			// Get the references of exported object from the RMI Registry...
			EnrollmentInitialInterface p1 = (EnrollmentInitialInterface) registry.lookup("access_enrollment");
			EnrollmentInterface p2 = (EnrollmentInterface) registry.lookup("access_enrollment");

			
			Scanner scanner = new Scanner(System.in);
			int userSelection = 0;
			// Start Menu
			do{
				System.out.println("\n\n ==== Menu ==== \n");
				System.out.println("Key [1] - Display All Students");
				System.out.println("Key [2] - Display All Courses");
				System.out.println("Key [3] - Enroll Student");
				System.out.println("Key [0] - Exit");
				System.out.print("Type here: ");
				userSelection = scanner.nextInt();
				if(userSelection == 1){
					System.out.println(p2.displayStudents());
				}else if(userSelection == 2){
					System.out.println(p2.displayCourses());
				}else if(userSelection == 3){
					Scanner scn = new Scanner(System.in);
					Scanner scn2 = new Scanner(System.in);
					System.out.print("\n\nEnter Student ID: ");
					String studentID = scn.nextLine();
					System.out.print("Enter Course Code: ");
					String studentCourseCode = scn2.nextLine();
					int result = 0;
					result = p2.enrollCourse(studentID, studentCourseCode);
					if(result == 0){
						System.out.println("Invalid student or course");
					}else{
						System.out.println("Student has been successfully enrolled a course with a code "+studentCourseCode);
					}
				}else{
					System.out.println("\n\nInvalid key!");
				}
			}while(userSelection != 0);
			System.out.println("\n\nProgram successfully exited.");
		}catch(Exception e){
			System.out.println("Client side error..." + e);
		}
	}
}