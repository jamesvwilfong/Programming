/*
Name: James Wilfong
Date: October 25 2018
Assignment: Laboratory 8
Description: The program will generate a series of random numbers that will all fall within a user defined range. 
             The program will count the number of times each number occurs in the randomized input data.
*/

#include "pch.h"
#include <iostream>
#include <vector>
#include <ctime>
#include <iomanip>

using namespace std;

// struct that contains a vector, it's size, max, and min so that these values 
// can be accesed easily an any function simply by passing in a single Vect parameter
struct Vect {
	vector<int> vect;
	int maxVal;
	int lowVal;
	int range;
};

// Generate a random number based on a specified start and end number.
// This function should be able to generate random numbers for any range up to RAND_MAX
int generateRandomNumber(Vect &in_vector) {
	return rand() % (in_vector.maxVal - in_vector.lowVal + 1) + in_vector.lowVal;
}

// Create a frequency count vector containing counts of random numbers from a user defined range.
void randomVector(Vect &in_vector) {
	for (int i = 0; i < in_vector.range; i++) {
		in_vector.vect.push_back(generateRandomNumber(in_vector));
	}
}

// Print the array in a formatted manner.
void printArray(Vect in_vector) {
	cout << "[";
	for (int i = 0; i < in_vector.range; i++) {
		cout << in_vector.vect[i];
		if (i != in_vector.range - 1)
			cout << ",";
	}
	cout << "]" << endl;
}

// Print array statistics including sum, standard deviation, average value, max, and min.
void vectorStatistics(const Vect given_vector) {
	int sum = 0;
	int maxVal = given_vector.vect[0];
	int minVal = given_vector.vect[0];
	for (int i = 0; i < given_vector.range; i++) {
		sum = sum + given_vector.vect[i];
		if (given_vector.vect[i] < minVal) {
			minVal = given_vector.vect[i];
		}
		if (given_vector.vect[i] > maxVal)
			maxVal = given_vector.vect[i];
	}
	cout << "Sum: " << sum << endl;
	cout << "Maximum Value: " << maxVal << endl;
	cout << "Minimum Value: " << minVal << endl;
	int ave = 0;
	if (given_vector.range != 0) {
		for (int j = 0; j < given_vector.range; j++) {
			ave = ave + given_vector.vect[j];
		}
	}
	ave = ave / given_vector.range;
	cout << "Average: " << ave << endl;
	int standev = 0;
	if (given_vector.range != 0) {
		for (int k = 0; k < given_vector.range; k++) {
			standev = standev + pow(given_vector.vect[k] - ave, 2);
		}
	}
	standev = sqrt(standev / given_vector.range);
	cout << "Standard Deviation: " << standev << endl;
}

// Display a horizontal barchart scaled to fit the page.
void displayChart(Vect in_vector) {
	cout << "Bar Graph: " << endl;
	cout << "Value\t-Count" << endl;
	for (int i = in_vector.lowVal; i <= in_vector.maxVal; i++) {
		cout << setw(5) << i << "\t- ";
		int count = 0;
		for (int j = 0; j < in_vector.range; j++){
			if(in_vector.vect[j]==i)
			count++;
		}
		count = count / (in_vector.range/3000); //ensures the chart will display within the window even with a very large number of samples
		for (int k = 0; k < count; k++) {
			cout << "*";
		}
		cout << endl;
	}
}

int main()
{
	Vect newVect;
	srand(time(0));
	do {
		cout << "Number of Samples(must be at least 10000): ";
		cin >> newVect.range;
	} while (newVect.range < 10000);

	cout << "Lowest Value: ";
	cin >> newVect.lowVal;
	do {
		cout << "Highest Value(>= lowest value and less than 100): ";
		cin >> newVect.maxVal;
	} while (newVect.maxVal < newVect.lowVal || newVect.maxVal>100);
	randomVector(newVect);
	vectorStatistics(newVect);
	displayChart(newVect);
}
