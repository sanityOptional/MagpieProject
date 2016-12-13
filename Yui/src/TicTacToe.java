import java.util.Scanner;
/* Sin Yee Cheung
 * APCS BTHS
 * Last modified: 12/9
 * Percentage done: 
 */

public class TicTacToe {
	
private static int rows, columns;
public static Scanner scan = new Scanner(System.in);
private static char [][] board = new char [3][3];
private static char turn = 'O';

public static void main (String[] args)
{
	for(int i=0; i<3; i++)
	{
		for (int j=0; j<3; j++)
		{
			board[i][j] = '_'; //char only one mark
  		}
	}
	System.out.println("Type in a row first then column : ");
	PrintBoard();
	Start();
	WinStrat(rows,columns);
}

private static void PrintBoard()
{
	for (int i=0; i<3; i++){
		System.out.println();
		for(int j=0; j<3; j++)
		{
			if (j==0)
				System.out.print(" ");
			System.out.print(board[i][j]+ " ");
		}
	}
	System.out.println();
}

private static void Start()
{
	boolean playing = true; 
		while(playing)
		{
			
			rows= scan.nextInt() - 1; // starts from 1, 2, 3
			columns = scan.nextInt() -1; 
			board[rows][columns]= turn;
			if (WinStrat(rows,columns))
			{
				playing = false;
				System.out.println("Game over, Player " + turn + " wins !");
			}
			PrintBoard(); //start over
			if (turn =='O')   //switch once game starts
				turn = 'X';
			else 
			{
				turn = 'O';
			}
		}
	
}

private static boolean WinStrat(int rMove,int  cMove)
{
	//check horizontal & vertical row 
	if (board[0][cMove] == board [1][cMove] && board[0][cMove]== board [2][cMove])
		return true;
	if (board [rMove][0] == board[rMove][1] && board [rMove][0] == board[rMove][2])
		return true;
	
	//check diagonal 
	
	if (board[0][0]==board[1][1] && board [0][0]== board [2][2] && board[1][1] != '_')
		return true;
	if (board[0][2] == board [1][1] && board [0][2] == board[2][0] && board[1][1] != '_')
		return true;
	return false;
	
}



}