
public interface Queue {
	//an interface for circular queue
	void Enqueue(int data);
	int deQueue();
	boolean isEmpty();
	boolean isFull();
	void displayQueue();
}
