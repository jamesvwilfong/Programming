/*
Name: James Wilfong
Date: October 31 2018
Assignment: Laboratory 8
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <vector>

using namespace std;

class Maze {
public:
	Maze() { start(); status(); }; //default constructor
	void moveNorth() {
		turnsTaken++;
		if (p.y == 19) 
			cout << "You can go no further North. A wall blocks your path." << endl;
		else
			p.y++;
		status();
	};
	void moveSouth() {
		turnsTaken++;
		if (p.y == 0) 
			cout << "You can go no further South. A wall blocks your path." << endl;
		else
			p.y--;
		status();
	};
	void moveEast() {
		turnsTaken++;
		if (p.x == 19) 
			cout << "You can go no further East. A wall blocks your path." << endl;
		else
			p.x++;
		status();
	};
	void moveWest() {
		turnsTaken++;
		if (p.x == 0) 
			cout << "You can go no further West. A wall blocks your path." << endl;
		else
			p.x--;
		status();
	};
private:
	struct Latte { //Latte coordinates
		int x;
		int y;
	};
	struct Coffee { //Coffee coordinates
		int x;
		int y;
	};
	struct Monster { //Monster coordinates
		int x;
		int y;
	};
	struct Player { //Player coordinates
		int x;
		int y;
	};
	Player p;
	Latte l;
	Monster m;
	Coffee c1;
	Coffee c2;
	Coffee c3;
	Coffee c4;
	Coffee c5;
	Coffee c6;
	Coffee c7;
	Coffee c8;
	int turnsTaken = 0;
	int lattesFound = 0;

	void displayStats() {
		cout << "It took you " << turnsTaken << " turns to find this." << endl;
		cout << "You have found " << lattesFound << " lattes so far." << endl;
	}

	//displays a hint to the player based on their location 
	//to steer them away from very nearby coffee
	void giveHint(Coffee c) {
		int hintNum = rand() % 3;
		if ((p.x + 1 == c.x) && p.y == c.y) {
			switch (hintNum) {
			case 0:
				cout << "There's a very bland smell to the east." << endl;
				break;
			case 1:
				cout << "The smell of gasoline is coming from the east." << endl;
				break;
			case 2:
				cout << "I heard Kanye might have been drinking a latte." << endl;
				break;
			}
		}
		if ((p.x - 1 == c.x) && p.y == c.y) {
			switch (hintNum) {
			case 0:
				cout << "There's steam to the west, but is it from the latte or a coffee?" << endl;
				break;
			case 1:
				cout << "It is convenient to go west." << endl;
				break;
			case 2:
				cout << "You can see a sign that begins with an S to your west...Starbucks?..Speedway?" << endl;
				break;
			}
		}
		if ((p.y - 1 == c.y) && p.x == c.x) {
			switch (hintNum) {
			case 0:
				cout << "Be careful not to burn your mouth when drinking coffee." << endl;
				break;
			case 1:
				cout << "I won't tell you which direction is best." << endl;
				break;
			case 2:
				cout << "Keep your head up." << endl;
				break;
			}
		}
		if ((p.y + 1 == c.y) && p.x == c.x) {
			switch (hintNum) {
			case 0:
				cout << "I'd feel down without a latte." << endl;
				break;
			case 1:
				cout << "Winter is coming." << endl;
				break;
			case 2:
				cout << "Starbucks is booming in Texas." << endl;
				break;
			}
		}
	}

	//places the player, coffee, latte, and monster on the board 
	//by assigning random values to their x and y coordinates
	//until those coordinates are found not to be shared by any other object
	void start() {
		p.x = rand() % 20;
		p.y = rand() % 20;
		do {
			m.x = rand() % 20;
			m.y = rand() % 20;
		} while (m.x == p.x && m.y == p.y);
		do {
			l.x = rand() % 20;
			l.y = rand() % 20;
		} while ((l.x == p.x && l.y == p.y) || (l.x == m.x && l.y == m.y));
		do {
			c1.x = rand() % 20;
			c1.y = rand() % 20;
		} while ((c1.x == p.x && c1.y == p.y) || (c1.x == m.x && c1.y == m.y) || (c1.x == l.x && c1.y == l.y));
		do {
			c2.x = rand() % 20;
			c2.y = rand() % 20;
		} while ((c2.x == p.x && c2.y == p.y) || (c2.x == m.x && c2.y == m.y) || (c2.x == l.x && c2.y == l.y) 
			|| (c2.x == c1.x && c2.y == c1.y));
		do {
			c3.x = rand() % 20;
			c3.y = rand() % 20;
		} while ((c3.x == p.x && c3.y == p.y) || (c3.x == m.x && c3.y == m.y) || (c3.x == l.x && c3.y == l.y) 
			|| (c3.x == c1.x && c3.y == c1.y) || (c3.x == c2.x && c3.y == c2.y));
		do {
			c4.x = rand() % 20;
			c4.y = rand() % 20;
		} while ((c4.x == p.x && c4.y == p.y) || (c4.x == m.x && c4.y == m.y) || (c4.x == l.x && c4.y == l.y) 
			|| (c4.x == c1.x && c4.y == c1.y) || (c4.x == c2.x && c4.y == c2.y) || (c4.x == c3.x && c4.y == c3.y));
		do {
			c5.x = rand() % 20;
			c5.y = rand() % 20;
		} while ((c5.x == p.x && c5.y == p.y) || (c5.x == m.x && c5.y == m.y) || (c5.x == l.x && c5.y == l.y) 
			|| (c5.x == c1.x && c5.y == c1.y) || (c5.x == c2.x && c5.y == c2.y) || (c5.x == c3.x && c5.y == c3.y) 
			|| (c5.x == c4.x && c5.y == c4.y));
		do {
			c6.x = rand() % 20;
			c6.y = rand() % 20;
		} while ((c6.x == p.x && c6.y == p.y) || (c6.x == m.x && c6.y == m.y) || (c6.x == l.x && c6.y == l.y) 
			|| (c6.x == c1.x && c6.y == c1.y) || (c6.x == c2.x && c6.y == c2.y) || (c6.x == c3.x && c6.y == c3.y) 
			|| (c6.x == c4.x && c6.y == c4.y) || (c6.x == c5.x && c6.y == c5.y));
		do {
			c7.x = rand() % 20;
			c7.y = rand() % 20;
		} while ((c7.x == p.x && c7.y == p.y) || (c7.x == m.x && c7.y == m.y) || (c7.x == l.x && c7.y == l.y) 
			|| (c7.x == c1.x && c7.y == c1.y) || (c7.x == c2.x && c7.y == c2.y) || (c7.x == c3.x && c7.y == c3.y) 
			|| (c7.x == c4.x && c7.y == c4.y) || (c7.x == c5.x && c7.y == c5.y) || (c7.x == c6.x && c7.y == c6.y));
		do {
			c8.x = rand() % 20;
			c8.y = rand() % 20;
		} while ((c8.x == p.x && c8.y == p.y) || (c8.x == m.x && c8.y == m.y) || (c8.x == l.x && c8.y == l.y) 
			|| (c8.x == c1.x && c8.y == c1.y) || (c8.x == c2.x && c8.y == c2.y) || (c8.x == c3.x && c8.y == c3.y) 
			|| (c8.x == c4.x && c8.y == c4.y) || (c8.x == c5.x && c8.y == c5.y) || (c8.x == c6.x && c8.y == c6.y) 
			|| (c8.x == c7.x && c8.y == c7.y));
		cout << "You have entered the maze." << endl;
		cout << "Find the pumpkin spice latte, and avoid the Speedway coffee." << endl;
		cout << "Watch out for the Coffee Monster that will completely disorient you." << endl;
		cout << "Type 'q' at any time to quit the game." << endl;
		turnsTaken = 0;
	}

	//compares the coordinates of the player with the coordinates of the latte, monster, and each coffee object
	//in order to give information to the player about their location, and hint where they should move next
	void status() {
		char response = 'a';

		//win condition
		if (p.x == l.x && p.y == l.y) {
			lattesFound++;
			cout << "CONGRATULATIONS! You found the pumpkin spice latte!" << endl;
			displayStats();
			cout << "Would you like to play again?(y,n)" << endl;
			cin >> response;
			if (response == 'y') {
				start();
				status();
			}
			else {
				displayStats();
				cout << "Thank you for playing." << endl;
				abort(); //Intentionally aborts the program
			}
		}

		//lose condition
		else if (p.x == c1.x && p.y == c1.y || p.x == c2.x && p.y == c2.y || p.x == c3.x && p.y == c3.y || p.x == c4.x && p.y == c4.y
			|| p.x == c5.x && p.y == c5.y || p.x == c6.x && p.y == c6.y || p.x == c7.x && p.y == c7.y || p.x == c8.x && p.y == c8.y) {
			cout << "How unfortunate. You've found a Speedway Coffee. Game Over." << endl;
			displayStats();
			cout << "Type y to try again." << endl;
			cin >> response;
			if (response == 'y') {
				start();
				status();
			}
			else {
				displayStats();
				cout << "Thank you for playing." << endl;
				abort(); //Intentionally aborts the program
			}
		}

		//causes the monster to move to a new random location that does not already have a coffee or latte in it
		do {
			m.x = rand() % 20;
			m.y = rand() % 20;
		} while ((m.x == c8.x && m.y == c8.y) || (m.x == l.x && m.y == l.y) || (m.x == c1.x && m.y == c1.y)
				|| (m.x == c2.x && m.y == c2.y) || (m.x == c3.x && m.y == c3.y) || (m.x == c4.x && m.y == c4.y) || (m.x == c5.x && m.y == c5.y)
				|| (m.x == c6.x && m.y == c6.y) || (m.x == c7.x && m.y == c7.y));

		//monster location matches location of the player causing player to be moved to a new random location
		if (p.x == m.x && p.y == m.y) {
			cout << "The Coffee Monster found you! You are moved to a random location." << endl;
			p.x = rand() % 20;
			p.y = rand() % 20;
			status();
		}

		//player enters an empty space
		else {
			cout << "There is nothing here." << endl;
			giveHint(c1);
			giveHint(c2);
			giveHint(c3);
			giveHint(c4);
			giveHint(c5);
			giveHint(c6);
			giveHint(c7);
			giveHint(c8);
			cout << "Where would you like to go? (n, s, e, w)(q to quit)" << endl;
			do {
				cin >> response;
				if (response == 'n')
					moveNorth();
				else if (response == 's')
					moveSouth();
				else if (response == 'e')
					moveEast();
				else if (response == 'w')
					moveWest();
				else if (response == 'q') {
					cout << "You have given up on the pumpkin spice latte." << endl;
					displayStats();
					cout << "Thank you for playing." << endl;
					abort(); //Intentionally aborts the program
				}
				else
					cout << "Invalid response. Where would you like to go?(n,s,e,w)(q to quit)" << endl;
			} while (response != 'n' && response != 's' && response != 'q' && response != 'w' && response != 'e');
		}
	}
};

int main() {
	srand(time(0));
	Maze game;
	return 0;
}
