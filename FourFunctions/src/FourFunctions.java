import java.util.*;

public class FourFunctions 
{
	public static double median(int []array)
	{
		Arrays.sort(array);
		double result = (double)array[2];
		return(result);
	}
	
	
	public static double stddev(int []array)
	{
		int total = 0;
		for(int i=0;i<5;i++)
		{
			total += Math.pow(array[i]-FourFunctions.average(array),2);
		}
		double result = (double)Math.sqrt(total/5);
		return(result);
	}
	
	public static double average(int []array)
	{
		int total = 0;
		for(int i=0;i<array.length;i++)
		{
			total += array[i];
		}
		double result = (double)total/5;
		return(result);
	}
	
	/*public static int mode(int []array)
	{
		int count = 0;
		int max = 0;
		for(int i=0;i<5;i++)
		{
			int temp = 0;
			for(int k=0;k<5;k++)
			{
				if(array[k]==array[i])
				{
					temp++;
				}
			}
			if(temp>count)
			{
				max = array[i];
			}
		}
		return max;
	}*/
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int mode = scan.nextInt();
		if(mode>4&&mode<0) {scan.close();return;}
		int numbers[] = new int[5];
		for(int i=0;i<5;i++)
		{
			numbers[i] = scan.nextInt();
		}
		scan.close();
		if(mode==1)
		{
			System.out.printf("%.2f\n", average(numbers));
		}
		else if(mode==2)
		{
			System.out.println(median(numbers));
		}
		else if(mode==3)
		{
			System.out.printf("%.2f\n",stddev(numbers));
		}
		else if(mode==4)
		{
			System.out.println(mode(numbers));
		}
	
	}
	
	public static int mode(int []array)
	{
	    HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
	    int max  = 1;
	    int temp = 0;

	    for(int i = 0; i < 5; i++) 
	    {
	        if (hash.get(array[i]) != null) 
	        {
	            int count = hash.get(array[i]); //match max with values returned from the HashMap
	            count++;
	            hash.put(array[i], count);

	            if(count > max) //if the value is repeated, update count
	            {
	                max  = count;
	                temp = array[i];
	            }
	        }

	        else
	        {
	        	hash.put(array[i],1);
	        }
	    }
	    
	    if(temp==0)
	    {	
	    	return array[0];
	    }
	    else
	    {
	    	return(temp);
	    }
	}
}
