#include "pch.h"
#include <iostream>

using namespace std;

const double PI = atan(1.0)*4.0;

//takes a double as a parameter representing the degrees and returns the angle in radians
double d_to_r(double angle) {
	if (angle > 0) {
		while (angle >= 360) {
			angle = angle - 360;
		}
	}
	else {
		while (angle <= -360) {
			angle = angle + 360;
		}
	}

	return angle * PI / 180.0;
}
int main()
{
	cout << d_to_r(720) << " Expected: 0"<< endl;
	cout << d_to_r(450) << " Expected: 1.5708" << endl;
	cout << d_to_r(750) << " Expected: 0.523599" << endl;
	cout << d_to_r(-360) << " Expected: 0" << endl;
	cout << d_to_r(-750) << " Expected: -0.523599" << endl;
	cout << d_to_r(-450) << " Expected: -1.5708" << endl;
}
