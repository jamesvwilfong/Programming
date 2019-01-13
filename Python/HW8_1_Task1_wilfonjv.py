# Homework 8.1: Task 1
# File: HW8_1_Task1_wilfonjv.py
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
# This program tests a function that calculates paralell resistance 
# and another function that calculates series resistance.

def parallelResistance(RESISTANCE1,RESISTANCE2):
	return ((1/RESISTANCE1) + (1/RESISTANCE2))**-1

def seriesResistance(RESISTANCE1,RESISTANCE2):
	return RESISTANCE1 + RESISTANCE2
	
RESISTANCE1 = float(input("Resistance 1: "))
RESISTANCE2 = float(input("Resistance 2: "))
print("Parallel, Equivalent Resistance: ", parallelResistance(RESISTANCE1,RESISTANCE2))
print("Series, Equivalent Resistance: ", seriesResistance(RESISTANCE1,RESISTANCE2))

