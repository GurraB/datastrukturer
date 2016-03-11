package f7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	private E[] elements;
	private int size;
	
	private void grow() {
		E[] temp = (E[])new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}
	
	public ArrayList() {
		this(20);
	}
	
	public ArrayList(int initialCapacity) {
		initialCapacity = Math.max(1, initialCapacity);
		elements = (E[])new Object[initialCapacity];
	}

	public void add(int index, E element) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		if(size==elements.length)
			grow();
		for(int i=size; i>index; i--) {
			elements[i]=elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	public void add(E element) {
		add(size,element);
	}

	public void addFirst(E element) {
		add(0, element);
	}

	public void addLast(E element) {
		add(element);
	}

	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		E removedObject = elements[index];
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		size--;
		return removedObject;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size);
	}

	public void clear() {
		E[] temp = (E[]) new Object[elements.length];
		elements = temp;
	}

	public E get(int index) {
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException();
		return elements[index];
	}

	public E set(int index, E element) {
		if(index > size || index < 0)
			throw new IndexOutOfBoundsException();
		elements[index] = element;
		return null;
	}

	public int indexOf(E element) {
		for (int i = 0; i < elements.length; i++) {
			if(element.equals(elements[i]))
				return i;
		}
		return -1;
	}

	public int indexOf(int startIndex, E element) {
		if(startIndex > size || startIndex < 0)
			throw new IndexOutOfBoundsException();

		for (int i = startIndex; i < elements.length; i++) {
			if(element.equals(elements[i]))
				return i;
		}
		return -1;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder res = new StringBuilder("[ ");
		for(int i=0; i<size; i++) {
			res.append(elements[i]);
			if(i<size-1)
				res.append("; ");
		}
		res.append(" ]");
		return res.toString();
	}

	public Iterator<E> iterator() {
		return new Iter();
//		return new Iterator<E>() {
//			private int index=0;
//			
//			public boolean hasNext() {
//				return index<size;
//			}
//			
//			public E next() {
//				if(index==size)
//					throw new NoSuchElementException();
//				return elements[index++];
//			}
//			
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
	}
	
	private class Iter implements Iterator<E> {
		private int index=0;
		
		public boolean hasNext() {
			return index<size;
		}
		
		public E next() {
			if(index==size)
				throw new NoSuchElementException();
			return elements[index++];
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		for(int i=10; i<100; i+=10) {
			list.add(i);
		}
		System.out.println(list);
		Iterator<Integer> numbers = list.iterator();
		while(numbers.hasNext())
			System.out.print(numbers.next()+ " ");
	}
}
