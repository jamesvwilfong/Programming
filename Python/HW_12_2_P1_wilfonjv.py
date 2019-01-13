# Homework 12.2: Problem 1
# File: HW_12_2_P1_wilfonjv.py
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
# This program calculates Perrin numbers to the nth term.
def perrinNumbers(terms):
	termList = [3]
	if(terms<=0):
		return "Error: there must be at least one term"
	if(terms>1):
		termList.append(0)
	if(terms>2):
		termList.append(2)
	if(terms>3):
		for ctr in range(3,terms):
			termList.append(int(termList[ctr-2])+int(termList[ctr-3]))
	return termList

		
terms = int(input("Enter number of terms: "))
print(perrinNumbers(terms))
