/*
ID: stevenw3
LANG: JAVA
TASK: gift1
*/
import java.util.*;
import java.io.*;
import java.lang.*;
public class gift1{

	static Scanner input = null;
	public static void main(String[] args)
	{

		
		try {
			input = new Scanner(new FileInputStream("gift1.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numPeople = input.nextInt();
		String[] names = new String[numPeople];
		int[] netWealth = new int[numPeople];
		for(int i = 0; i < numPeople; i++)
		{
			names[i] = input.next();
			//System.out.println(names[i]);
			netWealth[i] = 0;
		}
		//System.out.println(names[4]);
		for(int i = 0; i < numPeople; i++)
		{
			String giver = input.next();
			//System.out.println(giver);
			int giftVal = input.nextInt();
			//System.out.println(giftVal);
			int numRecipients = input.nextInt();
			//System.out.println(numRecipients);
			for(int x = 0; x < numPeople; x++)
			{
				if(names[x].equals(giver) && numRecipients != 0)
				{
					netWealth[x] += -giftVal + (giftVal % numRecipients);
					break;
				}
			}
			for(int x = 0; x < numRecipients; x++)
			{
				String recipient = input.next();
				for(int a = 0; a < numPeople; a++)
				{
					if(names[a].equals(recipient) && numRecipients != 0)
					{
						netWealth[a] += giftVal / numRecipients;
						break;
					}
				}
			}
		}
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("gift1.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < numPeople; i++)
		{
			writer.println(names[i] + " " + netWealth[i]);
		}
		writer.close();
		System.exit(0);
	}
}