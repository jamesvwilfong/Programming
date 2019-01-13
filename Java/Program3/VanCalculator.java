// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 9/14/2016
// FIlename: VanCalculator.java
// Description: write a program that asks how many people need 
//              a ride, and then print the number of vans needed

import java.util.Scanner; // We need this for user input

public class VanCalculator {
   
   public static void main(String[] args) {
      
      Scanner keyboardReader = new Scanner(System.in);
      int passengers;
      int remainingPassengers;
      int fullVans;
      double remainder;
      int extraVan;
      int totalVans;
      
      System.out.println("Vans hold 20 people.");
      
      // Get number of passengers
      System.out.print("How many people need a ride? ");
      passengers = keyboardReader.nextInt();
      
      // Calculate number of vans needed.
      fullVans = passengers / 20;
      remainingPassengers = passengers % 20;
      remainder = remainingPassengers / (remainingPassengers-0.1);
      extraVan = (int)remainder;
      totalVans = fullVans + extraVan;
              
      // Give answer
      System.out.println("You need " + totalVans + " vans.");
   }
