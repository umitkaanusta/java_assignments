/* This class denotes the regular employees in our company system.
 * 
 * Ümit Kaan Usta- 150119068*/

import java.util.Calendar;

public class RegularEmployee extends Employee {
	/* double performanceScore: Shows the performance score of the employee
	 * double bonus: Shows the bonus calculated on the employee's performance score
	 */
	private double performanceScore;
	private double bonus;
	
	public RegularEmployee(int id, String firstName, String lastName, String gender,
			Calendar birthDate, String maritalStatus, String hasDriverLicence,
			double salary, Calendar hireDate, Department department, 
			double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence,
				salary, hireDate, department);
		this.performanceScore = performanceScore;
	}
	
	public RegularEmployee(Employee employee, double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(),
				employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(),
				employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), 
				employee.getDepartment());
		this.performanceScore = perfScore;
	}

	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) throws Exception {
		if(performanceScore < 0) {
			// Since bonus is calculated by perfscore and bonus cannot be negative,
			// the performance score should not be negative as well.
			throw new Exception("Performance score cannot be negative");
		}
		this.performanceScore = performanceScore;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		try {
			return super.toString() + " " + getPerformanceScore() + " " + getBonus();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
	
}
