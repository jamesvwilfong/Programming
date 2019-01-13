// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 10/29/2016
// Filename: Program8.java

import java.util.Scanner; // We need this for user input
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Program8 {
   
   // Globalized variables
   static String date = getDate();
   static int year = parseYear(date);
   static int month = parseMonth(date);
   static int day = parseDay(date);
   static boolean leap = isLeapYear(year);
   
   // The starting point for the program. This method
   // calls on the other twelve methods as needed
   public static void main(String[] args) {
      
      if(isValid(month,day,year) == true) {
         System.out.println(dateString(month, day, year));
         System.out.println("Days in " + getMonthName(month) + ", " 
                               + year + ": " + daysInMonth(leap,month));
         System.out.println("Days remaining in " + year + ": " 
                               + daysRemaining(month,day,year));
         if(leap == true)
            System.out.println("Leap year: yes");
         else
            System.out.println("Leap year: no");
         System.out.println("Next Day: " +nextDateString(month,day,year));
      }
      else
         System.out.println("This is not a valid date.");
      
   }
   
   // Returns user input for date
   public static String getDate() {
      Scanner keyboardReader = new Scanner(System.in); 
      System.out.print("Enter a date: ");
      return keyboardReader.nextLine();
   }
   
   // Takes a date and returns the number corresponding to the month
   public static int parseMonth(String date) {
      return Integer.parseInt(date.substring(0, date.indexOf("-")));
   }
   
   // Takes a date and returns the number corresponding to the day
   public static int parseDay(String date) {
      return Integer.parseInt(date.substring(date.indexOf("-")+1,date.lastIndexOf("-")));
   }
   
   // Takes a date and returns the number corresponding to the year
   public static int parseYear(String date) {
      return Integer.parseInt(date.substring(date.lastIndexOf("-")+1));
   }
   
   // Takes a year and determines whether it is a leap year
   public static boolean isLeapYear(int year) {
      return (year % 4 == 0 && year % 100 != 0 || 
              year % 4 == 0 && year % 100 == 0 && year % 400 == 0);
   }
   
   // Takes a boolean flag indicating whether a year is a leap year
   // along with a month, and returns the number of days in that month
   // Returns -1 if month is not in the range 1 to 12
   public static int daysInMonth(boolean leap, int month) {
      if(leap == true && month == 2)
         return 29;
      else if(leap == false && month == 2)
         return 28;
      else if(month == 4 || month == 6 || month == 9 || month == 11)
         return 30;
      else if(month == 1 || month == 3 || month == 5 || month == 7 ||
              month == 8 || month == 10 || month == 12)
         return 31;
      else
         return -1;
   }
   
   // Takes a month, day, and year, and returns true if the numbers
   // correspond to a valid date, and false otherwise
   public static boolean isValid(int month, int day, int year) {
      if(month<1 || month>12)
         return false;
      else if(isLeapYear(year) == true && month == 2 && (day<1 || day>29))
         return false;
      else if(isLeapYear(year) == false && month == 2 && (day<1 || day>28))
         return false;
      else if((month == 4 || month == 6 || month == 9 || month == 11) 
                 && (day<1 || day>30))
         return false;
      else if((month == 1 || month == 3 || month == 5 || month == 7 ||
               month == 8 || month == 10 || month == 12) && (day<1 || day>31))
         return false;
      else if(year<1600)
         return false;
      else
         return true;
   }
   
   // Takes a month, day, and year, and returns the number of days
   // remaining in the year, including the specified day
   // Returns -1 if date is not valid
   public static int daysRemaining(int month, int day, int year) {
      if(isValid(month,day,year) == true) {
         for(int i = 1; i<month; i++)
            day = day + daysInMonth(isLeapYear(year),i);
         if(isLeapYear(year) == true)
            return 367 - day;
         else 
            return 366 - day;
      }
      else
         return -1;
   }
   
   // Takes a month, day, and year, and returns an int 
   // corresponding to the day of the week
   // Returns -1 if date is not valid
   // http://www.java2s.com/Tutorials/Java/Java_Date_Time/0050__Java_Year_Month_Day.htm
   public static int dayOfWeek(int month, int day, int year) {
      LocalDate localDate  = LocalDate.of(year, month, day);
      DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
      if(isValid(month,day,year) == true) {
         if(dayOfWeek.getValue() == 7)
            return 0;
         else
            return dayOfWeek.getValue();
      }
      else
         return -1;
   }
   
   // Takes an integer for a day, and returns 
   // the name of the corresponding day
   // Returns ERROR if day is outside the range 0 to 6
   public static String getDayName(int day) {
      String dayName = "";
      switch(dayOfWeek(month,day,year)) {
         case 0:
            dayName = "Sunday";
            break;
         case 1:
            dayName = "Monday";
            break;
         case 2:
            dayName = "Tuesday";
            break;
         case 3:
            dayName = "Wednesday";
            break;
         case 4:
            dayName = "Thursday";
            break;
         case 5:
            dayName = "Friday";
            break;
         case 6:
            dayName = "Saturday";
            break;
         default:
            dayName = "ERROR";
      }
      return dayName;    
   }
   
   // Takes an integer for a month, and returns the 
   // name of the corresponding month
   // Returns ERROR if month is outside the range 1 to 12
   public static String getMonthName(int month) {
      switch(month) {
         case 1:
            return "January";   
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";
         default:
            return "ERROR";
      }
   }
   
   // Takes a month, day, and year, and returns a String representation
   // of the correponding date
   // Returns ERROR if date is not valid
   public static String dateString(int month, int day, int year) {
      if(isValid(month,day,year) == true) 
         return getDayName(day) + ", " + getMonthName(month) 
         + " " + day + ", " + year;
      else
         return "ERROR";
   }
   
   // Takes a month, day, and year, and returns a String representation
   // of the next corresponding date
   // Returns ERROR if date is not valid
   public static String nextDateString(int month, int day, int year) {
      if(isValid(month,day,year) == true){
         
         String nextDay = "";
         String nextMonth = "";
         
         if(daysRemaining(month,day,year) == 1)
            year += 1;
         else
            year = year;
         
         if(getDayName(day).equals("Saturday"))
            nextDay = "Sunday";
         else if (getDayName(day).equals("Sunday"))
            nextDay = "Monday";
         else if (getDayName(day).equals("Monday"))
            nextDay = "Tuesday";
         else if (getDayName(day).equals("Tuesday"))
            nextDay = "Wednesday";
         else if (getDayName(day).equals("Wednesday"))
            nextDay = "Thursday";
         else if (getDayName(day).equals("Thursday"))
            nextDay = "Friday";
         else if (getDayName(day).equals("Friday"))
            nextDay = "Saturday";
         
         if(day == daysInMonth(leap,month)) {
            day = 1;
            if(month == 12)
               nextMonth = getMonthName(1);
            else
               nextMonth = getMonthName(month+1);
         }
         else {
            day +=1;
            nextMonth = getMonthName(month);
         }
         
         
         return  nextDay + ", " + nextMonth + " " + day + ", " + year;     
      }
      else
         return "ERROR";
   }  
}


