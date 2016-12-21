/*
 * Bo Li
 * APCS BTHS
 * Last Modified: 12/9/16
 * Percentage Done: .01%
 */

import java.util.Scanner;

public class Nim 
{
    public static int input;
    public static int total;
    
    public static void main(String[] args) throws InterruptedException 
    {
        System.out.println("Instructions:");
        System.out.println("Start out with a specific number of sticks and each player removes some on their turn until no more remains.");
        System.out.println("Your goal is to remove the last stick.");
        System.out.println("You can only remove 1, 2, or 3 sticks at a time.");
        System.out.println("How many sticks would you like to start out with?");
        
        try (Scanner scanInput = new Scanner(System.in)) 
        {
        	total = scanInput.nextInt();
        	System.out.println("There are " + total + " sticks right now.");
        	System.out.println("Would you like to go first?");
            while (scanInput.hasNextInt()) 
            {

            	System.out.println("There are " + total + " sticks right now.");
            	
                input = scanInput.nextInt();

                if (input > 3) 
                {
                    System.out.println("The most you can removeat a time is 3 sticks.");
                    continue;
                } 
                else 
                {
                	if (input < 1)
                	{
                		System.out.println("You need to at least remove 1 stick");
                	}
                }
                
                total = total - input;
                
                if (total - input <= 0) 
                {
                    System.out.println("There are no more sticks remaining.");
                    System.out.println("YOU WON!!");
                    return;
                }
                
                Thread.sleep(250);
                
                int cpuAnswer = 4 - input;
                
                System.out.println("The computer has removed " + cpuAnswer + " sticks");
              
                if (total - cpuAnswer <= 0) 
                {
                    System.out.println("There are no marbles remaining");
                    System.out.println("You have lost.");
                    return;
                }

                total = total - cpuAnswer;
            }
        }
    }
}