package datastructures.worklists;

import java.util.NoSuchElementException;
import cse332.interfaces.worklists.FIFOWorkList;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
	Node front;
	Node back;
	int size;
	
	private class Node {
		E val;
		Node next; 
		
		public Node() {
			next = null;
		}
		
		public Node(E val) {
			this.val = val;
		}
	}
    
    public ListFIFOQueue() {
        setup();
    }

    @Override
    public void add(E work) {
    	if  (!hasWork()) {
    		front = new Node(work);
    		back = front;
    	}
        back.next = new Node(work);
        back = back.next;
        size++;
    }

    @Override
    public E peek() {
        if (!hasWork()) {
        	throw new NoSuchElementException();
        }
        return front.val;
    }

    @Override
    public E next() {
    	if (!hasWork()) {
        	throw new NoSuchElementException();
        }
        E val = front.val;
        front = front.next;
        size--;
        return val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        setup();
    }
    
    private void setup() {
    	front = new Node();
        back = null;
        size = 0;
    }
}
