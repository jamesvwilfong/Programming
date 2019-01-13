#include "pch.h"
#include <iostream>

using namespace std;

// A function to return the absolute value of an integer number
int absolute(int a) {
	return (a < 0) ? a * -1 : a;
}

//A function to return the minimum value of two integer numbers
int minimum(int a, int b) {
	return (a < b) ? a : b;
}

//A function to return the maximum value of two integer numbers
int maximum(int a, int b) {
	return (a > b) ? a : b;
}

//A function to swap two integers
void swapEm(int &a, int &b) {
	int temp = a;
	a = b;
	b = temp;
}

int main()
{
	cout << absolute(-11)<< " Expected: 11" << endl;
	cout << minimum(4, 16)<< " Expected: 4" << endl;
	cout << maximum(4, 16) << " Expected: 16" << endl;
	int a = 12;
	int b = 7;
	swapEm(a, b);
	cout << a << " Expected: 7"<<endl;
	cout << b << " Expected: 12" << endl;
}
