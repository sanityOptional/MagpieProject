/* Hillary Li
 * APCS BTHS
 * Last modified: 12/9/16
 * Percentage done: 51%
 */
import java.util.*;
public class SlidingPuzzle
{
	private int[] puzzleSolution = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private  int[] puzzleShuffled = puzzleSolution;
	private  String difficulty = "easy";
	private int lengthOfPuzzle = 3 ;
	SlidingPuzzle(String difficulty)
	{
		changeDifficulty(difficulty);
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
			System.out.print("Not a difficulty level, please type easy, medium, or hard: ");
		}
	}
	private void initializePuzzle(int lengthOfPuzzle)
	{
		this.lengthOfPuzzle = lengthOfPuzzle;
		puzzleSolution = createSolution(lengthOfPuzzle);
		puzzleShuffled = puzzleSolution;
		shufflePuzzle(shufflePattern());
	}
	public void changeDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
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
			puzzleMove(pattern.charAt(0));
			return shufflePuzzle(pattern.substring(1));
		}
	}
	public void puzzleMove(char move)
	{
	}
	public Boolean done()
	{
		return puzzleShuffled.equals(puzzleSolution);
	}
}
