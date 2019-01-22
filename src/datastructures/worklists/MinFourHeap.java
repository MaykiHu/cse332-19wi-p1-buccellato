package datastructures.worklists;

import cse332.interfaces.worklists.PriorityWorkList;
import cse332.exceptions.NotYetImplementedException;

/**
 * See cse332/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;
    //private int size;
    
    public MinFourHeap() {
        throw new NotYetImplementedException();
        //setup();
    }
    
    //private void setup() {
    	//data = (E[])new Comparable[SIZE]; what size?
    	//size = 0;
    //}
    
    @Override
    public boolean hasWork() {
        throw new NotYetImplementedException();
        // return super.hasWork();
    }

    @Override
    public void add(E work) {
        throw new NotYetImplementedException();
        //data[size] = work;
        //size++;
        //if (size >= 2) {
        //	boolean isOrdered = false;
        //	int loc = size - 1;
        //	while (loc != 0 && !isOrdered) {
        //		E childData = data[loc];
        //		E parentData = data[parentLoc(loc)];
        //		if (childData.compareTo(parentData) < 0) {
        //			data[parentLoc(loc)] = childData;
        //			data[loc] = parentData;
        //			loc = parentLoc(loc);
        //		} else { // New element can be added as a child
        //			isOrdered = true;
        //		}
        //	}
        //}
        //if (size == data.length) {
        	//E[] newData = (E[])new Comparable[2 * data.length];
        	//for (int i = 0; i < data.length; i++) {
        	  	//newData[i] = data[i];
        	//
        	//}
        	//data = newData;
    	//}
    }
    
    //private int parentLoc(int childLoc) {
    	//return (childLoc - 1) / 4;
    //}

    @Override
    public E peek() {
        throw new NotYetImplementedException();
        //if (!hasWork()) {
          	//throw new NoSuchElementException();
        //}
        //return data[0];
    }

    @Override
    public E next() {
        throw new NotYetImplementedException();
        //if (!hasWork()) {
        //	throw new NoSuchElementException();
        //}
        //E min = peek();
        //size--;
        //if (size == 0) {
        //	data[0] = null;
        //	return min;
        //}
        //data[0] = data[size];
        //data[size] = null;
        //int parentLoc = 0;
        //boolean isOrdered = false;
        //while (!isOrdered && 4 * parentLoc + 1 < size) {
        //	int nChild = 0;
        //	int childLoc = 4 * parentLoc + nChild + 1;
        //	int priority = data[childLoc].compareTo(data[parentLoc]);
        //	int swapPos = childLoc;
        //	while (nChild < 3 && childLoc + 1 < size) {
        //		childLoc++;
        //		nChild++;
        //		int currPriority = data[childLoc].compareTo(data[parentLoc]);
        //		if (currPriority < priority) {
        //			priority = currPriority;
        //			swapPos = childLoc;
        //		}
        //	}
        //	if (priority < 0) {
        //		E newParent = data[swapPos];
        //		data[swapPos] = data[parentLoc];
        //		parentLoc = swapPos;
        // 	} else {
        //		isOrdered = true;
        //	}
        //}
        //return min;
    }

    @Override
    public int size() {
        throw new NotYetImplementedException();
        //return size;
    }

    @Override
    public void clear() {
        throw new NotYetImplementedException();
        //setup();
    }
}
