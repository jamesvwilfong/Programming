// Lab04ast.java
// The Mortgage Payment Program
// This the student, starting version of the Lab04a assignment.

import java.text.DecimalFormat;
public class Lab04ast

{
	public static void main(String args[])
	{
		System.out.println("Lab04a, 100 Point Version\n");

		double principal  = 250000;
		double annualRate = 4.85;
		double numYears   = 30;
		System.out.println("Principal:        $" + principal);
		System.out.println("Annual Rate:      " + annualRate + "%");
		System.out.println("Number of Years:  " + numYears);
		double monthlyRate = (annualRate / 12) / 100;
		double numMonths = (numYears * 12);
		double numerMonthlyPayment = (monthlyRate * (Math.pow((1 + monthlyRate),numMonths)));
		double denominMonthlyPayment = (Math.pow((1 + monthlyRate),numMonths) - 1);
		DecimalFormat df1 = new DecimalFormat("0.##");
		DecimalFormat df2 = new DecimalFormat("0.00");
		System.out.println("Monthly Payment:  $" + df1.format((numerMonthlyPayment / denominMonthlyPayment) * principal));
		double monthlyPayment = ((numerMonthlyPayment / denominMonthlyPayment) * principal);
		System.out.println("Total Payments:   $" + df2.format(monthlyPayment * numMonths));
		double totalPayments = (monthlyPayment * numMonths);
		System.out.println("Total Interest:   $" + df2.format(totalPayments - principal));









		System.out.println();
	}
}
