/*When a vehicle is parked, a Ticket object is created containing the 
 * vehicle itself and entry date of the vehicle. 
 * 
 *  Ümit Kaan Usta - 150119068*/

public class Ticket {
	/* Vehicle vehicle: Specifies which vehicle's ticket it is, see Vehicle.java
	 * Date entryDate: The vehicle's entry date
	 * Date exitDate: The vehicle's exit date
	 * double totalPrice: The price that the driver will pay
	 * int numberOfTickets
	 * */
	private Vehicle vehicle;
	private java.util.Date entryDate;
	private java.util.Date exitDate;
	private double totalPrice;
	public static int numberOfTickets;
	
	public Ticket(Vehicle vehicle, java.util.Date entryDate) {
		// Ticket objectName = new Ticket(vehicle, entryDate);
		this.vehicle = vehicle;
		this.entryDate = entryDate;
		numberOfTickets++;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public double getPrice() {
		return totalPrice;
	}

	public double calculatePrice(double hourlyPrice, java.util.Date exitDate) {
		// Calculates the price using the hourly price and the entry and exit dates
		this.exitDate = exitDate;
		long diff = exitDate.getTime() - entryDate.getTime();
		long diffMinutes = diff / (60 * 1000) % 60;
	    long diffHours = diff / (60 * 60 * 1000);
	    double numberOfHours = Math.ceil(diffHours + (diffMinutes/100));
		
		double price = vehicle.getSize() * hourlyPrice * (int) numberOfHours;
		this.totalPrice = price;
		return price;
	}
	
	public String getTicketInfo() {
		// Shows the plate number and entry date if the vehicle is still there
		// Shows the exit date, hours spent and the price in addition, if the vehicle has exited
		
		if(exitDate != null) {
			
			long diff = exitDate.getTime() - entryDate.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
		    long diffHours = diff / (60 * 60 * 1000);
		    double numberOfHours = Math.ceil(diffHours + (diffMinutes/100));
			
		   String str = "Ticket Info\nPlate number: " + vehicle.getPlateNumber() + "\n Entry : " 
					+ entryDate.toString() + "\nExit  : " + exitDate.toString()
					+ "\nHour  : " + (int) numberOfHours + "\nFee   : " + this.totalPrice
					+ " TLs";
			return str;
		}
		
		else {
			String str = "Ticket Info\n Plate number: " + vehicle.getPlateNumber() + "\n Entry : "
					+ entryDate.toString();
			return str;
		}
		
	}
}
