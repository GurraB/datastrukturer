package f7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Iterable<E> {
    private ListNode<E> list = null;

    /**
     * locates an element in the list
     * @param index what index of the requested element
     * @return the found element
     */
    private ListNode<E> locate(int index) {
        ListNode<E> node = list;
        for( int i = 0; i < index; i++)
            node = node.getNext();
        return node;
    }

    /**
     * gets the size of the list
     * @return size of the list
     */
    public int size() {
        int n = 0;
        ListNode<E> node = list;
        while( node != null ) {
            node = node.getNext();
            n++;
        }
        return n;
    }

    /**
     * gets an element from the list
     * @param index index of the element to return
     * @return the element at index
     */
    public E get( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        ListNode<E> node = locate( index );
        return node.getData();
    }

    /**
     * sets the element at index
     * @param index index of the element to replace
     * @param data what data to be placed at index
     * @return the removed data
     */
    public E set( int index, E data ) {
        if(index >= size() || index < 0)
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        ListNode<E> node = locate(index);
        E removedValue = node.getData();
        node.setData(data);
    	return removedValue;
    }

    /**
     * adds an element to the last position of the list
     * @param data the element
     */
	public void add(E data) {
        addLast(data);
	}

    /**
     * adds an element to the first position of the list
     * @param data the element
     */
    public void addFirst( E data ) {
        add(0, data);
    }

    /**
     * adds an element to the last position of the list
     * @param data the element
     */
    public void addLast( E data ) {
        add(size(), data);
    }

    /**
     * adds an element to the list
     * @param index index at which the specified element is to be inserted
     * @param data the element
     */
    public void add( int index, E data ) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        if(index == 0) {
            list = new ListNode<E>(data, list);
            return;
        }
        ListNode<E> node = locate(index - 1);
        node.setNext(new ListNode<E>(data, node.getNext()));
    }

    /**
     * removes the first element of the lsit
     * @return removed element
     */
    public E removeFirst() {
        E first = list.getData();
    	list = list.getNext();
        return first;
    }

    /**
     * removes the last element of the list
     * @return removed element
     */
    public E removeLast() {
        E last = locate(size() - 1).getData();
        locate(size() - 2).setNext(null);
    	return last;
    }

    /**
     * removes the element at index
     * @param index the index of the element to be removed
     * @return removed element
     */
    public E remove( int index ) {
        if( ( index < 0 ) || ( index >= size() ) )
            throw new IndexOutOfBoundsException( "size=" + size() + ", index=" + index );
        
        E res;
        if( index == 0 ) {
            res = list.getData();
            list = setNull(list);
        } else {
            ListNode<E> node = locate( index - 1 );
            res = node.getNext().getData();
            node.setNext(setNull(node.getNext()));
        }
        return res;
    }

    /**
     * sets the toNull to null
     * @param toNull the element to be set to null
     * @return the next element in the list
     */
    private ListNode<E> setNull(ListNode<E> toNull) {
    	ListNode<E> res = toNull.getNext();
    	toNull.setData(null);
    	toNull.setNext(null);
    	return res;
    }

    /**
     * clears the list
     */
	public void clear() {
        int n = size();
        for (int i = n; i < 0; i--) {
            locate(i).setNext(null);
        }
        list = null;
    }

    /**
     * finds the index of data
     * @param data the element to be found
     * @return position of the element, if it does not exits it will return -1
     */
	public int indexOf(E data) {
        return indexOf(0, data);
	}

    /**
     * finds the index of data starting from startIndex
     * @param startIndex the search starts at position startIndex in the list
     * @param data the element to be found
     * @return position of the element, if it does not exits it will return -1
     */
	public int indexOf(int startIndex, E data) {
        int n = size();
        for (int i = startIndex; i < n; i++) {
            if(data.equals(locate(i).getData()))
                return i;
        }
        return -1;
	}

    /**
     * creates a new iterator
     * @return an iterator
     */
	public Iterator<E> iterator() {
		return new Iter();
	}

    /**
     * returns a string format of the list
     * @return string format of the list
     */
    public String toString() {
    	if( list != null )
    		return list.toString();
    	else
    		return "[]";
    }

    /**
     * an iterator of the list
     */
    private class Iter implements Iterator<E> {

        int index = 0;

        /**
         * finds out if there is a next element
         * @return true if there is a next element, false if this is the last element
         */
    	public boolean hasNext() {
            return index < size();
    	}

        /**
         * gets the next element in the list
         * @return the next element in the list
         */
    	public E next() {
            if(index == size())
    		    throw new NoSuchElementException();
            return locate(index++).getData();
    	}

        /**
         * removes the element
         */
        @Deprecated
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
