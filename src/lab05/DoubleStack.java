package lab05;

import java.util.EmptyStackException;

/**
 * Created by Gustaf on 27/01/2016.
 */
public class DoubleStack implements DStack {

    Double[] d;
    int size = 0;

    public DoubleStack(int capacity) {
        d = new Double[capacity];
    }

    @Override
    public void push(Double element) {
        if(size >= d.length)
            throw new StackOverflowError();
        d[size++] = element;
    }

    @Override
    public Double pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return d[--size];
    }

    @Override
    public Double peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return d[size - 1];
    }

    @Override
    public boolean isEmpty() {
        if(size > 0)
            return false;
        else
            return true;
    }

    @Override
    public int size() {
        return size;
    }
}
