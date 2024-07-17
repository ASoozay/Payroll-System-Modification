// Andrew Sousa
// 7/14/24
// CS 145
// Programming Assignment 4: Payment System Heirarchy
// CommissionEmployee.java

// CommissionEmployee.java is a class that contains and calculates all informaiton for a commission employee
// (first name, last name, social security number, birth date, gross sales, commission rate)
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------

public class CommissionEmployee extends Employee { 
    private double grossSales; 
    private double commissionRate; 
 
    // method: CommissionEmployee (no return type)
    // purpose: constructs the CommissionEmployee object
    // parameters:  (1) firstName (String): employee's first name
    //              (2) lastName (String): employee's last name
    //              (3) socialSecurityNumber: employee's social security number
    //              (4) month (int): employee's birth month
    //              (5) day (int): employee's birth day
    //              (6) year (int): employee's birth year
    //              (7) grossSales (double): employee's gross sales
    //              (8) commissionRate (double): employee's commission rate
    // NOTE: parameters (1), (2), (3), (4), (5), (6) are constructed from the Employee superclass
    // NOTE: if grossSales and commissionRate are not postitive numbers, an IllegalArgumentException is thrown
    public CommissionEmployee(String firstName, String lastName, 
       String socialSecurityNumber, int month, int day, int year, 
       double grossSales, double commissionRate) {
       super(firstName, lastName, socialSecurityNumber, month, day, year);
 
       if (commissionRate <= 0.0 || commissionRate >= 1.0) {
          throw new IllegalArgumentException(
             "Commission rate must be > 0.0 and < 1.0");
       }
 
       if (grossSales < 0.0) {
          throw new IllegalArgumentException("Gross sales must be >= 0.0");
       }
 
       this.grossSales = grossSales;
       this.commissionRate = commissionRate;
    } 
 

    // method: setGrossSales (void)
    // purpose: sets the employee's gross sales
    // parameters:  (1) grossSales (double): employee's new gross sales amount
    public void setGrossSales(double grossSales) {
       if (grossSales < 0.0) { // validate
          throw new IllegalArgumentException("Gross sales must be >= 0.0");
       }
 
       this.grossSales = grossSales;
    } 
 

    // method: getGrossSales (double)
    // purpose: returns the employee's gross sales amount
    // parameters: none
    public double getGrossSales() {
       return grossSales;
    } 
 

    // method: setCommissionRate (void)
    // purpose: sets the employee's commission rate
    // parameters:  (1) commissionRate (double) 
    public void setCommissionRate(double commissionRate) {
       if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
          throw new IllegalArgumentException(
             "Commission rate must be > 0.0 and < 1.0");
       }
 
       this.commissionRate = commissionRate;
    } 
 

    // method: getCommissionRate (double)
    // purpose: returns the employee's commission rate
    // parameters: none
    public double getCommissionRate() {
       return commissionRate;
    } 
 

    // method: earnings (double)
    // purpose: calculates and returns the employee's total earnings
    // parameters: none
    // NOTE: overrides earnings method in Employee.java
    @Override                                                           
    public double earnings() {                                            
       return getCommissionRate() * getGrossSales();                    
    }                                             
 

    // method: toString (String)
    // purpose: condenses employee's information into a single string and returns it
    // parameters: none
    // NOTE: overrides toString method from Employee.java
    @Override                                                   
    public String toString() {                                    
       return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",    
          "commission employee", super.toString(),              
          "gross sales", getGrossSales(),                       
          "commission rate", getCommissionRate());             
    } 

 }
 

 
