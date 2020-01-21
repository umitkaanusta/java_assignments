/* This class is a blueprint for Vehicle objects.
 * 
 * Ümit Kaan Usta - 150119068 */

public class Vehicle {
	 /* String plateNumber: A plate number, such as "34CSE1141" 
	  * int size: This field only takes 1, 2 and 4. (1: Motorcycle, 2: Car, 3: Truck) 
	  * */
	private String plateNumber;
	private int size;
	
	public Vehicle(String plateNumber, int size) {
		// Vehicle objectName = new Vehicle(plateNumber, size);
		this.plateNumber = plateNumber;
		this.size = size;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public int getSize() {
		return size;
	}
	
	public String getVehicleInfo() {
		// Returns a vehicle's plate number and size
		String str = "Vehicle Info\nPlate Number: " + plateNumber + "\n Size: " + size;
		return str;
	}
}
