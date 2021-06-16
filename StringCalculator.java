package kata;


public class StringCalculator {
	
	public static void main (String args[])
	{
		String numbers = ",1,2,3,4,5,6,7";
		StringCalculator obj =new StringCalculator();	
		obj.add(numbers);
	}
	
	
	public int add(String numbers) 
	{
		int result=0;
		int len= numbers.length()-1;
		 if(len>=0)
		{
			 if(numbers.charAt(len)==','||numbers.charAt(0)==',')
			 {
				System.out.println("Number Format Exception Occured: Number is missing");
				return 0;
			 }
			 else if(len==0)
			 {
				 try
					{
					result = result+Integer.parseInt(numbers);
					}
					catch(NumberFormatException e)
					{
						System.out.println("Number Format Exception Occured: Number is missing");
						return 0;
					}
			 }
			 else
			 {
				 
				 
				String [] adders = numbers.split(",");
				for(int i=0;i<adders.length;i++)
				{
					try
					{
					result = result+Integer.parseInt(adders[i]);
					}
					catch(NumberFormatException e)
					{
						System.out.println("Number Format Exception Occured: Number is missing");
						return 0;
					}
				}
			 }
		}
		System.out.println("The Result is "+result);
		return result;
	}
}