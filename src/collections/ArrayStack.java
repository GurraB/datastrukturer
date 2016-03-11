package collections;
import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

/**
 * creates a stack
 * @param <T> type of object
 */

public class ArrayStack<T> implements Stack<T> {
    private T[] elements;
    private int size=0;

    /**
     * constructor
     * @param capacity size of stack
     */
    public ArrayStack(int capacity) {
        elements = (T[])(new Object[capacity]);
    }

    /**
     * puts an element at the top of the stack
     * @param element element to put on stacken
     */
    public void push(T element) {
    	if(size>=elements.length)
    		throw new BufferOverflowException();
        elements[ size ] = element;
        size++;
    }

    /**
     * returns the last element on the stack and removes it
     * @return removed element
     */
    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * looks at the element at the top of the stack without removing it
     * @return the element at the top of the stack
     */
    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    /**
     * checks if the stack is empty
     * @return true if empty, false if there is elements
     */
    public boolean isEmpty() {
        return (size==0);
    }

    /**
     * returns the size of the stack
     * @return the size of the stack
     */
    public int size() {
        return size;
    }
}
