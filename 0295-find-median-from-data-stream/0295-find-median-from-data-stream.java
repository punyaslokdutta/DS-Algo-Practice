class MedianFinder {

    public MedianFinder() {
        
    }
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
    boolean even = true;
    public void addNum(int num) {
    		if(even)
    		{
    			largeHeap.offer(num);
    			smallHeap.offer(largeHeap.poll());
    		}
    		else
    		{
    			smallHeap.offer(num);
    			largeHeap.offer(smallHeap.poll());
    		}
    		even = !even;
        
    }
    
    public double findMedian() {
    	if(even)
    	{
    		return (smallHeap.peek() + largeHeap.peek())/2.0;
    	}
    	else
    		return smallHeap.peek();
        
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */