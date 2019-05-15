import java.util.Scanner;
import java.text.NumberFormat;

public class EmployeeTest {

public static void main(String [] args) {
    final int SIZE = 10;
    final int REGULAR = 1;
    Employee[] employees = new Employee [SIZE];
    CommissionEmployee[] commissionEmployees = new CommissionEmployee [SIZE];
    int sub;
    int amount;
    int employeeType;

    employeeType = getEmployeeType();

    System.out.print("\nPlease enter the number of employees you wish to enter information for: ");
    amount = getInt();

    sub = 0;

        
    if (employeeType == REGULAR) {
    while (sub < amount) {
        employees[sub] = getEmployeeInfo();
        System.out.print("\n");
        sub++;
    }
    displayEmployees(employees, amount);
    
    } 
    else {
        while (sub < amount) {
            commissionEmployees[sub] = getCommissionInfo();
            System.out.print("\n");
            sub++;
        }
        displayCommissionEmployees(commissionEmployees, amount);
        
    } 
}

    public static Employee getEmployeeInfo() {
        String idNumber;
        String name;
        String lastName;
        int age;
        double wage;
        String startDate;
        double hoursWorked;

        System.out.print("\nPlease enter the next employee's ID number: ");
        idNumber = getInput();
        
        System.out.print("Please enter the employee's first name: ");
        name = getInput();

        System.out.print("Please enter the employee's last name: ");
        lastName = getInput();

        System.out.print("Please enter the employee's age: ");
        age = getInt();

        System.out.print("Please enter the employee's start date: ");
        startDate = getInput();

        System.out.print("Please enter the employee's wage per hour: ");
        wage = getDouble();

        System.out.print("Please enter the employee's hours worked: ");
        hoursWorked = getDouble();


        Employee emp = new Employee(wage);
        emp.setIDNumber(idNumber);
        emp.setFirstName(name);
        emp.setLastName(lastName);
        emp.setAge(age);
        emp.setHoursWorked(hoursWorked);
        emp.setStartDate(startDate);


        return emp;

    }

    public static CommissionEmployee getCommissionInfo() {
        double commissionRate;
        String idNumber;
        String name;
        String lastName;
        int age;
        double wage;
        double hoursWorked;
        double salesRevenue;
        String startDate;


        System.out.print("\nPlease enter the next employee's ID number: ");
        idNumber = getInput();
        
        System.out.print("Please enter the employee's first name: ");
        name = getInput();

        System.out.print("Please enter the employee's last name: ");
        lastName = getInput();

        System.out.print("Please enter the employee's age: ");
        age = getInt();

        System.out.print("Please enter the employee's start date: ");
        startDate = getInput();

        System.out.print("Please enter the employee's wage per hour: ");
        wage = getDouble();

        System.out.print("Please enter the employee's hours worked: ");
        hoursWorked = getDouble();

        System.out.print("Please enter the employee's commission rate percentage: ");
        commissionRate = getDouble();

        System.out.print("Please enter the employee's sales revenue: ");
        salesRevenue = getDouble();

        CommissionEmployee emp = new CommissionEmployee();
        emp.setIDNumber(idNumber);
        emp.setFirstName(name);
        emp.setLastName(lastName);
        emp.setAge(age);
        emp.setWage(wage);
        emp.setHoursWorked(hoursWorked);
        emp.setSalesRevenue(salesRevenue);
        emp.setStartDate(startDate);
        emp.setCommissionRate(commissionRate);

        return emp;
    }

    public static void createPaycheck(Employee[] employees, int amount, int x) {
        double wage;
        double hours;
        
        wage = employees[x].getWage();
        hours = employees[x].getHoursWorked();
        PaycheckGenerator paycheck = new PaycheckGenerator(wage, hours);
        paycheck.calculatePaycheck();
        paycheck.displayPaycheck();
    }

    public static void createPaycheck(CommissionEmployee[] commissionEmployees, int amount, int x) {
        double wage;
        double hours;
        double commission;
        double revenue;
        
        wage = commissionEmployees[x].getWage();
        hours = commissionEmployees[x].getHoursWorked();
        commission = commissionEmployees[x].getCommissionRate();
        revenue = commissionEmployees[x].getSalesRevenue();
        PaycheckGenerator paycheck = new PaycheckGenerator(wage, hours, commission, revenue);
        paycheck.calculatePaycheck();
        paycheck.displayPaycheck();
    }

    public static void displayEmployees(Employee[] employees, int amount) {
        int x;

        x = 0;
        
        while (x < amount) {

            System.out.println("\n");
            System.out.println("Here is " + employees[x].getFirstName() + " " + employees[x].getLastName() + "'s information:");
            System.out.print("\n");
            employees[x].printInfo();
            System.out.println("\n");
            System.out.println("Paycheck information:");
            createPaycheck(employees, amount, x);

            x++;
        
        }
	
    }

    public static void displayCommissionEmployees(CommissionEmployee[] commissionEmployees, int amount) {
        int x;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        x = 0;
        
        while (x < amount) {

            System.out.println("\n");
            System.out.println("Here is " + commissionEmployees[x].getFirstName() + " " + commissionEmployees[x].getLastName() + "'s information:");
            System.out.println("\n");
            commissionEmployees[x].printInfo();
            System.out.println("Employee commission rate: " + commissionEmployees[x].getCommissionRate() + "%");
            System.out.println("Employee sales revenue: " + formatter.format(commissionEmployees[x].getSalesRevenue()));
            System.out.println("\n");
            System.out.println("Paycheck information:");
            createPaycheck(commissionEmployees, amount, x);

            x++;
        
        }
	
    }

    public static String getResponse() {
        Scanner keyboardInput = new Scanner(System.in);
        return keyboardInput.next();
    }


    public static String getInput() {
        Scanner keyboardInput = new Scanner(System.in);
		return keyboardInput.nextLine();
    }

    public static int getInt() {
        Scanner keyboardInput = new Scanner(System.in);
        return keyboardInput.nextInt();
    }

    public static double getDouble() {
        Scanner keyboardInput = new Scanner(System.in);
        return keyboardInput.nextDouble();
    }

    public static int getEmployeeType() {
        final int REGULAR = 1;
        final int COMMISSION = 2;
        int employeeType;
        System.out.print("Please enter the type of employee you will enter data for( " + REGULAR + " for regular or " + COMMISSION + " for commission): ");
        employeeType = getInt();
        return employeeType;
    }
}