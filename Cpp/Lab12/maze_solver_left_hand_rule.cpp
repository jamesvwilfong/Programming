/*
Name: James Wilfong
Date: November 28 2018
Assignment: Laboratory 12
Description: randomly places a robot in any point of a room
			 as long as it is not a barrier or door way
			 and the robot finds its way out of the room
*/

#include "pch.h"
#include <iostream>
#include <string>
#include <cstdlib>
#include <cmath>
#include <ctime>
#include <vector>
#include <fstream>

using namespace std;

class Maze {
public:
	// default constructor
	Maze() {generateMaze();}

private:
	// prompts the user for maze file
	// each row of the maze is a string 
	// the characters of the string are pushed to a vector
	// that vector is then pushed to the maze vector
	void generateMaze() {
		ifstream inFS;
		string row;
		vector<char> temp;

		// opens/creates the file mazeOutput.txt and clears any content inside it
		outFS.open("mazeOutput.txt", std::ios::trunc);
		outFS.close();

		// Try to open input file
		inFS.open("mazeInput.txt");

		if (!inFS.is_open()) {
			cout << "Could not open file mazeInput.txt" << endl;
			return;
		}
		while (!inFS.eof()) {
			inFS >> row;
			if (!inFS.fail()) {
				for (int k = 0; k < row.length(); k++) {
					temp.push_back(row[k]);
				}
				maze.push_back(temp);
				temp.clear();
			}
		}
		inFS.close();
		rows = maze.size();
		columns = maze[0].size();
		placeRobot();
		robotMove();
	}

	// appends the current state of the maze to the output file
	// mazeOutput.txt
	void displayMaze() {

		// Try to open output file in append mode
		outFS.open("mazeOutput.txt", std::ios::app);

		if (!outFS.is_open()) {
			cout << "Could not open file mazeOutput.txt." << endl;
			return;
		}

		for (int i = 0; i < maze.size(); i++) {
			for (int m = 0; m < maze[i].size(); m++) {
				outFS << maze[i][m];
			}
			outFS << endl;
		}
		outFS << endl;
		outFS.close();
	}

	// tells the robot to move in the direction of the exit
	// if it is nearby
	void exitCheck() {
		if (maze[robotY - 1][robotX] == 'd')
			directionMove =  0;
		else if (maze[robotY - 1][robotX + 1] == 'd')
			directionMove = 1;
		else if (maze[robotY][robotX + 1] == 'd')
			directionMove = 2;
		else if (maze[robotY + 1][robotX + 1] == 'd')
			directionMove = 3;
		else if (maze[robotY + 1][robotX] == 'd')
			directionMove = 4;
		else if (maze[robotY + 1][robotX - 1] == 'd')
			directionMove = 5;
		else if (maze[robotY][robotX - 1] == 'd')
			directionMove = 6;
		else if (maze[robotY - 1][robotX - 1] == 'd')
			directionMove = 7;
	}

	// robot's direction based on proximity to barriers
	// used to keep the robot following the wall
	// uses robot's current direction to determine
	// where it should start looking for the wall
	int directionStart() {
		if (escaped == false) {
			if (directionMove == 5) {
				if (maze[robotY][robotX + 1] == '|')
					return 3;
				else if (maze[robotY + 1][robotX + 1] == '|')
					return 4;
				else if (maze[robotY + 1][robotX] == '|')
					return 5;
				else if (maze[robotY + 1][robotX - 1] == '|')
					return 6;
				else if (maze[robotY][robotX - 1] == '|')
					return 7;
				else if (maze[robotY - 1][robotX - 1])
					return 0;
				else if (maze[robotY - 1][robotX] == '|')
					return 1;
				else
					return 2;
			}
			else if (directionMove == 7) {
				if (maze[robotY + 1][robotX] == '|')
					return 5;
				else if (maze[robotY + 1][robotX - 1] == '|')
					return 6;
				else if (maze[robotY][robotX - 1] == '|')
					return 7;
				else if (maze[robotY - 1][robotX - 1])
					return 0;
				else if (maze[robotY - 1][robotX] == '|')
					return 1;
				else if (maze[robotY - 1][robotX + 1] == '|')
					return 2;
				else if (maze[robotY][robotX + 1] == '|')
					return 3;
				else
					return 4;
			}
			else if (directionMove == 1) {
				if (maze[robotY][robotX - 1] == '|')
					return 7;
				else if (maze[robotY - 1][robotX - 1])
					return 0;
				else if (maze[robotY - 1][robotX] == '|')
					return 1;
				else if (maze[robotY - 1][robotX + 1] == '|')
					return 2;
				else if (maze[robotY][robotX + 1] == '|')
					return 3;
				else if (maze[robotY + 1][robotX + 1] == '|')
					return 4;
				else if (maze[robotY + 1][robotX] == '|')
					return 5;
				else
					return 6;
			}
			else {
				if (maze[robotY - 1][robotX] == '|')
					return 1;
				else if (maze[robotY - 1][robotX + 1] == '|')
					return 2;
				else if (maze[robotY][robotX + 1] == '|')
					return 3;
				else if (maze[robotY + 1][robotX + 1] == '|')
					return 4;
				else if (maze[robotY + 1][robotX] == '|')
					return 5;
				else if (maze[robotY + 1][robotX - 1] == '|')
					return 6;
				else if (maze[robotY][robotX - 1] == '|')
					return 7;
				else
					return 0;
			}			
		}
	}

