 package lab1;

import java.util.ArrayList;


public class DeadlineManager {
	private Date currentdate;
	private ArrayList<Task> tasks;
	

	//getters
	public Date getDate() {
		return currentdate;
	}
	
	public ArrayList<Task> getTasks(){
		return tasks;
	}
	
	//constructor
	public DeadlineManager(Date d) {
		this.currentdate = d;
		tasks = new ArrayList<Task>();
		
	}
	//addtask
	public void addTask(Task t) {
		tasks.add(t);
		
	}
	//printtasks
	public void printTasks() {
		int count = 1;
		for (Task t: tasks) {
			System.out.println("Task "+ count +":");
			System.out.println("Name: "+t.getName());
			
			String deadlineStr = t.getDeadline().toString();
			int daysLeft = currentdate.daysUntil(t.getDeadline());
			
			//print
			System.out.println("Deadline: "+ deadlineStr + "--"+ daysLeft + "  days left!!");
			System.out.println("-----");
			count++;
		}
		
	}
	//recurring tasks: basically like a reminder. how it works?
	//t -> original reminder (reminder task; eg: "Workout on jan 10")
	//period -> how often it repeats (eg: every 7 days)
	//iters -> how many reminders you want (eg: 5 times a week)
	public void addRecurringTask(Task t, int period, int iters) { //takes three arguments
		int startday = t.getDeadline().getDayOfYear(); //note getDayOfYear returns the number of the date 
		
		for (int i = 0; i<iters; i++ ) {//checks condition that i is lesser than "the number of reminders (recurring task)"
			int newDayOfYear = startday + i * period;
			if (newDayOfYear > 365) break;
				//period is basically the number of days between the recurring task
			
			Date newDate = new Date(newDayOfYear);
			String newName = t.getName() + " [" + (i+1) + "]";	//prints task name along with the number of the ith time it repeated
			
			Task newTask = new Task (newName, newDate);
			tasks.add(newTask);
			
		}
		
	}

}
