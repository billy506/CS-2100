package hash;
/**
 * Hash Table implementation. Uses linear probing to resolve collisions.
 * @author Prof. Mark Floryan
 * @help received from Declan Stacy (fmw3cs)
 * @param <K>
 * @param <V>
 */

public class HashTable<K,V> implements Map<K,V>{

	/* The array of objects and related things */
	private HashNode<K,V>[] table;
	private HashNode<K,V> sentinel;
    	public int currentSize;
    	private int totalprimeSize;
    	private static int maxSize = 40;
	
	public HashTable() {
		this(maxSize);
	}
	
	public String printIndex(int index) {
		if(table[index]!=null)
		{
			return table[index].getKey().toString() +", " +  table[index].getValue();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int initialCapacity) {
		if (initialCapacity <= 0) {
	         throw new IllegalArgumentException("Illegal Initial Capacity");
		}
		
		K k = null; //plug into the sentinel 
		V v = null;
		
		currentSize = 0;
		totalprimeSize = getPrime();
		maxSize = initialCapacity;
		table = (HashNode <K,V>[]) new HashNode[maxSize];
		for (int i = 0; i < maxSize; i++)
            table[i] = null;
		sentinel = new HashNode<K, V>(k,v);
	}
   
	@Override
	public void insert(K key, V value) {
			int index = getHashIndex(key);
			int j; //IMPORTANT: This allows the probing process to go smoothly

			/////////// Linear Probing ///////////
			for(int i=0;i<table.length;i++) {
				j = (index + i) % table.length; //IMPORTANT: This allows the linear probing process to go smoothly
				if(table[j]==null||table[j].getKey()==null) {
					table[j] = new HashNode<K,V>(key, value);
					currentSize++;
					break;
				}
				else if(table[j].getKey().equals(key))
				{
					table[j] = new HashNode<K,V>(key, value);
					break;
				}
			}
			
			/////////// Double Hashing ///////////
			for(int i=0;i<table.length;i++) {
				j = (index + i*i) % table.length;
				if(table[j]==null||table[j].getKey()==null) {
					table[j] = new HashNode<K,V>(key, value);
					currentSize++;
					break;
				}
				else if(table[j].getKey().equals(key)){
					table[j] = new HashNode<K,V>(key, value);
					break;
				}
			}
       
        if( ((double) currentSize) / table.length >= 0.7) {
        		this.resize();
              }
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		HashNode<K, V>[] temp = table.clone();
    	table = (HashNode <K,V>[]) new HashNode[table.length * 2];
    	maxSize = table.length;
    	currentSize = 0;
    	for (int i=0;i<temp.length;i++) {
            if(temp[i] != null&&temp[i]!=sentinel) {
            		this.insert(temp[i].getKey(),temp[i].getValue());
            		}
    		}
	}
	
	
	public V retrieve(K key) {
		int index = getHashIndex(key);
		int j;
		for(int i=0;i<table.length;i++) {
			j = (index + i) % table.length; //IMPORTANT: This allows the linear probing process to go smoothly
			if(table[j]!=null&&key.equals(table[j].getKey())) {
				return table[j].getValue();
			}
			if(table[j]==null)
			{
				break;
			}
		}
		return null;
	}

	
	public boolean contains(K key) {
		int index = getHashIndex(key);
		int j;
		for(int i=0;i<table.length;i++) {
			j = (index + i*i) % table.length; //IMPORTANT: This allows the linear probing process to go smoothly
			if(table[j]!=null&&key.equals(table[j].getKey())) {
				return true;
			}
		}
		return false;
	}

	
	public void remove(K key) {
		int index = getHashIndex(key);
		int j;
		for(int i=0;i<table.length;i++) {
			j = (index + i) % table.length; //IMPORTANT: This allows the linear probing process to go smoothly
			if(table[j]!=null&&key.equals(table[j].getKey())) {
				table[j] = sentinel;
			}
		}
	}
	
	private int getHashIndex(K key) {
		return Math.abs(key.hashCode()) % table.length;
	}
	
	
	private int quadProbing(K key)
    {
        int hashVal = Math.abs(key.hashCode());
        hashVal %= table.length;
        if (hashVal < 0)
        	hashVal += maxSize;
        return totalprimeSize - hashVal % totalprimeSize;
    }
	
	public int getPrime()
    {
		for (int i=maxSize-1;i>=1;i--) {
            int count = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                	count++;
                }
                if (count == 0) {
                	return i;
                }
            }
		}
        // Returning a prime number
            return 3;
    }
	
	 public void printHashTable()
	    {
	        // Display message
	        System.out.println("Hash Table");
	        for (int i = 0; i < maxSize; i++)
	        	System.out.println(table[i].getKey() + " "+ table[i].getValue());
	    }
	
}
