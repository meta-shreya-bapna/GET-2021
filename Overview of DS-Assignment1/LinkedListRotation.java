import java.util.Scanner;

public class LinkedListRotation {    
	
	//Represent a node of the linked list    
    class Node{    
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    //Represent the start and tail of the linked list    
    public static Node start = null;    
    public Node tail = null;    

    /**
	 * Add new node to the list
	 * @param data to insert in node
	 */    
    public void addNode(int data) {      
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(start == null) {    
            
            start = newNode;    
            tail = newNode;    
        }    
        else {    
                
            tail.next = newNode;        
            tail = newNode;    
        }    
    }    

    /**
	 * Displays all the nodes present in the list
	 */     
    public void display() {        
        Node current = start;    
            
        if(start == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of linked list: "); 
        
        while(current != null) {        
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }    

    /**
     * Rotates sublist from L to R positions to n numbers in clockwise direction
     * @param leftIndex : left index of sublist
     * @param rightIndex : right index of sublist
     * @param n : no. of times to rotate the sublist
     */
    public static void rotateSubList(int leftIndex,int rightIndex,int n)
	{
		int size = rightIndex-leftIndex+1;
		if(n>size){
			n=n%size;
		}
		if(n==0 || n==size){
			Node temp = start;                
			while(temp!=null){
				System.out.println(temp.data);
				temp = temp.next;
			}
			return;
		}
		
		Node link = null;
		if(leftIndex==1){
			link =start;
		}
		Node currentNode = start;
		int count = 0;
		Node end = null;
		Node previous = null;
		while(currentNode!=null){
			count++;
			if(count==leftIndex-1){
				previous = currentNode;
				link=currentNode.next;
			}
			
			if(count==rightIndex-n){
				if(leftIndex==1){
					end = currentNode;
					start = currentNode.next;
				}
				else{
					end = currentNode;
					previous.next=currentNode.next;
				}
			}
			
			if(count==rightIndex){
				Node d = currentNode.next;
				currentNode.next = link;
				end.next = d;
				Node temp = start;
				while(temp!=null){
					System.out.print(temp.data +" -> ");
					temp = temp.next;
				}
				return;
			}
			currentNode = currentNode.next;
		}
	}   
    
    //main method
    public static void main(String[] args) {    
        Scanner sc= new Scanner(System.in);    
        LinkedListRotation sList = new LinkedListRotation();    
        System.out.println("How many nodes you want to enter ");
        int num=sc.nextInt();
        int data;
        
        //Add nodes to the list 
        for(int i=0;i<num;i++)
        {
        	System.out.println("Enter "+(i+1)+" node value");
        	data= sc.nextInt();
        	sList.addNode(data);
        }
        int R;int L;
        System.out.println("Enter the left L and right R positions for creating sublist from 0 to "+num);
        L=sc.nextInt();
        R=sc.nextInt();
        System.out.println("Enter no. to rotate linked list in clockwise direction");
        int number=sc.nextInt();
        rotateSubList(L,R, number);
        sc.close();
    }
	 
}    