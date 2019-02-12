// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 12/8/2016
// Filename: Program13.java

import java.util.Scanner; // We need this for user input

public class Program13 {
   
   //Allows the Scanner class to be accessed in all methods
   static Scanner in = new Scanner(System.in);
   
   // The starting point for the program. This method
   // calls on the other methods as needed. 
   // Handles overall flow of the program.
   public static void main(String[] args) {
      
      System.out.print("How many lockers? ");
      int lockers = in.nextInt();
      System.out.print("Show stages? (y/n)");
      String response = in.next();
      
      boolean[] lockArr = new boolean[lockers];
      int count = 0;
      for(int j = 1; j<=lockers; j++){
         count = 0;
      for(boolean element: lockArr){
         if((count+1)%j == 0){
            if(element == true)
               lockArr[count] = false;
            else if(element == false)
               lockArr[count] = true;
         }
            count++;
         }
      if(response.equals("y")){
            for(int i = 0; i<lockers;i++){
            if(lockArr[i] == true)
               System.out.print("O");
            else if(lockArr[i] == false)
               System.out.print("-");
            if(i== lockers-1)
               System.out.println();
         }
      }
   }
      toString(lockers, lockArr);
   }
   
   // Displays a String that tells which lockers are open
    public static void toString(int lockers, boolean[] lockArr){
       System.out.print("Open: ");
       String result = "";
       for(int i = 0; i<lockers;i++){
          if(lockArr[i] == true)
             result = result + (i+1) + ", ";
      }
       result = result.substring(0,result.length()-2);
       System.out.println(result);
   }
}
   
   
   


         
