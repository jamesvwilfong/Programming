/*
Name: James Wilfong
Date: November 1 2018
Assignment: Laboratory 9
Description: simple implementation of a series DC circuit
			 uses the vector class to “unlimit” the number of resistors in the circuit
			 creates an edit menu so you can make changes to your circuit
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <vector>

using namespace std;

struct node {
	double voltage = 0;
	double resistance = 0;
	double current = 0;
	double power = 0;
};

void powerCalc(node &a){
	a.power = a.voltage*a.current;
}

void currentCalc(node &b){
	b.current = b.voltage / b.resistance;
}

void displayCircuitVals(node c){
	cout << "Total Resistance: " << c.resistance << " ohms" << endl;
	cout << "Input Voltage: " << c.voltage << " volts" << endl;
	cout << "Series Current: " << c.current << " Amps" << endl;
	cout << "Power: " << c.power << " Watts" << endl;
}

int main() {
	node N1;

	cout << "Enter Voltage: ";
	cin >> N1.voltage;

	cout << "Enter Resistance: ";
	cin >> N1.resistance;

	currentCalc(N1);
	powerCalc(N1);
	displayCircuitVals(N1);

	return 0;
}
