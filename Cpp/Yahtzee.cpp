/*
Name: James Wilfong
Date: December 8 2018
Assignment: Final Project
Description: Yahtzee
*/

#include "pch.h"
#include <iostream>
#include <vector>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <string>

using namespace std;

class Yahtzee {
public:
	// default constructor
	Yahtzee() { beginGame(); }
private:
	// function that runs the game
	void beginGame(){
		cout << "Welcome to Yahtzee!" << endl;
		roll();
		while (finished == false) {
			rollNumber++;
			sort();
			displayDice();
			scoreChoices();
			if(finished == false){
				// prevents more than 2 rerolls
				if (rollNumber < 3)
					reroll();
				else 
					chooseScore();
			}
		}
		displayResults();
	}

	// displays the player's final score 
	void displayResults() {
		int sum = 0;
		for (int i = 0; i < score.size(); i++) {
			sum = sum + score[i].score;
		}
		cout << "Game Over." << endl;
		cout << "Final Score: " << sum << endl;
	}

	// assigns a random value between 1 and 6 to each dice
	void roll() {
		dice.clear();
		while (dice.size() < 5) {
			dice.push_back(rand() % 6 + 1);
		}
	}

	// sorts the dice in ascending order
	// without this function, other function
	// algorithms would not work properly
	// such as straight() and fullHouse()
	void sort() {
		vector<int> temp;
		while (dice.size() > 0) {
			int min = dice[0];
			int loc = 0;
			for (int i = 0; i < dice.size(); i++) {
				if (dice[i] < min) {
					min = dice[i];
					loc = i;
				}
			}
			dice.erase(dice.begin() + loc);
			temp.push_back(min);
		}
		dice.swap(temp);
	}

	// displays the value of each rolled dice 
	// in a space separated list
	void displayDice() {
		cout << "Roll #" << rollNumber << ": " << endl;
		for (int i = 0; i < dice.size(); i++) {
			cout << dice[i] << " ";
		}
		cout << endl;
	}

	// calculates and returns the sum of all dice
	// whose number match the given value
	int sum(int value) {
		int sum = 0;
		for (int i = 0; i < dice.size(); i++) {
			if (dice[i] == value)
				sum = sum + dice[i];
		}
		return sum;
	}

	// returns the sum of all rolled dice
	int total() {
		int sum = 0;
		for (int i = 0; i < dice.size(); i++) {
			sum = sum + dice[i];
		}
		return sum;
	}

	// returns the number of dice that have the same
	// value as the one given to this function
	int ofAKind(int value) {
		int same = 0;
		for (int i = 0; i < dice.size(); i++) {
			if (dice[i] == value)
				same++;
		}
		return same;
	}

