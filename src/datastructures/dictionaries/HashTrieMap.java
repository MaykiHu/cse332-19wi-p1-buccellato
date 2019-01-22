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
    		throw new NullPointerException();
    	}
    	V prevVal = null;
    	HashMap<A, HashTrieNode> children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) root.pointers;
        Iterator<A> itr = key.iterator(); // Should check if instance of
        while(itr.hasNext()) {
        	A nextChar = itr.next();
        	HashTrieNode t;
        	if (children.containsKey(nextChar)) {
        		prevVal = (V) children.get(nextChar).value;
        		t = children.get(nextChar);
        	} else {
        		t = new HashTrieNode();
        		children.put((A) nextChar, t);
        	}
        	children = (HashMap<A, HashTrieMap<A, K, V>.HashTrieNode>) t.pointers;
        	if (!itr.hasNext()) {
        		children.get(nextChar).value = value;
        	}
        }
		return prevVal;
    }

    @Override
    public V find(K key) {
        throw new NotYetImplementedException();
    }

    @Override
    public boolean findPrefix(K key) {
        throw new NotYetImplementedException();
    }

    @Override
    public void delete(K key) {
        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
        throw new NotYetImplementedException();
    }
}
