/*
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

class Cylinder {
public:
	Cylinder() { setH(0); setR(0); } // default
	Cylinder(double in_h, double in_r) { // overloaded constructor 1
		setH(in_h);
		setR(in_r);
	}

	void display();

	void setH(double in_h) {
		h = in_h;
		setVol();
		setSA();
	}
	void setR(double in_r) {
		r = in_r;
		setVol();
		setSA();
	}

	double getH() { return h; }
	double getR() { return r; }

private:
	void setSA() {
		sa = (2 * PI * r * h) + (2 * PI * (r * r));
	}
	void setVol() {
		vol = PI * h * (r * r);
	}
	double h;
	double r;
	const double PI = 3.14159265359;

	double sa;
	double vol;
};


void Cylinder::display() {

	cout << "Height: " << getH() << endl;
	cout << "Radius: " << getR() << endl;
	cout << "Sa: " << sa << endl;
	cout << "Volume: " << vol << endl;
}

int main() {
	Cylinder R0;
	Cylinder R1;
	Cylinder R2(9,3);


	R0.setH(5);
	R0.setR(5);

	cout << " Expected: Height: 5" << endl;
	cout << "           Radius: 5" << endl;
	cout << "           Sa: 314.16" << endl;
	cout << "           Volume: 392.7" << endl;
	cout << " Expected: Height: 0" << endl;
	cout << "           Radius: 0" << endl;
	cout << "           Sa: 0" << endl;
	cout << "           Volume: 0" << endl;
	cout << " Expected: Height: 9" << endl;
	cout << "           Radius: 3" << endl;
	cout << "           Sa: 226.19" << endl;
	cout << "           Volume: 254.47" << endl << endl;

	R0.display();
	R1.display();
	R2.display();

	return 0;
}
