/**
 * The Board class represents a Tic Tac Toe board.
 * It manages the grid where moves are made and provides methods
 * to place moves, check for winners, checks if the board is full,
 * and it displays the board.
 */
public class Board {

    /**
     * The Tic Tac Toe grid is represented as a 3x3 matrix.
     * Each cell stores X's, O's, or a blank spaces
     */
    private char[][] grid = new char[3][3];

    /**
     * This is the constructor to construct a new Board and initializes it to a 3x3 grid
     * filled with empty spaces.
     */
    public Board() {
        // This will fill grid with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Places a move on the board if the spot is empty.
     *
     * @param row row index from 0 to 2
     * @param column column index from 0 to 2
     * @param symbol X's or O's
     * @return true if move was successful
     */
    public boolean emptySpot(int row, int column, char symbol) {
        // Returns false if out of bounds. Can't be greater than 2 or less than 0
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return false;
        }
        // Checks if the cell in not empty so you do not place another symbol
        if (grid[row][column] != ' ') {
            // If the cell is not empty then you cant place another symbol since cell already taken. Returns false
            return false;
        }
        // Places the player's symbol 'X' or 'O' on the board.
        grid[row][column] = symbol;
        // Returns true if there is a valid empty spot to play symbol
        return true;
    }

    /**
     * Checks if a player has won by getting three of their symbols
     * in a row, column, or diagonal.
     *
     * @param ticTacToeSymbol 'X' or 'O'
     * @return true if this player has won, false otherwise
     */

    public boolean checkWinner(char ticTacToeSymbol) {
        // This will check the rows
        for (int i = 0; i < 3; i++) {
            // This will check rows by having all index i's the same meaning same row and then checking if columns within row are the same symbol
            // Example checks grid[0][0], grid[0][1], grid[0][2]. If row matches return true
            if (grid[i][0] == ticTacToeSymbol && grid[i][1] == ticTacToeSymbol && grid[i][2] == ticTacToeSymbol) {
                // Returns true if all the symbols in the row match each other
                return true;
            }
        }

        // This will check columns if there is a match for a winner
        for (int j = 0; j < 3; j++) {
            // Checks each column to see if all three cells match the symbol
            // Example like grid[0][1], grid[1][1], grid[2][1] If any column matches then returns true
            if (grid[0][j] == ticTacToeSymbol && grid[1][j] == ticTacToeSymbol && grid[2][j] == ticTacToeSymbol) {
                // Returns true if a column all has the same symbol
                return true;
            }
        }

        // Checks diagonals for a match and winner
        if (grid[0][0] == ticTacToeSymbol && grid[1][1] == ticTacToeSymbol && grid[2][2] == ticTacToeSymbol) {
            return true;
        }
        if (grid[0][2] == ticTacToeSymbol && grid[1][1] == ticTacToeSymbol && grid[2][0] == ticTacToeSymbol) {
            return true;
        }
        // This will return false if no match so no winner was found that time
        return false;
    }

    /**
     * Prints the current state of the board to the console.
     */
    public void printBoard() {
        // Print a title for the players to see the current board
        System.out.println("Current TicTacToe board:");
        // Loop through the 3 rows in the grid
        for (int i = 0; i < 3; i++) {
            // This will loop through the 3 columns in the grid
            for (int j = 0; j < 3; j++) {
                // Prints out the symbol at the current spot. Also add extra spaces for better visuals on the symbols
                System.out.print(" " + grid[i][j] + " ");
                // After printing the cell, this will check if it is in the first two columns
                if (j == 0 || j == 1) {
                    // If it is in the first two columns, then it adds a divider
                    System.out.print("|");
                }
            }
            // After finishing one row it moves to a new line
            System.out.println();
            // Checks if the current row is the first or second row
            if (i == 0 || i == 1)
            {
                // If the current row is the first or second row then it will place divider lines between the rows
                System.out.println(" ---------");
            }
        }
    }

    /**
     * Checks if the board is full (no empty spaces left).
     *
     * @param ticTacToeSymbol1 Symbol for player 1
     * @param ticTacToeSymbol2 Symbol for player 2
     * @return true if board is full, false otherwise
     */
    public boolean fullBoard (char ticTacToeSymbol1, char ticTacToeSymbol2) {
        // Initialize a counter to 0 to help keep track of total symbols on board
        int count = 0;
        // Loop through the rows
        for (int i = 0; i < 3; i++) {
            // Loop through the columns
            for (int j = 0; j < 3; j++) {
                // Checks if any of the spots has the symbol X or O and if it does, it adds one to the count
                if (grid[i][j] == ticTacToeSymbol1 || grid[i][j] == ticTacToeSymbol2) {
                    // Increment the count by 1 if there is an X or an O in a spot on the board
                    count += 1;
                }

            }
        }
        // Total spots on board are 9 so if the board is full then count will be 9
        if (count == 9)
        {
            // Returns true if the count is equaled to 9
            return true;
        }
        // If the board count does not equal to 9 then it will be false meaning the board is not full yet
        else
        {
            // This will return false if the board is not full yet
            return false;
        }
    }

}
