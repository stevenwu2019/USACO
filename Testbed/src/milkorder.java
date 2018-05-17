//Written by Steven Wu for USACO March 2018
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
public class milkorder {
	

	public static void main(String[] args) throws IOException
	{
		//input goes here
		Scanner input = new Scanner(new File("milkorder.in"));
		int numCows = input.nextInt();
		int numHierarchy = input.nextInt();
		int numSpecific = input.nextInt();
		int[] order = new int[numCows];
		for(int i = 0; i < numCows; i++)
		{
			order[i] = 0;
		}
		int[] hierarchy = new int[numHierarchy];
		int[][] specific = new int[numSpecific][2];
		for(int i = 0; i < numHierarchy; i++)
		{
			hierarchy[i] = input.nextInt();
		}
		for(int i = 0; i < numSpecific; i++)
		{
			specific[i][0] = input.nextInt(); //cow number
			specific[i][1] = input.nextInt() - 1; //cow position
		}
		
		//implementation goes here
		for(int i = 0; i < numCows; i++) //place specific cows first
		{
			for(int j = 0; j < numSpecific; j++)
			{
				if(i == specific[j][1])
				{
					order[i] = specific[j][0];
				}
			}
		}
		//next place hierarchy cows

		int previous = -1;
		boolean hasOne = false;
		for(int i = 0; i < numHierarchy; i++)
		{
			if(hierarchy[i] == 1) hasOne = true;
		}
		if(!hasOne)
		{
			for(int i = 0; i < numCows; i++)
			{
				for(int j = 0; j < numHierarchy; j++)
				{
					if(order[i] == hierarchy[j]) //looking at cow numbers 
					{
						int dummyPos = i - 1;
						int dummyHierarchy = j - 1;
						while(dummyHierarchy > previous)
						{
							if(order[dummyPos] == 0) 
							{
								order[dummyPos] = hierarchy[dummyHierarchy];
								dummyHierarchy--;
							}
							else 
							{
								dummyPos--;
							}
						}
						previous = j;
						break;
					}
				}
			}
		}
		if(hasOne)
		{
			//boolean encounteredHier = false;
			int after = numHierarchy;
			for(int i = numCows - 1; i > -1; i--)
			{
				for(int j = numHierarchy - 1; j > -1; j--)
				{
					if(order[i] == hierarchy[j]) //looking at cow numbers 
					{
						//if(!encounteredHier)
						//{
							int dummyPos = i + 1;
							int dummyHierarchy = j + 1;
							while(dummyHierarchy < after)
							{
								if(order[dummyPos] == 0) 
								{
									order[dummyPos] = hierarchy[dummyHierarchy];
									dummyHierarchy++;
								}
								else 
								{
									dummyPos++;
								}
							}
							after = j;
							break;
						//}
					}
				}
			}
			after--; //TODO the error is somewhere here
			int pos = 0;
			int remaining = 0;
			while(remaining < after - 1)
			{
				if(order[pos] == 0) 
				{
					order[pos] = hierarchy[remaining];
					remaining++;
				}
				else 
				{
					pos++;
				}
			}
		}
		//then find earliest open spot (equal to 0)
		int earliestPos = numCows - 1;
		for(int i = 0; i < numCows; i++)
		{
//			if(order[i] == 0 || order[i] == 1)
//			{
//				earliestPos = i + 1;
//				break;
//			}
			if(hasOne)
			{
				if(order[i] == 1)
				{
					earliestPos = i + 1;
					break;
				}
			}
			else
			{
				if(order[i] == 0)
				{
					earliestPos = i + 1;
					break;
				}
			}
		}
		
		File file = new File("milkorder.out");
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		
		//outwriting goes here
		out.write(earliestPos + "\n");
		for(int i = 0; i < numCows; i++)
		{
			System.out.println(order[i]);
		}
		
		out.close();
	}
	
	
}
