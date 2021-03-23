import java.util.Scanner;

class Task {
	public int job;
	public int priority;

	public Task(int job, int priority) {
		this.job = job;
		this.priority = priority;
	}
}

public class PriorityQueue implements Priority {

	public Task task[];
	public int cap;
	public int size;

	public PriorityQueue(int cap) {
		this.cap = cap;
		task = new Task[this.cap];
		this.size = 0;
	}

	/*----------getter------------*/
	public Task[] getTask() {
		return this.task;
	}
	
	/**
	 * To check if queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/*
	 * To check if queue is full
	 */
	@Override
	public boolean isFull() {
		return this.size == this.cap;
	}

	/*
	 * Adding Element to Queue
	 * @param val to be added in Queue
	 * @param priority of task
	 */

	@Override
	public void enqueue(int val, int priority) {
		if (isFull()) {
			System.out.println("Queue is Full");
			System.exit(1);
		}

		Task newJob = new Task(val, priority);
		boolean flag = false;
		for (int i = 0; i < this.size; i++) {
			if (this.task[i].priority < priority) {
				int move = size;
				while (i <= move) {
					this.task[move + 1] = this.task[move];
					move--;
				}
				task[i] = newJob;
				size++;
				flag = true;
				break;
			}
		}
		if (!flag) {
			task[size++] = newJob;
		}
	}

	/*
	 * Method to remove an Element from Queue
	 */

	@Override
	public int dequeue() {
		if (isEmpty()) {
			throw new AssertionError("Empty Queue");
			}
		
		int data = task[0].job;
		for (int i = 1; i < this.size; i++) {
			task[i - 1] = task[i];
			size--;
		}
		return data;
	}

	/*
	 * Method to get Highest priority element of Queue
	 * @return data of highest priority element
	 */

	@Override
	public int peek() {
		if (isEmpty()) {
			throw new AssertionError("Empty List");
		}

		int highestPriority = task[0].priority;
		int index = 0;

		// Check for the element with highest priority
		for (int i = 1; i <this.size; i++) {
			if (highestPriority < task[i].priority) {
				highestPriority = task[i].priority;
				index = i;
			}
		}
		return task[index].job;
	}

	//main method
	public static void main(String[] args) 
	{ 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of queue ");
	    PriorityQueue q = new PriorityQueue(sc.nextInt()); 
	    boolean flag=true;
	    while(flag)
	    {
	    System.out.println("\nEnter your choice\n"+"1: Enqueue\n"+"2: Dequeue\n"+"3: IsEmpty\n"+"4: IsFull\n"+"5: Peek\n"+ "6: displayQueue\n"+"7: Exit");  
	    int choice=sc.nextInt();
		    
	    switch(choice)
		   {
		   case 1:
			   if(q.isFull())
		    	{
		    		System.out.println("More items can't be inserted");
		    	}
		    	else
		    	{
				System.out.println("Enter data along with its priority to insert:");
				q.enqueue(sc.nextInt(),sc.nextInt());
		    	}
				break;
		
			case 2:
				int x = q.dequeue(); 
			    // Checking for empty queue. 
			    if(x != -1) 
			    { 
			        System.out.print("Deleted value = "); 
			        System.out.println(x); 
			    }
				break;
		
			case 3:
				if(q.isEmpty())
				{
					System.out.println("queue is empty");
				}
				else
					System.out.println("Queue is not empty");
				break;
		
			case 4:
				if(q.isFull())
				{
					System.out.println("queue is full");
				}
				else
					System.out.println("Queue is not full");
				break;
				
			case 5:
				System.out.println("Highest priority data: "+ q.peek());
				break;
				
			case 6:
				if(q.isEmpty())
				{
					System.out.println("queue is empty");
				}
				else{
					System.out.println("Queue acc. to its priority is ");
					Task task[]=q.getTask();
					//int arr[]=new int[]{6, 4, 3, 2};
					System.out.println("Priority data");
					for(int i=0;i<q.size;i++)
					{
						System.out.println(task[i].priority+"\t"+task[i].job);
					}
				}
				break;
				
			case 7:
				flag=false;
				break;
				
			default:
				System.out.println("Invalid input! Try again");
		    }
		    }

		} 
}

