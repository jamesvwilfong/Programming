#include "pch.h"
#include <iostream>

using namespace std;

//returns a true if an integer number is a prime or false if it is not
bool isPrime(int a) {
	bool result = true;
	if (a <= 1)
		result = false;
	else if (a == 2)
		result = true;
	else {
		for (int i = 2; i <= a / 2; i++) {
			if (a%i == 0)
				result = false;
		}
	}
	return result;
}
int main() {

	cout << isPrime(-5) << " Expected: 0" << endl;
	cout << isPrime(11) << " Expected: 1" << endl;
	cout << isPrime(8) << " Expected: 0" << endl;	
	cout << isPrime(1) << " Expected: 0" << endl;
	cout << isPrime(191) << " Expected: 1" << endl;
}

// this is a test
