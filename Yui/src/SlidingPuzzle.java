/* Hillary Li
 * APCS BTHS
 * Last modified: 12/9/16
 * Percentage done: 45%
 */
public class SlidingPuzzle
{
	private static int[] puzzleSolution = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	public static int[] puzzleShuffled = puzzleSolution;
	public static String difficulty = "easy";
	private static int lengthOfPuzzle = 3 ;
	public SlidingPuzzle(String input)
	{
		difficulty = input;
		if (difficulty.equals("easy"))
		{
			lengthOfPuzzle = 3;
			puzzleSolution = createSolution(lengthOfPuzzle);
			puzzleShuffled = puzzleSolution;
		}
		else if (difficulty.equals("medium"))
		{
			lengthOfPuzzle = 4;
			puzzleSolution = createSolution(lengthOfPuzzle);
			puzzleShuffled = puzzleSolution;
		}
		else if(difficulty.equals("hard"))
		{
			lengthOfPuzzle = 5;
			puzzleSolution = createSolution(lengthOfPuzzle);
			puzzleShuffled = puzzleSolution;
		}
	}
	private static String shufflePattern(int length)
	{
	}
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
			return shufflePattern(pattern.substring(1));
		}
	}
	public static void puzzleMove(char move)
	{
	}
	public Boolean done()
	{
		return puzzleShuffled.equals(puzzleSolution);
	}
}
