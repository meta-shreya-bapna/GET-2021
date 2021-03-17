import java.util.Scanner;

public class LinkedListLoop {    
	//Represent a node of the linked list    
    class Node{    
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    //Represent the head and tail of the linked list    
    public Node head = null;    
    public Node tail = null;    

    /*
	 * Add new node to the list
	 * @param data to insert in node
	 */    
        
    public void addNode(int data) {      
        Node newNode = new Node(data);    
            
        //Checks if the list is empty    
        if(head == null) {    
            
            head = newNode;    
            tail = newNode;    
        }    
        else {    
                
            tail.next = newNode;        
            tail = newNode;    
        }    
    }    
    
    /*
	 * For creating loop inside the Linkedlist
	 * @param list having linked list
	 */ 
    
    public static void createTryLoop(LinkedListLoop list){
    	list.tail.next=list.head.next;
    }
    
    /*
	 * Checking if Loop exists or not 
	 * @param data to insert in node
	 */ 
    
    public boolean ifLoopExists() {
        Node first = head;
        Node second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (second == first)
                return true;
 
        }
        return false;
    }
    
    /*
	 * Displays all the nodes present in the list
	 */ 
    
    public void display() {        
        Node current = head;    
            
        if(head == null) {    
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

    
    public static void main(String[] args) {    
        Scanner sc= new Scanner(System.in);    
        LinkedListLoop sList = new LinkedListLoop();    
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
        
        //to create loop in list for trial enable below function
        //createTryLoop(sList);
        System.out.println("Loop exist :"+sList.ifLoopExists());
        
        //Displays the nodes present in the list
        sList.display();
    }    
}    