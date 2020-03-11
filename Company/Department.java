/* Shows the deparments in our company.
 * 
 * Ümit Kaan Usta - 150119068 */

public class Department {
	/* int departmentId: Shows the id of the department
	 * String departmentName: Shows the name of the department
	 */
	private int departmentId;
	private String departmentName;
	
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) throws Exception {
		if(departmentId < 0) {
			throw new Exception("Department ID cannot be negative.");
		}
		else {
			this.departmentId = departmentId;
		}
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) throws Exception {
		if(departmentName.length() < 3) {
			throw new Exception("Department Name should be at least 3 characters long.");
		}
		else {
			this.departmentName = departmentName;
		}
	}
	
	@Override
	public String toString() {
		try {
			return getDepartmentId() + " " + getDepartmentName();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
}
