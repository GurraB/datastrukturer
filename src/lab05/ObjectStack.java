package lab05;
import java.util.EmptyStackException;

public class ObjectStack implements Stack2 {
    private Object[] elements;
    private int size=0;
    
    public ObjectStack(int capacity) {
        elements = new Object[capacity];
    }

    public void push(Object element) {
    	if(size>=elements.length)
    		throw new StackOverflowError();
        elements[ size ] = element;
        size++;
    }

    public Object pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        Object o = elements[--size];
        elements[size] = null;
        return o;
    }

    public Object peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size-1];
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ObjectStack stack = new ObjectStack(5);
        Integer elem;
        for(int i=30; i<33; i++) {
            stack.push(new Integer(i));
        }
        while(!stack.isEmpty()) {
            elem = (Integer)stack.pop();
            System.out.print(elem + " ");
        }
        
        System.out.println("\n----------------------------");
        for( int i = 50; i < 55; i++ )
            stack.push( new Integer( i ) );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.isEmpty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );
    }
}
