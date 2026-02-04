 package lab1;
public class Date {
	//fields
	private int day;
	private int month;
	
	//getters
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	private static final int[] daysOfMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	//constructors
	public Date(int day, int month) {
		if (month < 1 ||  month > 12) {
			throw new IllegalArgumentException("Invalid Month");
		} 
		this.month = month;
		
		if (day < 1 || day > daysOfMonths[month-1]) {
			throw new IllegalArgumentException("Invalid Day");
		} 
		this.day = day;
		

		
	}
	//dayofyear
	public int getDayOfYear() {
		int total = 0; //variable
		for (int i = 0; i < month - 1; i++) //goes through each month. i < month - 1 indicates the month prior to the one here
			total += daysOfMonths[i]; //and then adds for example if it is mar 3: jan has 31 days: 0+31 = 31. feb has 28 days so 31+28 = 59
		//and like mar is third month so month - 1: it stops at feb i think 
		
		
		return total + getDay(); //so now we have total = 59 and getDay returns the current day so like mar 3 would mean 59+3= 62
	}
	//daysuntil
	public int daysUntil(Date d) {
		return d.getDayOfYear() - this.getDayOfYear(); 
	}
	
	//tostring
	public String toString() {
		String day = Integer.toString(getDay());	//stringify the integer 
		String month = Integer.toString(getMonth());
	
	if(getDay() < 10) {	//this condition is for when the date starts with a double digit so like: 01/01/2026
		day= "0" + day;	//since 1/1/2026 can also be written 01/01/2026 and 1 < 10, add 0 before the single digit
	}
	if (getMonth() < 10) {	//the same goes for month
		month = "0" + month;
	}
	
		return (day+ "/" + month + "/" + "2026");
	}
	
	public Date (int DayOfYear) {//this is basically the opposite of getDayOfYear
	
		if (DayOfYear < 1 || DayOfYear > 365) {
			throw new IllegalArgumentException ("invalid day of the year");
		}
		int remaining = DayOfYear; //counting remaining days
		int month = 1; //count starts from 1
		
		for (int i = 0; i < daysOfMonths.length; i++) { //goes from jan through dec 
			if (remaining > daysOfMonths[i]) {
				remaining -= daysOfMonths[i];
				month++;
			}
			else {	//Stop when remaining ≤ days in the current month → that remaining number = day of the month
				break;
			}
			
		}
		this.day = remaining;
		this.month = month;
	}
	



} 
