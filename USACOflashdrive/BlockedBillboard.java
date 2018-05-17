import java.util.*;
import java.io.*;
import java.lang.*;
public class BlockedBillboard {
	static int[] b1 = new int[4];
	static int[] b2 = new int[4];
	static int[] truck = new int[4];
	static int b1_area = 0;
	static int b2_area = 0;
	
	static Scanner input = null;
	public static void main(String[] args)
	{

		
		try {
			input = new Scanner(new FileInputStream("billboard.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b1[0] = input.nextInt();
		b1[1] = input.nextInt();
		b1[2] = input.nextInt();
		b1[3] = input.nextInt();
		
		b2[0] = input.nextInt();
		b2[1] = input.nextInt();
		b2[2] = input.nextInt();
		b2[3] = input.nextInt();
		
		truck[0] = input.nextInt();
		truck[1] = input.nextInt();
		truck[2] = input.nextInt();
		truck[3] = input.nextInt();
		
		b1_area = (b1[3] - b1[1]) * (b1[2] - b1[0]);
		b2_area = (b2[3] - b2[1]) * (b2[2] - b2[0]);
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("billboard.out", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println(checkBlock(b1));
		writer.println(b1_area - checkBlock(b1) + b2_area - checkBlock(b2));
		writer.close();
		System.exit(0);
		
		
		
	}
	public static int checkBlock(int[] b)
	{
		int blockedArea = 0;
		int outside = 0;
		for(int x = 0; x < 4; x++)
		{
			if(x % 2 == 0)
			{
				if(!(truck[x] > b[0] && truck[x] < b[2]))
				{
					outside++;
					truck[x] = b[x];
				}
			}
			else
			{
				 if(!(truck[x] > b[1] && truck[x] < b[3]))
				 {
					 outside++;
					 truck[x] = b[x];
				 }
			}
		}
		if(outside != 4 && !(truck[0] < b[0] && truck[1] < b[1] && truck[2] > b[2] && truck[3] > b[3])) 
			blockedArea = (truck[3] - truck[1]) * (truck[2] - truck[0]);
//		if(truck[0] > b[0] && truck[0] < b[2] && truck[1] > b[1] && truck[1] < b[3]
//				&& truck[2] > b[2] && truck[3] > b[3])
//		{
//			blockedArea = Math.abs((b[2] - truck[0]) * (b[3] - truck[1]));
//		}
//		else if(truck[2] > b[0] && truck[2] < b[2] && truck[1] > b[1] && truck[1] < b[3]
//				&& truck[0] < b[0] && truck[3] > b[3])
//		{
//			blockedArea = Math.abs((b[0] - truck[2]) * (b[3] - truck[1]));
//			System.out.println(b[0] - truck[2]);
//		}
//		else if(truck[2] > b[0] && truck[2] < b[2] && truck[3] > b[1] && truck[3] < b[3])
//		{
//			blockedArea = Math.abs((b[0] - truck[2]) * (b[1] - truck[3]));
//		}
//		else if(truck[0] > b[0] && truck[0] < b[2] && truck[3] > b[1] && truck[3] < b[3])
//		{
//			blockedArea = Math.abs((b[2] - truck[0]) * (b[1] - truck[3]));
//		}
		return blockedArea;
	}
}
