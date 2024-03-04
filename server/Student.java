import java.rmi.RemoteException;

public class Student implements StudentInterface{
	// Attributes of product
	private String id;
	private String fullName;
	private String program;
	private String course = "";

	Student(String id, String fullName, String program) throws RemoteException{
		this.id = id;
		this.fullName = fullName;
		this.program = program;
	}
	public String getId() throws RemoteException{
		return this.id;
	}
	public String getFullName() throws RemoteException{
		return this.fullName;
	}
	public String getProgram() throws RemoteException{
		return this.program;
	}
	public String getCourseEnrolled() throws RemoteException{
		return this.course;
	}
	public void setCourse(String courseCode) throws RemoteException{
		this.course += "\n\n> " + courseCode;
	}
}