// Andrew Soozay
// 7/14/24
// Date.java

// Date.java is a class that contains all the employee's birth information (birth day, birth month, birth year)
// NOTE: code is taken from Pearson's "Building Java Programs: Supplements", with some small alterations 
//-------------------------------------------------------------------------------------------------------------------------------------------

public class Date {
    private int month;
    private int day;
    private int year;
    private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    // method: Date (no return type)
    // purpose: constructs the Date object
    // parameters:  (1) month (int): employee's birth month
    //              (2) day (int): employee's birth day
    //              (3) year (int): employee's birth year
    public Date (int month, int day, int year){
        if (month <= 0 || month > 12){
            throw new IllegalArgumentException("Month must be between 1-12.");
        }

        if(day <= 0 || day > daysPerMonth[month] && !(month == 2 && day == 29)){
            throw new IllegalArgumentException("day (" + day +") out-of-range for the specified month and year");
        }

        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("day (" + day +") out-of-range for the specified month and year");
      }

      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date object constructor for date %s%n", this);
    }
    
    
    // method: getMonth (int)
    // purpose: returns the employee's birth month
    // parameters: none
    public int getMonth(){
        return month;
    }


    // method: getDay (int)
    // purpose: returns the employee's birth day
    // parameters: none
    public int getDay(){
        return day;
    }

    
    // method: getYear (int)
    // purpose: returns the employee's birth year
    // parameters: none
    public int getYear(){
        return year;
    }

    
    // method: toString (String)
    // purpose: condenses the employee's birth information into a single string and returns it
    // parameters: none
    public String toString() {
        return String.format("%d/%d/%d", month, day, year); 
    } 

}
