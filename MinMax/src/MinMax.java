import java.util.Scanner;
import java.util.Arrays;

public class MinMax {
	//Given a list of numbers , return the second largest integer in that list
	public static int secondMax ( int [] numbers )
	{
		return(numbers[numbers.length-2]);
	}
	
	
	//Given a list of numbers , return the second smallest integer in that list
	public static int secondMin ( int [] numbers )
	{
		return(numbers[1]);
	}
	public static void main(String args[])
	{
		int size;
		Scanner in = new Scanner(System.in);
		size = in.nextInt();//read the size of an array
		int numbers[];//create an array
		numbers = new int[size];//instantiate the array with given size
		
		
		for(int i=0;i<size;i++)
		{
			numbers[i]=in.nextInt();//populate the array
		}
		in.close();//close the scanner
		Arrays.sort(numbers);
		
		System.out.println(MinMax.secondMax(numbers));
		System.out.println(MinMax.secondMin(numbers));
	}
}
