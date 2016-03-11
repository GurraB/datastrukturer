package lab08;

import f7.LinkedList;
import f7.List;
import lab05.Stack;

/**
 * Created by Gustaf on 03/02/2016.
 */
public class LinkedStack<T> implements Stack<T> {

    List<T> stack = new LinkedList<T>();

    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public T pop() {
        return stack.removeLast();
    }

    @Override
    public T peek() {
        return stack.get(0);
    }

    @Override
    public boolean isEmpty() {
        if(stack.size() == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
