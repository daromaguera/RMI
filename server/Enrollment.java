import java.rmi.RemoteException;

public class Enrollment implements EnrollmentInterface, EnrollmentInitialInterface{
    private int i = 0;
	Student studx[];
    Course course[];
    public void initializeStudents() throws RemoteException{
        this.studx = new Student[4];
        try{
            this.studx[0] = new Student("156-20954","Karen", "BSIT");
            this.studx[1] = new Student("295-20514","Joshua", "BSIS");
            this.studx[2] = new Student("312-29294","Paul", "BSCS");
            this.studx[3] = new Student("405-20259","Raul", "BSIS");
        }catch(Exception e){
			System.out.println("Error while initializing students" + e);
		}
    }
    public void initializeCourses() throws RemoteException{
        this.course = new Course[4];
        try{
            this.course[0] = new Course("IT-105","Intermediate Programming", "Lorem ipsum course description 1");
            this.course[1] = new Course("IT-106","Integrative Programming and Technologies 1", "Lorem ipsum course description 2");
            this.course[2] = new Course("CSC-122","Data Structures and Algorithms", "Lorem ipsum course description 3");
            this.course[3] = new Course("ITE-12","Fundamentals of Problem Solving and Programming", "Lorem ipsum course description 4");
        }catch(Exception e){
			System.out.println("Error while initializing students" + e);
		}
    }
    public String displayStudents() throws RemoteException{
        String allStudents = "";
        allStudents = "\n\nAll Students:\n";
        for (Student student : studx) {
            if (student != null) {
                allStudents += "\nID: " + student.getId() + "\n";
                allStudents += "Full Name: " + student.getFullName() + "\n";
                allStudents += "Program: " + student.getProgram() + "\n";
                if(student.getCourseEnrolled() == ""){
                    allStudents += "Courses Enrolled: No courses enrolled yet." + "\n---------------";
                }else{
                    allStudents += "Courses Enrolled: " + student.getCourseEnrolled() + "\n---------------";
                }
            }
        }
        System.out.println("A request from unknown client has been processed: Displaying all students in the client...");
        return allStudents;
    }
    public String displayCourses() throws RemoteException{
        String allCourses = "";
        allCourses = "\n\nAll Courses:\n";
        for (Course course : course) {
            if (course != null) {
                allCourses += "\nCourse Code: " + course.getCCode() + "\n";
                allCourses += "Name: " + course.getCName() + "\n";
                allCourses += "Description: " + course.getCDescription() + "\n---------------";
            }
        }
        System.out.println("A request from unknown client has been processed: Displaying all courses in the client...");
        return allCourses;
    }
    public int enrollCourse(String studentID, String studentCourseCode) throws RemoteException{
        int haveStudID = 0;
        int haveCourse = 0;
        for (Student student : studx) {
            if (studentID.equals(student.getId())) { // Matching inputted ID to student ID stored...
                haveStudID = 1;
            }
        }
        for (Course course : course) {
            if (studentCourseCode.equals(course.getCCode())) { // Matching inputted ID to student ID stored...
                haveCourse = 1;
            }
        }
        if(haveStudID == 0 || haveCourse == 0){
            System.out.println("A Client attempted to Enroll student. Error found to be an invalid student or course...");
            return 0;
        }
        for (Student student : studx) {
            if (studentID.equals(student.getId())) { // Matching inputted ID to student ID stored...
                student.setCourse(studentCourseCode);
            }
        }
        System.out.println("A Client successfully enrolled one student...");
        return 1;
    }
}