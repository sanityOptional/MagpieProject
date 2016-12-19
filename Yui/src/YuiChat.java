
public class YuiChat 
{
	public String getGreeting()
	{
		return "Hello, let's talk!";
	}
	
	String response = "";
	public String startChat() // ask questions
	{
		if (statement.indexOf("no") = 0)
		{
		  response = " Why not? Let's play a game!";
		}
			
		
	}
	//no and something else <--
	
	
	
	
	public String getResponse(String statement) //keyword detector 
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("game") >= 0
				|| statement.indexOf("bored") >= 0
				|| statement.indexOf("friend") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;	
		
		
		
		
	}
	
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "What?";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "???";
		}
		else if (whichResponse == 3)
		{
			response = "...";
		}
		
		

		return response;
	}
}

