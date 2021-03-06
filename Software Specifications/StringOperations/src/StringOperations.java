import java.util.Scanner;
public class StringOperations {
	
	/*
	 * Comparing 2 strings
	 * @param string1: first input string
	 * @param string2: second input string
	 * @return 1 if equal and 0 if not equal
	 */
	public static int compareStrings(String string1,String string2)
	{
		if(string1.length() !=string2.length())
		{
			return 0;
		}
		int i=0;
		while(i<string1.length())
		{
			if(string1.charAt(i)!=string2.charAt(i))
			{
				return 0;
			}
			i++;
		}
		return 1;
		
	}
	
	/*
	 * Reversing a String
	 * @param str String Input
	 * @return Reversed string
	 */
	public static String reverse(String str)
	{
		int i;
		String result="";
		int length=str.length();
		for(i=length-1;i>=0;i--)
		{
			result=result+str.charAt(i);
		}
		return result;
	}
	
	/*
	 * Converting a string from lowercase to uppercase or vice-a-versa
	 * @param str String Input
	 * @return Converted String
	 */
	public static String conversion(String str)
	{
		int i=0;
		String result="";
		while(i<str.length())
		{
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
			{
				result+=(char)(str.charAt(i)+32);
			}
			else
			{
				result+=(char)(str.charAt(i)-32);
			}
			i++;
		}
		return result;
		
	}
	
	/*
	 * Finding Largest Word in a String
	 * @param str String Input
	 * @return Longest Word in the String
	 */
	public static String longestWord(String str)
	{
		
		String[] word=str.split(" ");
		String longestWord=" ";
		for(int i=0;i<word.length;i++)
		{
			if(word[i].length()>=longestWord.length())
			{
				longestWord=word[i];
			}
		}
		return longestWord;
		
	}
	public static void main(String[] args)
	{
		int choice;
		boolean flag=true;
		Scanner sc= new Scanner(System.in);
		
		while(flag)
		{
			System.out.println("Enter your choice:\n"+"1.Compare 2 strings\n"+"2.Reverse of a string\n"+"3.Conversion of case\n"+"4.Find largest word of string\n"+"5.Exit");
			choice=sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter 2 strings to compare");
				String string1=sc.next();
				String string2=sc.next();
				int result=compareStrings(string1,string2);
				
				if(result==1)
					System.out.println("Strings are equal\n");
				else
					System.out.println("Strings are not equal\n");
				break;
				
			case 2:
				System.out.println("Enter string to reverse it");
				String str=sc.next();
				System.out.println("Reversed string of "+str+" is "+reverse(str)+"\n");
				break;
			
			case 3:
				System.out.println("Enter string to convert it");
				String string3=sc.next();
				System.out.println("String "+string3+" after conversion is "+conversion(string3)+"\n");
				break;
				
			case 4:
				System.out.println("Enter string to convert it");
				String string=sc.nextLine();
				System.out.println("Longest word is: "+longestWord(string)+"\n");
				break;
				
			case 5:
				flag=false;
				break;
				
			default:
				System.out.println("Invalid input! Try again");
			}
		}
		sc.close();
	}
}
