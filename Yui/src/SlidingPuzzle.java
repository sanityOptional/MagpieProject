/* Hillary Li
 * APCS BTHS
 * Last modified: 12/13/16
 * Percentage done: 51%
 */
import java.util.*;
public class SlidingPuzzle
{
	private int[] puzzleSolution = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private  int[] puzzleShuffled = puzzleSolution;
	private  String difficulty = "easy";
	private int lengthOfPuzzle = 3 ;
	private int numOfMoves = 0;
	private boolean gameStart = false;
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
		//shufflePuzzle(shufflePattern());
		gameStart = true;
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
	//private String shufflePattern()
	//{
	//}
	private int[] createSolution(int length)
	{
		int[] newSolution = new int[(length^2)-1];
		for (int count = 0; count < ((length^2)-1); count++)
		{
			newSolution[count] = count;
		}
		return newSolution;
	}
	private String shufflePuzzle(String pattern)
	{
		if(pattern.length() == 0)
		{
			return "";
		}
		else
		{
			puzzleMove(pattern);
			return shufflePuzzle(pattern.substring(1));
		}
	}
	public void puzzleMove(String move)
	{
		String movement = move.substring(0,1);
		if(gameStart)
		{
			numOfMoves++;
		}
		if(movement.equals("U"))
		{
			
		}
		else if(movement.equals("D"))
		{
			
		}
		else if(movement.equals("L"))
		{
			
		}
		else if(movement.equals("R"))
		{
			
		}
	}
	public Boolean done()
	{
		return puzzleShuffled.equals(puzzleSolution);
	}
	private int zeroPos()
	{
		String currentPuzzle = "";
		for(int x : puzzleShuffled)
		{
			currentPuzzle = currentPuzzle + x;
		}
		return currentPuzzle.indexOf(0);
	}
}
