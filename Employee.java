import java.text.NumberFormat;

public class Employee {
		
    private String employeeIDNumber;
    private String employeeFirstName;
    private String employeeLastName;
    private int employeeAge;
    private double employeeWagePerHour;
    private double employeeHoursWorked;
    private String employeeStartDate;

    public Employee() {
        final double DEFAULT_WAGE = 15.00;
        setWage(DEFAULT_WAGE);
    }

    public Employee(double wage) {
        setWage(wage);
    }

    public void setIDNumber(String employeeIDNumber) {
        this.employeeIDNumber = employeeIDNumber;
    }

    public String getIDNumber() {
        return employeeIDNumber;
    }

    public void setFirstName(String name){
        employeeFirstName = name;
    }
    
    public String getFirstName() {
        return employeeFirstName;
    }
    
    public void setLastName(String lastName) {
        employeeLastName = lastName;
    }
    
    public String getLastName() {
        return employeeLastName;
    }
    
    public void setAge(int age) {
        employeeAge = age;
    }
    
    public int getAge() {
        return employeeAge;
    }
    
    public void setWage(double wage) {
        employeeWagePerHour = wage;
    }
    
    public double getWage() {
        return employeeWagePerHour;
    }

    public void setHoursWorked(double hours) {
        employeeHoursWorked = hours;
    }

    public double getHoursWorked() {
        return employeeHoursWorked;
    }
    
    public void setStartDate(String startDate) {
        employeeStartDate = startDate;
    }
    
    public String getStartDate() {
        return employeeStartDate;
    }
	
	public void printInfo() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Employee ID: " + employeeIDNumber);
		System.out.println("Employee first name: " + employeeFirstName);
		System.out.println("Employee last name: " + employeeLastName);
        System.out.println("Employee age: " + employeeAge);
        System.out.println("Employee start date: " + employeeStartDate);
        System.out.println("\nEmployee wage per hour: " + formatter.format(employeeWagePerHour));
        System.out.println("Employee hours worked: " + employeeHoursWorked);
		
    }
	
}
