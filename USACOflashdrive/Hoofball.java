import java.util.*;
import java.io.*;
import java.lang.*;
public class Hoofball{
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
			input = new Scanner(new FileInputStream("hoofball.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numCows = input.nextInt();
		int[] positions = new int[numCows];
		
		for(int i = 0; i < numCows; i++)
		{
			positions[i] = input.nextInt();
		}

		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("hoofball.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(); //TODO
		writer.println(numCows * 2 / 5);
		writer.close();
		System.exit(0);
		
		
		
	}
}