// Andrew Sousa
// 7/14/24
// CS 145
// Programming Assignment 4: Payment System Heirarchy
// HourlyEmployee.java

// HourlyEmployee.java is a class that contains and calculates all informaiton for an hourly employee
// (first name, last name, social security number, birth date, wage, hours)
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours; 
 
    // parameters:  (1) firstName (String): employee's first name
    //              (2) lastName (String): employee's last name
    //              (3) socialSecurityNumber: employee's social security number
    //              (4) month (int): employee's birth month
    //              (5) day (int): employee's birth day
    //              (6) year (int): employee's birth year
    //              (7) wage (double): employee's hourly wage
    //              (8) hours (double): employee's hours worked per week
    // NOTE: parameters (1), (2), (3), (4), (5), (6) are constructed from the Employee superclass
    // NOTE: if wage and hours are not postitive numbers, an IllegalArgumentException is thrown
    public HourlyEmployee(String firstName, String lastName,
       String socialSecurityNumber, int month, int day, int year, 
       double wage, double hours) {
       super(firstName, lastName, socialSecurityNumber, month, day, year);
 
       if (wage < 0.0) {
          throw new IllegalArgumentException(
             "Hourly wage must be >= 0.0");
       }
 
       if ((hours < 0.0) || (hours > 168.0)) {
          throw new IllegalArgumentException(
             "Hours worked must be >= 0.0 and <= 168.0");
       }
 
       this.wage = wage;
       this.hours = hours;
    } 
 
    
    // method: setWage (void)
    // purpose: sets the employee's wage
    // parameters:  (1) wage (double): employee's new wage
    // NOTE: if wage is less than 0, an IllegalArgumentException is thrown
    public void setWage(double wage) {
       if (wage < 0.0) { // validate wage
          throw new IllegalArgumentException(
             "Hourly wage must be >= 0.0");
       }
 
       this.wage = wage;
    } 
 
    
    // method: getWage (double)
    // purpose: returns the employee's wage
    // parameters: none
    public double getWage() {
       return wage;
    } 
 
    
    // method: setHours (void)
    // purpose: sets the employee's hours
    // parameters:  (1) hours (double): employee's new hours
    // NOTE: if hours is less than 0, an IllegalArgumentException is thrown
    public void setHours(double hours) {
       if ((hours < 0.0) || (hours > 168.0)) {
          throw new IllegalArgumentException(
             "Hours worked must be >= 0.0 and <= 168.0");
       }
 
       this.hours = hours;
    } 
 
    
    // method: getHours (double)
    // purpose: returns the employee's hours
    // parameters: none
    public double getHours() {
       return hours;
    } 
    
 
    // method: earnings (double)
    // purpose: calculates and returns the emloyee's total earnings
    // parameters: none
    // NOTE: wage is calculated wage * hours. If hours exceeds 40, hours worked beyond 40 earn wage * 1.5 per hour
    // NOTE: overrides earnings method from Employee.java 
    @Override                                                           
    public double earnings() {                                            
       if (getHours() <= 40) {                     
          return getWage() * getHours();   
       }
       else {                                                             
          return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
       }
    }                                          
 

    // method: toString (String)
    // purpose: condenses the employee's information into a single string and returns it
    // parameters: none
    // NOTE: overrides toString method from Employee.java       
    @Override                                                             
    public String toString() {                                              
       return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
          super.toString(), "hourly wage", getWage(),                     
          "hours worked", getHours());                                   
    }  
                                      
 }
 
 

 
