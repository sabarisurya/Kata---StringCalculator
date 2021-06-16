package kata;

import java.util.*;


class NegativeNumber extends Exception
{  
	int num;
	NegativeNumber(int num)
	{  
		this.num=num;
	}  
}  

public class StringCalculator 
{
	
	ArrayList<String> delimiterslist = new ArrayList<>();

	public static void main (String args[])
	{
		String numbers = "//;\n1;2,3,4;1005\n5\n6";
		StringCalculator obj =new StringCalculator();	
		int res=0;
		res= obj.add(numbers);
		System.out.println("\nThe Result is "+res);
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
		int result=0,negative=0;
		int len= numbers.length()-1;
		ArrayList<Integer> negatives=new ArrayList<> ();
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
					 	int num=Integer.parseInt(numbers);
					 	if(num<0)
					 		throw new NegativeNumber(num);
					 	else if(num<=1000)
					 		result = result+num;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Number Format Exception Occured: Number is missing");
						return 0;
					}
				 	catch(NegativeNumber e)
				 	{
				 		negative=1;
				 		negatives.add(e.num);
				 	}
			 }
			 else
			 {
				String [] adders = numbers.split(delimits);
				for(int i=0;i<adders.length;i++)
				{
					try
					{
						int num=Integer.parseInt(adders[i]);
						if(num<0)
					 		throw new NegativeNumber(num);
						else if(num<=1000)
							result = result+num;
					}
					catch(NumberFormatException e)
					{
						System.out.println("Number Format Exception Occured: Number is missing");
						return 0;
					}
					catch(NegativeNumber e)
				 	{
						negative=1;
						negatives.add(e.num);
				 		
				 	}
				}
			 }
		}
		if(negative==0)
		{
			return result;
		}
		else
		{
			System.out.print("Negatives Not Allowed: ");
			for(int i=0;i<negatives.size();i++)
			{
				System.out.print(negatives.get(i)+" ");
			}
			return 0;
		}
		
	}
}