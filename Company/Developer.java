/* This class denotes the Developers as a child class of RegularEmployee
 * 
 * Ümit Kaan Usta - 150119068*/

import java.util.Calendar;
import java.util.ArrayList;

public class Developer extends RegularEmployee {
	/* ArrayList<Project> projects: List of the projects of the developer
	 * public int numberOfDevelopers: Total number of developers
	 */
	private ArrayList<Project> projects;
	public static int numberOfDevelopers; // Did not create getters/setters since it's public
	
	public Developer(int id, String firstName, String lastName, String gender, 
	Calendar birthDate, String maritalStatus, String hasDriverLicence, 
	double salary, Calendar hireDate, Department department, double pScore, 
	ArrayList<Project> p) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus,
				hasDriverLicence, salary, hireDate, department, pScore);
		this.projects = p;
		numberOfDevelopers += 1; // Increment number of employees when an object is created
	}
	
	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(),
				re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(),
				re.getSalary(), re.getHireDate(), re.getDepartment(),
				re.getPerformanceScore());
		this.projects = p;
		numberOfDevelopers += 1;
	}
	
	public boolean addProject(Project p) {
		try {
			this.projects.add(p);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean removeProject(Project p) throws Exception {
		try {
			if(this.projects.contains(p)) {
				this.projects.add(p);
				return true;
			}
			else {
				throw new Exception("Seems like you have already removed the item.");
			}
		} catch(Exception e) {
			return false;
		}
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		try {
			StringBuffer sb = new StringBuffer(); // This is needed to "stringify" an arraylist
			ArrayList<Project> projects = getProjects();
			for(Project p: projects) {
				sb.append(p.toString());
			}
			return super.toString() + " " + sb.toString();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
}