	// checks whether the robot has trapped itself, 
	// meaning that the robot cannot move in any direction
	// without hitting a barrier or entering a previously entered location
	// or a space not next to a wall
	bool isTrapped() {
		if ((maze[robotY - 1][robotX] == '|' || maze[robotY - 1][robotX] == '.' || !onWall(robotY-1,robotX))
			&& (maze[robotY + 1][robotX] == '|' || maze[robotY + 1][robotX] == '.'|| !onWall(robotY + 1, robotX))
			&& (maze[robotY][robotX - 1] == '|' || maze[robotY][robotX - 1] == '.' || !onWall(robotY, robotX - 1))
			&& (maze[robotY][robotX + 1] == '|' || maze[robotY][robotX + 1] == '.' || !onWall(robotY, robotX + 1))
			&& (maze[robotY - 1][robotX - 1] == '|' || maze[robotY - 1][robotX - 1] == '.' || !onWall(robotY - 1, robotX - 1))
			&& (maze[robotY - 1][robotX + 1] == '|' || maze[robotY - 1][robotX + 1] == '.' || !onWall(robotY - 1, robotX + 1))
			&& (maze[robotY + 1][robotX + 1] == '|' || maze[robotY + 1][robotX + 1] == '.' || !onWall(robotY + 1, robotX + 1))
			&& (maze[robotY + 1][robotX - 1] == '|' || maze[robotY + 1][robotX - 1] == '.') || !onWall(robotY + 1, robotX - 1))
			return true;
		else
			return false;
	}

	// returns true if there is a wall near the position, 
	// false otherwise
	bool onWall(int y, int x) {
		if (y == 0 || x == 0 || y == rows - 1 || x == columns - 1)
			return true;
		if (maze[y - 1][x] == '|'
			|| maze[y + 1][x] == '|'
			|| maze[y][x - 1] == '|'
			|| maze[y][x + 1] == '|'
			|| maze[y - 1][x - 1] == '|'
			|| maze[y - 1][x + 1] == '|'
			|| maze[y + 1][x + 1] == '|'
			|| maze[y + 1][x - 1] == '|')
			return true;
		else
			return false;
	}

	// algorithm that controls the movement of the robot
	// through the maze using the left-hand rule
	void movement(int y, int x) {
		// checks if movement will enter a doorway
		if (maze[y][x] == 'd')
			escaped = true;
		// allows robot to move if it is an open space, a doorway, 
		// or if it is a previously visited space and the robot has trapped itself
		// and if that space is next to a wall or the robot has not yet made it to a wall
		if ((maze[y][x] == 'n' || maze[y][x] == 'd'
			|| (isTrapped() && maze[y][x] == '.')) && (onWall(y, x) || !onWall(robotY,robotX))) {
			maze[robotY][robotX] = '.';
			maze[y][x] = 'R';
			robotY = y;
			robotX = x;
			displayMaze();
			directionMove = directionStart();
		}
		else {
			if (directionMove == 7)
				directionMove = 0;
			else
			    	directionMove++;
		}
	}

	// Robot chooses a direction (north, south, west, east, northeast, northwest, southeast, and southwest) to go. 
	// Once the direction is decided the robot will attempt to move in that direction. 
	// If the path is blocked by a barrier (wall) it will need to find another path. 
	// Once it finds a doorway the simulation ends.
	void robotMove() {

		// initializes the movement of the robot based on it's proximity to a wall
		directionMove = directionStart();
		do {
			// checks for exits and adjusts direction if nearby 
			exitCheck();
			switch(directionMove){
			
				// movement north
				case 0:
					// ensures robot is not at very top of the maze
					if (robotY != 0) {
						movement(robotY - 1, robotX);
					}
					break;
				// movement northeast
				case 1:
					//ensures robot is not at very right or very top of the maze
					if (robotX != columns - 1 && robotY != 0) {
						movement(robotY - 1, robotX + 1);
					}
					break;
				// movement east
				case 2:
					// ensures robot is not at very right of the maze
					if (robotX != columns - 1) {
						movement(robotY, robotX + 1);
					}
					break;
				// movement southeast
				case 3:
					// ensures robot is not at very right or very bottom of the maze
					if (robotX != columns - 1 && robotY != rows - 1) {
						movement(robotY + 1, robotX + 1);
					}
					break;
				// movement south
				case 4:
					// ensures robot is not at very bottom of the maze
					if (robotY != rows - 1) {
						movement(robotY + 1, robotX);
					}
					break;
				// movement southwest
				case 5:
					// ensures robot is not at very left or very bottom of the maze
					if (robotX != 0 && robotY != rows - 1) {
						movement(robotY + 1, robotX - 1);
					}
					break;
				// movement west
				case 6:
					// ensures robot is not at very left of the maze
					if (robotX != 0) {
						movement(robotY, robotX - 1);
					}
					break;
				// movement northwest
				case 7:
					// ensures robot is not at very left or very top of the maze
					if (robotX != 0 && robotY != 0) {
						movement(robotY - 1, robotX - 1);
					}
					break;
			}
		} while (escaped == false);
	}

	// randomly places the robot in any point of the maze
	// as long as it is not a barrier or door way
	void placeRobot() {
		do {
			robotY = rand() % rows;
			robotX = rand() % columns;
		} while (maze[robotY][robotX] != 'n');
		maze[robotY][robotX] = 'R';
		displayMaze();
	}

	bool escaped = false;
	ofstream outFS;
	int directionMove;
	int robotX;
	int robotY;
	int columns = 0;
	int rows = 0;
	vector<vector<char>> maze;
};

int main() {
	srand(time(0));
	Maze newMaze;
	return 0;
}
