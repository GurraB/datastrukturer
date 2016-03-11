package lab07;
import f7.LinkedList;
import java.util.Iterator;

public class Laboration7b {

    /****** UPPGIFT 5a ******/
    public void exercise5a() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 5; i++ )
            list.add( i, new Integer( i ) ); 
        for( int i = 5; i < 9; i++ )
            list.add( list.size(), new Integer( i ) ); 
        System.out.println( list );
    }
    
    /****** UPPGIFT 5b ******/
    public void exercise5b() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 3; i++ )
            list.add( new Integer( i ) ); 
        for( int i = 4; i < 7; i++ )
            list.addFirst( new Integer( i ) ); 
        for( int i = 8; i < 11; i++ )
            list.addLast( new Integer( i ) ); 
        System.out.println( list );
    }
    
    /****** UPPGIFT 5c ******/
    public void exercise5c() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 10; i++ )
            list.add( new Integer( i ) ); 
        System.out.println( "Borttagen: " + list.removeFirst() ); 
        System.out.println( "Borttagen: " + list.removeLast() ); 
        System.out.println( "Borttagen: " + list.removeFirst() ); 
        System.out.println( list );
    }
    
    /****** UPPGIFT 5d ******/
    public void exercise5d() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 8; i++ )
            list.add( new Integer( i ) ); 
        for(int i=0; i<=6; i+=3)
        	list.set( i, new Integer( i+10 ) );
        System.out.println( list );
    }
    
    /****** UPPGIFT 5e ******/
    public void exercise5e() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 10; i++ )
            list.add( new Integer( i ) ); 
        System.out.println( list );
        System.out.print( list.indexOf(3, new Integer(5)) );
        System.out.print( ", " + list.indexOf(3, new Integer(11)) );
        System.out.print( ", " + list.indexOf(3, new Integer(1)) );
        System.out.print( ", " + list.indexOf( new Integer(11)) );
        System.out.println( ", " + list.indexOf( new Integer(5)) );
    }
    
    /****** UPPGIFT 6a ******/
    public void exercise6a() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 10; i++ )
            list.add( new Integer( i ) ); 
        list.clear();
        System.out.println( list );
    }
    
    /****** UPPGIFT 6a ******/
    public void exercise6b() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for( int i = 0; i < 10; i++ )
            list.add( new Integer( i ) ); 
        System.out.println( list );
        Iterator<Integer> numbers = list.iterator();
        while(numbers.hasNext()) {
        	System.out.print(numbers.next() + " ");
        }
    }
    
    public static void main(String[] args) {
        Laboration7b lab7b = new Laboration7b();
        lab7b.exercise6b();
    }
}
