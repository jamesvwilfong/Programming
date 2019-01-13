/*
Name: James Wilfong
Date: October 18 2018
Assignment: Laboratory 7
Description: Various Integer and String functions
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <iomanip>
#include <sstream>
#include <vector>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

// Accepts an integer array, its length, and a integer value to find.
// It returns true if value exists in the array. 
// Otherwise it returns false if not found.
bool itExists(int array[], int length, int value) {
	bool flag = false;
	for (int i = 0; i < length; i++) {
		if (array[i] == value)
			flag = true;
	}
	return flag;
}

// Accepts an integer array and length. 
// It determines if it is sorted in ascending numeric order. 
// Returns true, if it is sorted or false if it is not.
bool isSorted(int array[], int length) {
	bool flag = true;
	for (int i = 0; i < length-1; i++) {
		if (array[i] > array[i + 1])
			flag = false;
	}
	return flag;
}

// Accepts an integer vector.  
// This function flips the order, so the first element becomes the last and the last, the first, etc. 
// Returns nothing, but the provided vector will be changed.  Should work for ANY sized vector
void reverse(vector <int> &reverse_me) {
	for (int i = 0; i < reverse_me.size()/2; i++) {
		int val1 = reverse_me[i];
		int val2 = reverse_me[reverse_me.size() - i-1];
		reverse_me[i] = val2;
		reverse_me[reverse_me.size() - i-1] = val1;
	}
}

// Accepts a float vector.  
// This function returns the mean of the elements of the vector.  
// Return 0 if the vector is empty.
float mean(const vector <float> values) {
	if (values.size() == 0)
		return 0;
	float sum = 0;
	for (int i = 0; i < values.size(); i++) {
		sum = sum + values[i];
	}
	return sum / values.size();
}

// Given a float array vector return the population standard deviation as a double (divide by N not N-1). 
// Return 0.0 if the vector is empty
float stddev(const vector <float> values) {
	if (values.size() == 0)
		return 0.0;
	float result = 0;
	for (int i = 0; i < values.size(); i++) {
		result = result + pow((values[i] - mean(values)), 2);
	}
	return sqrt(result / values.size());
}

// Accepts an int vector and returns a new vector.  
// This function should return a new vector with all duplicate elements removed.
vector<int> removeDups(vector<int> array) {
	if (array.size() == 0)
		return array;
	vector<int> temp = array;
	bool flag = true;
	for (int i = 0; i < temp.size(); i++) {
		if (temp[i] != temp[0])
			flag = false;
		for (int j = i+1; j < temp.size(); j++) {
			if (temp[j] == temp[i])
				temp.erase(temp.begin() + j);
		}
	}
	if (flag == true) {
		temp.clear();
		temp.push_back(array[0]);
	}
	return temp;
}

// Strings 

// Given a string, return the number of punctuation characters
unsigned int countPunctChars(const string &countme) {
	int sum = 0;
	for (int i = 0; i < countme.length(); i++) {
		if (ispunct(countme.at(i)))
			sum += 1;
	}
	return sum;
}

// Given a string, return the number of uppercase characters
unsigned int countUpperCaseChars(const string &countme) {
	int sum = 0;
	for (int i = 0; i < countme.length(); i++) {
		if (isupper(countme.at(i)))
			sum += 1;
	}
	return sum;
}

// Given a string, return the number of lowercase characters
unsigned int countLowerCaseChars(const string &countme) {
	int sum = 0;
	for (int i = 0; i < countme.length(); i++) {
		if (islower(countme.at(i)))
			sum += 1;
	}
	return sum;
}

// Given a string, return the position in the string of the character with the maximum ASCII value
unsigned int positionOfMaxAsciiValue(const string &countme) {
	if (countme.length() == 0)
		return -1;
	int val = 0;
	for (unsigned i = 0; i < countme.length() - 1; i++) {
		if (countme[i + 1] > countme[i])
			val = i + 1;
	}
	return val;
}

// Given an input string convert all alphabetic characters to uppercase. 
// Return a new string converted to uppercase. 
// If the input string is empty just return the input string.
string convertToUpper(const string &to_be_converted) {
	if (to_be_converted.length() == 0)
		return to_be_converted;
	string temp;
	for (int i = 0; i < to_be_converted.length(); i++) {
		temp.push_back(toupper(to_be_converted[i]));
	}
	return temp;
}

// Given an input string convert all alphabetic characters to lower case. 
// Return a new string converted to lowercase. 
// If the input string is empty just return the input string.
string convertToLower(const string &to_be_converted) {
	if (to_be_converted.length() == 0)
		return to_be_converted;
	string temp;
	for (int i = 0; i < to_be_converted.length(); i++) {
		temp.push_back(tolower(to_be_converted[i]));
	}
	return temp;
}

// Given an input string remove all spaces from this string. 
// Return a new string with spaces removed. 
// If the input string is empty return the original string.
string removeSpaces(const string &remove_from_me) {
	if (remove_from_me.length() == 0)
		return remove_from_me;
	string temp = remove_from_me;
	bool flag = true;
	for (int i = 0; i < temp.length(); i++) {
		if (isspace(temp[i]))
			temp.erase(i, 1);
		if (!isspace(temp[i]))
			flag = false;
	}
	if (flag == true)
		return "";
	else
		return temp;
}

// Given a string, return a vector of ints of length 26 containing the number of times each letter was seen.
vector <int> characterCounts(const string &countme) {
	vector<int> result(26, 0);
	for (int i = 0; i < countme.length(); i++) {
		switch (tolower(countme[i])) {
		case 'a':
			result[0]++;
			break;
		case 'b':
			result[1]++;
			break;
		case 'c':
			result[2]++;
			break;
		case 'd':
			result[3]++;
			break;
		case 'e':
			result[4]++;
			break;
		case 'f':
			result[5]++;
			break;
		case 'g':
			result[6]++;
			break;
		case 'h':
			result[7]++;
			break;
		case 'i':
			result[8]++;
			break;
		case 'j':
			result[9]++;
			break;
		case 'k':
			result[10]++;
			break;
		case 'l':
			result[11]++;
			break;
		case 'm':
			result[12]++;
			break;
		case 'n':
			result[13]++;
			break;
		case 'o':
			result[14]++;
			break;
		case 'p':
			result[15]++;
			break;
		case 'q':
			result[16]++;
			break;
		case 'r':
			result[17]++;
			break;
		case 's':
			result[18]++;
			break;
		case 't':
			result[19]++;
			break;
		case 'u':
			result[20]++;
			break;
		case 'v':
			result[21]++;
			break;
		case 'w':
			result[22]++;
			break;
		case 'x':
			result[23]++;
			break;
		case 'y':
			result[24]++;
			break;
		case 'z':
			result[25]++;
			break;
		}
	}
	return result;
}

template<typename T>
string print(vector<T> vec);

template<typename T>
string print(T array[], int length);


int main() {
	srand(time(0));

	cout << "itExists:" << endl;
	int x1[10] = { 1,2,3,5,5,6,7,8,9,0 };

	cout << "false/0 = " << itExists(x1, 10, 4) << endl;
	cout << "false/0 = " << itExists(x1, 10, 99) << endl;
	cout << "true/1 = " << itExists(x1, 10, 5) << endl;
	cout << "true/1 = " << itExists(x1, 10, 0) << endl;
	cout << "true/1 = " << itExists(x1, 10, 1) << endl;
	cout << "true/1 = " << itExists(x1, 10, 6) << endl;
	cout << endl;
	cout << endl;
	cout << "isSorted:" << endl;
	cout << "false/0 = " << isSorted(x1, 10) << endl;
	cout << endl;
	cout << endl;
	cout << "reverse:" << endl;
	vector <int> v1 = { 1,2,3,4,5 };
	reverse(v1);
	cout << "[5,4,3,2,1] = " << print(v1) << endl;
	reverse(v1);
	cout << "[1,2,3,4,5] = " << print(v1) << endl;
	vector <int> v2 = { 5 };
	cout << "[5] = " << print(v2) << endl;
	vector <int> v3 = { 1,2,4,5 };
	reverse(v3);
	cout << "[5,4,2,1] = " << print(v3) << endl;
	vector <int> v4(100);
	v4[0] = 4;
	v4[1] = 2;
	reverse(v4);
	cout << "0 = " << v4[0] << endl;
	cout << "2 = " << v4[98] << endl;
	cout << "4 = " << v4[99] << endl;

	cout << endl << "mean:" << endl;
	vector <float> f1 = { 1.2, 2.4, 3.4 };
	vector <float> f2 = { 5.6, 5.6, 5.6, 5.6, 5.6, 5.6 };
	cout << "2.33 = " << mean(f1) << endl;
	cout << "5.6 = " << mean(f2) << endl;

	cout << endl << "stddev:" << endl;
	cout << "0.899 = " << stddev(f1) << endl;
	cout << "0 = " << stddev(f2) << endl;

	cout << endl << "removedups:" << endl;
	vector<int> v5;
	v5.push_back(1);
	v5.push_back(2);
	v5.push_back(3);
	v5.push_back(3);
	v5.push_back(4);
	v5.push_back(5);
	v5.push_back(1);
	vector<int> v12 = removeDups(v5);
	cout << "[1,2,3,4,5] = " << print(v12) << endl;
	cout << "5 = " << v12.size() << endl;
	vector<int> v6;
	for (int i = 0; i < 100; i++) {
		v6.push_back(i % 17 + i % 7);
	}
	vector<int> v22 = removeDups(v6);
	cout << "22 = " << v22.size() << endl;
	vector<int> v20(20, 1);
	vector<int> vtest = removeDups(v20);
	cout << "[1] = " << print(vtest) << endl;
	cout << "1 = " << vtest.size() << endl << endl;

	cout << "\nString Functions: " << endl;
	string upper_test = "aaABCdeFG";
	cout << "countUpperCase" << endl;
	cout << "5 = " << countUpperCaseChars(upper_test) << endl;
	cout << "5 = " << countUpperCaseChars("AAAAA") << endl;
	cout << "0 = " << countUpperCaseChars("aaaaa") << endl;
	string no_upper_case = "aaaa";
	cout << "0 = " << countUpperCaseChars(no_upper_case) << endl << endl;

	string lower_test = "aaABCdeFG";
	cout << "countLowerCase" << endl;
	cout << "4 = " << countLowerCaseChars(lower_test) << endl;
	cout << "0 = " << countLowerCaseChars("AAAAA") << endl;
	cout << "5 = " << countLowerCaseChars("aaaaa") << endl;
	string no_lower_case = "AAAAA";
	cout << "0 = " << countLowerCaseChars(no_lower_case) << endl << endl;

	string punct_test = "aaA.BCde!F?G..";
	cout << "countPunctCase" << endl;
	cout << "5 = " << countPunctChars(punct_test) << endl;
	cout << "5 = " << countPunctChars(".....") << endl;
	cout << "0 = " << countPunctChars("aaaaa") << endl;
	string no_punct_case = "aaaa";
	cout << "0 = " << countPunctChars(no_punct_case) << endl << endl;

	string max_test = "abcdefg";
	cout << "positionOfMaxAsciiValue" << endl;
	cout << "6 = " << positionOfMaxAsciiValue(max_test) << endl;
	cout << "0 = " << positionOfMaxAsciiValue("gfedcb") << endl;
	cout << "3 = " << positionOfMaxAsciiValue("abdxbb") << endl;
	string empty_string__case = "";
	cout << "-1 = " << positionOfMaxAsciiValue(empty_string__case) << endl << endl;

	cout << "RemoveSpaces:" << endl;
	string test1 = "aa AB Cd e FG";
	string test2 = "aaAB Cd e FG ";
	string test3 = " rrAB Cd e FG";
	string test4 = " rrAB Cd e FG ";

	cout << "aaABCdeFG = " << removeSpaces(test1) << endl;
	cout << "aaABCdeFG = " << removeSpaces(test2) << endl;
	cout << "rrABCdeFG = " << removeSpaces(test3) << endl;
	cout << "rrABCdeFG = " << removeSpaces(test4) << endl << endl;

	cout << "ConvertToUpper" << endl;
	string test5 = "aaaaa";
	string test6 = "AAAAA";
	string test7 = "aB cD";
	string test8 = "aa bb CC";

	cout << "AAAAA = " << convertToUpper(test5) << endl;
	cout << "AAAAA = " << convertToUpper(test6) << endl;
	cout << "AB CD = " << convertToUpper(test7) << endl;
	cout << "AA BB CC = " << convertToUpper(test8) << endl << endl;

	cout << "ConvertToLower" << endl;
	cout << "aaaaa = " << convertToLower(test5) << endl;
	cout << "aaaaa = " << convertToLower(test6) << endl;
	cout << "ab cd = " << convertToLower(test7) << endl;
	cout << "aa bb cc = " << convertToLower(test8) << endl << endl;

	cout << "CharacterCounts" << endl;
	cout << "[1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0] = " << print(characterCounts("abb")) << endl;
	cout << "[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0] = " << print(characterCounts("")) << endl;
	cout << "[1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3] = " << print(characterCounts("abbzzz")) << endl;
	cout << "[0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0] = " << print(characterCounts("bYYYYb")) << endl << endl;

	

	return 0;
}

// A sneaky way to allow 1 function to print any typed array, as long as
// the passed array element can be sent to <<.
// The stringstream allows us to 'print' information to a fake output
// stream, and then get the result as a string.  It's a simple way of
// getting a non-string/character into a string.
// Contense of this function will not be tested in this course!

template<typename T>
string print(vector<T> vect) {
	stringstream out;
	out << '[';
	for (int i = 0; i < vect.size(); i++) {
		out << vect[i];
		if (i != vect.size() - 1)out << ',';
	}
	out << ']';
	return out.str();
}


template<typename T>
string print(T array[], int length) {
	stringstream out;
	out << '[';
	for (int i = 0; i < length; i++) {
		out << array[i];
		if (i != length - 1)out << ',';
	}
	out << ']';
	return out.str();
}
