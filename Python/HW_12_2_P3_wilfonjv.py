# Homework 12.2: Problem 3
# File: HW_12_2_P3_wilfonjv.py
# Date:    18 Nov 2018
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
# This program will count the total number of wins and losses for the number of rolls specified
# and output the percent of wins and losses.

import random

numRolls = [10, 100, 1000, 10000, 100000, 1000000]
for ctr in range(0,6):
	print("For",numRolls[ctr],"Rolls")
	wins = 0
	losses = 0
	for ctr2 in range(0,numRolls[ctr]):
		roll = random.randint(1,6)
		if(roll == 5 or roll ==6):
			wins = wins + 1
		else:
			losses = losses + 1
	winPercent = (wins/numRolls[ctr])*100
	lossPercent = (losses/numRolls[ctr])*100
	print("Percent Wins: ",winPercent)
	print("Percent Losses: ",lossPercent)
