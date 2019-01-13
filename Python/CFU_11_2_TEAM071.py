# CFU 11.2: Task 1
# File: CFU_11_2_TEAM071.py
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
# This program takes 3 inputs and tests the determinant of a quadratic equation to find
# the nummber of real solutions.

A = input("What are the values for a, b, and c? ")

def determinant(A):
	A = A.split()
	return float(A[1])**2 - (4*float(A[0])*float(A[2]))
	
if(determinant(A) < 0):
	print("There are no real roots")
elif(determinant(A) == 0):
	print("There is one real root")
else:
	print("There are two real roots")
