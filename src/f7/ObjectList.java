package f7; 

public class ObjectList {
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
    
    public Object set( int index, Object data ) {
    	return null;
    }
    
    public void addFirst( Object data ) {
    }
    
    public void addLast( Object data ) {
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
    
    public Object removeFirst() {
    	return null;
    }
    
    public Object removeLast() {
    	return null;
    }
    
    public Object remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        Object res;
//        ObjectNode toNull; // help garbagecollection
        if( index == 0 ) {
            res = list.getData();
//            toNull = list;
            list = list.getNext();
        } else {
            ObjectNode node = locate( index - 1 );
            res = node.getNext().getData();
//            toNull = node.getNext();
            node.setNext( node.getNext().getNext() );
        }
//        toNull.setData(null);
//        toNull.setNext(null);
        return res;
    }
    
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }
}
