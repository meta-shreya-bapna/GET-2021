
class StackInfix implements Stack {

  private int arr[];
  private int top;
  // total capacity of the stack
  private int capacity;

 
  StackInfix(int size) {
    // initialize the stack variables
    this.arr = new int[size];
    this.capacity = size;
    this.top = -1;
  }

  	/**
	 * Method to add element to the top of stack
	 * @param data to add in stack
	 */
  @Override
  public void push(int x) {
    if (isFull()) {
      System.out.println("Stack OverFlow");

      // terminates the program
      System.exit(1);
    }
    arr[++top] = x;
  }

  	/**
	 * Method to delete element in top of stack
	 * @return top element
	 */
	@Override
  public char pop() {

    if (isEmpty()) {
      System.out.println("STACK EMPTY");
      System.exit(1);
    }
   
    return (char) arr[top--];
  }

	/**
	 * Method to get size of the stack
	 * @return size
	 */
	@Override
  public int getSize() {
    return top + 1;
  }

	/**
	 * Method to check if stack is empty or not
	 * @return boolean value
	 */
	@Override
  public boolean isEmpty() {
    return top == -1;
  }

	/**
	 * Method to check if queue is full or not
	 * @return boolean value
	 */
	@Override
  public boolean isFull() {
    return top == capacity - 1;
  }

	/**
	 * Method to display elements of stack
	 */
	@Override
  public void displayStack() {
    for (int i = 0; i <= top; i++) {
      System.out.print(arr[i] + ", ");
    }
	} 
   public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
        	System.out.println("Stack is empty");
            System.exit(1);
        }
 
        return -1;
    }
  }
	