	// returns 25 if there is a full house
	// 0 if not
	int fullHouse() {
		if (dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4] && dice[2] != dice[3] ||
			dice[0] == dice[1] && dice[2] == dice[3] && dice[3] == dice[4] && dice[1] != dice[2])
			return 25;
		else
			return 0;
	}

	// returns the number of dice in consecutive order
	// returns 4 for a small straight
	// returns 5 for a large straight
	int straight() {
		int count = 1;
		for (int i = 0; i < dice.size()-1; i++) {
			if (dice[i] == dice[i + 1] - 1)
				count++;
			else if(dice[i] != dice[i+1] && i != 3)
				count = 1;
		}
		return count;
	}

	// asks the user if they would like to reroll
	// if so, they are asked to identify which 
	// dice to reroll by entering a 5 character
	// string of y's and n's
	// if not, the chooseScore() function is called
	void reroll() {
		char response;
		string response2;
		int error;
		do {
			cout << "Roll Again?(y/n)" << endl;
			cin >> response;
		} while (response != 'y' && response != 'n');
		if (response == 'y') {
			do {
				error = 0;
				cout << "Indicate which dice to roll using y and n: " << endl;
				cin >> response2;
				if (response2.length() != dice.size())
					error++;
				for (int i = 0; i < response2.length(); i++) {
					if (response2.at(i) != 'n' && response2.at(i) != 'y')
						error++;
				}
			} while (error != 0);
			for (int i = 0; i < response2.length(); i++) {
				if (response2.at(i) == 'y')
					dice[i] = rand() % 6 + 1;
			}
			sort();
		}
		else {
			chooseScore();
		}
	}

	// returns true if the type of score has
	// been selected or crossed off by the user
	// previously
	bool scoreTaken(string type) {
		bool flag = false;
		int yahtzeeCount;

		// since Yahtzee can be selected up to four times
		// if not crossed off, this function only returns
		// true when type = "Yahtzee", yahtzeeCount == 4
		// or Yahtzee has been crossed off
		if (type == "Yahtzee") {
			for (int j = 0; j < score.size(); j++) {
				if (score[j].type == "Yahtzee" && score[j].score == 0)
					flag = true;
				if (score[j].type == "Yahtzee")
					yahtzeeCount++;
			}
			if (yahtzeeCount == 4)
				flag = true;
		}
		else {
			for (int j = 0; j < score.size(); j++) {
				if (score[j].type == type)
					flag = true;
			}
		}
		return flag;
	}

	// gives a suggestion to the user based on the highest 
	// scoring option they have available
	void highestOption() {
		int max = scoreOptions[0].score;
		int loc = 0;
		for (int i = 0; i < scoreOptions.size(); i++) {
			if (scoreOptions[i].score > max) {
				max = scoreOptions[i].score;
				loc = i;
			}
		}
		cout << "Your highest option is choice " << loc + 1 << " for " << max << " points." << endl;
	}

	// prompts the user to select one of the numbered
	// options displayed to them to either add to their
	// score or cross off from their options
	void chooseScore() {
		int response;
		if(scoreOptions[0].score !=0)
			highestOption();
		do {
			if (scoreOptions[0].score == 0)
				cout << "Choose what to cross off: " << endl;
			else
				cout << "Choose which score to take: " << endl;
			cin >> response;
		}while (response< 1 || response > scoreOptions.size());
		score.push_back(scoreOptions[response - 1]);

		// once one yahtzee is added for 50 points,
		// following yahtzees will give 100 points
		if (scoreOptions[response - 1].type == "Yahtzee")
			yahtzeeScore = 100;
		// resets the roll number and rolls all 5 dice
		rollNumber = 0;
		roll();
	}

	// structure used to associate a scoring type to
	// its score value
	struct scoreAndType {
		int score;
		string type;
	};

	// displays scoring options to the user
	// based on what they've rolled
	void scoreChoices(){
		// resets scoring options
		scoreOptions.clear();
		scoreAndType val;
		scoreNumber = 0;
		// flag used to determine if a scoring type has been 
		// used or crossed off previously
		bool flag;

		// 1-6 totals
		for (int i = 1; i < 7; i++) {
			flag = scoreTaken(to_string(i));
			if (sum(i) != 0 && flag == false) {
				scoreNumber++;
				cout <<scoreNumber << ". " << i << " total: " << sum(i) << endl;
				val.score = sum(i);
				val.type = to_string(i);
				scoreOptions.push_back(val);
			}
		}

		for (int i = 1; i < 7; i++) {

			// three of a kind
			flag = scoreTaken("Three of a Kind");
			if (ofAKind(i) > 2 && flag == false) {
				scoreNumber++;
				cout << scoreNumber << ". Three of a Kind: " << total() << endl;
				val.score = total();
				val.type = "Three of a Kind";
				scoreOptions.push_back(val);
			}

			// four of a kind
			flag = scoreTaken("Four of a Kind");
			if (ofAKind(i) > 3 && flag == false) {
				scoreNumber++;
				cout << scoreNumber << ". Four of a Kind: " << total() << endl;
				val.score = total();
				val.type = "Four of a Kind";
				scoreOptions.push_back(val);
			}

			// yahtzee
			flag = scoreTaken("Yahtzee");
			if (ofAKind(i) > 4 && flag == false) {
				scoreNumber++;
				cout << scoreNumber << ". YAHTZEE!: " << yahtzeeScore << endl;
				val.score = yahtzeeScore;
				val.type = "Yahtzee";
				scoreOptions.push_back(val);
			}
		}

		// full house
		flag = scoreTaken("Full House");
		if (fullHouse() != 0 && flag == false) {
			scoreNumber++;
			cout << scoreNumber << ". Full House: " << fullHouse() << endl;
			val.score = 25;
			val.type = "Full House";
			scoreOptions.push_back(val);
		}

		// small straight
		flag = scoreTaken("Small Straight");
		if (straight() == 4 && flag == false) {
			scoreNumber++;
			cout << scoreNumber << ". Small Straight: 30" << endl;
			val.score = 30;
			val.type = "Small Straight";
			scoreOptions.push_back(val);
		}

		// large straight
		flag = scoreTaken("Large Straight");
		if (straight() == 5 && flag == false) {
			scoreNumber++;
			cout << scoreNumber << ". Large Straight: 40" << endl;
			val.score = 40;
			val.type = "Large Straight";
			scoreOptions.push_back(val);
		}

		// chance
		flag = scoreTaken("Chance");
		if (flag == false) {
			scoreNumber++;
			cout << scoreNumber << ". Chance: " << total() << endl;
			val.score = total();
			val.type = "Chance";
			scoreOptions.push_back(val);
		}

		// if no options are available at this point, then the user must
		// choose a scoring type that they have not used to cross off
		// for a score of 0
		if (scoreOptions.empty()){
			cout << "No available options." << endl;

			// 1-6 totals
			for (int i = 1; i < 7; i++) {
				flag = scoreTaken(to_string(i));
				if (flag == false) {
					scoreNumber++;
					cout << scoreNumber << ". " << i << " total: 0" << endl;
					val.score = 0;
					val.type = to_string(i);
					scoreOptions.push_back(val);
				}
			}
			// three of a kind
			availableScore("Three of a Kind", val);
			// four of a kind
			availableScore("Four of a Kind", val);
			// yahtzee
			availableScore("Yahtzee", val);
			// full house
			availableScore("Full House", val);
			// small straight
			availableScore("Small Straight", val);
			// large straight
			availableScore("Large Straight", val);
			// chance
			availableScore("Chance", val);
		}
		// if scoringOptions is empty at this point,
		// there are no options to score or cross off
		// this means that the game is over so 
		// finished is set to true in order to end
		// the loop running in beginGame()
		if (scoreOptions.empty())
			finished = true;
	}

	// checks if the given scoring type is available
	// by using the scoreTaken function
	// If available(not taken), the scoring type is 
	// displayed to the user as an option to cross
	// off of their list and give 0 points
	// (reusability within the function above)
	void availableScore(string type, scoreAndType val) {
		if (!scoreTaken(type)) {
			scoreNumber++;
			cout << scoreNumber << ". " << type << ": 0" << endl;
			val.score = 0;
			val.type = type;
			scoreOptions.push_back(val);
		}
	}

	// private variables
	int yahtzeeScore = 50;
	int scoreNumber = 0;
	int rollNumber = 0;
	bool finished = false;
	vector<int> dice;
	vector<scoreAndType> score;
	vector<scoreAndType> scoreOptions;
};

// the starting point of the program
int main()
{
	srand(time(0));
	Yahtzee newGame;
	return 0;
}
