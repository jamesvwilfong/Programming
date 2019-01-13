// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section D
// Date: 12/3/2016
// Filename: YahtzeeGame.java

import java.util.Scanner; // We need this for user input

public class YahtzeeGame {
   
   //Allows the Scanner class to be accessed in all methods
   static Scanner in = new Scanner(System.in);
   
   // Globalized boolean variable used to determine when 
   // the user is finished rerolling
   static boolean finished = false;
   
   // The starting point for the program. This method
   // calls on the other methods as needed. Creates an int array
   // representing 5 dice. Handles overall flow of the program.
   public static void main(String[] args) {
      
      int i = 0;
      System.out.println("Welcome to Yahtzee!");
      int[] dice = new int[5];
      roll(dice);
      sort(dice);
      System.out.println("Roll #1: " + toString(dice));
      scoreChoices(dice); 
      reroll(dice);
      if(finished == false){
      sort(dice);
      System.out.println("Roll #2: " + toString(dice));
      scoreChoices(dice);
      reroll(dice);
      }
      if(finished == false) {
      sort(dice);
      System.out.println("Roll #3: " + toString(dice));
      scoreChoices(dice);
      System.out.println("Your score is " + maxScore(dice) + ". Goodbye.");
      }
   } 


// Rolls all five dice by assigning a random integer, 1-6,
// to each element in the array.
public static void roll(int[] dice) {
   
   for(int i = 0; i<5;i++) {
      dice[i] = (int)((Math.random()*6)+1);
   }
}

// Implements bubble sort algorithm to sort the
// dice in ascending order.
public static void sort(int[] dice) {
   
   for(int i = 0; i<5;i++){
      for(int j = 0; j<5-i-1;j++){
         if(dice[j] > dice[j+1]) {
            int a = dice[j];
            dice[j] = dice[j+1];
            dice[j+1] = a;
         }
      }
   }
}

// Returns a space-separated list of the dice in the array.
public static String toString(int[] dice) {
   String result = "";
   for(int i = 0; i<5;i++){
      result = result + dice[i] + " ";
   }
   return result;
}

// Asks the user to indicate which dice to reroll
// by entering a 5-character string consisting only of y and n.
public static void reroll(int[] dice) {
   boolean flag = true;
   boolean flag2 = true;
   while(flag){
      System.out.print("Roll again?");
      String response = in.nextLine();
      if(response.equals("y")){
         flag = false;
         while(flag2){
            int err = 0;
            System.out.print("Indicate which dice to roll using y and n: ");
            String response2 = in.nextLine();
            for(int i = 0; i<response2.length();i++){
               if(response2.charAt(i) != 'n' && response2.charAt(i) != 'y')
                  err+=1;
            }
            if(response2.contains("y") && response2.length() == 5 && err ==0){
               flag2 = false; 
               for(int i = 0; i <5; i++){
                  if(response2.charAt(i) == 'y')
                     dice[i] = (int)((Math.random()*6)+1);
               }
            }
         } 
      }
      else if(response.equals("n")){
         flag = false;
         finished = true;
         System.out.println("Your score is "+maxScore(dice)
                               +". Goodbye.");
      }
   }
}

// Returns the score for yahtzee.
public static int yahtzee(int[] dice){
   int same = 0;
   for(int i = 1;i<5;i++){
      if(dice[0] == dice[i])
         same +=1;
   }
   if(same == 4)
      return 50;
   else
      return 0;
}

// Returns the score for a four of a kind.
public static int fourOfAKind(int[] dice){
   int same = 0;
   int sum = 0;
   for(int i = 0; i<5;i++){
      sum = sum + dice[i];
   }
   for(int i = 0;i<2;i++){
      if(same>=3)
         break;
      same = 0;
      for(int j = i+1;j<5;j++){
         if(dice[i] == dice[j])
            same +=1;
      }
   }
   if(same>=3)
      return sum;
   else
      return 0;
}

// Returns the score for a three of a kind.
public static int threeOfAKind(int[] dice){
   int same = 0;
   int sum = 0;
   for(int i = 0; i<5;i++){
      sum = sum + dice[i];
   }
   for(int i = 0;i<3;i++){
      if(same>=2)
         break;
      same = 0;
      for(int j = i+1;j<5;j++){
         if(dice[i] == dice[j])
            same +=1;
      }
   }
   if(same>=2)
      return sum;
   else
      return 0;
}

// Returns the score for a large straight.
public static int largeStraight(int[] dice){
   int same = 0;
   for(int i = 0;i<4;i++){
      if(dice[i] == dice[i+1]-1)
         same +=1;
   }
   if(same == 4)
      return 40;
   else
      return 0;
}

// Returns the score for a small straight.
public static int smallStraight(int[] dice){
   int same = 0;
   int same2 = 0;
   for(int i = 0;i<3;i++){
      if(dice[i] == dice[i+1]-1)
         same +=1;
   }
   for(int a = 1;a<4;a++){
      if(dice[a] == dice[a+1]-1)
         same2 +=1;
   }
   if(same == 3 || same2 ==3)
      return 30;
   else
      return 0;
}

// Returns 25 if the player has a full house.
public static int fullHouse(int[] dice) {
   if(dice[0]==dice[1] && dice[1]==dice[2] && dice[3]==dice[4]||
      (dice[2]==dice[3] && dice[3]==dice[4] && dice[0]==dice[1]))
      return 25;
   else
      return 0;
}

// Returns the sum of all the dice whose value match key.
public static int sum(int[] dice, int key){
   int sum = 0;
   for(int i = 0; i<5;i++){
      if(dice[i] == key)
         sum = sum + dice[i];
   }
   return sum;
}

// Returns the sum of all the dice.
public static int chance(int[] dice){
   int sum = 0;
   for(int i = 0; i<5;i++){
      sum = sum + dice[i];
   }
   return sum;
}

// Prints all the non-zero scoring options for the given dice.
public static void scoreChoices(int[] dice){
   for(int i = 1; i<7;i++){
      if(sum(dice,i) != 0)
         System.out.println(i+ " total: " + sum(dice,i));
   }
   if(threeOfAKind(dice) != 0)
      System.out.println("3 of a kind: " + threeOfAKind(dice));
   if(fourOfAKind(dice) != 0)
      System.out.println("4 of a kind: " + fourOfAKind(dice));
   if(fullHouse(dice) != 0)
      System.out.println("full house: " + fullHouse(dice));
   if(smallStraight(dice) != 0)
      System.out.println("small straight: " + smallStraight(dice));
   if(largeStraight(dice) != 0)
      System.out.println("large straight:" + largeStraight(dice));
   if(yahtzee(dice) != 0)
      System.out.println("yahtzee: " + yahtzee(dice));
   System.out.println("chance: " + chance(dice));
}

// Returns the highest possible score that
// can be obtained with the given dice.
public static int maxScore(int[] dice){
   int max = 0;
   if(yahtzee(dice)>max)
      return 50;
   if(chance(dice) > max)
      max = chance(dice);
   if(threeOfAKind(dice) > max)
      max = threeOfAKind(dice);
   if(fourOfAKind(dice) > max)
      max = fourOfAKind(dice);
   if(fullHouse(dice) > max)
      max = fullHouse(dice);
   if(smallStraight(dice) > max)
      max = smallStraight(dice);
   if(largeStraight(dice) > max)
      max = largeStraight(dice);
   for(int i = 1; i < 7; i++) {
      if(sum(dice,i) >max)
         max = sum(dice,i);
   }
   return max;
}
}
