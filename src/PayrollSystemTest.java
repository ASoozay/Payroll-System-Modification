// Andrew Sousa
// 7/14/24
// CS 145
// Programming Assignment 4: Payment System Heirarchy
// PayrollSystemTest.java

//PayrollSystemTest.java is a class where the user can test the different employee's and run a test of a payroll. 
// One kind of each employee is already created, and the program contains a test where payroll is calculated both individually and polymorphically
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements"
//-------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee(
         "John", "Smith", "111-11-1111", 6, 15, 1944, 800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee(
         "Karen", "Price", "222-22-2222", 12, 29, 1960, 16.75, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee(
         "Sue", "Jones", "333-33-3333", 9, 8, 1954, 10000, .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee(
         "Bob", "Lewis", "444-44-4444", 3, 2, 1965, 5000, .04, 300);

      System.out.println("Employees processed individually:\n");
      
      System.out.printf("%s\n%s: $%,.2f\n\n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s\n%s: $%,.2f\n\n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      Scanner input = new Scanner(System.in); // to get current month
      int currentMonth;

      // get and validate current month
      do {
         System.out.print("Enter the current month (1 - 12): ");
         currentMonth = input.nextInt();
         System.out.println();
      } while ((currentMonth < 1) || (currentMonth > 12));

      System.out.println("Employees processed polymorphically:\n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) {
            // downcast Employee reference to 
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = 
               (BasePlusCommissionEmployee) currentEmployee;

            double oldBaseSalary = employee.getBaseSalary();
            employee.setBaseSalary(1.10 * oldBaseSalary);
            System.out.printf(
               "new base salary with 10%% increase is: $%,.2f\n",
               employee.getBaseSalary());
         }

         // if month of employee's birthday, add $100 to salary
         if (currentMonth == currentEmployee.getBirthDate().getMonth()) {
            System.out.printf(
               "earned $%,.2f %s\n\n", currentEmployee.earnings(), 
               "plus $100.00 birthday bonus");
         }
         else {
            System.out.printf(
               "earned $%,.2f\n\n", currentEmployee.earnings());
         }
      }

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++) {
         System.out.printf("Employee %d is a %s\n", j, 
            employees[j].getClass().getName()); 
      }

   }
}


