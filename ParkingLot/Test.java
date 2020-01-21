/* This program tests the functionality of our car park.
 * 
 * Ümit Kaan Usta - 150119068
 * */
public class Test {

	public static void main(String[] args) {
		CarPark park = new CarPark(10, 5);
		Vehicle veh1 = new Vehicle("34CSE1141", 4);
		Vehicle veh2 = new Vehicle("06CSE1141", 1);
		Vehicle veh3 = new Vehicle("35CSE1141", 2);
		Vehicle veh4 = new Vehicle("26CSE1141", 1);
		Vehicle veh5 = new Vehicle("50CSE1141", 4);
		
		java.util.Date date1 = new java.util.Date(2020, 1, 14, 3, 2, 20);
		//  14.01.2020 -- 03:02:20
		java.util.Date date2 = new java.util.Date(2020, 1, 14, 4, 2, 20);
		//  14.01.2020 -- 04:02:20
		java.util.Date date3 = new java.util.Date(2020, 1, 14, 5, 2, 20);
		//  14.01.2020 -- 05:02:20
		java.util.Date date4 = new java.util.Date(2020, 1, 14, 6, 2, 20);
		//  14.01.2020 -- 06:02:20
		java.util.Date date5 = new java.util.Date(2020, 1, 14, 7, 2, 20);
		//  14.01.2020 -- 07:02:20
		
		park.parkVehicle(veh1, date1);
		park.parkVehicle(veh2, date2);
		park.parkVehicle(veh3, date3);
		park.parkVehicle(veh4, date4);
		park.parkVehicle(veh5, date5); // this can't fit in the park obviously
		park.printVehicleList();
				
		park.exitVehicle(park.ticketArray[0], date3);
		park.exitVehicle(park.ticketArray[1], date3);
		park.printVehicleList();
		
		park.exitVehicle(park.ticketArray[2], date5);
		park.exitVehicle(park.ticketArray[3], date5);
		
		System.out.println(park.getTotalIncome());
		System.out.println(Ticket.numberOfTickets);
		park.printTickets();

	}

}
