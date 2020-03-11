/* This class creates the fundamentals for our company system.
 *
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;

public class Person {
	/* int id: An identity number
	 * String firstName: First name of the person
	 * String lastName: Surname of the person
	 * byte gender: Gender of the person (1 for Woman, 2 for Man)
	 * Calendar birthDate: Date of birth of the person in java.util.Calendar format
	 * byte maritalStatus: Marital status of the person (1 for Single, 2 for Married)
	 * boolean hasDriverLicence: Shows whether the person has a driver's licence
	 */
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence) throws Exception {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = bytifyGender(gender);
		this.birthDate = birthDate;
		this.maritalStatus = bytifyStatus(maritalStatus);
		this.hasDriverLicence = boolifyLicence(hasDriverLicence);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		if(id < 0) {
			throw new Exception("ID value cannot be negative or null.");
		}
		else {
			this.id = id;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if(firstName.length() < 3) {
			throw new Exception("First name cannot be less than 3 characters.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if(lastName.length() < 3) {
			throw new Exception("Last name cannot be less than 3 characters.");
		}
		else {
			this.lastName = lastName;
		}
	}

	public String getGender() throws Exception {
		if(this.gender == 1) {
			return "Man";
		}
		else if(this.gender == 2) {
			return "Woman";
		}
		else {
			throw new Exception("The gender of the person should be either Man or Woman.");
		}
	}

	public void setGender(String gender) throws Exception {
		if(gender == "Man") {
			this.gender = 1;
		}
		else if(gender == "Woman") {
			this.gender = 2;
		}
		else {
			throw new Exception("The gender of the person should be either Man or Woman.");
		}
	}
	
	public byte bytifyGender(String gender) throws Exception {
		// Converts the string value to a byte value due to type-compatibility reasons
		if(gender == "Man") {
			return 1;
		}
		else if(gender == "Woman") {
			return 2;
		}
		else {
			throw new Exception("The gender of the person should be either Man or Woman.");
		}
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() throws Exception {
		if(this.maritalStatus == 1) {
			return "Single";
		}
		else if(this.maritalStatus == 2) {
			return "Married";
		}
		else {
			throw new Exception("The marital status of the person should be either Single or Married.");
		}
	}

	public void setMaritalStatus(String maritalStatus) throws Exception {
		if(maritalStatus == "Single") {
			this.maritalStatus = 1;
		}
		else if(maritalStatus == "Married") {
			this.maritalStatus = 2;
		}
		else {
			throw new Exception("The marital status of the person should be either Single or Married.");
		}
	}
	
	public byte bytifyStatus(String maritalStatus) throws Exception {
		// Converts the string value to a byte value due to type-compatibility reasons
		if(maritalStatus == "Single") {
			return 1;
		}
		else if(maritalStatus == "Married") {
			return 2;
		}
		else {
			throw new Exception("The marital status of the person should be either Single or Married.");
		}
	}

	public String getHasDriverLicence() throws Exception {
		if(this.hasDriverLicence) {
			return "Yes";
		}
		else if(!this.hasDriverLicence) {
			return "No";
		}
		else {
			throw new Exception("Invalid driver's licence value.");
		}
	}

	public void setHasDriverLicence(String hasDriverLicence) throws Exception {
		if(hasDriverLicence == "Yes") {
			this.hasDriverLicence = true;
		}
		else if(hasDriverLicence == "No") {
			this.hasDriverLicence = false;
		}
		else {
			throw new Exception("Invalid driver's licence value.");
		}
	}
	
	public boolean boolifyLicence(String hasDriverLicence) throws Exception {
		// Converts the string value to a boolean value due to type-compatibility reasons
		if(hasDriverLicence == "Yes") {
			return true;
		}
		else if(hasDriverLicence == "No") {
			return false;
		}
		else {
			throw new Exception("Invalid driver's licence value.");
		}
	}

	@Override
	public String toString() {
		try {
			return getId() + " " + getFirstName() + " " + getLastName() + " " + getGender() +
					" " + getBirthDate().toString() + getMaritalStatus() + " " + 
					getHasDriverLicence();
		} catch (Exception e) {
			return "There are null or invalid data fields.";
		}
	}
	
	
}
