import java.rmi.RemoteException;

public class Product implements ProductInterface{
	// Attributes of product
	private String name;
	private String description;
	private double price;

	Product(String newName, String newDescription, double newPrice) throws RemoteException{
		this.name = newName;
		this.description = newDescription;
		this.price = newPrice;
	}
	public String getName() throws RemoteException{
		return this.name;
	}
	public String getDescription() throws RemoteException{
		return this.description;
	}
	public double getPrice() throws RemoteException{
		return this.price;
	}
	public void changeProductName(String newName) throws RemoteException{
		this.name = newName;
	}
}