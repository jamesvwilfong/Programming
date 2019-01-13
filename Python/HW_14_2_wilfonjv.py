# Homework 14.2: Problem 1
# File: HW_14_2_wilfonjv.py
# Date:    1 Dec 2018
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
# Program that creates a new file with the given output file name, 
# and then writes the file such that each line of the input file
# is written into it with line numbers added to the beginning each line.

inFileName = input("Enter the name of the input file: ")
outFileName = input("Enter the filename of the output file: ")

print("\nContents of " + inFileName + ": \n")
inFileContent = open(inFileName,'r')
sentences = inFileContent.readlines()
inFileContent = open(inFileName, 'r')
print(inFileContent.read())
inFileContent.close()

print("Contents of " + outFileName + ": \n")
counter = 1
outFileContent = open(outFileName,'w')
for ctr in sentences:
	outFileContent.write(str(counter) + ": " + ctr)
	counter = counter + 1
outFileContent = open(outFileName,'r')
print(outFileContent.read())
outFileContent.close()
