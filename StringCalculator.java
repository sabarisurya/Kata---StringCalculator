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
	
	List<String>  delimiterslist = new ArrayList<>();
	String Default_Delimiter = ",";
	String New_Line = "\n";
	
	public static void main (String args[])
	{
		String numbers = "//[]\n1";
		StringCalculator obj =new StringCalculator();	
		int res =obj.add(numbers);
		System.out.print(res);
	}
	
	/**
	 
	 String changeDelimiters(String numbers)-
	 
	 This function changes all the delimiters specified in the input with the 
	 Default_Delimiter "," and returns the changed string
	 
	 **/
	 
	String changeDelimiters(String numbers) 
	{
		while(!delimiterslist.isEmpty())
		{
			String delimiter = delimiterslist.get(0);		
			if(numbers.contains(delimiter))
			{
					while(numbers.contains(delimiter))
					{
					numbers=numbers.replace(delimiter,",");
					}
					delimiterslist.remove(delimiter);	
					numbers = changeDelimiters(numbers);
			}
			else
			{
				delimiterslist.remove(delimiter);
			}
		}
		return numbers;
		
	}
	
	
	/**
	 
	 public String delimiters(String numbers)
	 
	 This function splits the delimiters(if present) and the actual input string to be added 
	 from the given input.
	 And Stores the delimiters in the list created as a instance variable
	 **/
	 
	
	public String delimiters(String numbers)
	{
		delimiterslist.clear();
		int len = numbers.length()-1;
		int i=0,found=0;
		while(i<=len)
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
				if(member=='[')
				{
					i=i+1;
					int j=i;
					String addlist = null;
					while(numbers.charAt(j)!=']')
					{
						char ch=numbers.charAt(j);
						if(addlist!=null)
						{
						addlist=addlist+ch;	
						}
						else
						{
							addlist=String.valueOf(ch);
						}
						j++;
					}
					j=j+1;
					i=j;
					if(addlist!=null)
					{
						delimiterslist.add(addlist);
					}
				}
				else if(member!='\n')
				{
					delimiterslist.add(String.valueOf(member));
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
	
	
	/**
	 
	 public int add(String numbers) 
	 
	 Actual procedure:
	 1. Splits the String to be added and the delimiters using delimiters(String) function.
	 2. Changes the custom delimiters in the string to default delimiters.
	 3. Adds the values and stores in result.
	 4. If there are negative numbers or invalid input exception in thrown respectively.
	 6. And the negative numbers are printed.
	 
	 **/
	
	public int add(String numbers) 
	{
		numbers=delimiters(numbers);
		numbers=changeDelimiters(numbers);
		String delimits=new String("");
		delimits="["+New_Line+Default_Delimiter+"]"+"+";
		int result=0,negative=0;
		int len= numbers.length()-1;
		ArrayList<Integer> negatives=new ArrayList<> ();
		if(len>=0)
		{
			
			if(numbers.startsWith(New_Line)||numbers.endsWith(New_Line)||numbers.startsWith(Default_Delimiter)||numbers.endsWith(Default_Delimiter))
			{
				System.out.println("Number Format Exception Occured: Invalid Input");
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
						System.out.println("Number Format Exception Occured: Invalid Input");
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
						System.out.println("Number Format Exception Occured: Invalid Input");
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
			System.out.println("Negatives Not Allowed: ");
			for(int i=0;i<negatives.size();i++)
			{
				System.out.println(negatives.get(i)+" ");
			}
			return 0;
		}
		
	}
}