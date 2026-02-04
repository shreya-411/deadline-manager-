package lab1;

public class Task {
	//fields
	private String name;
	private Date deadline;
	
	//constructor
	public Task(String name, Date deadline) {
		this.name = name;
		this.deadline = deadline;
		
	}
	
	//getters 
	public String getName() {
		return name;
	}
	
	public Date getDeadline() {
		return deadline;
	}

}
