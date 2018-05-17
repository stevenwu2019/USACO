import java.util.*;
import java.io.*;
import java.lang.*;
public class BovineShuffle {
	
	public static void main(String[] args)
	{
		int size = 0;
		Scanner input = null;
		
		try {
			input = new Scanner(new FileInputStream("shuffle.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		size = input.nextInt();
		ArrayList<cow> cows = new ArrayList<cow>();
		int[] nextPos = new int[size];
		int[] reverseNextPos = new int[size];
		for(int x = 0; x < size; x++)
		{
			//System.out.print("hi");
			//cows[x].setPos(input.nextInt());
			//System.out.println(cows[x].getPos());
			cows.add(new cow());
			int dummy = input.nextInt();
			
			nextPos[x] = dummy;
		}
		
		for(int x = 0; x < size; x++)
		{
			for(int a = 0; a < size; a++)
			{
				if(nextPos[a] == x)
					reverseNextPos[x] = a;
			}
		}
		for(int x = 0; x < size; x++)
		{
			cows.get(x).setID(input.nextInt());
			cows.get(x).setPos(x + 1);
			//System.out.println(cows.get(x).getPos());
		}
		String results = "";
//		for(int x = 0; x < size; x++)
//		{
//		System.out.println(cows.get(x).getPos());
//		System.out.println(cows.get(x).getID());
//		}
		for(int y = 0; y < 3; y++)
		{
		for(int x = 1; x <= size; x++)
		{
			for(int a = 0; a < size; a++)
			{
				if(cows.get(a).getPos() == x)
				{
					cows.get(a).setPos(reverseNextPos[x]);
					break;
				}
			}
		}
		}
		
		for(int x = 1; x <= size; x++)
		{
			for(int a = 0; a < size; a++)
			{
				if(cows.get(a).getPos() == x)
				{
					if(x == 1) results += (cows.get(a).getID());
					else results += ("\n" + cows.get(a).getID());
					break;
				}
				
			}
		}
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("shuffle.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(results);
		writer.println(results);
		writer.close();
		System.exit(0);
		
	}
}


class cow {
		private int id = 0;
		private int pos = 0;
		public cow()
		{
			id = 0;
			pos = 0;
		}
		public cow(int iden, int posit)
		{
			id = iden;
			pos = posit;
		}
		public void setID(int ident)
		{
			id = ident;
		}
		public void setPos(int posit)
		{
			pos = posit;
		}
		public int getID()
		{
			return id;
		}
		public int getPos()
		{
			return pos;
		}
}


