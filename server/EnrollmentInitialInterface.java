import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EnrollmentInitialInterface extends Remote{
    public void initializeStudents() throws RemoteException;
    public void initializeCourses() throws RemoteException;
}