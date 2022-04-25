package hash;


/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Mark Floryan
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	
	/* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
	static private int INITIAL_CAP = 10;
	private int curSize;
	private int maxSize;
	private K[] keys;
	private V[] values; 
	
	
	public HashTable() {
		this(INITIAL_CAP);
	}
	
	public HashTable(int initialCapacity) {
		/* TODO: IMPLEMENT THIS METHOD */
		curSize = 0;
		maxSize = initialCapacity; 
		keys = (K[]) new Object[maxSize];
		values = (V[]) new Object[maxSize];
	}
	
	
	  private int hash(K key) {
	        int h = key.hashCode();
	        return h & (maxSize-1);
	    }
	  
	  private void resize(int capacity) {
		  HashTable<K,V> temp = new HashTable<K,V> (capacity);
		  for(int i = 0; i < maxSize; i++) {
			  if(keys[i] != null) {
				 temp.insert(keys[i], values[i]);
			  }
		  }
		  keys = temp.keys;
		  values = temp.values;
		  maxSize = temp.maxSize;
	  }
	
	
	@Override
	public void insert(K key, V value) {
		if (value == null) {
			remove(key);
			return;
		}
		
		if(curSize >= maxSize/2) resize(2*maxSize);
		
		int i;
		for(i = hash(key); keys[i] != null; i =(i+1) % maxSize) {
			if(keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		curSize ++;	
	}

	@Override
	public V retrieve(K key) {
		for(int i = hash(key); keys[i] != null; i = (i+1) % maxSize) 
			if(keys[i].equals(key)) return values[i];
		return null; 
	}

	@Override
	public boolean contains(K key) {
		return retrieve(key) != null;
	}

	@Override
	public void remove(K key) {
		if(!contains(key)) return;
		
		int i = hash(key); 
		while(!key.equals(keys[i])) {
			i = (i+1) % maxSize;
		}
		
		keys[i] = null;
		values[i] = null;
		
		i = (i + 1) % maxSize;
		while(keys[i] != null) {
			K keyToRehash = keys[i];
			V valuestoRehash = values[i];
			keys[i] = null;
			values[i] = null;
			curSize --;
			insert(keyToRehash, valuestoRehash);
			i = (i+1) % maxSize;
		}
		curSize --;
		
		if(curSize > 0 && curSize <= maxSize/8) resize(maxSize/2);
	}	
}
