# Homework 8.1: Task 2
# File: HW8_1_Task2_wilfonjv.py
# Date:    28 Oct 2018
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
# simple operations dealing with character strings, integers, and floating-point values

print(" Enter your last name:")
LASTNAME = input()
print(" Enter your first name:")
FIRSTNAME = input()
print(" Enter your age in whole years:")
AGE = float(input())
print(" Enter the days elapsed since your last birthday:")
SINCEBIRTHDAY = float(input())

CURRENTAGE = AGE + SINCEBIRTHDAY/365.242199
def minutesAge(CURRENTAGE):
	return CURRENTAGE*365.242199*24*60

print("",FIRSTNAME,LASTNAME)
print(" You are",CURRENTAGE,"years old.")
print(" You are",minutesAge(CURRENTAGE),"minutes old.")
