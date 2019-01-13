#include "pch.h"
#include <iostream>
#include <cmath>
#include <iomanip>
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
	cout << fixed << setw(7) << "Degrees";
	cout << fixed << setw(10) << "Sine";
	cout << fixed << setw(10) << "Cosine";
	cout << fixed << setw(25) << "Tangent"<<endl;
	for (int i = 0; i <= 360; i += 10) {
		cout << fixed << setw(7) << i;
		cout << fixed << setw(10) << setprecision(4) << sin(d_to_r(i));
		cout << fixed << setw(10) << setprecision(4) << cos(d_to_r(i));
		cout << fixed << setw(25) << setprecision(4) << tan(d_to_r(i)) <<endl;
	}
    
}
