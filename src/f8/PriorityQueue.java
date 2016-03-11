package f8;
import java.util.*;

public class PriorityQueue<E> implements Queue<E> {
    private Node<E> list = null;
    private Comparator<E> comparator;
    private int size = 0;
    
    public PriorityQueue() {
    	this.comparator = new Comp();
    }
    
    public PriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void enqueue( E data ) {
        if(list==null || comparator.compare(data,list.data)<0) {
            list = new Node<E>(data,list);
        } else {
            Node<E> node = list;
            while(node.next!=null && comparator.compare(data,node.next.data)>=0) {
                node = node.next;
            }
            node.next = new Node<E>(data,node.next);
        }
        size++;
    }
    
    public E dequeue() {
        if( isEmpty() ) {
            throw new QueueException("dequeue: No elements in queue");
        }
        E data = list.data;
        list = list.next;
        size--;
        return data;
    }
    
    public E peek() {
        if( isEmpty() ) {
            throw new QueueException("peek: No elements in queue");
        }
        return list.data;
    }
    
    private class Node<E> {
        E data;
        Node<E> next;
        
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    private class Comp implements Comparator<E> {
		public int compare(E e1, E e2) {
			return ((Comparable<E>)e1).compareTo(e2);
		}    	
    }
}
