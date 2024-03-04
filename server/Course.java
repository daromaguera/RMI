import java.rmi.RemoteException;

public class Course implements CourseInterface{
	// Attributes of product
	private String courseCode;
	private String courseName;
	private String courseDescription;

	Course(String courseCode, String courseName, String courseDescription) throws RemoteException{
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}
	public String getCCode() throws RemoteException{
		return this.courseCode;
	}
	public String getCName() throws RemoteException{
		return this.courseName;
	}
	public String getCDescription() throws RemoteException{
		return this.courseDescription;
	}
}