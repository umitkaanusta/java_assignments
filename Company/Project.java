/* This Project class shows the Projects of our company system.
 * 
 * Ümit Kaan Usta - 150119068 */

import java.util.Calendar;

public class Project {
	/* String projectName: Name of the project
	 * Calendar startDate: The date when the project is initiated
	 * boolean state: The state of the project (true if "Open", false if "Close")
	 * */
	private String projectName;
	private Calendar startDate;
	private boolean state;
	
	public Project(String pName, Calendar startDate, String state) throws Exception {
		this.projectName = pName;
		this.startDate = startDate;
		this.state = boolifyState(state);
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) throws Exception {
		if(projectName.length() < 3) {
			throw new Exception("Project name should be at least 3 characters long.");
		}
		this.projectName = projectName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public String getState() throws Exception {
		if(this.state) {
			return "Open";
		}
		else if(!this.state) {
			return "Close";
		}
		else {
			throw new Exception("The state of the project should be either open or close.");
		}
	}

	public void setState(String state) throws Exception {
		if(state == "Open") {
			this.state = true;
		}
		else if(state == "Closed") {
			this.state = false;
		}
		else {
			throw new Exception("The state of the project should be either open or close.");
		}
	}
	
	public boolean boolifyState(String state) throws Exception {
		if(state == "Open") {
			return true;
		}
		else if(state == "Closed") {
			return false;
		}
		else {
			throw new Exception("The state of the project should be either open or close.");
		}
	}
	
	public void close() throws Exception {
		// Closes an open project
		try {
			if(this.state) {
				this.state = false;
			}
		} catch(Exception e) {
			System.out.println("Failed to close.");
		}
	}
	
	@Override
	public String toString() {
		try {
			return getProjectName() + " " + getStartDate() + " " + getState();
		} catch(Exception e) {
			return "There are null or invalid data fields.";
		}
	}
}
