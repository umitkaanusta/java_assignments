/* This class is a blueprint for ParkPlace objects.
 * A ParkPlace object represents a suitable place to park a vehicle.
 * 
 * Ümit Kaan Usta - 150119068 */

public class ParkPlace {
	/* Vehicle vehicle: Vehicle to be parked, see Vehicle.java
	 * int size: The size of the park place */
	private int size;
	private Vehicle vehicle;
	
	public ParkPlace(Vehicle vehicle) {
		// ParkPlace objectName = new ParkPlace(vehicle); 
		this.vehicle = vehicle;
	}

	public int getSize() {
		return size;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	
}
