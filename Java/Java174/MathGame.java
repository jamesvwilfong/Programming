// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 10/8/2016
// Filename: MathGame.java

import java.util.Scanner; // We need this for user input
import java.util.Date; // We need this to compute elapsed time

public class MathGame {
   
   public static void main(String[] args) {
      
      Scanner keyboardReader = new Scanner(System.in);
      // mult stands for multiplication
      // div stands for division
      int multLimit, divLimit; 
      int mult1, mult2, mult3;
      int mult1A, mult1B, mult2A, mult2B, mult3A, mult3B;
      int multAnswer1, multAnswer2, multAnswer3;
      int div1, div2, div3;
      int div1A, div1B, div2A, div2B, div3A, div3B;
      int divAnswer1, divAnswer2, divAnswer3;
      String response;
      int numberCorrect = 0;
      
      System.out.println("Welcome to my math quiz!");
      System.out.print("This quiz will give you ");
      System.out.println("three multiplication problems,");
      System.out.println("and then three division problems.");
      System.out.print("-----------------------------");
      System.out.println("-----------------------");
      
      System.out.print("Enter the multiplication limit: ");
      multLimit = keyboardReader.nextInt();
      System.out.print("Enter the division limit: ");
      divLimit = keyboardReader.nextInt(); 
      
      mult1 = (int)(1 + multLimit*Math.random());
      mult2 = (int)(1 + multLimit*Math.random());
      mult3 = (int)(1 + multLimit*Math.random());
      
      mult1A = (int)(1 + mult1*Math.random());
      while ( mult1 % mult1A != 0){             
         mult1A = (int)(1 + mult1*Math.random());
      }
      mult1B = mult1 / mult1A;
      
      mult2A = (int)(1 + mult2*Math.random());
      while ( mult2 % mult2A != 0){
         mult2A = (int)(1 + mult2*Math.random());
      }
      mult2B = mult2 / mult2A;
      
      mult3A = (int)(1 + mult3*Math.random());
      while ( mult3 % mult3A != 0){
         mult3A = (int)(1 + mult3*Math.random());
      }
      mult3B = mult3 / mult3A;
      
      div1 = (int)(1 + divLimit*Math.random());
      div2 = (int)(1 + divLimit*Math.random());
      div3 = (int)(1 + divLimit*Math.random());
      
      div1A = (int)(1 + div1*Math.random());
      while ( div1 % div1A != 0){             
         div1A = (int)(1 + div1*Math.random());
      }
      div1B = div1 / div1A;
      
      div2A = (int)(1 + div2*Math.random());
      while ( div2 % div2A != 0){
         div2A = (int)(1 + div2*Math.random());
      }
      div2B = div2 / div2A;
      
      div3A = (int)(1 + div3*Math.random());
      while ( div3 % div3A != 0){
         div3A = (int)(1 + div3*Math.random());
      }
      div3B = div3 / div3A;
      
      System.out.println();
      System.out.println("The timer starts...now!\n");
      System.out.print("-MULTIPLICATION------------");
      System.out.println("-------------------------");
      
      long startTime = new Date().getTime(); // start time
      
      System.out.print(mult1A + " * " + mult1B + " = ");  
      multAnswer1 = keyboardReader.nextInt();
      if (multAnswer1 == mult1){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + mult1A + " * " + mult1B + " = "
          + mult1 + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      } 
      
      System.out.print(mult2A + " * " + mult2B + " = ");  
      multAnswer2 = keyboardReader.nextInt();
      if (multAnswer2 == mult2){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + mult2A + " * " + mult2B + " = "
          + mult2 + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      
      System.out.print(mult3A + " * " + mult3B + " = ");  
      multAnswer3 = keyboardReader.nextInt();
      if (multAnswer3 == mult3){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + mult3A + " * " + mult3B + " = "
          + mult3 + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      
      double multCorrect = numberCorrect;
      
      System.out.println();
      System.out.print("-DIVISION------------------");
      System.out.println("-------------------------");
      
      System.out.print(div1 + " / " + div1A + " = ");  
      divAnswer1 = keyboardReader.nextInt();
      if (divAnswer1 == div1B){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + div1 + " / " + div1A + " = "
          + div1B + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      } 
      
      System.out.print(div2 + " / " + div2A + " = ");  
      divAnswer2 = keyboardReader.nextInt();
      if (divAnswer2 == div2B){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + div2 + " / " + div2A + " = "
          + div2B + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      } 
      
      System.out.print(div3 + " / " + div3A + " = ");  
      divAnswer3 = keyboardReader.nextInt();
      if (divAnswer3 == div3B){
         numberCorrect += 1;
         response = "Yes! You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }
      else {
         response = "Sorry, " + div3 + " / " + div3A + " = "
          + div3B + ". You have " + numberCorrect + " correct so far.";
         System.out.println(response);
      }    
      
      double divCorrect = numberCorrect - multCorrect;
      
      long endTime = new Date().getTime(); // end time
      int timeTotal = (int)((endTime - startTime)/ 1000);
      
      System.out.println();
      System.out.print("The timer stops...now!");
      System.out.println("  You answered in " + timeTotal + " seconds.");
      
      System.out.println();
      System.out.print("-RESULTS-------------------");
      System.out.println("-------------------------");
       
      System.out.print("Multiplication score: " + (int)multCorrect
                            + " out of 3 (");
      System.out.printf("%.3f", (multCorrect/3)*100);
      System.out.println("%)");
      
      System.out.print("Division score: " + (int)divCorrect
                            + " out of 3 (");
      System.out.printf("%.3f", (divCorrect/3)*100);
      System.out.println("%)");
      
      System.out.print("Overall score: " + numberCorrect
                            + " out of 6 (");
      System.out.printf("%.3f", (numberCorrect/6.0)*100);
      System.out.println("%)");
      
   }
}
