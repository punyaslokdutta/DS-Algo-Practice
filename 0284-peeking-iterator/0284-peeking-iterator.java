// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it = null;
    Integer next = null;
	public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        if(it.hasNext()) next = it.next();
	    // initialize any member here.
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer curr = next;
        if(it.hasNext())
        {
            next = it.next();
        }
        else{
            next = null;
        }
        
        return curr;
	}
	
	@Override
	public boolean hasNext() {
        return next!= null || it.hasNext();
	}
}


// PeekingInterator p = new PeekingIterator(new Iterator<Integer>(new int []{1, -1, 2}))
