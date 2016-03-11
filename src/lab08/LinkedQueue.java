package lab08;

import f7.LinkedList;
import f8.*;

/**
 * Created by Gustaf on 05/02/2016.
 */
public class LinkedQueue<E> implements Queue<E> {

    LinkedList<E> stack = new LinkedList<E>();


    @Override
    public void enqueue(E data) {
        stack.addLast(data);
    }

    @Override
    public E dequeue() {
        return stack.removeFirst();
    }

    @Override
    public E peek() {
        return stack.get(0);
    }

    @Override
    public boolean isEmpty() {
        if(stack.size() <= 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
