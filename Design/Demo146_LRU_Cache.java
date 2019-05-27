import java.util.Arrays;

class Demo146_LRU_Cache {
	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(1, 1);
		c.put(2, 2);

		c.get(1);       // returns 1
		c.put(3, 3);    // evicts key 2
		c.get(2);       // returns -1 (not found)
		c.put(4, 4);    // evicts key 1
		c.get(1);       // returns -1 (not found)
		System.out.println(Arrays.toString(c.cache[0]));
		System.out.println(Arrays.toString(c.cache[1]));
		System.out.println(Arrays.toString(c.cache[2]));
		c.get(3);       // returns 3
		System.out.println(c.get(3));
		c.get(4);       // returns 4
	}
}

class LRUCache {
	public int[][] cache;
	public int capacity;
	public int count;
    
    public LRUCache(int capacity) {
    	this.count = 0;
        this.capacity = capacity;
        cache = new int[3][capacity];
    }
    
    public int get(int key) {
        int index = search(cache[0], key);
        // System.out.println(index);
        if(index < 0)
        	return -1;
        else {

        	return cache[1][index];
        }
    }
    
    public void put(int key, int value) {

    	if(count < capacity) {
    		int index = search(cache[0], key);

    		if(index < 0) {
    			cache[0][count] = key;
	    		cache[1][count] = value;
	    		cache[2][count] = count;
    			count++;
    		}else {
    			cache[1][index] = value;
    			for (int i = 0; i < capacity; i++) {
    				if(i == index)
    					cache[2][i] = 0;
    				else
    					cache[2][i]++;
    			}
    		}
    	}else {
    		int index = search(cache[2], capacity - 1);
    		cache[0][index] = key;
    		cache[1][index] = value;
    		for (int i = 0; i < capacity; i++) {
    				if(i == index)
    					cache[2][i] = 0;
    				else
    					cache[2][i]++;
    		}
    	}
        
    }

    public int search(int[] arr, int target) {
    	for(int i = 0; i < arr.length; i++) {
    		if (arr[i] == target)
    			return i;
    	}
    	return -1;
    }
}