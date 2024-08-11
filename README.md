# Tic-Tac-Toe Game

## Overview

This is a simple Tic-Tac-Toe game developed in Java using Swing for the graphical user interface (GUI). The game is designed for two players, where Player 1 uses "X" and Player 2 uses "O". 
The objective of the game is to get three of your marks in a row either horizontally, vertically, or diagonally before your opponent does.

## Features

- **Two-player game**: Play against a friend locally.
- **Graphical User Interface**: Intuitive and easy-to-use GUI built with Java Swing.
- **Game Reset**: A "Retry" button allows players to reset the game and start over without restarting the application.
- **Turn Indicator**: Displays the current player's turn.
- **Winning Highlight**: Highlights the winning combination when a player wins.
- **Draw Detection**: Detects and displays a message when the game is a tie.

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/shivapriya032005/tictactoe-java.git
   cd tictactoe-java
   ```

2. **Compile the Java source code**:
   ```bash
   javac TicTacToe.java
   ```

3. **Run the game**:
   ```bash
   java TicTacToe
   ```

## How to Play

1. **Start the Game**: Once the game starts, Player 1 ("X") takes the first turn.
2. **Make a Move**: Click on any of the empty squares to place your mark. The game will automatically switch turns between players.
3. **Win or Draw**: The game will declare a winner when one player gets three marks in a row. If all squares are filled and no player has won, the game will declare a draw.
4. **Retry**: Click the "Retry" button to reset the board and start a new game.

## Code Structure

- `TicTacToe.java`: The main class that contains the entire game logic, including the GUI setup, game state management, and event handling.

## Future Enhancements

- Add an AI mode to play against the computer.
- Implement a scoreboard to keep track of multiple games.
- Add sound effects for moves and game results.

## Contributing

Feel free to fork this project, submit issues, or create pull requests. Contributions to enhance the game are welcome!

## Author

- **Your Name** - (https://github.com/shivapriya032005)

