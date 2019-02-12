/* Sarah Valentine, Jack Latimer, Joe Gurnig, James Wilfong
 * Final Group Project
 * CSE 174 D
 */

import java.util.Scanner;

public class GroupProject {
   
   public static int mult35 () {
      int count = 1;
      int sum = 0;
      while (count < 1000) {
         if (count % 3 == 0 || count % 5 == 0) {
            sum += count;
         }
         count++;
      }
      return sum;
   }
   public static int fibSum() {
      int count = 1;
      int sum = 0;
      int lastNum = 1;
      while (count < 4000000) {
         if (count % 2 == 0) {
            sum += count;
         }
         count += lastNum;
         lastNum = count - lastNum;
      }
      return sum;
   }
   public static long largestPrimeFactor() {
      long max = 0;
      long num = 600851475143L;
      for(long j = 3; j < num; j += 2){
         while(num%j == 0){
            max = num;
            num = num/j;   
         }
      }
      return (num == 1)?max:num;
   }
   public static int largestPalindrome() {
      int mult = 0;
      int max = 0;
      for(int i = 999; i>99;i--){
         for(int j=999;j>99;j--){
            mult = i*j;
            String num = Integer.toString(mult);
            char[] numArray = new char[String.valueOf(mult).length()+1];
            int x = 0;
            int y = String.valueOf(mult).length()-1;
            for(int a = 0; a<y+1;a++)
               numArray[a] = num.charAt(a);
            for(int b=0;b<String.valueOf(mult).length()-1;b++){
               if(numArray[x]!=numArray[y])
                  break;
               else if(b==String.valueOf(mult).length()-2)
                  if(mult>max)
                  max =mult;
               x++;
               y--;
            } 
         }
      }
      return max;
   }
   public static int smallestMult() {
      boolean flag = false;
      int num = 20;
      while (flag == false) {
         int count = 0;
         for (int i = 1; i <=20; i++) {
            if (num%i==0) {
               count++;
            }
         }
         if(count==20) {
            flag=true;
         }
         else {
            flag=false;
            num++;
         }
      }
      return num; 
   }
   public static int sumSqDiff() {
      double sqsum = 0, sumsq = 0;
      for (int i = 1; i <= 100; i++) {
         sqsum += i;
         sumsq +=(Math.pow(i,2));
      }
      sqsum = Math.pow(sqsum,2);
      return (int)(Math.abs(sqsum-sumsq));
   }
   public static int prime10001() {
      return 0;
   }
   public static int largestProd() {
      return 0;
   }
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int choice = 0;
      while (choice != 9) {
         System.out.println("================= GROUP 17 FINAL PROJECT MAIN MENU =================");
         System.out.println("Please select an item from the menu below");
         System.out.println("1: Multiples of 3 and 5");
         System.out.println("2: Even Fibonacci numbers");
         System.out.println("3: Largest prime factor");
         System.out.println("4: Largest palindrome product");
         System.out.println("5: Smallest multiple");
         System.out.println("6: Sum square difference");
         System.out.println("7: 10001st prime");
         System.out.println("8: Largest product in a series");
         System.out.println("9: Quit");
         System.out.print("Enter your choice here: ");
         choice = input.nextInt();
         switch(choice) {
            case 1: 
               System.out.print("The sum of all multiples of 3 or 5 less than 1000 is ");
               System.out.println(mult35() + ". Now redirecting to the main menu.");
               break;
            case 2: 
               System.out.print("The sum of even Fibonacci numbers below 4,000,000 is ");
               System.out.println(fibSum() + ". Now redirecting to the main menu.");
               break;
            case 3: 
               System.out.print("The largest prime factor of 600851475143 is ");
               System.out.println(largestPrimeFactor() + ". Now redirecting to the main menu.");
               break;
            case 4: 
               System.out.print("The largest palindrome produced by multiplying two 3-digit numbers is ");
               System.out.println(largestPalindrome() + ". Now redirecting to the main menu.");
               break;
            case 5: 
               System.out.print("The smallest multiple that can be evenly divided by all integers 1 through 20 is ");
               System.out.println(smallestMult() + ". Now redirecting to the main menu.");
               break;
            case 6: 
               System.out.print("For the first 100 natural numbers, the difference between the sum of the squares and the square of the sum is ");
               System.out.println(sumSqDiff() + ". Now redirecting to the main menu.");
               break;
            case 7: 
               System.out.print("The 10001st prime number is ");
               System.out.println(prime10001() + ". Now redirecting to the main menu.");
               break;
            case 8: 
               System.out.print("The greatest product found in adjacent digits of the 1000-digit number was ");
               System.out.println(largestProd() + ". Now redirecting to the main menu.");
               break;
            case 9: 
               System.out.println("Thank you for trying out our project!");
               break;
            default: 
               System.out.println("That was not a valid request. You will be redirected back to the menu.");
               break;
         }
      }
   }
}
