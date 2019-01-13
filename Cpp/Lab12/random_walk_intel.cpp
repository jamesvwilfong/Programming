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

using namespace std;

class Maze {
public:
	// default constructor
	Maze() {}
	// prompts the user to enter the maze row by row
	// each row is a string 
	// the characters of the string are pushed to a vector
	// that vector is then pushed to the maze vector
	// copy and pasting will work as long as the dimensions are consistent with 
	// what the user specified them to be
	void generateMaze() {
		getDimension();
		int j = 0;
		string row;
		vector<char> temp;
		cout << "Enter Maze(simply copy and paste): " << endl;
		while (j < rows) {
			cin >> row;
			// ensures that the dimensions of the maze are consistent with the dimensions
			// specified by the user in the function getDimension()
			if (row.length() != columns) {
				cout << "ERROR: Maze does not match the given dimensions";
				break;
			}
			else {
				for (int k = 0; k < row.length(); k++) {
					temp.push_back(row[k]);
				}
				maze.push_back(temp);
				j++;
				temp.clear();
			}
		}
	}
	// displays the current state of the maze
	void displayMaze() {
		for (int i = 0; i < maze.size(); i++) {
			for (int m = 0; m < maze[i].size(); m++) {
				cout << maze[i][m];
			}
			cout << endl;
		}
		cout << endl;
	}

	// randomly places the robot in any point of the room 
	// as long as it is not a barrier or door way
	void placeRobot() {
		do {
			robotY = rand() % rows;
			robotX = rand() % columns;
		} while (maze[robotY][robotX] != 'n');
		maze[robotY][robotX] = 'R';
	}

	// Robot randomly chooses a direction (north, south, west, east, northeast, northwest, southeast, and southwest)  to go. 
	// Once the direction is decided the robot will attempt to move in that direction. 
	// If the path is blocked by a barrier (wall) it will need to find another path. 
	// Once it finds a doorway the simulation ends.
	void robotMove() {
		int directionMove;
		bool escaped = false;
		do {
			
			directionMove = rand() % 8;
			// movement north
			if (directionMove == 0) {
				// ensures robot is not at very top of the maze
				if (robotY != 0) {
					// checks if movement north will enter a doorway
					if (maze[robotY - 1][robotX] == 'd')
						escaped = true;
					// allows robot to move north if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY - 1][robotX] == 'n' || maze[robotY - 1][robotX] == 'd' 
						|| (isTrapped() && maze[robotY - 1][robotX] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY - 1][robotX] = 'R';
						robotY = robotY - 1;
						displayMaze();
					}
				}
			}
			// movement south
			else if (directionMove == 1) {
				// ensures robot is not at very bottom of the maze
				if (robotY != rows - 1) {
					//checks if movement south will enter a doorway
					if (maze[robotY + 1][robotX] == 'd')
						escaped = true;
					// allows robot to move south if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY + 1][robotX] == 'n' || maze[robotY + 1][robotX] == 'd' 
						|| (isTrapped() && maze[robotY + 1][robotX] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY + 1][robotX] = 'R';
						robotY = robotY + 1;
						displayMaze();
					}
				}
			}
			// movement west
			else if (directionMove == 2) {
				// ensures robot is not at very left of the maze
				if (robotX != 0) {
					// checks if movement west will enter a doorway
					if (maze[robotY][robotX - 1] == 'd')
						escaped = true;
					// allows robot to move west if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY][robotX - 1] == 'n' || maze[robotY][robotX - 1] == 'd' 
						|| (isTrapped() && maze[robotY][robotX-1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY][robotX - 1] = 'R';
						robotX = robotX - 1;
						displayMaze();
					}
				}
			}
			// movement east
			else if (directionMove == 3) {
				// ensures robot is not at very right of the maze
				if (robotX != columns - 1) {
					// checks if movement east will enter a doorway
					if (maze[robotY][robotX + 1] == 'd')
						escaped = true;
					// allows robot to move east if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY][robotX + 1] == 'n' || maze[robotY][robotX + 1] == 'd' 
						|| (isTrapped() && maze[robotY][robotX+1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY][robotX + 1] = 'R';
						robotX = robotX + 1;
						displayMaze();
					}
				}
			}
			// movement northeast
			else if (directionMove == 4) {
				//ensures robot is not at very right or very top of the maze
				if (robotX != columns - 1 && robotY != 0) {
					// checks if movement northeast will enter a doorway
					if (maze[robotY - 1][robotX + 1] == 'd')
						escaped = true;
					// allows robot to move northeast if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself 
					if (maze[robotY - 1][robotX + 1] == 'n' || maze[robotY - 1][robotX + 1] == 'd' 
						|| (isTrapped() && maze[robotY - 1][robotX+1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY - 1][robotX + 1] = 'R';
						robotX = robotX + 1;
						robotY = robotY - 1;
						displayMaze();
					}
				}
			}
			// movement northwest
			else if (directionMove == 5) {
				// ensures robot is not at very left or very top of the maze
				if (robotX != 0 && robotY != 0) {
					// checks if movement northwest will enter a doorway
					if (maze[robotY - 1][robotX - 1] == 'd')
						escaped = true;
					// allows robot to move northwest if it is an open space, a doorway,
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY - 1][robotX - 1] == 'n' || maze[robotY - 1][robotX - 1] == 'd' 
						|| (isTrapped() && maze[robotY - 1][robotX - 1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY - 1][robotX - 1] = 'R';
						robotX = robotX - 1;
						robotY = robotY - 1;
						displayMaze();
					}
				}
			}
			// movement southeast
			else if (directionMove == 6) {
				// ensures robot is not at very right or very bottom of the maze
				if (robotX != columns - 1 && robotY != rows - 1) {
					// checks if movement southeast will enter a doorway
					if (maze[robotY + 1][robotX + 1] == 'd')
						escaped = true;
					// allows robot to move southeast if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY + 1][robotX + 1] == 'n' || maze[robotY + 1][robotX + 1] == 'd' 
						|| (isTrapped() && maze[robotY + 1][robotX + 1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY + 1][robotX + 1] = 'R';
						robotX = robotX + 1;
						robotY = robotY + 1;
						displayMaze();
					}
				}
			}
			// movement southwest
			else if (directionMove == 7) {
				// ensures robot is not at very left or very bottom of the maze
				if (robotX != 0 && robotY != rows - 1) {
					// checks if movement southeast will enter a doorway
					if (maze[robotY + 1][robotX - 1] == 'd')
						escaped = true;
					// allows robot to move southwest if it is an open space, a doorway, 
					// or if it is a previously visited space and the robot has trapped itself
					if (maze[robotY + 1][robotX - 1] == 'n' || maze[robotY + 1][robotX - 1] == 'd' 
						|| (isTrapped() && maze[robotY + 1][robotX - 1] == '.')) {
						maze[robotY][robotX] = '.';
						maze[robotY + 1][robotX - 1] = 'R';
						robotX = robotX - 1;
						robotY = robotY + 1;
						displayMaze();
					}
				}
			}
		} while (escaped == false);
	}

