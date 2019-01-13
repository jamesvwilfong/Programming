# Homework 12.2: Problem 2
# File: HW_12_2_P2_wilfonjv.py
# Date:    18 Nov 2018
# By:      James Wilfong
#          wilfonjv
# Section: 007
# Team:    071
#
# ELECTRONIC SIGNATURE
# James Wilfong
#
# The electronic signature above indicates the script
# submitted for evaluation is my individual work, and I
# have a general understanding of all aspects of its
# development and execution.
#
# A BRIEF DESCRIPTION OF WHAT THE SCRIPT OR FUNCTION DOES
# This program represents a simple savings plan.

dollarsSaved = float(input("Enter amount you wish to save(dollars): "))
pennies = dollarsSaved*100
balance = [1]
ctr = 0
while(balance[ctr]<pennies):
	balance.append(balance[ctr] + (ctr+1))
	ctr = ctr + 1
finalBalance = balance[ctr]/100
print("The final balance is: $",finalBalance)
lastContribution = ctr/100
print("Contribution on last day: $",lastContribution)
print("Number of days to save: ",ctr)
print("Number of years to save: ", ctr/365)
