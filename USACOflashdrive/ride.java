/*
ID: stevenw3
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;
import java.lang.*;
public class ride{

	static Scanner input = null;
	public static void main(String[] args)
	{

		
		try {
			input = new Scanner(new FileInputStream("ride.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String lineOne = input.nextLine();
		String lineTwo = input.nextLine();
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("ride.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(charFun(lineOne) == charFun(lineTwo)) 
		{
			writer.print("GO\n");
		}
		else
		{
			writer.print("STAY\n");
		}
		writer.close();
		System.exit(0);
	}
	
	public static int charFun(String inString)
	{
		int ret = 1;
		for(int i = 0; i < inString.length(); i++)
		{
			ret *= inString.charAt(i) - 64;
		}
		ret = ret % 47;
		if(ret < 0) ret = 47 + ret;
		return ret;
	}
}