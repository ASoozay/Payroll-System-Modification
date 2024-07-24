// Andrew Soozay
// 7/14/24
// SalariedEmployee.java

// SalariedEmployee.java is a class that contains and calculates all informaiton for a salaried employee
// (first name, last name, social security number, birth date, weekly salary)
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------

public class SalariedEmployee extends Employee  {
    private double weeklySalary;
 
    // method: SalariedEmployee (no return type)
    // purpose: constructs the SalariedEmployee object
    // parameters:  (1) firstName (String): employee's first name
    //              (2) lastName (String): employee's last name
    //              (3) socialSecurityNumber: employee's social security number
    //              (4) month (int): employee's birth month
    //              (5) day (int): employee's birth day
    //              (6) year (int): employee's birth year
    //              (7) weeklySalary (double): employee's weekly salary
    // NOTE: parameters (1), (2), (3), (4), (5), (6) are constructed from the Employee superclass
    // NOTE: if weeklySalary is less than 0, an IllegalArgumentException is thrown
    public SalariedEmployee(String firstName, String lastName, 
       String socialSecurityNumber, int month, int day, int year, 
       double weeklySalary) {
       super(firstName, lastName, socialSecurityNumber, month, day, year); 
 
       if (weeklySalary < 0.0) {
          throw new IllegalArgumentException(
             "Weekly salary must be >= 0.0");
       }
 
       this.weeklySalary = weeklySalary;
    } 
 

    // method: setWeeklySalary (void)
    // purpose: sets the employee's weekly salary
    // parameters:  (1) weeklySalary (double): employee's new salary
    // NOTE: if weekly salary is less tha 0, an IllegalArgumentException is thrown
    public void setWeeklySalary(double weeklySalary) {
       if (weeklySalary < 0.0) {
          throw new IllegalArgumentException(
             "Weekly salary must be >= 0.0");
       }
 
       this.weeklySalary = weeklySalary;
    } 
 
   
    // method: getWeeklySalary (double)
    // purpose: returns the employee's weekly salary
    // parameters: none
    public double getWeeklySalary() {
       return weeklySalary;
    } 
 
   
    // method: earnings (double)
    // purpose: calculates the employee's total earnings (weekly salary)
    // parameters: none
    // NOTE: overrides the earnings method from Employee.java
    @Override                                                         
    public double earnings() {                                          
       return getWeeklySalary();                                        
    }                                             
 
    // method: toString (String)
    // purpose: condenses the employee's information into a single string and returns it
    // parameters: none
    // NOTE: overrides the toString method from Employee.java
    @Override                                                    
    public String toString() {                                     
       return String.format("salaried employee: %s%n%s: $%,.2f",
          super.toString(), "weekly salary", getWeeklySalary());
    } 
    
 }
 

 
