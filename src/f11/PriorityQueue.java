package f11;
import java.util.Comparator;
import f8.Queue;

public class PriorityQueue<E> implements Queue<E>{
	private ArrayHeap<PriorityQueueElement<E>> heap;
	
	public PriorityQueue() {
		this(20);
	}
	
	public PriorityQueue(int initialCapacity) {
		heap = new ArrayHeap<PriorityQueueElement<E>>(initialCapacity);
	}
	
	public PriorityQueue(int initialCapacity, Comparator<E> comparator) {
		heap = new ArrayHeap<PriorityQueueElement<E>>(initialCapacity, new PriorityQueueComparator<E>(comparator));
	}

	// Lägg till ett PriorityQueueElement i heapen
	public void enqueue(E data) {

	}

	// Returnera elementet som lagras i PriorityQueueElement-objektet. Anropa delete-metoden i ArrayHeap.
	public E dequeue() {
	    return null;
	}

	// Returnera elementet som lagras i PriorityQueueElement-objektet. Anropa peek-metoden i ArrayHeap.
	public E peek() {
	    return null;
	}

	public boolean isEmpty() {
	    return false;
	}

	public int size() {
	    return 0;
	}	
}

class PriorityQueueElement<E> implements Comparable<PriorityQueueElement<E>> {
    private static int nextOrder=1;
    private E element;
    private int order;
    
    public PriorityQueueElement(E element) {
        this.element = element;
        this.order = nextOrder++;
    }
    
    public E getElement() {
        return element;
    }
    
    public int getOrder() {
        return order;
    }
    
    public int compareTo(PriorityQueueElement<E> pqElement) {
        int res = ((Comparable<E>)element).compareTo(pqElement.element);
        if(res==0)
            res = order - pqElement.order;
        return res;
    }
}
class PriorityQueueComparator<E> implements Comparator<PriorityQueueElement<E>> {
	private Comparator<E> comp;
	
	public PriorityQueueComparator(Comparator<E> comparator) {
		comp = comparator;
	}
	
	public int compare(PriorityQueueElement<E> pqElement1, PriorityQueueElement<E> pqElement2) {
		int res = comp.compare(pqElement1.getElement(), pqElement2.getElement());
		if(res==0)
			res = pqElement1.getOrder() - pqElement2.getOrder();
		return res;
	}
}
