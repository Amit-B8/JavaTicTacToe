/**
 * The Player class represents a player in a Tic Tac Toe game like a blueprint
 * This class is abstract, so it can not make a plain Player but only Human or Computer.
 * It stores shared information like symbol 'X' or 'O' and name. It also shares common code.
 * Subclasses must implement their own version of makeMove to decide how moves are made.
 * The abstract makeMove method forces each subclass to define its own move logic.
 *
 * @author Amit Boodhoo
 * @since 2025-10-05
 */

// Using abstract because this class will have the common structures and some shared behaviors, but regular human player and computer work different
// They implement moves differently Computer will use an algorithm and human can make their own moves and interacts different but both are similar
public abstract class Player {
    /**
     * The symbol for this player, either 'X' or 'O'.
     */
    private final char tictacToeSymbol;
    /**
     * The name of this player (e.g., "Player1" or "Computer").
     */
    private final String name;

    /**
     *
     * Constructs a Player with thier given symbol and name.
     *
     * @param tictacToeSymbol The player's symbol either X or O
     * @param name The player's name
     */
    public Player (char tictacToeSymbol, String name) {
        this.tictacToeSymbol = tictacToeSymbol;
        this.name = name;
    }

    /**
     * Returns the player’s symbol.
     *
     * @return The symbol either 'X' or 'O'
     */

    // Getter for the symbol of either X or O
    public char getTicTacToeSymbol() {
        return tictacToeSymbol;
    }

    /**
     * Returns the player’s name.
     *
     * @return The player's name
     */
    // Getter of the name either player or computer
    public String getName() {
        return name;
    }

    /**
     * Abstract makeMove method that the subclasses must implement their
     * own version of makeMove to decide how moves are made.
     * The abstract makeMove method forces each subclass to define its own move logic.
     *
     * @param board The Tic Tac Toe board where the move will be made.
     */
    // This is an Abstract method subclass. Both computer and Human have to implement their own ways of moving
    public abstract void makeMove(Board board);
}
