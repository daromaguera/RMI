import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{
	public static void main(String[] args){
		try{
			// Get the references of exported object from RMI Registry...

			//locate the registry.
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

			// Get the references of exported object from the RMI Registry...
			ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
			ProductInterface p2 = (ProductInterface) registry.lookup("mobilePhone");
			ProductInterface p3 = (ProductInterface) registry.lookup("charger");
			ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");

			System.out.println( "The product name is: " + p1.getName() + ",  The price is: " + p1.getPrice());

		}catch(Exception e){
			System.out.println("Client side error..." + e);
		}
	}
}