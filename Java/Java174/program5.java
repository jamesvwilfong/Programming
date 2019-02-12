// Name: James Wilfong
// Instructor: Viji
// CSE 174, Section DSMITH , Mary jean
// Date: 10/2/2016
// FIlename: program5.java
// Description: reads the name, address, and phone information 
// from a user, and then "parses" that information to display 
// it in a different format.
// Test Cases:
// Name: "  wilfong,  jAmeS   verNon "---> James V. Wilfong
// Phone: " 5   3   4 -    4 5   2    -   45  23 " ---> (534)452-4523
// Address: " Morris Hall, Room 001, Miami, Florida 11232" 
//                              --> Morris Hall, Room 001
//                                  Miami, Florida 11232

// Name: "WILFONG, JAMES VERNON" ---> James V. Wilfong
// Phone: "513-     5 5 6 -   23 23" --> (513)556-2323
// Address: "204 Main Street, Apt. 5, Oxford, Ohio 45056"
//                              --> 204 Main Street, Apt. 5
//                                  Oxford, Ohio 45056

// Name: "wilfong, james vernon" --> James V. Wilfong
// Phone: "453    -   23 4 -  2342" --> (453)234-2342
// Address: "  329 Home Avenue, Reading, Ohio 45215  " 
//                              --> 329 Home Avenue
//                                  Reading, Ohio 45215

import java.util.Scanner; // We need this for user input

public class program5 {
   
   public static void main(String[] args) {
      
      Scanner keyboardReader = new Scanner(System.in);
      String origName, lastName, middleName, firstName;
      char middleInitial, firstInitial, firstNameNextInitial;
      char lastInitial, lastNameNextInitial;
      String phoneNumber, areaCode;
      String origAddress, streetAddressWithCity, stateAndZip;
      String city, streetAddress, cityWithStateAndZip;
      
      System.out.print("Name: ");
      origName = keyboardReader.nextLine();
      origName = origName.trim();
      
      System.out.print("Phone: ");
      phoneNumber = keyboardReader.nextLine();
      phoneNumber = phoneNumber.trim();
      
      System.out.print("Address: ");
      origAddress = keyboardReader.nextLine();
      origAddress = origAddress.trim();
      
      System.out.println();
      System.out.println("***** Results *****");
      
      lastName = origName.substring(0,origName.indexOf(",",0));
      lastName = origName.charAt(0)+lastName.substring(1).toLowerCase();
      lastName = lastName.trim();
      lastInitial = lastName.charAt(0);
      // Below capitalizes first initial of last name if lower case
      if(Character.isLowerCase(lastInitial)) {  
         lastName = lastName.toUpperCase();
         lastInitial = lastName.charAt(0);     
      }
      lastName = lastName.substring(1);
      // Below checks whether next letters of last name
      // after the first initial of the last name
      // need to be capitalized or lower-cased
      for (int a = 1; a<lastName.length(); a++)
      {
         lastNameNextInitial = lastName.charAt(a);
         if (Character.isUpperCase(lastNameNextInitial))
         {
            lastName = lastName.toLowerCase();
            lastNameNextInitial = lastName.charAt(a);
         }
         else
         { 
            lastNameNextInitial = lastName.charAt(a);
         }
      }
      
      // Isolates and capitalizes middle initial
      middleName = origName.substring(origName.lastIndexOf(" "));
      middleName = middleName.trim();
      middleInitial = middleName.charAt(0);
      if (Character.isLowerCase(middleInitial)) {
         middleName = middleName.toUpperCase();
         middleInitial = middleName.charAt(0);
      }
      
      firstName = origName.substring(origName.indexOf(","),
                                     origName.lastIndexOf(" "));
      firstName = firstName.substring(1);
      firstName = firstName.trim();
      firstInitial = firstName.charAt(0);
      // Below capitalizes first initial of first name if lower case
      if(Character.isLowerCase(firstInitial)){ 
         firstName = firstName.toUpperCase();
         firstInitial = firstName.charAt(0);
      } 
      //  Below Checks whether letters of first name
      //  after first initial need to be capitalized
      //  or lower-cased 
      firstName = firstName.substring(1);
      for (int i=1; i<firstName.length(); i++) 
      {
         firstNameNextInitial = firstName.charAt(i);
         if (Character.isUpperCase(firstNameNextInitial))
         {
            firstName = firstName.toLowerCase();
            firstNameNextInitial = firstName.charAt(i);
         }
         else
         { 
            firstNameNextInitial = firstName.charAt(i);
         }
      }
      System.out.println(firstInitial + firstName + " " + middleInitial
                            + ". " + lastInitial + lastName);
      
      // Below statement removes white space from user input
      phoneNumber = phoneNumber.replaceAll("\\s+",""); 
      areaCode = phoneNumber.substring(0,3);
      areaCode = areaCode.trim();
      System.out.println("(" + areaCode + ")" + phoneNumber.substring(4));
      
      stateAndZip = origAddress.substring(origAddress.lastIndexOf(","));
      streetAddressWithCity = origAddress.replace(stateAndZip,"");
      city = streetAddressWithCity.substring
         (streetAddressWithCity.lastIndexOf(","));
      streetAddress = streetAddressWithCity.replace(city,"");
      city = city.substring(1);
      city = city.trim();
      cityWithStateAndZip = city + stateAndZip;
      System.out.println(streetAddress);
      System.out.println(cityWithStateAndZip);
      
   }
}
