
import java.util.Scanner;
/* Sin Yee Cheung
 * APCS BTHS
 * Last modified: 12/9
 * Percentage done: 
 */

public class TicTacToe
{

	  public static Scanner sc = new Scanner(System.in);

	  public static void main(String[] args)
	  {

	    final int SIZE = 3;
	    char[][] board = new char[SIZE][SIZE]; // game board

	    Board(board); // initialize the board 

	    System.out.println("Welcome to tic tac toe, try to beat me! :)~" );
	    System.out.println("You are PLAYER 'X'!");
	    showBoard(board);
	    char userSymbol= 'X';
	    char compSymbol ='O';
	    
	    int turn;  // 0 - the user, 1 - the computer
	    int remainCount = SIZE * SIZE; 

	    // user will be X first
	    if (userSymbol == 'X') {
	      turn = 0;
	      userPlay(board, userSymbol); // user puts his/her first tic
	    }
	    else {
	      turn = 1;
	      compPlay(board, compSymbol); // computer puts its first tic
	    }
	 
	    remainCount--;

	    // Play the game until either one wins.
	    boolean done = false;
	    int winner = -1;    //-1 -- draw

	    while (!done && remainCount > 0) {
	      
	      done = isGameWon(board, turn, userSymbol, compSymbol); // Did the turn won?

	      if (done)
	        winner = turn; // the one who made the last move won the game
	      else {
	        // No winner yet.  Find the next turn and play.
	        turn = (turn + 1 ) % 2;

	        if (turn == 0)
	          userPlay(board, userSymbol);
	        else
	          compPlay(board, compSymbol);

	        showBoard(board);
	        remainCount--;
	      }
	    }

	    // Winner is found.  Declare the winner.
	    if (winner == 0)
	      System.out.println("\n** YOU WON. CONGRATULATIONS!! **");
	    else if (winner == 1)
	      System.out.println("\n** YOU LOST, better luck next time :P **");
	    else
	      System.out.println("\n** IT'S A DRAW! **");
	  }
	  
	  
	  private static void Board(char[][] board) 
	  {
	    for (int i = 0; i < board.length; i++)
	      for (int j = 0; j < board[0].length; j++)
	        board[i][j] = ' ';
	    
	    // board : 3 rows & columns 
	  }

	  private static void showBoard(char[][] brd)
	  {
	    int numRow = brd.length;
	    int numCol = brd[0].length;

	    System.out.println();

	    // column header
	    System.out.print("    ");
	    for (int i = 0; i < numCol; i++)
	      System.out.print(i + "   ");
	    System.out.print('\n');

	    System.out.println(); 
	    
	    // table
	    for (int i = 0; i < numRow; i++) {
	      System.out.print(i + "  ");
	      for (int j = 0; j < numCol; j++) {
	        if (j != 0)
	          System.out.print("|");
	        System.out.print(" " + brd[i][j] + " ");
	      }

	      System.out.println();
	      
	      

	      if (i != (numRow - 1)) {
	    
	    	  
	        System.out.print("   ");
	        for (int j = 0; j < numCol; j++) {
	          if (j != 0)
	            System.out.print("");
	          System.out.print("----");
	        }
	        System.out.println();
	      }
	    }
	    System.out.println();
	  }

	  private static void userPlay(char[][] board, char uTurn)
	  {
	    System.out.print("\nEnter a row and column: ");
	    int rowIndex = sc.nextInt(); // scan row
	    int colIndex = sc.nextInt(); // scan column 

	    while (board[rowIndex][colIndex] != ' ') 
	    { 
	      System.out.print("\n!! The space is taken.!! \n PLEASE TRY AGAIN: "); // next line
	      rowIndex = sc.nextInt();
	      colIndex = sc.nextInt();
	    }

	    board[rowIndex][colIndex] = uTurn;
	  }

	  private static void compPlay(char[][] board, char cTurn)
	  {
	    //
	    for (int i = 0; i < board.length; i++) {
	      for (int j = 0; j < board[0].length; j++) {
	        if (board[i][j] == ' ') { 
	          board[i][j] = cTurn;
	          return;
	        }
	      }
	    }
	  }

	  private static boolean isGameWon(char[][] board, int turn, char uTurn, char cTurn)
	  {	  
		 
	    char sym;
	    if (turn == 0)
	      sym = uTurn;
	    else
	      sym = cTurn;

	    int i, j;
	    boolean win = false;

	    // Check win by a row
	    for (i = 0; i < board.length && !win; i++) {
	      for (j = 0; j < board[0].length; j++) {
	        if (board[i][j] != sym)
	          break;
	      }
	      if (j == board[0].length)
	        win = true;
	    }

	    // Check win by a column
	    for (j = 0; j < board[0].length && !win; j++) {
	      for (i = 0; i < board.length; i++) {
	        if (board[i][j] != sym)
	          break;
	      }
	      if (i == board.length)
	        win = true;
	    }

	    // Check diagonal 
	    if (!win) {
	      for (i = 0; i < board.length; i++) {
	        if (board[i][i] != sym)
	          break;
	      }
	      if (i == board.length)
	        win = true;
	    }

	    // Check  diagonal 
	    if (!win) {
	      for (i = 0; i < board.length; i++) {
	        if (board[i][board.length - 1 - i] != sym)
	          break;
	      }
	      if (i == board.length)
	        win = true;
	    }

	    return win;
	  }
	}