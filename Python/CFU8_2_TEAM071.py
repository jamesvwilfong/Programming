# CFU 8.2: Task 1
# File: CFU8_2_TEAM071.py
# Date:    17 Oct 2018
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
# This program computes the surface area of a cylinder.
import math
def CylinderArea(Diameter,Height):
	return 2*math.pi*((Diameter/2)**2) + 2*math.pi*(Diameter/2)*Height
Diameter = float(input("Insert diameter (in cm): "))
Height = float(input("Insert height (in cm): "))
print("The surface area of a cylinder is ",CylinderArea(Diameter,Height), " cm^2 for a given diameter of")
print(Diameter," cm and height of ", Height," cm.")
