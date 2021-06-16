package kata;


public class StringCalculator {
	
	public static void main (String args[])
	{
		String numbers = "\n4";
		StringCalculator obj =new StringCalculator();	
		obj.add(numbers);
		int len = numbers.length();
		System.out.println(len);
		System.out.println(numbers.charAt(1));
	}
	
	
	public int add(String numbers) 
	{
		int result=0;
		int len= numbers.length()-1;
		 if(len>=0)
		{
			 if(numbers.charAt(len)==','||numbers.charAt(0)==','||numbers.charAt(0)=='\n'||numbers.charAt(len)=='\n')
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
				String [] adders = numbers.split(",|\n");
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