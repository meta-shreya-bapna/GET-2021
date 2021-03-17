import java.util.Scanner;

public class polynomialDegree {
	
	//node as main linked list
	public class Node 
	{
		int coeff;
		char sign;
		Noded down;
		Node next;
		Node(int c,char s)
		{
			coeff=c;
			sign =s;
			//next=null;
			//down=null;
		}
	}

	//node for down nested linked list
	public class Noded 
	{
		char var;
		int exp;
		Noded next;
		Noded(char c, int e)
		{
			var=c;
			exp=e;
		
		}
	}
	
	/**
	 * Main method: taking no. of terms in the multiVarient polynomial and coefficient of each term along with 
	 * it's sign(+/-) along with no. of variables in that term
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		polynomialDegree list=new polynomialDegree();
		System.out.println("Enter no of terms");
		int N =sc.nextInt();
		while(N>0)
		{ System.out.println("enter coefficient ,it's sign, no of variable terms with that coefficient");
		 list.addTerm(sc.nextInt(),sc.next().charAt(0),sc.nextInt());
		 N--;
			
		}
		list.printDegree();
	}


	Node head=null;
	Noded downHead=null;

	/**
	 * Method adds term to the multivariate polynomial , and also calls method addVar which stores variables and
	 * exponents associated with the variable in a nested down linked list 
	 * @param coeff: coefficient
	 * @param c: sign
	 * @param term: no. of variable terms
	 */
	public void addTerm(int coeff,char c,int term)
	{
		Scanner sc=new Scanner(System.in);
		Node temp=new Node(coeff,c);
		temp.next=null;
		
		if(head==null)
		{temp.next=null;
			head=temp;
		}
		else{
			temp.next=head;
			head=temp;
		
		}
		downHead=null;
		
		while(term>0)
		{
			System.out.println("enter variable and then exponent");
			head.down=addVar(sc.next().charAt(0) ,sc.nextInt());
			term--;
		}
	}
	
	/**
	 * Method adds variables and their exponents in the nested linked list .
	 * @param coefficient
	 * @param exponent
	 * @return
	 */
	public Noded addVar(char coefficient, int exponent) {
		Noded temp = new Noded(coefficient, exponent);
		if (downHead == null)
		{
			temp.next = null;
			downHead = temp;
		} 
		else 
		{
			temp.next = downHead;
			downHead = temp;
		}
		return downHead;

	}

	/**
	 * Method is used to print the multivariate polynomial and it's degree
	 */
	public void printDegree() {
		Node curr = head;
		int deg = -1;
		while (curr != null) {
			int temp = 0;
			System.out.print(curr.sign);
			System.out.print(curr.coeff);
			Noded currs = curr.down;

			while (currs != null) {
				System.out.print(currs.var);
				System.out.print("^" + currs.exp);

				temp += currs.exp;
				currs = currs.next;
			}
			if (deg < temp) {
				deg = temp;
			}
			curr = curr.next;
		}
		System.out.println(" ");
		System.out.println("highest degree in this multivariate polynomial is "
				+ deg);
	}

}