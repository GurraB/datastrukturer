package collections;

/**
 * A node in the LinkedList
 * @param <E> type of object
 */
public class ListNode<E> {
    private E data;
    private ListNode<E> next;

    /**
     * constructor
     * @param data data in element
     * @param next next element in the list
     */
    public ListNode( E data, ListNode<E> next ) {
        this.data = data;
        this.next = next;
    }

    /**
     * returns the data in this node
     * @return data in this node
     */
    public E getData() {
        return this.data;
    }


    /**
     * sets the data in this node
     * @param data data to be set
     */
    public void setData( E data ) {
        this.data = data;
    }

    /**
     * returns the next node in the list
     * @return the next node
     */
    public ListNode<E> getNext() {
        return this.next;
    }

    /**
     * sets the next node in the list
     * @param next the next node
     */
    public void setNext( ListNode<E> next ) {
        this.next = next;
    }


    /**
     * returns a string format of the node
     * @return a string format of the node
     */
    public String toString() {
    	StringBuilder str = new StringBuilder("[ ");
    	str.append(data.toString());
    	ListNode<E> node = next;
        while( node!=null ) {
        	str.append( "; ");
            str.append( node.getData().toString() );
            node = node.getNext();
        }
        str.append( " ]");
        return str.toString();
    }
}