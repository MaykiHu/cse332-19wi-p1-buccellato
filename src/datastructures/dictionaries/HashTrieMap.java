package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import cse332.interfaces.misc.BString;
import cse332.interfaces.trie.TrieMap;
import datastructures.worklists.ArrayStack;

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

    @SuppressWarnings("unchecked")
	@Override
    public V insert(K key, V value) {
    	if (key == null || value == null) {
    		throw new IllegalArgumentException();
    	}
    	V prevVal = null;
    	if (key.isEmpty()) {
    		if (root.value == null) {
    			size++;
    			root.value = value;
    			return prevVal;
    		}
    		prevVal = root.value;
    		root.value = value;
    		return prevVal;
    	}
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
        		if (children.get(currChar).value == null) {
        			size++;
        			prevVal = null;
        		} else {
        			prevVal = children.get(currChar).value;
        		}
        		children.get(currChar).value = value;
        	}
        	children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>)
        				children.get(currChar).pointers;
        }
		return prevVal;
    }

    @SuppressWarnings("unchecked")
	@Override
    public V find(K key) {
    	if (key == null) {
    		throw new IllegalArgumentException();
    	}
    	V val = null;
    	if (key.isEmpty() && root.value != null) {
    		return root.value;
    	}
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

    @SuppressWarnings("unchecked")
	@Override
    public boolean findPrefix(K key) {
    	if (key == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	if (key.isEmpty()) {
    		return true;
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
    
    @SuppressWarnings("unchecked")
	@Override
    public void delete(K key) {
    	
        if (key == null || this.root == null) {
        	throw new IllegalArgumentException();
        }
        if (key.isEmpty()) {
        	if (root.value != null) {
        		root.value = null;
        		size--;
        	}
        } else if (find(key) != null) { // If the key exists        	
        	@SuppressWarnings("rawtypes")
			ArrayStack nodes = new ArrayStack();
        	@SuppressWarnings("rawtypes")
			ArrayStack characters = new ArrayStack();
        	HashMap<A, HashTrieNode> children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>)
        										root.pointers;
        	Iterator<A> itr = key.iterator();
        	while (itr.hasNext()) {
        		nodes.add(children);
        		A currChar = itr.next();
        		characters.add(currChar);
        		HashTrieNode currNode = children.get(currChar);
        		children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) currNode.pointers;
        	}
        	boolean continueRemove = true;
        	while (nodes.hasWork() && continueRemove) {
        		HashMap<A, HashTrieNode> refs = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) 
        											nodes.next();
        		A character = (A) characters.next();
        		HashTrieNode node = refs.get(character);
        		boolean hasChildren = !node.pointers.isEmpty();
        		if (key.size() - nodes.size() == 1) { // "key" node location
        			if (hasChildren) { 
        				node.value = null;
        				continueRemove = false;
        			} else {
        				refs.clear();
        			}
        		} else { // Not "key" node location
        			if (node.value != null || hasChildren) { // Stop if node has value or branches
        				continueRemove = false;
        			} else { // Continue removing because it's a lonely node
        				refs.remove(character);
        			}
        		}
        	}
	        size--;
        }
    }
    
    @Override
    public void clear() {
        this.root = new HashTrieNode();
        size = 0;
    }
}
