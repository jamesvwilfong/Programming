# Activity 8.2.1: Task 3
# File: ACT8_2_1_Task3_wilfonjv.py
# Date:    17 Oct 2018
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
# This program calculates the modulus between 2 values.

def remainder(A,B):
	if A < B:
		return A
	else:
		while(A-B>0):
			A = A -B
	return A
