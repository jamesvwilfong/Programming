*/
Name: James Wilfong
Date: October 31 2018
Assignment: Laboratory 8
Description: This demostrates both classes, operator overloading,
			 and multiple file linking
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>

using namespace std;

class Cube {
public:
	Cube() { setL(0); } // default
	Cube(double in_l) { // overloaded constructor 1
		setL(in_l); 
	}
	
	void display();
	
	void setL(double in_l) {
		l = in_l;
		setVol();
		setSA();
	}
	
	double getL() { return l; }

private:
	void setSA() {
		sa = 6 * pow(getL(),2);
	}
	void setVol() {
		vol = pow(getL(),3);
	}
	double l;

	double sa;
	double vol;
};


void Cube::display() {

	cout << "Side Length: " << getL() << endl;
	cout << "Sa: " << sa << endl;
	cout << "Volume: " << vol << endl;
}

int main() {
	Cube R0;
	Cube R1;
	Cube R2(9);


	R0.setL(5);

	cout << " Expected: Side Length: 5" << endl;
	cout << "           Sa: 150" << endl;
	cout << "           Volume: 125" << endl;
	cout << " Expected: Side Length: 0" << endl;
	cout << "           Sa: 0" << endl;
	cout << "           Volume: 0" << endl;
	cout << " Expected: Side Length: 9" << endl;
	cout << "           Sa: 486" << endl;
	cout << "           Volume: 729" << endl << endl;

	R0.display();
	R1.display();
	R2.display();

	return 0;
}
