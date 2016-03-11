package lab13;
import java.util.Iterator;
import f13.Map;
import collections.LinkedList;
import collections.ArrayList;

/**
 * Hashtabellen använder öppen hashing
 * @author Rolf Axelsson
 */
public class HashtableOH<K,V> implements Map<K,V> { 
    private LinkedList<Entry<K,V>>[] table;
    private int size;
    
    /** Creates a new instance of HashtableOH */
    public HashtableOH( int size ) {
        table = (LinkedList<Entry<K,V>>[])new LinkedList[ size ];
        for( int i = 0; i < size; i++ ) {
            table[ i ] = new LinkedList<Entry<K,V>>();
        }
    }
    
    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        return ( hashCode < 0 ) ? -hashCode : hashCode;
    }
    
    public V put( K key, V value ) {
    	V res = null;
        int hashIndex = hashIndex( key );
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
            table[ hashIndex ].addFirst( entry );
            size++;
        }
        else {
        	res = table[ hashIndex ].set( index, entry ).value;
        }
        return res;
    }
    
    public void list() {
        Entry<K,V> entry;
        for(int i=0; i<table.length; i++) {
            System.out.print( i + ":");
            for( int j = 0; j < table[ i ].size(); j++ ) {
                entry = table[ i ].get( j );
                System.out.print(" <" + entry.key +"," + entry.value + ">" );
            }
            System.out.println();
        }
    }

	public V get(K key) {
        Entry<K, V> value;
        Iterator<Entry<K,V>> it = table[hashIndex(key)].iterator();
        while (it.hasNext()) {
            if(key.equals((value = it.next()).key))
                return value.value;
        }
		return null;
	}

	public V remove(K key) {
        int counter = 0;
        Iterator<Entry<K,V>> it = table[hashIndex(key)].iterator();
        while (it.hasNext()) {
            if(key.equals(it.next().key)) {
                size--;
                return table[hashIndex(key)].remove(counter).value;
            }
            counter++;
        }
		return null;
	}

	public int size() {
        return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(K key) {
		return get(key) != null;
	}

	public void clear() {
        for (LinkedList<Entry<K, V>> entries : table)
            entries.clear();
	}

	public Iterator<K> keys() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Entry<K, V>> entries : table) {
            for (Entry<K, V> entry : entries) {
                keys.add(entry.key);
            }
        }
        return keys.iterator();
	}

	public Iterator<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (LinkedList<Entry<K, V>> entries : table) {
            for (Entry<K, V> entry : entries) {
                values.add(entry.value);
            }
        }
        return values.iterator();
	}
    
    public static void main(String[] args) {
        HashtableOH<String,String> table = new HashtableOH<String,String>(4);
        table.put("hej", "hello");      
        table.put("röd", "red");        
        table.put("vit", "white");      
        table.put("säng", "bed");       
        table.put("svart", "black");    
        table.put("gul", "yellow");     
        table.put("dator", "computer"); 
        table.put("snö", "snow");       
        table.put("blå", "blue");       
        table.put("grön", "green");     
        table.put("hus", "house");      
        table.list();
        System.out.println(table.get("hus"));
        System.out.println(table.remove("hus"));
        table.list();
    }
}
