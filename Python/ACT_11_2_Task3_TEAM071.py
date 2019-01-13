# Activity 11.2: Task 3
# File: ACT_11_2_Task3_TEAM071.py
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

value = float(input("Enter a number: "))
listNums = [47, 28, 69, 1, 1.5, 9] 

if((value%2 == 0 and value%7 == 0 and value in listNums) or value == 53):
	print("Yes")
else:
	print("No")
