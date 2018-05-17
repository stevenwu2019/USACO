/*
ID: stevenw3
LANG: JAVA
TASK: milk2
*/
/*
 * what i learned from this program
 * don't create so many reliances. code is less likely to be buggy if sections can stand alone by themselves. dependencies breed
 * problems.
 * keep it super simple! never fails
 * */
 
import java.util.*;
import java.io.*;
import java.lang.*;
public class milk2{

	//read file
	static Scanner input = null;
	public static void main(String[] args)
	{
		try {
			input = new Scanner(new FileInputStream("milk2.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scan input data
		int size = input.nextInt();
		int[] startTimes = new int[size];
		int[] endTimes = new int[size];
		for(int i = 0; i < size; i++)
		{
			startTimes[i] = input.nextInt();
			endTimes[i] = input.nextInt();
		}
		
		//find largest endtime to determine range
		int largestTime = 0;
		for(int i = 0; i < size; i++)
		{
			if(endTimes[i] > largestTime) largestTime = endTimes[i];
		}
		
		//find smallest starttime to determine range
				int smallestTime = Integer.MAX_VALUE;
				for(int i = 0; i < size; i++)
				{
					if(startTimes[i] < smallestTime) smallestTime = startTimes[i];
				}
		
		//System.out.println(smallestTime);
		
		//create boolean array to generate schedule
		boolean[] timeSlots = new boolean[largestTime];
		for(int i = 0; i < size; i++)
		{
			for(int a = startTimes[i]; a < endTimes[i]; a++)
			{
				timeSlots[a] = true;
			}
		}
		//System.out.println(timeSlots[100]);
		//System.out.println(timeSlots[150]);
		
		//parse through boolean array to find longest milking and non-milking intervals
		int longestMilkingTime = 0;
		int longestNonmilkingTime = 0;
		int milkDummy = 0;
		int nonmilkDummy = 0;
		for(int i = 0; i < largestTime; i++)
		{
			if(timeSlots[i])
			{
				milkDummy++;
			}
			else
			{
				if(milkDummy > longestMilkingTime) longestMilkingTime = milkDummy;
				//System.out.println(milkDummy);
				milkDummy = 0;
			}
		}
		for(int i = smallestTime; i < largestTime; i++)
		{
			if(!timeSlots[i])
			{
				nonmilkDummy++;
			}
			else
			{
				if(nonmilkDummy > longestNonmilkingTime) longestNonmilkingTime = nonmilkDummy;
				nonmilkDummy = 0;
			}
		}
		
		if(milkDummy > longestMilkingTime) longestMilkingTime = milkDummy;
		if(nonmilkDummy > longestNonmilkingTime) longestNonmilkingTime = nonmilkDummy;
		
		//generate output
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("milk2.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.print(longestMilkingTime + " " + longestNonmilkingTime + "\n");
		writer.close();
		System.exit(0);
		
	}
	
	
}

