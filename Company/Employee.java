/* This class defines the attributes and methods for the employees in the company
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;

public class Employee extends Person {
	/* double salary: Shows the salary of the employee
	 * Calendar hireDate: Shows the employee's first day in the company
	 * Department department: Shows the department the employee is working in
	 * public int numberofEmployees: Shows total number of employees in the company
	 */
	private double salary;
	private Calendar hireDate;
	private Department department;
	public int numberofEmployees; // Did not create getters/setters since it's public
	
	public Employee(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, Calendar hireDate, Department department) throws Exception {
		super(id, hasDriverLicence, hasDriverLicence, hasDriverLicence, 
				hireDate, hasDriverLicence, hasDriverLicence);
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees += 1; // Increment number of employees when an object is created
	}
	
	public Employee(Person person, double salary, Calendar hireDate, 
			Department department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), 
				person.getGender(), person.getBirthDate(), person.getMaritalStatus(),
				person.getHasDriverLicence());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees += 1; // Increment number of employees when an object is created
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) throws Exception {
		if(salary < 0) {
			throw new Exception("Salary can not be a negative value.");
		}
		else {
			this.salary = salary;
		}
	}
	
	public void raiseSalary(double percent) throws Exception {
		// Raises salary by percent, percent must be between 0 and 1 included.
		if(percent > 1 || percent < 0) {
			throw new Exception("The percentage must be between 0 and 1 included.");
		}
		else {
			try {
				double salary_raised = this.salary + this.salary * percent;
				this.salary = salary_raised;
			} catch(Exception e) {
				System.out.println("There are null or invalid data fields.");
			}
		}
	}
	
	public void raiseSalary(int amount) throws Exception {
		// Raises salary by a fixed amount.
		if(amount < 0) {
			throw new Exception("The amount should be greater than zero.");
		}
		else {
			try {
				this.salary += amount;
			} catch(Exception e) {
				System.out.println("There are null or invalid data fields.");
			}
		}
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		try {
			return super.toString() + " " + getSalary() + " " + getHireDate().toString() +
			getDepartment();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
	
}
