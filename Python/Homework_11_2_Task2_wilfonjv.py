# Homework 11.2: Task 2
# File: Homework_11_2_Task2_wilfonjv.py
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
# This program will tell you the performance of two resistors 
# connected in either series or parallel.

resistors = input("Enter resistor values(non-negative): ")
resistors = resistors.split()
if(float(resistors[0]) < 0 or float(resistors[1]) < 0):
	print("ERROR: negative values were given")
else:
	voltage = float(input("Enter voltage: "))
	circuitType = input("Enter circuit type(parallel or series)")
	circuitType = circuitType.lower()
	if(circuitType == "series"):
		rTotal = float(resistors[0]) + float(resistors[1])
		print("Total Resistance(ohms): ",rTotal)
		print("Resistor 1 Voltage(V): ", (float(resistors[0])/rTotal)*voltage)
		print("Resistor 2 Voltage(V): ", (float(resistors[1])/rTotal)*voltage)
		print("Resistor 1 Current(amps): ", voltage/rTotal)
		print("Resistor 2 Current(amps): ", voltage/rTotal)
	else:
		rTotal = 1/(1/float(resistors[0])+1/float(resistors[1]))
		iTotal = voltage/rTotal
		print("Total Resistance(ohms): ",rTotal)
		print("Resistor 1 Voltage(V): ", voltage)
		print("Resistor 2 Voltage(V): ", voltage)
		print("Resistor 1 Current(amps): ", (float(resistors[0])/rTotal)*iTotal)
		print("Resistor 2 Current(amps): ", (float(resistors[1])/rTotal)*iTotal)

