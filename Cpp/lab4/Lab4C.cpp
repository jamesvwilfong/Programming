#include "pch.h"
#include <iostream>

using namespace std;
//returns a true if the difference of the two parameters lays between  the  plus / minus of delta parameter
bool compareDelta(double num1, double num2, double delta) {
	double diff = 0;
	if (num1 > num2)
		diff = num1 - num2;
	else
		diff = num2 - num1;
	if (diff <= delta)
		return true;
	else
		return false;
}
int main()
{
	double num1, num2, delta;
	cout << "Number 1: "<<endl;
	cin >> num1;
	cout << "Number 2: " << endl;
	cin >> num2;
	cout << "Delta: " << endl;
	cin >> delta;
	if (compareDelta(num1, num2, delta))
		cout << "True";
	else
		cout << "False";

}
