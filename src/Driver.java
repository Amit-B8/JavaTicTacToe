// Needed for user input
import java.util.Scanner;

/**
 * The Driver class is where the main Tic Tac Toe game is run.
 * It prompts the user to select between three game modes that are
 * Human vs Computer, Human vs Human, or Computer vs Computer.
 * Based on the selection, it will initialize the players
 * and play the game loop until there is a winner or a tie.
 */


public class Driver {

    /**
     * The main method runs the entire Tic Tac Toe game.
     * It asks the user to pick a game mode, creates the board and players,
     * and will alternate turns until the game ends.
     *
     * @param args command-line arguments
     */

    public static void main(String[] args) {
        // This is the Scanner object for the users input on what they want to play
        Scanner scanner = new Scanner(System.in);
        // This will store the user input as a string
        String choice = "";

        // This will keep asking the user to type valid option until user types 1, 2, or 3
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
        {
            // Print statement to let the user pick what type of game mode they want
            System.out.println("Click 1 for Human vs Computer, 2 for Human vs Human, and 3 for Computer vs Computer: ");
            // This will read the user's input choice
            choice = scanner.nextLine();
            // If the users input does nto equal 1,2, or 3 it will tell them to pick one of those correct options
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))
            {
                System.out.println("Not a valid choice. Please click 1, 2, or 3");
            }
        }
        // If choice equals to 1 then it will be a human a computer
        // Since I now made it a string used .equals to check if the strings have the same sequence of characters rather cause == will if they have the exact same object in memory
        if (choice.equals("1"))
        {
            // Create a blank board object for the players to play the game
            Board board1 = new Board();
            // Create a human player object with symbol X and name Player1
            Human player1 = new Human('X', "Player1");
            // Create a computer player object with symbol O and name Player2
            Computer player2 = new Computer('O', "Player2");
            // Game will continue to play if X hasn't won, O hasn't won, and board is not full
            while (!board1.checkWinner('X') && !board1.checkWinner('O') && !board1.fullBoard('X','O'))
            {
                // Prompt the human player to go first and pick their row and column
                System.out.println("Player 1's turn. Pick the row and column spots to place your piece");
                // This will allow the human player to make their move
                player1.makeMove(board1);
                // This will display the current state of the board
                board1.printBoard();
                // After Player 1 makes a move, it will check if player 1 has won already or if the board is fill
                if (board1.checkWinner('X') || board1.fullBoard('X','O'))
                {
                    // If player 1 has already won, then no need for player 2 to make a move it will continue
                    // Skips the rest of the loop, jump to top of while loop and realize a player has won and display the winner
                    continue;
                }
                // Prompt the computer to make a move
                System.out.println("Player 2 goes next. Computer will pick right away.");
                // This will allow the computer to make their move
                player2.makeMove(board1);
                // This will display the current state of the board
                board1.printBoard();
            }
            // This will display that player 1 has won if check winner for symbol X is ture
            if (board1.checkWinner('X'))
            {
                // Print out that Player 1 ahs won
                System.out.println("Player 1 wins!");
            }
            // This will display that player 2 has won if check winner for symbol O is ture
            else if (board1.checkWinner('O'))
            {
                // Print out that player 2 has won
                System.out.println("Player 2 wins!");
            }
            // Checks if the game ends in tie so no winner
            else
            {
                // Prints that the game ended in a tie
                System.out.println("Game ended in a tie!");
            }

        }

        else if (choice.equals("2"))
        {
            // Create a blank board object for the players to play the game
            Board board2 = new Board();
            // Create a human player object with symbol X and name Player1
            Human humanPlayer1 = new Human('X', "Player1");
            // Create a human player object with symbol O and name Player2
            Human humanPlayer2 = new Human('O', "Player2");
            // Game will continue to play if X hasn't won, O hasn't won, and board is not full
            while (!board2.checkWinner('X') && !board2.checkWinner('O') && !board2.fullBoard('X','O'))
            {
                // Prompt the first human player to go first and pick their row and column to place their piece
                System.out.println("Player 1's turn. Pick the row and column spots to place your piece");
                // This will allow the human player 1 to make their move
                humanPlayer1.makeMove(board2);
                // This will display the current state of the board
                board2.printBoard();
                // After Player 1 makes a move, it will check if player 1 has won already or if the board is fill
                if (board2.checkWinner('X') || board2.fullBoard('X','O'))
                {
                    // If player 1 has already won, then no need for player 2 to make a move it will continue
                    // Skips the rest of the loop, jump to top of while loop and realize a player has won and display the winner
                    continue;
                }
                // Prompt the second human player to go second and pick their row and column to place their piece
                System.out.println("Player 2's turn. Pick the row and column spots to place your piece");
                // This will allow the human player to make their first move
                humanPlayer2.makeMove(board2);
                // This will display the current state of the board
                board2.printBoard();
            }
            // This will display that player 1 has won if check winner for symbol X is ture
            if (board2.checkWinner('X'))
            {
                // Print out that Player 1 ahs won
                System.out.println("Player 1 wins!");
            }
            // This will display that player 2 has won if check winner for symbol O is ture
            else if (board2.checkWinner('O'))
            {
                // Print out that player 2 has won
                System.out.println("Player 2 wins!");
            }
            // Checks if the game ends in tie so no winner
            else
            {
                // Prints that the game ended in a tie
                System.out.println("Game ended in a tie!");
            }

        }

        // If user input is 3 for computer vs computer game mode
        else
        {
            // Create a blank board object for the players to play the game
            Board board3 = new Board();
            // Create a human player object with symbol X and name Player1
            Computer computerPlayer1 = new Computer('X', "Player1");
            // Create a human player object with symbol O and name Player2
            Computer computerPlayer2 = new Computer('O', "Player2");
            // Game will continue to play if X hasn't won, O hasn't won, and board is not full
            while (!board3.checkWinner('X') && !board3.checkWinner('O') && !board3.fullBoard('X','O'))
            {
                // Prompt the first human player to go first and pick their row and column to place their piece
                System.out.println("Player 1's turn.");
                // This will allow the human player 1 to make their move
                computerPlayer1.makeMove(board3);
                // This will display the current state of the board
                board3.printBoard();
                // After Player 1 makes a move, it will check if player 1 has won already or if the board is fill
                if (board3.checkWinner('X') || board3.fullBoard('X','O'))
                {
                    // If player 1 has already won, then no need for player 2 to make a move it will continue
                    // Skips the rest of the loop, jump to top of while loop and realize a player has won and display the winner
                    continue;
                }
                // Prompt the second human player to go second and pick their row and column to place their piece
                System.out.println("Player 2's turn");
                // This will allow the human player to make their first move
                computerPlayer2.makeMove(board3);
                // This will display the current state of the board
                board3.printBoard();
            }
            // This will display that player 1 has won if check winner for symbol X is ture
            if (board3.checkWinner('X'))
            {
                // Print out that Player 1 ahs won
                System.out.println("Player 1 wins!");
            }
            // This will display that player 2 has won if check winner for symbol O is ture
            else if (board3.checkWinner('O'))
            {
                // Print out that player 2 has won
                System.out.println("Player 2 wins!");
            }
            // Checks if the game ends in tie so no winner
            else
            {
                // Prints that the game ended in a tie
                System.out.println("Game ended in a tie!");
            }

        }
        // Close the scanner at the end of the game
        scanner.close();

    }

}
