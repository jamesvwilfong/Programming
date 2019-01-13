// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 11/13/2016
// Filename: PrimeStuff.java

import java.util.Scanner;
public class PrimeStuff {
   
   // Allows the Scanner class to be accessed in all methods:
   static Scanner in = new Scanner(System.in);
   
   public static void main(String[] args) {
      int choice = 0;
      while(choice !=1 && choice !=2 && choice != 3 && choice != 4) {
         System.out.println("What would you like to do?");
         System.out.println("1) Check if a number is prime");
         System.out.println("2) Factor a number");
         System.out.println("3) List prime numbers");
         System.out.println("4) Quit");
         System.out.print("Choice: ");
         choice = in.nextInt();
         if(choice !=1 && choice != 2 && choice != 3 && choice != 4)   
            System.out.println("**** INVALID OPTION ****");
         if(choice == 1){
            primeCheck();
            choice = 0;
         }
         if(choice == 2){
            numFactor();
            choice = 0;
         }
         if(choice == 3){
            primeList();
            choice = 0;
         }
         if(choice == 4)
            break; 
      }
   }
   
   
   // Checks, and displays whether a number is prime
   public static void primeCheck() {
      long num = 0;
      while(num<1 || num > Long.MAX_VALUE) {
         System.out.print("Enter a number between 1 and " 
                             + Long.MAX_VALUE + ":");
         num = in.nextLong();
      }
      for(int i = 2; i<num; i++) {
         if(num % i == 0) {
            System.out.println("---> " + num + " is not prime.");
            break;
         }
         else if(i == num-1) 
            System.out.println("---> " + num + " is prime.");
         
      }
   }
   
   // Returns true if number is prime, and false otherwise
   public static boolean primeCheckBoolean(Long num) {
      for(int i = 2; i<num; i++) {
         if(num % i == 0) {
            return false;
         }
         else if(i == num-1) 
            return true;
      }
      return false;
   }
   
   // Factors a number into prime numbers, from smallest to largest
   public static void numFactor() {
      long num = 0;
      while(num<1 || num > Long.MAX_VALUE) {
         System.out.print("Enter a number between 1 and " 
                             + Long.MAX_VALUE + ":");
         num = in.nextLong();
      }
      String factor = num+" = ";
      if(num!=1) {
         for(int i = 2; i<=num; i++) {
            while(num % i == 0) {
               if(i == num) {
                  factor = factor + num;
                  break;
               }
               num = num/i;
               factor = factor + i + " * ";    
            }
         } 
         System.out.println("---> " + factor);
      }
      else
         System.out.println("---> 1 = 1");
   }
   
   // Creates a list of prime numbers 
   public static void primeList() {
      long num = 0;
      while(num<1 || num > Long.MAX_VALUE) {
         System.out.print("Enter a number between 1 and " 
                             + Long.MAX_VALUE + ":");
         num = in.nextLong();
      }
      int primeNum = 0;
      int primeRow = 0;
      while(primeNum <1 || primeNum > 1000) {
         System.out.print("How many primes (1-1000): ");
         primeNum = in.nextInt();
      }
      while(primeRow <1 || primeRow >20) {
         System.out.print("How many primes per row (1-20): ");
         primeRow = in.nextInt();
      }
      String str = "  ";
      for(int i = 1; i<=primeNum; i++) {
         while(primeCheckBoolean(num) == false) {
            num += 1; 
         }
         str = str + num + " ";
         num = num+1;
         if(i % primeRow == 0) {
            System.out.println(str);
            str = "  ";
         }
      }
      System.out.println(str);
   }  
}



   
