
/* Sin Yee Cheung
 * APCS BTHS
 * Last modified: 12/9
 * Percentage done: 
 */

import java.util.Scanner;
public class TicTacToe {
		public static char turn = 'X';
		public static int row, col; //field
		public static Scanner scan = new Scanner(System.in);
		public static char[][]board;
		
	
		private int [][] board;
		private string playerIcon;
		private boolean gameStart;
		private boolean playerWin;
		private boolean gameDone; 
		
		5public static void main (String[] args)
		{ 
			board = new char [3][3];
			for (int i = 0; i<3; i++)
			{
			for (int j=0; j<3; j++)
			{
				board[i][j]= '_';
			}
			Play();
		}
			
			
		}
		private static void Play(){
			boolean playing = true;
			displayBoard();
			while(playing){
				row = scan.nextInt()-1; //scan #
				col = scan.nextInt()-1;
				if (board[row][col] != ' ')
					 System.out.print("\n!! The space is taken.!! \n PLEASE TRY AGAIN: "); // next line
			      row = scan.nextInt()-1;
			      col = scan.nextInt()-1;
			    if (board[row][col] == ' ')
			    	board[row][col] = turn;
				if (gameOver(row,col))
				{
					playing=false;
					System.out.print("Game Over! Player " + turn + "wins!");
				}
			      }
			}
			
		
		private static void displayBoard()
		{
			for (int i = 0; i <3; i++){
				System.out.println();
				for (int j=0; j<3; j++){
					System.out.print(board[i][j] + " ");
				}
			}
		}

		
		
		
		
		public static boolean gameOver(int rMove, int cMove){
			//Check perpendicular victory
			if(board[0][cMove] == board[1][cMove]
				&& board[0][cMove] == board[2][cMove])
				return true;
			if(board[rMove][0] == board[rMove][1]
				&& board[rMove][0] == board[rMove][2])
				return true;
			//Check diagonal victory
			if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
				&& board[1][1] != '_')
				return true;
			if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
				&& board[1][1] != '_')
				return true;
			return false;
		
	}

}	