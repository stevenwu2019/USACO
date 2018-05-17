//Written by Steven Wu for USACO March 2018
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
public class family {
	
	
	public static void main(String[] args) throws IOException
	{
		//input goes here
		Scanner input = new Scanner(new File("family.in"));
		int numLines = input.nextInt();
		String cowA = input.next();
		String cowB = input.next();
		String[] listedMothers = new String[numLines];
		String[] listedDaughters = new String[numLines];
		for(int i = 0; i < numLines; i++)
		{
			listedMothers[i] = input.next();
			listedDaughters[i] = input.next();
		}
		
		//implementation goes here
		//ancestral data - look for mothers of the two cows
		ArrayList<String> cowA_moms = new ArrayList<String>();
		ArrayList<String> cowB_moms = new ArrayList<String>();
		cowA_moms.add(cowA);
		cowB_moms.add(cowB);
		
		int momPos = -1;
		for(int i = 0; i < numLines; i++)
		{
			if(listedDaughters[i].equals(cowA))
			{
				//System.out.println("TEST");
				momPos = i;
				cowA_moms.add(listedMothers[momPos]);
				for(int j = 0; j < numLines; j++)
				{
					for(int z = 0; z < numLines; z++) //chase the moms all the way to the top
					{
						if(listedDaughters[z].equals(listedMothers[momPos]))
						{
							momPos = z;
							cowA_moms.add(listedMothers[momPos]);
						}
					}
				}
			}
		} 
//		//now go in the opposite direction TODO
//		momPos = -1;
//		for(int i = 0; i < numLines; i++)
//		{
//			if(listedMothers[i].equals(cowA))
//			{
//				//System.out.println("TEST");
//				momPos = i;
//				cowA_moms.add(0, listedDaughters[momPos]);
//				for(int j = 0; j < numLines; j++)
//				{
//					for(int z = 0; z < numLines; z++) //chase the moms all the way to the top
//					{
//						if(listedMothers[z].equals(listedDaughters[momPos]))
//						{
//							momPos = z;
//							cowA_moms.add(0, listedDaughters[momPos]);
//						}
//					}
//				}
//			}
//		} 
//		//TODO
		momPos = -1;
		for(int i = 0; i < numLines; i++)
		{
			if(listedDaughters[i].equals(cowB))
			{
				momPos = i;
				cowB_moms.add(listedMothers[momPos]);
				for(int j = 0; j < numLines; j++)
				{
					for(int z = 0; z < numLines; z++)
					{
						if(listedDaughters[z].equals(listedMothers[momPos]))
						{
							momPos = z;
							cowB_moms.add(listedMothers[momPos]);
						}
					}
				}
			}
		}
//		//now go in the opposite direction TODO
//		momPos = -1;
//		for(int i = 0; i < numLines; i++)
//		{
//			if(listedMothers[i].equals(cowB))
//			{
//				//System.out.println("TEST");
//				momPos = i;
//				cowB_moms.add(0, listedDaughters[momPos]);
//				for(int j = 0; j < numLines; j++)
//				{
//					for(int z = 0; z < numLines; z++) //chase the moms all the way to the top
//					{
//						if(listedMothers[z].equals(listedDaughters[momPos]))
//						{
//							momPos = z;
//							cowB_moms.add(0, listedDaughters[momPos]);
//						}
//					}
//				}
//			}
//		} 
//		//TODO
		//System.out.println(cowB_moms.get(0));
		
		//now determine closest shared relative
		boolean related = false;
		String relationship = "";
		int aPos = -1;
		int bPos = -1;
		
		for(int i = 0; i < cowA_moms.size(); i++)
		{
			System.out.println(cowA_moms.get(i));
		}
		
		for(int i = 0; i < cowA_moms.size(); i++)
		{
			for(int j = 0; j < cowB_moms.size(); j++)
			{
				if(cowA_moms.get(i).equals(cowB_moms.get(j)))
				{
					System.out.println("TEST");
					related = true;
					aPos = i;
					bPos = j;
					i = cowA_moms.size();
					j = cowB_moms.size();
				}
			}
		}
		
		
		//determine relationship from offset
		int offset = aPos - bPos;
		if(related)
		{
			//directly related
			if(cowB_moms.get(bPos).equals(cowA)) 
			{
				if(Math.abs(offset) == 1) 
				{
					relationship = cowA + " is the mother of " + cowB;
				}
				if(Math.abs(offset) == 2) 
				{
					relationship = cowA + " is the grand-mother of " + cowB;
				}
				if(Math.abs(offset) > 2) 
				{
					relationship = cowA + " is the ";
					for(int i = 0; i < offset - 2; i++)
					{
						relationship += "great-";
					}
					relationship += "grand-mother of " + cowB;
				}
			}
			if(cowA_moms.get(aPos).equals(cowB)) 
			{
				if(Math.abs(offset) == 1) 
				{
					relationship = cowB + " is the mother of " + cowA;
				}
				if(Math.abs(offset) == 2) 
				{
					relationship = cowB + " is the grand-mother of " + cowA;
				}
				if(Math.abs(offset) > 2) 
				{
					relationship = cowB + " is the ";
					for(int i = 0; i < offset - 2; i++)
					{
						relationship += "great-";
					}
					relationship += "grand-mother of " + cowA;
				}
			}
			//aunts
			else if(aPos == 1) //a is blank aunt of b
			{
				if(Math.abs(offset) == 0) relationship = "SIBLINGS";
				if(Math.abs(offset) == 1) relationship = cowA + " is the aunt of " + cowB;
				if(Math.abs(offset) > 1)
				{
					relationship = cowA + " is the ";
					for(int i = 0; i < offset - 1; i++)
					{
						relationship += "great-";
					}
					relationship += "aunt of " + cowB;
				}
			}
			else if(bPos == 1)
			{
				if(offset == 0) relationship = "SIBLINGS";
				if(Math.abs(offset) == 1) relationship = cowB + " is the aunt of " + cowA;
				if(Math.abs(offset) > 1)
				{
					relationship = cowB + " is the ";
					for(int i = 0; i < Math.abs(offset) - 1; i++)
					{
						relationship += "great-";
					}
					relationship += "aunt of " + cowA;
				}
			}
			//cousins
			else
			{
				relationship = "COUSINS";
			}
		}
		else relationship = "NOT RELATED";
		
		
		
		File file = new File("family.out");
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		
		//outwriting goes here
		//if(!related) out.write("NOT RELATED");
		out.write(relationship); //may need to be flipped
		
		out.close();
	}
	
}
