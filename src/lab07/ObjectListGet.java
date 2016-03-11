package lab07;
import f7.ObjectNode;

public class ObjectListGet {
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

    // Metod att ändra och komplettera
    public Object get( int index ) {
        int n = 0;
        ObjectNode node = list;
        while(node != null) {
            if(n == index)
                return node.getData();  //ska nog inte vara getData()
            n++;
            node = node.getNext();
        }
        throw new IndexOutOfBoundsException("size=" + size() + ", index=" + index);
    }
    
    public void add( int index, Object data ) {
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
    
    public Object remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        Object res;
        if( index == 0 ) {
            res = list.getData();
            list = list.getNext();
        } else {
        	ObjectNode node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext( node.getNext().getNext() );
        }
        return res;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
    
    public static void main(String[] args) {
        ObjectListGet list = new ObjectListGet();
        for( int i = 0; i < 5; i++)
            list.add(i,i);
        System.out.println(list);
        for( int i = -1; i <= list.size(); i += 1 ) {
        	try {
                System.out.println("Element " + i +" = " + list.get( i ) );
        	} catch(IndexOutOfBoundsException e) {
        		System.out.println(e);
        	}
        }
    }
}
