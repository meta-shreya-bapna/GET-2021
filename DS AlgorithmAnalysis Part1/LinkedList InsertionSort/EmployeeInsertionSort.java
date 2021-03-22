class EmployeeNode{
	EmployeeNode next;
	EmployeeMain details;
	EmployeeNode(EmployeeMain det){
		next = null;
		details = det;
	}
}

public class EmployeeInsertionSort {
	EmployeeNode head;
	EmployeeNode sortedHead;
	EmployeeInsertionSort(){
		head = null;
		this.addEmployee(new EmployeeMain(1,"Shreya",10000,20));
		this.addEmployee(new EmployeeMain(2,"Kavya",20000,25));
		this.addEmployee(new EmployeeMain(3,"Ayush",100000,26));
		this.addEmployee(new EmployeeMain(4,"Muskan",10000,27));
	}
	
	/**
	 * Method adds new Employee in LinkedList
	 * @param newEmp
	 */
	void addEmployee(EmployeeMain newEmp){
		if(head == null){
			head = new EmployeeNode(newEmp);
		}
		else{
			EmployeeNode temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new EmployeeNode(newEmp);
		}
	}
	
	/**
	 * Method prints Employee LinkedList details before sorting
	 */
	void printList(){
		EmployeeNode temp = head;
		while(temp != null){
			System.out.println(temp.details.empId + "\t"+temp.details.empName+"\t "+temp.details.empSalary + "\t "+temp.details.empAge);
			temp = temp.next;
		}
		System.out.println("\n");
	}
	
	/**
	 * Method prints Employee LinkedList details after sorting
	 */
	void printSortedList(){
		EmployeeNode temp = sortedHead;
		System.out.println("Id\tName\tSalary\tAge");
		while(temp != null){
			System.out.println(temp.details.empId + "\t"+temp.details.empName+"\t "+temp.details.empSalary + "\t "+temp.details.empAge);
			temp = temp.next;
		}
		System.out.println("\n");
	}
	
	/**
	 * Sorts the Employee LinkedList acc. to decreasing order of salary and in case salaries of 2 employees are
	 * equal then it sorts on ascending basis of age
	 */
	public void sort()  
    {  
        sortedHead = null; 
        EmployeeNode current = head; 
        
        // Traversing the given linked list and inserting every node to sorted in sorted manner 
        while (current != null)  
        { 
            // Storing next for next iteration 
        	EmployeeNode next = current.next;
        	
            // inserts current in sorted linked list 
            sortedInsert(current);
             
            current = next; 
        } 
        head = sortedHead; 
    }

	/**
	 * Helper method which sorts the list
	 * @param newNode: node to insert in sorted list in right place
	 */
	private void sortedInsert(EmployeeNode newNode) {
		
		 // Special case for the head end (inserts at the beginning)
	    if (sortedHead == null || sortedHead.details.empSalary < newNode.details.empSalary)  
	    { 
	        newNode.next = sortedHead; 
	        sortedHead = newNode; 
	    } 
	    else 
	    { 
	    	EmployeeNode current = sortedHead; 
	    	
	        // Locates the node before the point of insertion 
	        while (current.next != null && (current.next.details.empSalary > newNode.details.empSalary || 
	        		(current.next.details.empSalary == newNode.details.empSalary  && newNode.details.empAge > current.next.details.empAge )))  
	        { 
	            current = current.next; 
	        } 
	        newNode.next = current.next; 
	        current.next = newNode; 
	    } 
		
	} 
	public static void main(String[] args)
    {
		EmployeeInsertionSort emp = new EmployeeInsertionSort();
		System.out.println("List before sorting");
		emp.printList();
		emp.sort();
		System.out.println("List after sorting");
		emp.printSortedList();
    }
}