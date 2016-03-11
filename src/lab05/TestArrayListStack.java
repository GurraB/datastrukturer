package lab05;

public class TestArrayListStack {
    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
        
        for( int i = 10; i < 20; i++ )
            stack.push( i );
        System.out.println( "Size = " + stack.size() );
        System.out.println( "Första element = " + stack.peek() );
        while( !stack.isEmpty() )
            System.out.println( "Element = " + stack.pop() +", size = " + stack.size() );
    }
}