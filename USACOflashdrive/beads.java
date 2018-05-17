/*
ID: stevenw3
LANG: JAVA
TASK: beads
*/

/*
 * what I learned from this:
 * spend more time thinking about generating a smart solution to this problem
 * creating a class was not necessary, nor was saving that massive list of combos. a simple search and sort would suffice.
 * thinking about the problem is just as important, maybe more so, as coding up the solution
 * i could've saved a lot of time by just finding the easier way to solve the problem initially
 * if you have a whole bunch of weird edge cases, your code is probably logically flawed
*/
import java.util.*;
import java.io.*;
import java.lang.*;
public class beads{

	static Scanner input = null;
	public static void main(String[] args)
	{
		try {
			input = new Scanner(new FileInputStream("beads.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = input.nextInt();
		String necklace = input.next();
		
		String necklaceCopy = necklace + necklace;
		ArrayList<Combo> combos = new ArrayList<Combo>();
		for(int i = 1; i < necklaceCopy.length(); i++)
		{
			char color = necklaceCopy.charAt(i);
			int position = i;
			int length = 1;
			if(true)//color == 'r' || color == 'b')
			{
				for(int x = position + 1; x < necklaceCopy.length() - 1; x++)
				{
					if(necklaceCopy.charAt(x) == color || necklaceCopy.charAt(x) == 'w')
					{
						length++;
						if(length > size) length = size;
						if(length > 1) combos.add(new Combo(color, position, length));
					}
					else
					{
						combos.add(new Combo(color, position, 1));
						break;
					}
				}
				int z;
				for(z = i - 1; z > -1; z--)
				{
					if(necklaceCopy.charAt(z) != 'w') 
					{
						color = necklaceCopy.charAt(z);
						break;
					}
					else
					{
						length++;
					}
				}
				for(int x = z; x > -1; x--)
				{
					if(necklaceCopy.charAt(x) == color || necklaceCopy.charAt(x) == 'w')
					{
						length++;
						if(length > size) length = size;
						combos.add(new Combo(color, position, length));
					}
					else
					{
						combos.add(new Combo(color, position, 1));
						break;
					}
				}
//				if(length > size) length = size;
//				if(length > 1) combos.add(new Combo(color, position, length));
//				for(int x = length - 1; x > -1; x--)
//				{
//					if(necklaceCopy.charAt(position + x) == 'w')
//					{
//						combos.add(new Combo(color, position, x));
//					}
//				}
//				for(int x = 0; x < length; x++)
//				{
//					if(necklaceCopy.charAt(position + x) == 'w')
//					{
//						combos.add(new Combo(color, position + x + 1, length - x - 1));
//					}
//				}
			}
		}
		//now find longest single combo
		int longest = 0;
		for(int i = 0; i < combos.size(); i++)
		{
			System.out.println(combos.get(i).length);
			if(combos.get(i).length > longest)
			{
				longest = combos.get(i).length;
			}
		}
		System.out.println(longest);
		//now check if combining 2 different color combos is greater
//		for(int i = 0; i < combos.size(); i++)
//		{
//			for(int x = 0; x < combos.size(); x++)
//			{
//				if((combos.get(i).position + combos.get(i).length == combos.get(x).position 
//						|| combos.get(x).position + combos.get(x).length == combos.get(i).position)
//						&& combos.get(i).color != combos.get(x).color)
//				{
//					if(combos.get(i).length + combos.get(x).length > longest)
//					{
//						longest = combos.get(i).length + combos.get(x).length;
//						System.out.println("longest: " + longest);
//					}
//				}
//			}
//		}
		System.out.println(longest);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("beads.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.print(longest + "\n");
		writer.close();
		System.exit(0);
	}
}


class Combo
{
	public char color;
	public int position;
	public int length;
	
	public Combo(char col, int pos, int len)
	{
		color = col;
		position = pos;
		length = len;
	}
}