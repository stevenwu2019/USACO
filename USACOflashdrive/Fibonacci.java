
public class Fibonacci {
	public static void doFibonacci(int length)
	{
		double[] result = new double[length];
		if(length <= 2) result[0] = 1;
		else if (length == 2) result[1] = 1;
		else
		{
			result[0] = 1;
			result[1] = 1;
			for(int i = 2; i < length; i++)
			{
				result[i] = result[i - 1] + result[i - 2];
			}
		}
		
		for(int i = 0; i < length - 1; i++)
		{
			System.out.print(result[i] + ", ");
		}
		System.out.println(result[length - 1]);
	}
	public static void main(String[] args)
	{
		doFibonacci(50);
	}
}
