/*
ID: stevenw3
LANG: JAVA
TASK: palsquare
*/
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
public class palsquare {

	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(new File("palsquare.in"));
		int base = input.nextInt();
		ArrayList<String> outputs = new ArrayList<String>();
		
		//System.out.println(isPalindrome("3BABA3"));
		for(int i = 1; i < 301; i++)
		{
			if(isPalindrome(convertToBase(i*i, base)))
			{
				outputs.add(convertToBase(i, base));
				outputs.add(convertToBase(i*i, base));
			}
		}
		
		File file = new File("palsquare.out");
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		
		for(int i = 0; i < outputs.size(); i++)
		{
			if(i % 2 == 0)
			{
				out.write(outputs.get(i) + " ");
			}
			else
			{
				out.write(outputs.get(i) + "\n");
			}
		}
		
		out.close();
	}
	
	public static String convertToBase(int num, int base)
	{
		String ret = "";
		int pos = 1;
		while(pos * base < num)
		{
			pos *= base;
			//System.out.println(pos);
		}
		while(pos > 1)
		{
			int value = 0;
			while(pos * (value + 1) <= num)
			{
				value++;
			}
			num -= pos * value;
			if(value > 9)
			{
				if(value == 10) ret += "A";
				if(value == 11) ret += "B";
				if(value == 12) ret += "C";
				if(value == 13) ret += "D";
				if(value == 14) ret += "E";
				if(value == 15) ret += "F";
				if(value == 16) ret += "G";
				if(value == 17) ret += "H";
				if(value == 18) ret += "I";
				if(value == 19) ret += "J";
				if(value == 20) ret += "K";
			}
			else ret += value;
			pos /= base;
		}
		if(num > 9)
		{
			if(num == 10) ret += "A";
			if(num == 11) ret += "B";
			if(num == 12) ret += "C";
			if(num == 13) ret += "D";
			if(num == 14) ret += "E";
			if(num == 15) ret += "F";
			if(num == 16) ret += "G";
			if(num == 17) ret += "H";
			if(num == 18) ret += "I";
			if(num == 19) ret += "J";
			if(num == 20) ret += "K";
		}
		else ret += num;
		
		return ret;
	}
	
	public static boolean isPalindrome(String str)
	{
		boolean ret = true;
		int length = str.length();
		char[] digits = new char[length];
		for(int i = length - 1; i > -1; i--)
		{
			digits[i] = str.charAt(i);
		}
		for(int i = 0; i < length; i++)
		{
			if(digits[i] != digits[length - i - 1]) ret = false; //TODO compare alternating digits
		}
		return ret;
	}
	
}
