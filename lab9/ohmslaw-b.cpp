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

void powerCalc(node &a) {
	a.power = a.voltage*a.current;
}

void currentCalc(node &b) {
	b.current = b.voltage / b.resistance;
}

void displayCircuitVals(node c) {
	cout << "Circuit Parameters: " << endl;
	cout << "\tTotal Resistance: " << c.resistance << " ohms" << endl;
	cout << "\tInput Voltage: " << c.voltage << " volts" << endl;
	cout << "\tSeries Current: " << c.current << " Amps" << endl;
	cout << "\tPower: " << c.power << " Watts" << endl;
	cout << endl;
}

void promptV(node &n) {
	cout << "Enter Voltage: ";
	cin >> n.voltage;
}

vector<double> promptR(node &n) {
	double resistor;
	vector<double> resistors;
	do {
		cout << "Enter resistor value(0 when finished): " << endl;
		cin >> resistor;
		if(resistor != 0)
			resistors.push_back(resistor);
	} while (resistor != 0);
	return resistors;
}

double dropCalc(double resistor, node n) {
	return resistor * n.current;
}

double dissipateCalc(double resistor, node n) {
	return n.current * dropCalc(resistor, n);
}

int main() {
	node N1;

	promptV(N1);
	vector<double> resistors = promptR(N1);
	for (int i = 0; i < resistors.size(); i++) {
		N1.resistance += resistors[i];
	}
	currentCalc(N1);
	powerCalc(N1);
	displayCircuitVals(N1);
	for (int j = 0; j < resistors.size(); j++) {
		cout << "\tNode " << j << " Parameters: " << endl;
		cout << "\tResistance: " << resistors[j] << " ohms" << endl;
		cout << "\tVoltage: " << dropCalc(resistors[j], N1) << " volts" << endl;
		cout << "\tPower: " << dissipateCalc(resistors[j], N1) << " Watts" << endl;
		cout << endl;
	}

	return 0;
}
