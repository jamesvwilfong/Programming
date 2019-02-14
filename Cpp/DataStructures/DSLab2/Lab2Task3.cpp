// Lab 2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
#include "productsInfo.h"

using namespace std;

// Function prototypes
void calcSales(productsInfo[]);
void showOrder(productsInfo[]);
void dualSort(productsInfo[]);
void showTotals(productsInfo[]);

// NUM_PRODS is the number of products produced.
const int NUM_PRODS = 9;

int main()
{

	productsInfo products[NUM_PRODS];

	// Array with product ID numbers
	int id[NUM_PRODS];

	// Array with number of units sold for each product
	int units[NUM_PRODS];

	// Array with product prices
	double prices[NUM_PRODS];

	// Array to hold the computed sales amounts
	double sales[NUM_PRODS];

	string line; 									//Holds the file input
	fstream productInfo;							//File stream object
	string fileName;
	int ctr = 0;
	cout << "Enter file name: " << endl;
	cin >> fileName;
	productInfo.open(fileName, ios::in); 			//Open the file in input mode

	while (!productInfo.is_open()) {
		cout << "ERROR: File not found. Please enter file name: " << endl;
		cin >> fileName;
		productInfo.open(fileName);
	}

	while (ctr < NUM_PRODS) { 						//Continue until all 9 array elements have been initialized 
		
		getline(productInfo, line); 				//Read an item from the file

		if (line.find("ID") != -1) {				//Checks the line for ID keyword 
			line.erase(0, 4);						//Erases the descriptor at the beginning of the line so only the important data is read
			products[ctr].id = stoi(line);			//Makes sure the class member and the line are the same type, then assigns line to the class member
		}
		else if (line.find("Units") != -1) {		//Checks the line for Units keyword
			line.erase(0, 7);
			products[ctr].units = stoi(line);
		}
		else if (line.find("Price") != -1) {		//Checks the line for Price keyword
			line.erase(0, 7);
			products[ctr].price = stod(line);
		}
		else if (line.find("Description") != -1) {	//Checks the line for Description keyword
			line.erase(0, 13);
			products[ctr].desc = line;
		}
		else if (line.find("TaxExempt") != -1) {	//Checks the line for TaxExempt keyword
			line.erase(0, 11);
			if (line == "False") {					//Returns 0 or 1 for false or true. if/else converts to numbers for the bool type
				products[ctr].taxExempt = 0;
			}
			else {
				products[ctr].taxExempt = 1;
			}
			ctr++;
		}
		else if (productInfo.eof()) {
			products[ctr].id = 0;
			products[ctr].units = 0;
			products[ctr].price = 0;
			products[ctr].desc = " ";
			products[ctr].taxExempt = 1;
			ctr++;
		}
	}
	
	if (ctr!=0) {
		// Calculate each product's sales.
		calcSales(products);

		// Sort the elements in the sales array in descending
		// order and shuffle the ID numbers in the id array to
		// keep them in parallel.
		dualSort(products);

		// Set the numeric output formatting.
		cout << setprecision(2) << fixed << showpoint;

		// Display the products and sales amounts.
		showOrder(products);

		// Display total units sold and total sales.
		showTotals(products);
	}

	productInfo.close();							//Close the text file
	
	return 0;
}
//****************************************************************
// Definition of calcSales. Accepts units, prices, and sales     *
// arrays as arguments. The size of these arrays is passed       *
// into the num parameter. This function calculates each         *
// product's sales by multiplying its units sold by each unit's  *
// price. The result is stored in the sales array.               *
//****************************************************************

void calcSales(productsInfo products[])
{
	for (int i = 0; i < NUM_PRODS; i++)
		products[i].sales = products[i].units * products[i].price;
}

//***************************************************************
// Definition of function dualSort. Accepts id and sales arrays *
// as arguments. The size of these arrays is passed into size.  *
// This function performs a descending order selection sort on  *
// the sales array. The elements of the id array are exchanged  *
// identically as those of the sales array. size is the number  *
// of elements in each array.                                   *
//***************************************************************

void dualSort(productsInfo products[])
{
	int startScan, maxIndex, tempid;
	double maxValue;

	for (startScan = 0; startScan < (NUM_PRODS - 1); startScan++)
	{
		maxIndex = startScan;
		maxValue = products[startScan].sales;
		tempid = products[startScan].id;
		for (int index = startScan + 1; index < NUM_PRODS; index++)
		{
			if (products[index].sales > maxValue)
			{
				maxValue = products[index].sales;
				tempid = products[index].id;
				maxIndex = index;
			}
		}
		products[maxIndex].sales = products[startScan].sales;
		products[maxIndex].id = products[startScan].id;
		products[startScan].sales = maxValue;
		products[startScan].id = tempid;
	}
}

//****************************************************************
// Definition of showOrder function. Accepts sales and id arrays *
// as arguments. The size of these arrays is passed into num.    *
// The function first displays a heading, then the sorted list   *
// of product numbers and sales.                                 *
//****************************************************************

void showOrder(productsInfo products[])
{
	cout << "Product Number\tSales\n";
	cout << "----------------------------------\n";
	for (int index = 0; index < NUM_PRODS; index++)
	{
		if (products[index].sales != 0) {
			cout << products[index].id << "\t\t$";
			cout << setw(8) << products[index].sales << endl;
		}
	}
	cout << endl;
}

//*****************************************************************
// Definition of showTotals function. Accepts sales and id arrays *
// as arguments. The size of these arrays is passed into num.     *
// The function first calculates the total units (of all          *
// products) sold and the total sales. It then displays these     *
// amounts.                                                       *
//*****************************************************************

void showTotals(productsInfo products[])
{
	int totalUnits = 0;
	double totalSales = 0.0;

	for (int index = 0; index < NUM_PRODS; index++)
	{
		totalUnits += products[index].units;
		totalSales += products[index].sales;
	}
	cout << "Total units Sold:  " << totalUnits << endl;
	cout << "Total sales:      $" << totalSales << endl;
}
