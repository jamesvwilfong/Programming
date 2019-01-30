/* Homework 1: Working with Files and Structures
* File: DSHW1.cpp
* Date: 29 January 2019
* By: Andrew Nease, James Wilfong
* neasaw, wilfonjv
* Section: 001
*
* ELECTRONIC SIGNATURE
* Andrew Nease, James V. Wilfong IV
*
* The electronic signatures above indicate the script
* submitted for evaluation is the combined effort of all
* team members and that each member of the team was an
* equal participant in its creation. In addition, each
* member of the team has a general understanding of all
* aspect of the script development and execution.
*
* A BRIEF DESCRIPTION OF WHAT THE SCRIPT OR FUNCTION DOES
* Takes the plain text from a series of formatted files
* and creates a card catalog file and a statistics file
*/

#include "pch.h"
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

struct Book {
	string title;
	string authorName;
	int wordCount;
	double letterFreq[26];
	int lineCount;
};

class BookStats {
public:
	// default constructor
	BookStats() { openBook(); }
	// destructor
	~BookStats(){}

private:

	void openBook();
	void processBook();
	void displayStats();
	void letterFrequency();
	void letterCount();
	void writeData();

	Book mobyDick;
	char letter;
	ifstream bookFile;
	string line;
	string fileName;
	double totalLetter;
	char asciiChar[26];
	const int ascii[26] = { 97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122 };
	int letterTotals[26] = {};
};

// appends the data of the Book to a file
// called CardCatalog.txt
void BookStats::writeData() {

	ofstream writeOut;
	writeOut.open("CardCatalog.txt", ios::app);
	writeOut << "Title: " << mobyDick.title << endl;
	writeOut << "Author: " << mobyDick.authorName << endl;
	writeOut << "Word count: " << mobyDick.wordCount << endl;
	writeOut << "Line count: " << mobyDick.lineCount << endl << endl;
	writeOut.close();

}

// Takes a string representing the name of a file,
// and attempts to open that file
// If the file is not opened, the user is asked to 
// enter another file name. This prompt is repeated 
// until the name of a file that can be opened is entered 
void BookStats::openBook() {

	cout << "Please enter file name: " << endl;
	cin >> fileName;
	
	bookFile.open(fileName);

	while (!bookFile.is_open()) {
		cout << "ERROR: File not found. Please enter file name: " << endl;
		cin >> fileName;
		bookFile.open(fileName);
	}

	if ((bookFile.is_open())) {
		processBook();
	}

}

// this function reads the open file line by line 
// in order to retrieve the word count, line count,
// book title, book author, and letter frequency
void BookStats::processBook() {

	mobyDick.lineCount = 0;
	mobyDick.wordCount = 0;
	totalLetter = 0;


	while (!bookFile.eof()) {

		getline(bookFile, line);

		if (mobyDick.lineCount == 0) {
			mobyDick.title = line;
		}

		else if (mobyDick.lineCount == 1) {
			mobyDick.authorName = line;
		}

		else if (mobyDick.lineCount > 2) {
			for (int i = 0; i < line.length(); i++) {

				letter = line[i];
				letterCount();


				if (letter == ' ') {
					mobyDick.wordCount++;
				}

				else if (i == (line.length() - 1)) {
					mobyDick.wordCount++;
				}
			}
		}

		mobyDick.lineCount += 1;

	}

	letterFrequency();
	mobyDick.lineCount -= 3;
	bookFile.close();
	writeData();

	char choice;
	cout << "Would you like to see the letter frequency?" << endl << "Enter Y or N: ";
	cin >> choice;

	while ((choice != 'Y') && (choice != 'N')) {
		cout << "Please enter valid choice (Y or N): ";
		cin >> choice;
	}

	if (choice == 'Y') displayStats();

	cout << "Do you wish to process another book?" << endl << "Enter Y or N: ";
	cin >> choice;

	while ((choice != 'Y') && (choice != 'N')) {
		cout << "Please enter valid choice (Y or N): ";
		cin >> choice;
	}

	if (choice == 'Y') {
		openBook();
	}
}

// displays the letter frequency statistics to the
// console window, and also writes them to a file 
// called statistics.txt
void BookStats::displayStats() {
	ofstream writeStatistics;
	writeStatistics.open("statistics.txt", ios::app);
	cout << mobyDick.title << " letter frequency: " << endl;
	writeStatistics << mobyDick.title << " letter frequency: " << endl;
	for (int i = 0; i < 26; i++) {
		asciiChar[i] = ascii[i];
		cout << setprecision(3) << asciiChar[i] << ": " << mobyDick.letterFreq[i] << "% " << endl;
		writeStatistics << setprecision(3) << asciiChar[i] << ": " << mobyDick.letterFreq[i] << "% " << endl;
	}
	cout << endl;
	writeStatistics << endl;
	writeStatistics.close();
}

// computes the frequency of each letter, a-z, 
// and stores the value in the proper location
// of the array letterFreq within this Book  
void BookStats::letterFrequency() {

	for (int i = 0; i < 26; i++) {
		mobyDick.letterFreq[i] = ((letterTotals[i] / totalLetter) * 100);
	}
}

// counts the total number of letters and stores
// this value in totalLetter
// counts the total number of each individual 
// letter, a-z, and stores these totals in an
// array called letterTotals
void BookStats::letterCount() {

	letter = tolower(letter);

	if (letter > 96 && letter < 123) {
		totalLetter++;
	}

	for (int i = 0; i < 26; i++) {

		if (letter == ascii[i]) {
			letterTotals[i] += 1;
		}
	}
}


int main() {
	BookStats B1;
	return 0;
}
