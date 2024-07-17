// Andrew Sousa
// 7/14/24
// CS 145
// Programming Assignment 4: Payment System Heirarchy
// BasePlusCommissionEmployee.java

// BasePlusCommissionEmployee.java is a class that contains and calculates information for base + commission employees 
// (first name, last name, social security number, birth date, base salary, commission)
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------

public class BasePlusCommissionEmployee extends CommissionEmployee { 
    private double baseSalary; // base salary per week
 
    // method: BasePlusCommissionEmployee (no return type)
    // purpose: constructs the BasePlusCommissionEmployee object
    // parameters:  (1) firstName (String): employee's first name
    //              (2) lastName (String): employee's last name
    //              (3) socialSecurityNumber: employee's social security number
    //              (4) month (int): employee's birth month
    //              (5) day (int): employee's birth day
    //              (6) year (int): employee's birth year
    //              (7) grossSales (double): employee's gross sales
    //              (8) commissionRate (double): employee's commission rate
    //              (9) baseSalary (double): employee's base salary, separate from any commissions
    // NOTE: parameters (1), (2), (3), (4), (5), (6), (7), (8) are constructed from the CommissionEmployee.java superclass
    // NOTE: if baseSalary is less than 0, an IllegalArgumentException will be thrown.
    public BasePlusCommissionEmployee(String firstName, String lastName, 
       String socialSecurityNumber, int month, int day, int year, 
       double grossSales, double commissionRate, double baseSalary) {
       super(firstName, lastName, socialSecurityNumber, 
          month, day, year, grossSales, commissionRate);
 
       if (baseSalary < 0.0) {                  
          throw new IllegalArgumentException("Base salary must be >= 0.0");
       }
 
       this.baseSalary = baseSalary;                
    }
 

    // method: setBaseSalary (void)
    // purpose: sets the employee's base salary
    // parameters:  (1) baseSalary (double): employee's new base salary
    public void setBaseSalary(double baseSalary) {
       if (baseSalary < 0.0) {              
          throw new IllegalArgumentException("Base salary must be >= 0.0");
       }
 
       this.baseSalary = baseSalary;                
    } 
 
    // method: getBaseSalary (double)
    // purpose: returns the employee's base salary
    // parameters: none
    public double getBaseSalary() {
       return baseSalary;
    }
 
    // method: earnings (double)
    // purpose: calculates and returns employee's total earnings (base salary + money from commissions)
    // parameters: none
    // NOTE: overrides earnings method from CommissionEmployee
    @Override                                                            
    public double earnings() {                                             
       return getBaseSalary() + super.earnings();                        
    } 
 
    // method: toString (String)
    // purpose: condenses employee's information into a single string and returns it
    // parameters: none
    // NOTE: overrides toString method from CommissionEmployee.java
    @Override                                                           
    public String toString() {                                            
       return String.format("%s %s; %s: $%,.2f",                       
          "base-salaried", super.toString(),                            
          "base salary", getBaseSalary());                             
    } 
    
 }
 
 
