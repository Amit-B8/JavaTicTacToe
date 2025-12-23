// Needed for user input
import java.util.Scanner;


/**
 * The Human class represents a human player in Tic Tac Toe.
 * It extends the Player class and inherits the common player data like the symbol X or O
 * and the player's name. This class implements the makeMove method which takes the users input for
 * the specific row and column where they want to place their symbol.
 */

// The Human class extends Player which means it Inherits the symbol and name fields
// and needs to implement the abstract makeMove method to show how a human player moves.
public class Human extends Player {

    /**
     * Constructor for a Human player with a given symbol and name.
     * It Calls the constructor of the superclass Player to initialize the inherited fields.
     *
     * @param tictacToeSymbol The symbol for this human player either 'X' or 'O'
     * @param name The name of this human player.
     */

    // This is the constructor for human that calls constructor of the superclass Player and initializes the inherited fields
    public Human(char tictacToeSymbol, String name) {
        // Calls Player constructor
        super(tictacToeSymbol, name);
    }

    /**
     * This makes a move for the human player.
     * It prompts the human player to choose a row and column to place their symbol.
     * It will continue to ask until a valid move is made.
     * A move is only valid if the spot is within the bounds 0-2 for
     * both row and columns, and if they choose a spot on the board that is not empty
     *
     * @param board The Tic Tac Toe board where the moves will be made.
     */
    // Uses Override since Player is abstract and this method provides its own
    // steps to implement the abstract makeMove. Without the Override it would still work
    // but using Override helps the compiler check that it correctly overrides the abstract method
    @Override
    public void makeMove(Board board) {
        // Creating a scanner object
        Scanner input = new Scanner(System.in);
        // Boolean to check if player made valid move
        boolean validMove = false;
        // Ask user for input while they have not made one yet
        while (validMove == false) {
            // Initializes a blank row variable string that will either be 0, 1, or 2
            String rowInput;
            // Initializes a blank column variable string that will either be 0, 1, or 2
            String columnInput;
            // Prompt the user to make a move
            System.out.print("Enter a row and column number to make a move: ");
            System.out.println();
            // Have the user enter the row they want to place their piece in
            System.out.print("Enter row (0-2): ");
            // This will read the input and set rowInput to that input value
            rowInput = input.nextLine();
            // Check row value. If it is 0, 1, or 2, then it will ask for the column value now
            if (rowInput.equals("0") || rowInput.equals("1") || rowInput.equals("2")) {
                // Boolean variable to check for valid column value
                boolean validColumn = false;
                // Repeatedly asks user for column until they enter valid value
                while (validColumn == false)
                {
                    // Ask the user for their column value
                    System.out.print("Enter column (0-2): ");
                    // This will read the input and set columnInput to that input value
                    columnInput = input.nextLine();
                    // Check column value if it is 0, 1, o r 2.
                    // Then it will convert both the row and columns values to integers
                    if (columnInput.equals("0") || columnInput.equals("1") || columnInput.equals("2")) {
                        // Turn the String row input to an integer value
                        int row = Integer.parseInt(rowInput);
                        // Turn the String column input to an integer value
                        int column = Integer.parseInt(columnInput);
                        // This checks if spot is empty and places the symbol.
                        // Valid Move now true if there is a free spot to place symbol
                        validMove = board.emptySpot(row, column, getTicTacToeSymbol());
                        // If a move was placed successfully then column loop ends
                        if (validMove == true)
                        {
                            // Set to ture since valid move was placed
                            validColumn = true;
                        }
                        // If not valid move tell user to retype a valid value
                        else
                        {
                            System.out.println("That spot is already taken. Try another column.");
                        }
                    }
                    // Checks if there was an invalid column value, and if so reprompt user to pick a valid spot
                    else
                    {
                        System.out.println("Please enter a valid column number either 0, 1, or 2: ");
                    }
                }
            }
            // Checks if there was an invalid row value, and if so reprompt user to pick a valid spot
            else
            {
                System.out.println("Please enter a valid row number either 0, 1, or 2: ");
            }

        }

    }

}
