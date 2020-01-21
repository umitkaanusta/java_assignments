/* This class basically simulates a car park.
 * 
 * Ümit Kaan Usta - 150119068*/


public class CarPark {
	/* int capacity: The capacity of the car park
	 * ParkPlace[] parkPlaceArray: An array that contains suitable park places, see ParkPlace.java
	 * Ticket[] ticketArray: An array that contains tickets, see Ticket.java
	 * double hourlyPrice: Hourly price of the car park
	 * */
	private int capacity;
	public ParkPlace[] parkPlaceArray = new ParkPlace[0];
	public Ticket[] ticketArray = new Ticket[0];
	private double hourlyPrice;
	
	public CarPark(int capacity, double hourlyPrice) {
		// CarPark objectName = new CarPark(capacity, hourlyPrice);
		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
	}
	
	public Ticket parkVehicle(Vehicle vehicle, java.util.Date entryDate) {
		// Invoked when a new vehicle enters to the park. A ticket is created.
		
		if(capacity < vehicle.getSize()) {
			System.out.println("The car park is full!");
		}
		else {
			capacity-= vehicle.getSize();
			ParkPlace place = new ParkPlace(vehicle);
			Ticket ticket = new Ticket(vehicle, entryDate);
			addToPlaceArray(place);
			addToTicketArray(ticket);
			System.out.println("The vehicle with the plate number " + vehicle.getPlateNumber()
			+ " is parked.");
			return ticket;
		}
		return null;
	}
	
	public Vehicle exitVehicle(Ticket ticket, java.util.Date exitDate) {
		// Invoked when a vehicle exits the park.
		
		for(ParkPlace i: parkPlaceArray) {
			if(i.getVehicle().getPlateNumber() == ticket.getVehicle().getPlateNumber()) {
				capacity+= i.getVehicle().getSize();
				ticket.calculatePrice(this.hourlyPrice, exitDate);
				System.out.println("The price for the vehicle with the plate number "
						+ ticket.getVehicle().getPlateNumber() + " is "
						+ ticket.getPrice() + " TLs");
			}
		}
		
		return ticket.getVehicle();
	}
	
	public double getTotalIncome() {
		double income = 0;
		for(Ticket ticket: ticketArray) {
			income += ticket.getPrice();
		}
		return income;
	}
	
	public void printVehicleList() {
		for(ParkPlace place: parkPlaceArray) {
			if (place != null) System.out.println(place.getVehicle().getVehicleInfo());
		}
	}
	
	public void printTickets() {
		for(Ticket ticket: ticketArray) {
			if(ticket != null) System.out.println(ticket.getTicketInfo());
		}
	}
	
	void addToPlaceArray(ParkPlace place) {
		parkPlaceArray = java.util.Arrays.copyOf(parkPlaceArray, parkPlaceArray.length + 1);
		parkPlaceArray[parkPlaceArray.length-1] = place;
	}
	
	void addToTicketArray(Ticket ticket) {
		ticketArray = java.util.Arrays.copyOf(ticketArray, ticketArray.length + 1);
		ticketArray[ticketArray.length-1] = ticket;
	}
}
