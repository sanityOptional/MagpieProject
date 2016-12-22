/* Hillary Li
 * APCS BTHS
 * Last modified: 12/22/16
 * Percentage done: 99.9% (Testing left to be completed)
 */
import java.util.Random;
public class SlidingPuzzle
{
	private int[] puzzleSolution = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private  int[] puzzleShuffled = puzzleSolution;
	private  String difficulty = "easy";
	private int lengthOfPuzzle = 3 ;
	private int numOfMoves = 0;
	private boolean gameStart = false;
	private boolean ff = false;
	private Random rdm = new Random();
	/*
	 * SlidingPuzzle (String difficulty)
	 * Accepts a String of "easy," "medium," or "hard"
	 * to initialize the SlidingPuzzle
	 * If unacceptable input, tells user automatic level is "easy"
	 */
	SlidingPuzzle(String difficulty)
	{
		changeDifficulty(difficulty);
	}
	/*
	 * initializePuzzle(int lengthOfPuzzle)
	 * abstraction for changeDifficulty
	 * creates a puzzleSolution and a puzzle
	 */
	private void initializePuzzle(int lengthOfPuzzle)
	{
		this.lengthOfPuzzle = lengthOfPuzzle;
		puzzleSolution = createSolution(lengthOfPuzzle);
		puzzleShuffled = puzzleSolution;
		shufflePuzzle();
		gameStart = true;
		ff = false;
	}
	/*
	 * changeDifficulty(String difficulty)
	 * changes the difficulty of the puzzle and restarts puzzle as well.
	 */
	public void changeDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
		if (difficulty.equals("easy"))
		{
			initializePuzzle(3);
		}
		else if (difficulty.equals("medium"))
		{
			initializePuzzle(4);
		}
		else if(difficulty.equals("hard"))
		{
			initializePuzzle(5);
		}
		else
		{
			changeDifficulty("easy");
			initializePuzzle(3);
			System.out.print("Not a difficulty level, automatic difficulty set to easy");
		}
	}
	/*
	 * shufflePuzzle
	 * shuffles the puzzle
	 */
	private void shufflePuzzle()
	{
		int numOfShuffles = rdm.nextInt(15) + 15;
		int choice = rdm.nextInt(3);
		String possibleMove = "";
		if (choice == 0)
		{
			possibleMove = "U";
		}
		else if (choice == 1)
		{
			possibleMove = "D";
		}
		else if (choice == 2)
		{
			possibleMove = "L";
		}
		else if (choice == 3)
		{
			possibleMove = "R";
		}
		for(int x = 0; x < numOfShuffles; x++)
		{
			while(!notIllegal(possibleMove))
			{
				choice = rdm.nextInt(3);
				if (choice == 0)
				{
					possibleMove = "U";
				}
				else if (choice == 1)
				{
					possibleMove = "D";
				}
				else if (choice == 2)
				{
					possibleMove = "L";
				}
				else if (choice == 3)
				{
					possibleMove = "R";
				}
			}
			puzzleMove(possibleMove);
		}
	}
	/*
	 * createSolution(int length)
	 * Creates the solution puzzle
	 */
	private int[] createSolution(int length)
	{
		int[] newSolution = new int[(length^2)-1];
		for (int count = 0; count < ((length^2)-1); count++)
		{
			newSolution[count] = count;
		}
		return newSolution;
	}
	/*
	 * puzzleMove(String move)
	 * Accepts a String move to move the position of the zero
	 */
	public void puzzleMove(String move)
	{
		String movement = move.substring(0,1);
		int pos = zeroPos();
		if(notIllegal(movement))
		{
			if(gameStart)
			{
				numOfMoves++;
			}
			if(movement.equals("U"))
			{
				trueMove(pos, pos - lengthOfPuzzle);
			}
			else if(movement.equals("D"))
			{
				trueMove(pos, pos + lengthOfPuzzle);
			}
			else if(movement.equals("L"))
			{
				trueMove(pos, pos - 1);
			}
			else if(movement.equals("R"))
			{
				trueMove(pos, pos + 1);
			}
		}
		else
		{
			if(movement.equals("FF"))
			{
				ff = true;
			}
			else if(gameStart)
			{
				System.out.println("Illegal move. Please enter U, D, L, R, or FF.");
			}
		}
	}
	/*
	 * trueMove(int x, int y)
	 * only used with x being equal to the position of the zero and y being the new position
	 */
	private void trueMove(int x, int y)
	{
		int a = puzzleShuffled[x];
		puzzleShuffled[x] = puzzleShuffled[y];
		puzzleShuffled[y] = a;
	}
	/*
	 * done
	 * Checks if the puzzle is completed
	 */
	public Boolean done()
	{
		return puzzleShuffled.equals(puzzleSolution);
	}
	public Boolean forfeit()
	{
		return ff;
	}
	/*
	 * zeroPos
	 * Searches for the position/index of the zero
	 */
	private int zeroPos()
	{
		String currentPuzzle = "";
		for(int x : puzzleShuffled)
		{
			currentPuzzle = currentPuzzle + x;
		}
		return currentPuzzle.indexOf(0);
	}
	/*
	 * notIllegal(String move)
	 * checks if a move is not illegal
	 */
	private Boolean notIllegal(String move)
	{
		int pos = zeroPos();
		boolean[] edges = {false, false, false, false};
		for(int x = 0; x < 4; x++)
		{
			for(int y = 0; y < lengthOfPuzzle; y++)
			{
				if (x == 0)
				{
					edges[x] = edges[x] || (pos == y);
				}
				else if (x == 1)
				{
					edges[x] = edges[x] || (pos == (lengthOfPuzzle*(lengthOfPuzzle - 1) + y));
				}
				else if (x == 2)
				{
					edges[x] = edges[x] || (pos == (lengthOfPuzzle*y));
				}
				else if (x == 3)
				{
					edges[x] = edges[x] || (pos == (((y + 1) * lengthOfPuzzle) - 1));
				}
			}
		}
		return !((move.equals("U") && (edges[0])) || (move.equals("D") && (edges[1])) || (move.equals("L") && (edges[2])) || (move.equals("R") && (edges[3])));
	}
	/*
	 * displayBoard()
	 * displays the board
	 */
	public void displayBoard()
	{
		for (int x = 0; x < (lengthOfPuzzle^2) - 1; x++)
		{
			if((x % lengthOfPuzzle) == (lengthOfPuzzle - 1))
			{
				System.out.println(puzzleShuffled[x] + " ");
			}
			else
			{
				System.out.print(puzzleShuffled[x] + " ");
			}
		}
	}
}
