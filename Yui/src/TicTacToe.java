

import java.util.Random;
import java.util.Scanner;


public class TicTacToe{
	
	private int[] board;
	private int playerIcon;
	private int botIcon;
	private boolean gameStart;
	private boolean playerWin;
	private int  move, spaceIndex;
	boolean gameDone;
	boolean playerTurn;
	public static Scanner scan = new Scanner(System.in);
	
	public TicTacToe(){
		board = new int[9];
		playerIcon = 1;
		botIcon = 2;
		gameStart = true;
		playerWin = false;
		gameDone = false;
	}
	public TicTacToe(String icon)
	{
		if (icon.equals("X"))
		{
			playerIcon = 1;
			botIcon = 2;
		}
		else if (icon.equals("O")){
			playerIcon = 2;
			botIcon = 1;
		}
		else {
			System.out.print("Invalid character");
			icon = "X";
			playerIcon = 1 ;
		}
			
	}
	public void playerMove(int move){
		System.out.print("Please enter from 0-8");
		spaceIndex = scan.nextInt(); // scan # 	   
		illegalMove(spaceIndex);
	  }
	

	Boolean illegalMove(int move){
		if (board[move] != ' '  )
		{ 
			return false;	
		    System.out.print("\n!! The space is taken.!! \n PLEASE TRY AGAIN: "); // next line
		    spaceIndex = scan.nextInt();
		    spaceIndex = move; 
		    }	
			return true;				
	}
	
	public void botMove(){
		int random = (int)(Math.random() * ((8 - 0) + 1));
		spaceIndex = random; 
		illegalMove(spaceIndex);
		}
	
	
	public int blokorkWinMove(){
		int a1[] = {0,1,2} ; // horizontal r1
		int a2[] =  {3,4,5}; //h r2
		int a3[] =  {6,7,8}; // h r3
		int a4 [] = {0,3,6};  // vertical c 1
		int a6 [] = {1,4,7}; //  v c2
		int a7 [] = {2,5,8}; // v c3
		int a8 [] = { 0,4,8}; //diagonal
		int a9 [] = {2,4,6}; //d2
		
		if (int a1)
		
		
		
		}
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}