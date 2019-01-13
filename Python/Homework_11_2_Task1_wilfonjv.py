# Homework 11.2: Task 1
# File: Homework_11_2_Task1_wilfonjv.py
# Date:    11 Nov 2018
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
# This program models a system of optical media to determine 
# how light entering a lens system will behave.

import math

print("Enter indices of refraction for bottom two media: ")
indices = input()
indices = indices.split()
print("Enter angle of incidence (in degrees): ")
angle = float(input())
print("Enter d1 and d2 (units): ")
distances = input()
distances = distances.split()
temp = (float(indices[0])*math.sin(math.radians(angle)))/float(indices[1])
if(temp >= -1 and temp<=1):
	angle2 = math.asin((float(indices[0])*math.sin(math.radians(angle)))/float(indices[1]))
	d3a = float(distances[0]) * math.tan(math.radians(angle))
	d3b = float(distances[1]) * math.tan(angle2)
	print("Ending distance is: ")
	print("%.3f"%(d3a+d3b),"units")
else:
	print("Error, no refraction in the second media ")

	

