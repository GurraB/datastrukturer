package lab05;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Created by Gustaf on 27/01/2016.
 */
public class ArrayListStack<T> implements Stack<T> {

    private ArrayList<T> elements = new ArrayList<T>();

    @Override
    public void push(T element) {
        elements.add(element);
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return elements.remove(elements.size() - 1);
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return elements.get(elements.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
