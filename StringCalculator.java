package kata;

import java.util.*;

public class StringCalculator {
	
	ArrayList<String> delimiterslist = new ArrayList<>();

	public static void main (String args[])
	{
		String numbers = "2,";
		StringCalculator obj =new StringCalculator();	
		int res= obj.add(numbers);
		System.out.println(res);
	}
	
	public String delimiters(String numbers)
	{
		int len = numbers.length()-1;
		int i=0,found=0;
		while(i<len)
		{
			if(i==0)
			{
				if(numbers.charAt(i)=='/'&&numbers.charAt(i+1)=='/')
				{
					if(i+2<len)
					{
						i+=2;
					}
					else
					{
						return "";
					}
				}
				else
				{
					return numbers;
				}
			}
			else 
			{
				char member =numbers.charAt(i);
				if(member!='\n')
				{
					String addtolist = new String("");
					addtolist=addtolist+member;
					delimiterslist.add(addtolist);
					i++;
					
				}
				else
				{
					found=1;
					i++;
					break;
				}
			}
		}
		if(i<=len&&found==1)
		{
			if(numbers.charAt(i)!='\n')
			{
				numbers=numbers.substring(i);
				return numbers;
			}
			else
			{
				return "";
			}
		}
		else
		{
			return "";
		}
			
	}
	
	public int add(String numbers) 
	{
		numbers=delimiters(numbers);
		delimiterslist.add(",");
		delimiterslist.add("\n");
		String delimits=new String("");
		for(int i=0;i<delimiterslist.size();i++)
		{
			delimits=delimits+delimiterslist.get(i);
		}
		delimits="["+delimits+"]"+"+";
		int result=0;
		int len= numbers.length()-1;
		System.out.println(len);
		if(len>=0)
		{
			
			if(delimiterslist.contains(String.valueOf(numbers.charAt(0)))||delimiterslist.contains(String.valueOf(numbers.charAt(len))))
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
				String [] adders = numbers.split(delimits);
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