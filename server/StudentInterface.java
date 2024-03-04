import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentInterface extends Remote{
	// Lets us define API
	public String getId() throws RemoteException;
	public String getFullName() throws RemoteException;
	public String getProgram() throws RemoteException;
	public String getCourseEnrolled() throws RemoteException;
	public void setCourse(String courseCode) throws RemoteException;
}