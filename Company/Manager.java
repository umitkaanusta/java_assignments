/* Denotes the managers in our company system.
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;
import java.util.ArrayList;

public class Manager extends Employee {
	/* ArrayList<RegularEmployee> regular Employees: The list of regular employee's under
	 * the manager's supervision.
	 * double bonusBudget: Manager's bonus budget to be distributed to their employees.
	 */
	private ArrayList<RegularEmployee> regularEmployees;
	private double bonusBudget;
	
	public Manager(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, Calendar hireDate, Department department,
			double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus,
				hasDriverLicence, salary, hireDate, department);
		this.bonusBudget = bonusBudget;
	}
	
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), 
				employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), 
				employee.getHasDriverLicence(), employee.getSalary(), 
				employee.getHireDate(),employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	
	public void addEmployee(RegularEmployee e) throws Exception {
		// If the employee is not in the manager's list, adds the employee.
		if(this.regularEmployees.contains(e)) {
			throw new Exception("This employee is already in the list.");
		}
		else {
			this.regularEmployees.add(e);
		}
	}
	
	public void removeEmployee(RegularEmployee e) throws Exception {
		if(this.regularEmployees.contains(e)) {
			this.regularEmployees.remove(e);
		}
		else {
			throw new Exception("The employee is probably already removed.");
		}
	}
	
	public void distributeBonusBudget() {
		/* To calculate bonus value for each employee:
		 * int unit = bonusBudget / sigma(salary * performanceScore)
		 * int bonus = unit * salary * performanceScore
		 */
		int numOfEmployees = this.regularEmployees.size();
		double totalSalaryAndScore = 0; // Temp variable
		for (int i = 0; i < numOfEmployees; i++) {
			double salaryTemp = this.regularEmployees.get(i).getSalary();
			double scoreTemp = this.regularEmployees.get(i).getPerformanceScore();
			totalSalaryAndScore = totalSalaryAndScore + salaryTemp + scoreTemp;
		}
		double unit = this.bonusBudget / totalSalaryAndScore;
		// After calculating unit, now let's set bonus value for employees
		for (int i = 0; i < numOfEmployees; i++) {
			double salaryTemp = this.regularEmployees.get(i).getSalary();
			double scoreTemp = this.regularEmployees.get(i).getPerformanceScore();
			double bonusValue = unit * salaryTemp * scoreTemp;
			this.regularEmployees.get(i).setBonus(bonusValue);
		}
	}

	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) throws Exception {
		if(bonusBudget < 0) {
			throw new Exception("The budget cannot be a negative value.");
		}
		else {
			this.bonusBudget = bonusBudget;

		}
	}
	
	@Override
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(); // This is needed to "stringify" an arraylist
			ArrayList<RegularEmployee> regularEmployees = getRegularEmployees();
			for(RegularEmployee e: regularEmployees) {
				sb.append(e.toString());
			}
			return super.toString() + " " + sb.toString() + " " + getBonusBudget();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
	
}
