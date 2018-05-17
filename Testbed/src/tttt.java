//Written by Steven Wu for USACO March 2018
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
public class tttt {
	
	static char[][] board = new char[3][3];
	static int indivCount = 0;
	static int teamCount = 0;
	public static void main(String[] args) throws IOException
	{
		//input goes here
		Scanner input = new Scanner(new File("tttt.in"));
		
		String line1 = input.nextLine();
		String line2 = input.nextLine();
		String line3 = input.nextLine();
		for(int i = 0; i < 3; i++)
		{
			board[0][i] = line1.charAt(i);
			board[1][i] = line2.charAt(i);
			board[2][i] = line3.charAt(i);
		}
		//System.out.println(board[1][0]);
		
		//implementation goes here
		checkLetter();
		checkPairings();
		
		//you need to find a way to check for non-duplicates of team victories TODO
		File file = new File("tttt.out");
		FileWriter writer = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(writer);
		
		//outwriting goes here
		out.write(indivCount + "\n");
		out.write(teamCount + "\n");
		
		out.close();
	}
	
	static void checkLetter()
	{
		for(char x = 65; x < 91; x++)
		{
			if(checkHorizontal(x) || checkVertical(x) || checkDiagonal(x)) indivCount++;
		}
	}
	static void checkPairings()
	{
		for(char x = 65; x <= 91; x++)
		{
			for(char y = 65; y <= 91; y++)
			{
				if(x != y) if(checkHorizontalTeam(x,y) || checkVerticalTeam(x,y) || checkDiagonalTeam(x,y)) teamCount++;
			}
		}
	}
	static boolean checkHorizontal(char x)
	{
		for(int i = 0; i < 3; i++)
		{
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i] 
					&& board[2][i] == x) return true;
		}
		return false;
	}
	static boolean checkVertical(char x)
	{
		for(int i = 0; i < 3; i++)
		{
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2]
					&& board[i][2] == x) return true;
		}
		return false;
	}
	static boolean checkDiagonal(char x)
	{
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]
				&& board[2][2] == x) return true;
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0]
				&& board[2][0] == x) return true;
		return false;
	}
	
	static boolean checkHorizontalTeam(char x, char y)
	{
		for(int i = 0; i < 3; i++)
		{
			if(board[0][i] == board[1][i] && board[1][i] == x && y == board[2][i]) return true;
			if(board[0][i] == board[2][i] && board[2][i] == x && y == board[1][i]) return true;
			if(board[1][i] == board[2][i] && board[1][i] == x && y == board[0][i]) return true;
		}
		return false;
	}
	static boolean checkVerticalTeam(char x, char y)
	{
		for(int i = 0; i < 3; i++)
		{
			if(board[i][0] == board[i][1] && board[i][1] == x && y == board[i][2]) return true;
			if(board[i][0] == board[i][2] && board[i][0] == x && y == board[i][1]) return true;
			if(board[i][2] == board[i][1] && board[i][1] == x && y == board[i][0]) return true;
		}
		return false;
	}
	static boolean checkDiagonalTeam(char x, char y)
	{
		if(board[0][0] == board[1][1] && board[1][1] == x && y == board[2][2]) return true;
		if(board[0][0] == board[2][2] && board[2][2] == x && y == board[1][1]) return true;
		if(board[1][1] == board[2][2] && board[2][2] == x && y == board[0][0]) return true;
		if(board[0][2] == board[1][1] && board[1][1] == x && y == board[2][0]) return true;
		if(board[1][1] == board[2][0] && board[2][0] == x && y == board[0][2]) return true;
		if(board[0][2] == board[2][0] && board[2][0] == x && y == board[1][1]) return true;
		return false;
	}
	
}
