import java.util.Scanner;

public class Power {
	public static long power(int base, int exp)
	{
		long result = base;
		if(exp!=0) {
		for(int i=1;i<exp;i++)
		{
			result=(long)result*base;
		}
		return result;
		}
		else
		{
			return 1;
		}
	}
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int base = scan.nextInt();
		int exp = scan.nextInt();
		scan.close();
		System.out.println(Power.power(base, exp));
	}
}
