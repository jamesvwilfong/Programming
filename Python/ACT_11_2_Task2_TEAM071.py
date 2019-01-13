# Activity 11.2: Task 2
# File: ACT_11_2_Task2_TEAM071.py
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


GPA = float(input("Enter GPA: "))

if(GPA < 0):
	print("Error: Invalid GPA")
elif(GPA < 1):
	print("Failed Semester-registration")
elif(GPA < 2):
	print("On probation for next semester")
elif(GPA < 3):
	print("Pass")
elif(GPA < 3.5):
	print("Dean's list for semester")
elif(GPA < 4):
	print("Highest honors for semester")
else:
	print("Error: Invalid GPA")
	
