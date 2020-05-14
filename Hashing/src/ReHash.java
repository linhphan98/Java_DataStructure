//Basically, when the load factor increases to more than its pre-defined value 
//(default value of load factor is 0.75), the complexity increases. So to overcome this, the size of the array is
//increased (doubled) and all the values are hashed again and stored in the 
//new double sized array to maintain a low load factor and low complexity.

// Rehashing is done because whenever key value pairs are inserted into the map, 
// the load factor increases, which implies that the time complexity also increases as explained above. 
// This might not give the required time complexity of O(1).
// Hence, rehash must be done, increasing the size of the bucketArray so as to reduce the load factor and the time complexity.

// How to rehash: 
// For each addition of a new entry to the map, check the load factor.
// If it’s greater than its pre-defined value (or default value of 0.75 if not given), then Rehash.
// For Rehash, make a new array of double the previous size and make it the new bucketarray.
// Then traverse to each element in the old bucketArray and call the insert() for each so as to insert it into the new larger bucket array.
import java.util.ArrayList;

class Map<Key, Value>{
	class MapNode<Key, Value>{
		Key key; 
		Value value;
		MapNode<Key, Value> next;
		
		public MapNode(Key key, Value value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
	
	// an array where nodes are Key-Value pairs
	ArrayList<MapNode<Key, Value>> listNodes; 
	int nodeCount; // how many nodes are in 
	int listSize; // actual list size
	final double DEFAULT_LOAD_FACTOR = 0.75;
	
	Map() {
		listSize = 5; 
		listNodes = new ArrayList<>(listSize); 
		
		for(int i = 0; i < listSize; i++) {
			listNodes.add(null);
		}
		
		System.out.println("HashMap created"); 
        System.out.println("Number of pairs in the Map: " + nodeCount); 
        System.out.println("Size of Map: " + listSize); 
        System.out.println("Default Load Factor : " + DEFAULT_LOAD_FACTOR + "\n"); 
	}
	
	private int getNodeHashKey(Key key) {
		int hashKeyIndex = key.hashCode(); // if integer will reture the same integer
		// but if it is a string or a char, it will return ASCII value of the string or a char
		return hashKeyIndex;
	}
	
	public void insert(Key key, Value value) {
		// getting index in the list needed to be inserted in 
		int listKey = getNodeHashKey(key);
		
		// Getting the entire linkedlist at that index in the array, returning the pointer 
		// The indexth element only link to the first node, the first node IS linked to other nodes by address pointers
		MapNode<Key, Value> head = listNodes.get(listKey); 
		
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
			}
			head = head.next;
		}
		
		// new node with Key and Value
		MapNode<Key, Value> newNode = new MapNode<>(key, value);
		
		// reassign the head back
		head = listNodes.get(listKey); 
		
		// inserting it at the top of the linkedList so it save time 
		newNode.next = head; 
		
		listNodes.set(listKey, newNode);
		
		System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");
		
		nodeCount++;
		
		// calculating the current load factor
		double currentLoadFactor = (1.0 * nodeCount) / listSize;
		
		if(currentLoadFactor > DEFAULT_LOAD_FACTOR) {
			System.out.println(currentLoadFactor + " is greater than " + DEFAULT_LOAD_FACTOR); 
            System.out.println("Therefore Rehashing will be done.\n"); 
            
            // Rehash
            rehash();
            
            System.out.println("New Size of Map: " + listSize + "\n"); 
		}
		
		System.out.println("Number of pairs in the Map: " + nodeCount); 
        System.out.println("Size of Map: " + listSize + "\n"); 
	}
	
	private void rehash() {
		System.out.println("\n***Rehashing Started***\n"); 
		
		ArrayList<MapNode<Key, Value>> tempList = listNodes;
		
		// doubling the size of the old node
		listSize *= 2;
		nodeCount = 0;
		listNodes = new ArrayList<>(listSize);
		
		
		for(int i = 0; i < listSize; i++) {
			// initialize 
			listNodes.add(null);
		}
		
		// copying over the tempList
		for(int i = 0; i < tempList.size(); i++) {
			// head of the chain at that index 
			MapNode<Key, Value> head = tempList.get(i);
			
			while(head != null) {
				Key key = head.key;
				Value value = head.value;
				
				// Calling the insert function
				insert(key, value);
				head = head.next;
			}
		}
		System.out.println("\n***Rehashing Ended***\n"); 
	}
	
	void printMap() {
		ArrayList<MapNode<Key, Value>> tempList = listNodes;
		
		System.out.println("Current HashMap:"); 
		for(int i = 0; i < tempList.size(); i++) {
			MapNode<Key, Value> head = listNodes.get(i);
			
			while(head != null) {
				System.out.println("key = " + head.key + ", val = " + head.value); 
				head = head.next;
			}
		}
		System.out.println(); 
	}
}

public class ReHash {
	public static void main (String args[]) {
		Map<Integer, String> map = new Map<Integer, String>();
		
		// Inserting elements 
	    map.insert(1, "Geeks");
	    map.printMap(); 

	    map.insert(2, "forGeeks"); 
	    map.printMap(); 

	    map.insert(3, "A"); 
	    map.printMap(); 

	    map.insert(4, "Computer"); 
	    map.printMap(); 

	    map.insert(5, "Portal"); 
	    map.printMap(); 
	}
}






