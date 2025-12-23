/**
 * The Computer class represents a computer player in Tic Tac Toe.
 * It extends the abstract Player class. It is inheriting common player data like symbol and name.
 * This class implements the makeMove method.
 * It places its symbol in the first available empty spot on the board.
 */
public class Computer extends Player {
    /**
     * Constructor for a Computer player with a given symbol and name.
     * It Calls the constructor of the superclass Player to initialize the inherited fields.
     *
     * @param tictacToeSymbol The symbol for this computer player either 'X' or 'O'
     * @param name The name of this computer player.
     */
    // This is the constructor for computer that calls constructor of the
    // superclass Player and initializes the inherited fields
    public Computer(char tictacToeSymbol, String name) {
        // Calls Player constructor
        super(tictacToeSymbol, name);
    }

    /**
     * This makes a move for the computer player.
     * This method searches the board and places the computer's symbol
     * in the first empty spot that it finds.
     *
     * @param board The Tic Tac Toe board where the moves will be made.
     */

    // Uses Override since Player is abstract and this method provides its own
    // steps to implement the abstract makeMove. Without the Override it would still work
    // but using Override helps the compiler check that it correctly overrides the abstract method
    @Override
    public void makeMove(Board board)  {
        // Boolean to check if player made valid move originally false since no move has been made
        boolean moveMade  = false;
        // Loop through the rows of the board but stops early if moveMade is true
        for (int row = 0; row < 3 && moveMade == false; row++ ) {
            // Loops through the columns of the board but will stop early as well if moveMade is true
            for (int column = 0; column < 3 && moveMade == false; column++) {
                // Try to place the symbol at the first empty spot
                // emptySpot() will return true if the spot is empty and the symbol was placed
                if (board.emptySpot(row, column, getTicTacToeSymbol())) {
                    System.out.println(getName() + " The computer placed " + getTicTacToeSymbol() + " at row " + row + ", and column " + column);
                    // Mark that a move has been made so the loops will stop
                    moveMade = true;
                }
            }
        }
    }
}
