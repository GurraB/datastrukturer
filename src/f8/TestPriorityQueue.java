package f8;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Person> queue1 = new PriorityQueue<Person>();
        PriorityQueue<Person> queue2 = new PriorityQueue<Person>(new Wealth());
        PriorityQueue<Person> queue3 = new PriorityQueue<Person>(new Age());
        Person[] list = {new Person("A",20,100), new Person("C",28,200), 
                         new Person("E",24,50), new Person("B",28,50),
                         new Person("D",28,100),new Person("F",24,100)};
        
        for( Person p : list )
            queue1.enqueue( p );
        System.out.println( "Size = " + queue1.size() );
        System.out.println( "Första element: " + queue1.peek() );
        while( !queue1.isEmpty() )
            System.out.println( "Element: " + queue1.dequeue() +", size = " + queue1.size() );
        System.out.println("------------------------------------------");
        for( Person p : list )
            queue2.enqueue( p );
        System.out.println( "Size = " + queue2.size() );
        System.out.println( "Första element: " + queue2.peek() );
        while( !queue2.isEmpty() )
            System.out.println( "Element: " + queue2.dequeue() +", size = " + queue2.size() );
        System.out.println("------------------------------------------");
        for( Person p : list )
            queue3.enqueue( p );
        System.out.println( "Size = " + queue3.size() );
        System.out.println( "Första element: " + queue3.peek() );
        while( !queue3.isEmpty() )
            System.out.println( "Element: " + queue3.dequeue() +", size = " + queue3.size() );

    }
}
