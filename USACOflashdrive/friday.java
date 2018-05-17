/*
ID: stevenw3
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;
import java.lang.*;
public class friday{

	static Scanner input = null;
	public static void main(String[] args)
	{
		try {
			input = new Scanner(new FileInputStream("friday.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numYears = input.nextInt();
		int[] days = new int[7]; //0 is Sat, 1 is Sun, 2 is Mon...
		int firstDay = 2;
		for(int years = 0; years < numYears; years++)
		{
			int jan = (firstDay + 12) % 7;
			days[jan]++;
			int feb = (jan + 31) % 7;
			days[feb]++;
			int mar = 0;
			if(years % 4 == 0 && (years % 100 != 0 || years == 100))
			{
				mar = (feb + 29) % 7;
			}
			else mar = (feb + 28) % 7;
			days[mar]++;
			int apr = (mar + 31) % 7;
			days[apr]++;
			int may = (apr + 30) % 7;
			days[may]++;
			int jun = (may + 31) % 7;
			days[jun]++;
			int jul = (jun + 30) % 7;
			days[jul]++;
			int aug = (jul + 31) % 7;
			days[aug]++;
			int sep = (aug + 31) % 7;
			days[sep]++;
			int oct = (sep + 30) % 7;
			days[oct]++;
			int nov = (oct + 31) % 7;
			days[nov]++;
			int dec = (nov + 30) % 7;
			days[dec]++;
			firstDay = (dec + 19) % 7;
		}
		
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("friday.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 6; i++)
		{
			writer.print(days[i] + " ");
		}
		writer.print(days[6] + "\n");
		writer.close();
		System.exit(0);
	}
}