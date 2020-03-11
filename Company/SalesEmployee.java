/* This class denotes the Sales employees as a child class of RegularEmployee
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;
import java.util.ArrayList;

public class SalesEmployee extends RegularEmployee {
	/* ArrayList<Product> sales: List of the products sold by the sales employee
	 * public int numberOfSalesEmployees: Total number of sales employees
	 */
	private ArrayList<Product> sales;
	public static int numberOfSalesEmployees; // Did not create getters/setters since it's public
	
	public SalesEmployee(int id, String firstName, String lastName, String gender, 
	Calendar birthDate, String maritalStatus, String hasDriverLicence, 
	double salary, Calendar hireDate, Department department, double pScore, 
	ArrayList<Product> s) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus,
				hasDriverLicence, salary, hireDate, department, pScore);
		this.sales = s;
		numberOfSalesEmployees += 1; // Increment number of employees when an object is created
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
				re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(),
				re.getSalary(), re.getHireDate(), re.getDepartment(),
				re.getPerformanceScore());
		this.sales = s;
		numberOfSalesEmployees += 1;
	}
	
	public boolean addSale(Product s) {
		try {
			this.sales.add(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean removeSale(Product s) throws Exception {
		try {
			if(this.sales.contains(s)) {
				this.sales.add(s);
				return true;
			}
			else {
				throw new Exception("Seems like you have already removed the item.");
			}
		} catch(Exception e) {
			return false;
		}
	}

	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}
	
	@Override
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(); // This is needed to "stringify" an arraylist
			ArrayList<Product> sales = getSales();
			for(Product p: sales) {
				sb.append(p.toString());
			}
			return super.toString() + " " + sb.toString();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
}
