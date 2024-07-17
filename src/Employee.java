// Andrew Sousa
// 7/14/24
// CS 145
// Programming Assignment 4: Payment System Heirarchy
// Employee.java

// Employee.java is a class that contains information that all employees have (first name, last name, social security number, date of birth), 
// and methods to get them.
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------


public abstract class Employee  {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Date birthDate;
 
    // method: Employee (no return type)
    // purpose: constructs the Employee object
    // parameters:  (1) firstName (String): employee's first name
    //              (2) lastName (String): employee's last name
    //              (3) socialSecurityNumber (String): employee's social security number
    //              (4) month (int): employee's month of birth;
    //              (5) day (int): employee's day of birth
    //              (6) year (int): employee's year of birth
    public Employee(String firstName, String lastName, 
       String socialSecurityNumber, int month, int day, int year) {
       this.firstName = firstName;                                    
       this.lastName = lastName;                                    
       this.socialSecurityNumber = socialSecurityNumber;         
       birthDate = new Date(month, day, year);
    } 
 
    // method: getFirstName (String)
    // purpose: returns the employee's first name
    // paramters: none
    public String getFirstName() {
       return firstName;
    } 
 
    // method: getLastName (String)
    // purpose: returns the employee's last name
    // paramters: none
    public String getLastName() {
       return lastName;
    } 
 
    // method: getSocialSecurityNumber (String)
    // purpose: returns the employee's social security number
    // paramters: none
    public String getSocialSecurityNumber() {
       return socialSecurityNumber;
    } 
 
    // method: getBirthDate (Date)
    // purpose: returns the employee's birth date
    // paramters: none
    public Date getBirthDate() {
       return birthDate;
    } 
 
    // method: toString (String)
    // purpose: condenses employee's information into a single string, and returns it
    // methods: none
    @Override
    public String toString() {
       return String.format("%s %s\n%s: %s\n%s: %s", 
          getFirstName(), getLastName(), 
          "social security number", getSocialSecurityNumber(), 
          "birth date", getBirthDate());
    } 
 
    // method: earnings (double)
    // purpose: abstract method for other classes to use, calculates emloyee's total earnings
    // paramters: none
    public abstract double earnings(); // no implementation here
 } 
 
 

 
