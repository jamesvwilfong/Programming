//James Wilfong
//simulation of a game of chance

#include "pch.h"
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

//returns a random integer in range 1-6
int rollDie() {
	return rand() % 6 + 1;
}

//return true if the game is won by the user, and returns false if the game is lost
bool playOneGame(int point) {
	for (int i = 1; i <= 3; i++) {
		int roll = rollDie();
		cout << "Roll #" << i << " is " << roll << endl;
		if (roll == point) {
			cout << "** You Win! **" << endl;
			return true;
			break;
		}
		else if (i == 3) {
			cout << "** You Lose **" << endl;
			return false;
		}
	}
}

void Display(int Balance, int &wager) {
	cout << "Account balance $" << Balance << endl;
	cout << "Enter wager (0 to exit): ";
	cin >> wager;
	while (wager<0 || wager>Balance) {
		cout << "Error: You must wager between $1 and $" << Balance << "(type 0 to exit): ";
		cin >> wager;
	}
}

void displayStats(double totalWins,double totalLosses) {
	cout << "You won " << totalWins << " time out of " << totalWins + totalLosses << " for a winning percentage of " << (totalWins / (totalLosses + totalWins)) * 100 << "%";
}

//loop control structure that keeps repeating the game, and tracks the number of wins and losses
//continue until the user enters 0 for wager or balance reaches 0
void diceGame() {
	int point;
	double totalWins = 0;
	double totalLosses = 0;
	int wager = 50;
	int balance = 100;

	while (balance != 0) {
		Display(balance,wager);
		if (wager == 0)
			break;
		cout << endl << endl;
		cout << "Enter your point value (1-6): ";
		cin >> point;
		while (point > 6 || point < 1) {
			cout << "Error: Enter your point value, must be between 1 and 6: ";
			cin >> point;
		}
		bool flag = playOneGame(point);
		if (flag == true) {
			totalWins += 1;
			balance += wager;
		}
		else {
			totalLosses += 1;
			balance -= wager;
		}
	}
	if (balance == 0) {
		cout << "Game over, you are out of money!" << endl;
	}
	cout << "Your final account balance is $" << balance << endl;
	displayStats(totalWins,totalLosses);
}

int main()
{
	srand(time(NULL));
	diceGame();
}
