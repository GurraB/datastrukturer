package f8;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(12);
        
        for( int i = 10; i < 20; i++ )
            queue.enqueue( i );
        for(int i=5; i<10; i++) {
            System.out.println(queue.dequeue());
        }
        for(int i=0; i<5; i++) {
            queue.enqueue(i);
        }
        System.out.println( "Size = " + queue.size() );
        System.out.println( "Första element = " + queue.peek() );
        while( !queue.isEmpty() )
            System.out.println( "Element = " + queue.dequeue() +", size = " + queue.size() );
    }
}
