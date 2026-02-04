package lab1; 

public class Run {
    public static void main(String args[]) {
    	
        DeadlineManager dm = new DeadlineManager(new Date(16, 1)); //invokes a constructor parameter: date object
        dm.addTask(new Task("F27SB Lab 2", new Date(3, 2)));
        dm.addTask(new Task("F27SB Lab 1", new Date(23, 1)));
        dm.addTask(new Task("F27SB Coursework 1", new Date(20, 2)));
        dm.addRecurringTask(new Task("Weekly test", new Date(5,12)), 10, 5);
        dm.printTasks();
    }
}
