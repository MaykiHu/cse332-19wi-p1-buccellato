package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.misc.BString;
import cse332.interfaces.trie.TrieMap;

/**
 * See cse332/interfaces/trie/TrieMap.java
 * and cse332/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        public HashTrieNode() {
            this(null);
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieMap<A, K, V>.HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    @Override
    public V insert(K key, V value) {
    	if (key == null || value == null) {
    		throw new IllegalArgumentException();
    	}
    	V prevVal = null;
    	HashMap<A, HashTrieNode> children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) 
    										root.pointers;
    	Iterator<A> itr = key.iterator(); // Should check if instance of
        while(itr.hasNext()) {
        	A currChar = itr.next();
        	if (children.containsKey(currChar)) {
        		prevVal = children.get(currChar).value;
        	} else {
        		children.put(currChar, new HashTrieNode());
        	}
        	if (!itr.hasNext()) {
        		children.get(currChar).value = value;
        	}
        	children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>)
        				children.get(currChar).pointers;
        }
		return prevVal;
    }

    @Override
    public V find(K key) {
    	if (key == null) {
    		throw new IllegalArgumentException();
    	}
    	V val = null;
    	HashMap<A, HashTrieNode> children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>)
    										root.pointers;
        Iterator<A> itr = key.iterator(); // Should check if instance of
        boolean hasPath = true;
        while(itr.hasNext() && hasPath) {
        	A currChar = itr.next();
        	if (children.containsKey(currChar)) {
        		val = children.get(currChar).value;
        		children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) 
        				children.get(currChar).pointers;
        	} else {
        		hasPath = false;
        		val = null;
        	}
        }
		return val;
    }

    @Override
    public boolean findPrefix(K key) {
    	if (key == null) {
    		throw new IllegalArgumentException();
    	}
    	HashMap<A, HashTrieNode> children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) 
				root.pointers;
		Iterator<A> itr = key.iterator();
		while (itr.hasNext()) {
			A currChar = itr.next();
			if (!children.containsKey(currChar)) {
				return false;
			} else {
				children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) 
				children.get(currChar).pointers;
			}
		}
		return true;
    }

    @Override
    public void delete(K key) {
        if (key == null || root == null) {
        	throw new IllegalArgumentException();
        }
        if (find(key) != null) {
        	
        }
    }
    
    @Override
    public void clear() {
        this.root = new HashTrieNode();
    }
}
