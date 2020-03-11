/* This class is for the customers buying products from our company.
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;
import java.util.ArrayList;

public class Customer extends Person {
	// ArrayList<Product> products: Shows the list of products bought by the customer
	private ArrayList<Product> products;

	public Customer(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence,
			ArrayList<Product> products) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
	}
	
	public Customer(Person person, ArrayList<Product> products) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), 
				person.getGender(), person.getBirthDate(), person.getMaritalStatus(),
				person.getHasDriverLicence());
		this.products = products;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(); // This is needed to "stringify" an arraylist
			ArrayList<Product> products = getProducts();
			for(Product p: products) {
				sb.append(p.toString());
			}
			return super.toString() + " " + sb.toString();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
	
}
