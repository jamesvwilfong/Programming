#pragma once
#include <string>
using namespace	std;
class productsInfo {		//Holds members for each product description
public:
	int id;
	int units;
	double price;
	double sales;
	string desc;
	bool taxExempt;
};
