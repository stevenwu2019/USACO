import java.util.*;
import java.io.*;
import java.lang.*;
public class TamingTheHerd{

	static Scanner input = null;
	public static void main(String[] args)
	{

		
		try {
			input = new Scanner(new FileInputStream("taming.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numDays = input.nextInt();
		int[] statuses = new int[numDays];
		
		for(int i = 0; i < numDays; i++)
		{
			statuses[i] = input.nextInt();
		}
		
		int min = 0;
		int add = 0;
		int max = 0;
		boolean[] flag = new boolean[numDays];
		for(int i = 0; i < numDays; i++)
		{
			flag[i] = false;
		}
		for(int i = statuses.length - 1; i >= 0; i--)
		{
			if(statuses[i - statuses[i]] == -1)
			{
				min++;
				flag[i - statuses[i]] = true;
			}
		}
		for(int i = 0; i < statuses.length; i++)
		{
			if(statuses[i] == -1 && !flag[i])
			{
				add++;
			}
		}
		max = min + add;

		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("taming.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(); //TODO
		writer.println((min - 1) + " " + (max - 1));
		writer.close();
		System.exit(0);
		
		
		
	}
}