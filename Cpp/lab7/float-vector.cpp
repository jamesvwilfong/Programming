/*
Name: James Wilfong
Date: October 18 2018
Assignment: Laboratory 7
Description: Various Integer and String functions
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>
#include <vector>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

// Fills any size floating point vector with random values up to a specified range.
void FunctionA(vector<float> &empty_vector, int min, int max) {
	vector<float> temp;
	for (int i = 0; i < empty_vector.size(); i++) {
		temp.push_back(rand() % (max - min + 1) + min);
	}
	empty_vector = temp;
}

// Displays any size floating point vector to console terminal or window
void FunctionB(const vector<float> display_vector) {
	cout << "[";
	for (int i = 0; i < display_vector.size(); i++) {
		cout << display_vector[i];
		if (i != display_vector.size() - 1)
			cout << ",";
	}
	cout << "]" << endl;
}

// Sums all values stored in any size floating point vector
float FunctionC(const vector<float> given_vector) {
	float sum = 0;
	for (int i = 0; i < given_vector.size(); i++) {
		sum = sum + given_vector[i];
	}
	return sum;
}

template<typename T>
string print(vector<T> vec);

template<typename T>
string print(T array[], int length);

int main() {
	srand(time(0));
	cout << "Function A:" << endl;
	vector<float> v1(5);
	vector<float> v2(0);
	vector<float> v3(1);
	vector<float> v4(8);
	FunctionA(v1,10,40);
	FunctionA(v2,0,8);
	FunctionA(v3,90,400);
	FunctionA(v4,1,2);
	cout << print(v1) << endl;
	cout << print(v2) << endl;
	cout << print(v3) << endl;
	cout << print(v4) << endl << endl;

	cout << "Function B:" << endl;
	FunctionB(v1);
	FunctionB(v2);
	FunctionB(v3);
	FunctionB(v4);
	cout << endl;

	cout << "Function C:" << endl;
	cout << FunctionC(v1) << endl;
	cout << FunctionC(v2) << endl;
	cout << FunctionC(v3) << endl;
	cout << FunctionC(v4) << endl;
}

// A sneaky way to allow 1 function to print any typed array, as long as
// the passed array element can be sent to <<.
// The stringstream allows us to 'print' information to a fake output
// stream, and then get the result as a string.  It's a simple way of
// getting a non-string/character into a string.
// Contense of this function will not be tested in this course!

template<typename T>
string print(vector<T> vect) {
	stringstream out;
	out << '[';
	for (int i = 0; i < vect.size(); i++) {
		out << vect[i];
		if (i != vect.size() - 1)out << ',';
	}
	out << ']';
	return out.str();
}


template<typename T>
string print(T array[], int length) {
	stringstream out;
	out << '[';
	for (int i = 0; i < length; i++) {
		out << array[i];
		if (i != length - 1)out << ',';
	}
	out << ']';
	return out.str();
}
