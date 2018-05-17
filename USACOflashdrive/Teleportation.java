import java.util.*;
import java.io.*;
import java.lang.*;
public class Teleportation {
	static int startToEnd = 0;
	static int startToTeleOne = 0;
	static int startToTeleTwo = 0;
	static int endToTeleOne = 0;
	static int endToTeleTwo = 0;
	static int teleOneToTeleTwo = 0;
	
	static Scanner input = null;
	public static void main(String[] args)
	{

		
		try {
			input = new Scanner(new FileInputStream("teleport.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int start = input.nextInt();
		int end = input.nextInt();
		int teleOne = input.nextInt();
		int teleTwo = input.nextInt();
		int answer = 0;
		
		startToEnd = Math.abs(start - end);
		startToTeleOne = Math.abs(start - teleOne);
		startToTeleTwo = Math.abs(start - teleTwo);
		endToTeleOne = Math.abs(end - teleOne);
		endToTeleTwo = Math.abs(end - teleTwo);
		teleOneToTeleTwo = Math.abs(teleTwo - teleOne);
		
		if(startToEnd < startToTeleOne && startToEnd < startToTeleTwo)
		{
			answer = startToEnd;
		}
		else if(startToEnd > startToTeleTwo)
		{
			if(startToEnd < startToTeleTwo + endToTeleOne)
			{
				answer = startToEnd;
			}
			else
			{
				answer = startToTeleTwo + endToTeleOne;
			}
		}
		else if(startToEnd > startToTeleOne)
		{
			if(startToEnd < startToTeleOne + endToTeleTwo)
			{
				answer = startToEnd;
			}
			else
			{
				answer = startToTeleOne + endToTeleTwo;
			}
		}
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("teleport.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(answer);
		writer.println(answer);
		writer.close();
		System.exit(0);
		
		
		
	}
}