private:
	// checks whether the robot has trapped itself, 
	// meaning that the robot cannot move in any direction
	// without hitting a barrier or entering a previously entered location
	bool isTrapped() {
		if ((maze[robotY - 1][robotX] == '|' || maze[robotY - 1][robotX] == '.') 
			&& (maze[robotY + 1][robotX] == '|' || maze[robotY + 1][robotX] == '.') 
			&& (maze[robotY][robotX - 1] == '|' || maze[robotY][robotX - 1] == '.')
			&& (maze[robotY][robotX + 1] == '|' || maze[robotY][robotX + 1] == '.')
			&& (maze[robotY - 1][robotX - 1] == '|' || maze[robotY - 1][robotX - 1] == '.') 
			&& (maze[robotY - 1][robotX + 1] == '|' || maze[robotY - 1][robotX + 1] == '.')
			&& (maze[robotY + 1][robotX + 1] == '|' || maze[robotY + 1][robotX + 1] == '.')
			&& (maze[robotY + 1][robotX - 1] == '|' || maze[robotY + 1][robotX - 1] == '.'))
			return true;
		else
			return false;
	}
	// prompts user for dimensions of maze
	// this allows for the maze to simply be copy and pasted in or entered row by row
	void getDimension() {
		do {
			cout << "Enter dimension of maze[#rows(0 to 80) and #colums(0 to 120) separated by a space]: " << endl;
			cin >> rows;
			cin >> columns;
		} while (rows > 80 || columns > 120 || rows < 0 || columns < 0);
	}
	int robotX;
	int robotY;
	int columns = 0;
	int rows = 0;
	vector<vector<char>> maze;
};

int main() {
	srand(time(0));
	Maze newMaze;

	newMaze.generateMaze();
	newMaze.placeRobot();
	newMaze.robotMove();
	return 0;
}
