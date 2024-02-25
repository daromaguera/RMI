import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
	// Lets us define API
	public String getName() throws RemoteException;
	public String getDescription() throws RemoteException;
	public double getPrice() throws RemoteException;
	public void changeProductName(String newName) throws RemoteException;
}