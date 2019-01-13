/*
Name: James Wilfong
Date: November 7 2018
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

// struct for resistor that holds voltage, resistance, and power
// values for particular resistors
struct resistor {
	double voltage = 0;
	double resistance = 0;
	double power = 0;
};

class Circuit {
public:

	// default constructor
	Circuit() {}

	// allows the user to edit a multi node circuit
	void menu() {
		int input;
		do {
			cout << "Circuit Options: " << endl;
			cout << "\t1. Add Resistor" << endl;
			cout << "\t2. Change Voltage" << endl;
			cout << "\t3. Delete Resistor" << endl;
			cout << "\t4. Edit Resistor Value" << endl;
			cout << "\t5. Add Series of Resistors" << endl;
			cout << "\t6. Display Network" << endl;
			cout << "\t7. Quit Program" << endl;
			cin >> input;
			switch (input) {
			// add resistor
			case 1:
				addR();
				break;
			// enter or change voltage
			case 2:
				promptV();
				break;
			// delete a resistor
			case 3:
				deleteR();
				break;
			// change a resistor
			case 4:
				editR();
				break;
			// add multiple resistors at once
			case 5:
				promptR();
				break;
			// display circuit values
			case 6:
				currentCalc();
				powerCalc();
				displayCircuitVals();
				displayNodeVals();
				break;
			// end the program
			case 7:
				cout << "Program Stopped" << endl;
				break;
			}
		} while (input != 7);
	}
private:

	// adds a resistor
	void addR() {
		double resVal;
		cout << "Enter resistor value to be added: " << endl;
		cin >> resVal;
		resistor temp = { dropCalc(resVal),resVal,dissipateCalc(resVal)};
		resistors.push_back(temp);
		resistance += resVal;
	}

	// deletes a resistor
	void deleteR() {
		double resVal;
		cout << "Enter resistor value to be deleted: " << endl;
		cin >> resVal;
		resistance -= resVal;
		bool flag = false;
		for (int i = 0; i < resistors.size(); i++) {
			if (resVal == resistors[i].resistance && flag == false) {
			resistors.erase(resistors.begin() + i);
			flag = true;
			}
		}
	}

	// changes the resistance of a chosen resistor
	void editR() {
		double resVal, newResVal;
		cout << "Enter resistor value to be changed, and new resistor value separated by a space: " << endl;
		cin >> resVal;
		cin >> newResVal;
		resistance -= resVal;
		resistance += newResVal;
		resistor temp = { dropCalc(newResVal),newResVal,dissipateCalc(newResVal) };
		bool flag = false;
		for (int i = 0; i < resistors.size(); i++) {
			if (resVal == resistors[i].resistance && flag == false) {
				resistors.erase(resistors.begin() + i);
				resistors.insert(resistors.begin() + i, temp);
				flag = true;
			}
		}
	}

	// prompts the user to enter the input voltage
	void promptV() {
		cout << "Enter Voltage: ";
		cin >> voltage;
	}

	// calculates the power of the circuit
	void powerCalc() {
		power = voltage*current;
	}

	// calculates the current of the circuit
	void currentCalc() {
		current = voltage / resistance;
	}

	// displays the values of the circuit
	void displayCircuitVals() {
		cout << "Circuit Parameters: " << endl;
		cout << "\tTotal Resistance: " << resistance << " ohms" << endl;
		cout << "\tInput Voltage: " << voltage << " volts" << endl;
		cout << "\tSeries Current: " << current << " Amps" << endl;
		cout << "\tPower: " << power << " Watts" << endl;
		cout << endl;
	}

	// Prompts the user to enter multiple resistor values
	void promptR() {
		double resistorVal;
		do {
			cout << "Enter resistor value(0 when finished): " << endl;
			cin >> resistorVal;
			if (resistorVal != 0) {
				resistor temp = { dropCalc(resistorVal),resistorVal,dissipateCalc(resistorVal) };
				resistors.push_back(temp);
			}
		} while (resistorVal != 0);
		for (int i = 0; i < resistors.size(); i++) {
			resistance += resistors[i].resistance;
		}
	}

	// displays the values of a particular node
	void displayNodeVals() {
		for (int j = 0; j < resistors.size(); j++) {
			cout << "\tNode " << j << " Parameters: " << endl;
			cout << "\tResistance: " << resistors[j].resistance << " ohms" << endl;
			cout << "\tVoltage: " << dropCalc(resistors[j].resistance) << " volts" << endl;
			cout << "\tPower: " << dissipateCalc(resistors[j].resistance) << " Watts" << endl;
			cout << endl;
		}
	}

	// calculates the voltage across a particular resistor
	double dropCalc(double resistor) {
		return resistor * current;
	}

	// calculates the power accross a particular resistor
	double dissipateCalc(double resistor) {
		return current * dropCalc(resistor);
	}

	// private variables
	vector<resistor> resistors = {};
	double resistance;
	double voltage;
	double current;
	double power;
};

int main() {
	Circuit N1;
	N1.menu();

	return 0;
}
