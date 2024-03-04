import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInterface extends Remote{
	// Lets us define API
	public String displayStudents() throws RemoteException;
    public String displayCourses() throws RemoteException;
	public int enrollCourse(String studentID, String studentCourseCode) throws RemoteException;
}