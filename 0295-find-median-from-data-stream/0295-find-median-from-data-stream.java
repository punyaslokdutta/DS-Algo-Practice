class MedianFinder {
    boolean even;
    PriorityQueue<Integer> smallHeap; //maxHeap
    PriorityQueue<Integer> largeHeap; //minHeap
    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
        even = true; //starts with '0'
    }
    
    public void addNum(int num) {
        if(even)
        {
            smallHeap.offer(num);
            largeHeap.offer(smallHeap.poll());
        }
        else
        {
            largeHeap.offer(num);
            smallHeap.offer(largeHeap.poll());
        }
        even =!even;
    }
    
    public double findMedian() {
        if(even)
        {
            return (largeHeap.peek() + smallHeap.peek())/2.00; 
        }
        else
            return largeHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */