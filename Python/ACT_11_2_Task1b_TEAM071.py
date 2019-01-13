# Activity 11.2: Task 1
# File: ACT_11_2_Task1b_TEAM071.py
# Date:    7 Nov 2018
# By:      James Wilfong, Joe Welage, Cole Bower, Konstantinos Frietchen
#          wilfonjv       welagejl    bowercr     papadokp 
# Section: 007
# Team:    071
#
# ELECTRONIC SIGNATURE
# James Wilfong, Cole Bower, Jow Welage, Konstantinos Frietchen
#
# The electronic signature above indicates the script
# submitted for evaluation is my individual work, and I
# have a general understanding of all aspects of its
# development and execution.
#
# A BRIEF DESCRIPTION OF WHAT THE SCRIPT OR FUNCTION DOES
# This program takes 2 lists or tuples as input arguments, then performs and returns the dot product 
# of the given lists or tuples.

def dotproduct(A,B):
	if(len(A)<3 or len(B)<3):
		print("ERROR: Not enough values")
	else:
		return int(A[0])*int(B[0]) + int(A[1])*int(B[1]) + int(A[2])*int(B[2])
	
listA = input("Please enter vector A: ")
listB = input("Please enter vector B: ")

print("Dot Product for entered vectors is: ", dotproduct(listA.split(),listB.split()))
