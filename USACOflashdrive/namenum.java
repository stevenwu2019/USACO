/*
ID: stevenw3
LANG: JAVA
TASK: namenum
*/

/*
 * what I learned from this program
 * don't add unnecessary gates to jump over that you don't need. they may just cause bugs
 * again, keep it simple. go for the bash that parses through less cases. don't write a go big or go home method
 */
 
import java.util.*;
import java.io.*;
import java.lang.*;
public class namenum{

	//read file
	static Scanner input = null;
	static Scanner dict = null;
	public static void main(String[] args)
	{
		try {
			input = new Scanner(new FileInputStream("namenum.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			try {
				dict = new Scanner(new FileInputStream("dict.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//String dummyInput = input.next();
		double originalID = input.nextDouble();//Integer.valueOf(dummyInput);
		
		int id = (int)originalID;
		
		ArrayList<String> ret = new ArrayList<String>();
		
		//split id into digits
		int numDigits = String.valueOf(id).length();
		int[] digits = new int[numDigits];
		for(int i = numDigits - 1; i > -1; i--)
		{
			digits[i] = id % 10;
			id /= 10;
		}
		
		ArrayList<String> acceptableNames = new ArrayList<String>();
		while(dict.hasNext())
		{
			String dummyName = dict.next();
			acceptableNames.add(dummyName);
		}
		
		for(int i = 0; i < acceptableNames.size(); i++)
		{
			//int pseudoID = 0;
			String stringPseudoID = "";
			for(int a = 0; a < acceptableNames.get(i).length(); a++)
			{
				char dummyChar = acceptableNames.get(i).charAt(a);
				if(dummyChar == 'A' || dummyChar == 'B' || dummyChar == 'C')
				{
					stringPseudoID += "2";
				}
				if(dummyChar == 'D' || dummyChar == 'E' || dummyChar == 'F')
				{
					stringPseudoID += "3";
				}
				if(dummyChar == 'G' || dummyChar == 'H' || dummyChar == 'I')
				{
					stringPseudoID += "4";
				}
				if(dummyChar == 'J' || dummyChar == 'K' || dummyChar == 'L')
				{
					stringPseudoID += "5";
				}
				if(dummyChar == 'M' || dummyChar == 'N' || dummyChar == 'O')
				{
					stringPseudoID += "6";
				}
				if(dummyChar == 'P' || dummyChar == 'R' || dummyChar == 'S')
				{
					stringPseudoID += "7";
				}
				if(dummyChar == 'T' || dummyChar == 'U' || dummyChar == 'V')
				{
					stringPseudoID += "8";
				}
				if(dummyChar == 'W' || dummyChar == 'X' || dummyChar == 'Y')
				{
					stringPseudoID += "9";
				}
			}
			double pseudoID = new Double(stringPseudoID);
			if(pseudoID == originalID)
			{
				ret.add(acceptableNames.get(i));
			}
			//if(true) System.out.println(pseudoID);
		}
		
//		for(int i = 0; i < numDigits; i++)
//		{
//			for(int a = 0; a < 3)
//		}
		
		//generate output
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("namenum.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(ret);
		for(int i = 0; i < ret.size(); i++)
		{
			writer.print(ret.get(i) + "\n");
		}
		if(ret.size() == 0)
		{
			writer.print("NONE" + "\n");
		}
		writer.close();
		System.exit(0);
		
	}
	
	
}

