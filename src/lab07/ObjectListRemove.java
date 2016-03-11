package lab07;
import f7.ObjectNode;

public class ObjectListRemove {
    private ObjectNode list = null;
    
    private ObjectNode locate(int index) {
    	ObjectNode node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }  
    
    public int size() {
        int n = 0;
        ObjectNode node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }

    public Object get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ObjectNode node = locate( index );
        return node.getData();
    }
    
    public void add( int index, int data ) {
        if( ( index < 0 ) || ( index > size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        if( index == 0 )
            list = new ObjectNode( data, list );
        else {
        	ObjectNode node = locate( index - 1 );
        	ObjectNode newNode = new ObjectNode( data, node.getNext() );
            node.setNext( newNode );
        }
    }
    
    // Metod att ändra och komplettera
    public Object remove( int index ) {
        Object removed = null;
        if(index == 0) {
            removed = list.getData();
            list = list.getNext();
            return removed;
        }
        int n = 0;
        ObjectNode node = list;
        while (node != null) {
            if(n == index - 1) {
                removed = node.getNext().getData();
                node.setNext(node.getNext().getNext());
                return removed;
            }
            node = node.getNext();
            n++;
        }
        return null;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }

    public static void main(String[] args) {
        ObjectListRemove list = new ObjectListRemove();
        for( int i = 0; i < 10; i++)
            list.add(i,i);
        System.out.println(list);
        
        for( int i = 4; i >= 0; i-- )
            System.out.println( list.remove( i ) );
        System.out.println(list);
    }
}
