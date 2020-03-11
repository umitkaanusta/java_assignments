/* The product class shows the products sold/created by our company system.
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;

public class Product {
	/* String productName: Name of the product
	 * Calendar saleDate: Shows when the product is sold
	 * double price: The price of the product
	 * */
	private String productName;
	private Calendar saleDate;
	private double price;
	
	public Product(String sName, Calendar sDate, double price) {
		this.productName = sName;
		this.saleDate = sDate;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) throws Exception {
		if(productName.length() < 3) {
			throw new Exception("Product name should have at least 3 characters.");
		}
		else {
			this.productName = productName;
		}
	}

	public Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if(price <= 0) {
			throw new Exception("Price can not be equal to or smaller than zero.");
		}
		else {
			this.price = price;
		}
	}
	
	@Override
	public String toString() {
		try {
			return getProductName() + " " + getSaleDate() + " " + getPrice();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
}
