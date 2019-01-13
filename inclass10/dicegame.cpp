#include "pch.h"
#include <iostream>
#include <ctime> 
#include <cstdlib>

using namespace std;

class DiceGame {
public:
	DiceGame() {};
	void playGame() {
		while (!end) 
		rollDice(end);
	}
private:
	bool end = false;
	void messageOutput(int a, int b, bool &end) {
		int total = a + b;
		cout << "You rolled a " << a << " and " << b << " for a total of  " << total << endl;
		switch (total) {
		case 7:
		case 9:
		case 11:
			cout << "You are a Winner!" << endl;
			end = true;
			break;
		case 2:
		case 3:
		case 5:
			cout << "Sorry: Not a winner." << endl;
			end = true;
			break;
		default:
			cout << "Try Again" << endl;
			break;
		}
	}
	//return a random number within a certain range
	int randomNumber(int range) {
		return (rand() % range) + 1;
	}
	//rolls 6-sided dice
	void rollDice(bool &end) {
		messageOutput(randomNumber(6), randomNumber(6), end);
	}
};

int main()
{
	srand((unsigned)time(0));
	DiceGame Game1;
	Game1.playGame();
	return 0;
}
