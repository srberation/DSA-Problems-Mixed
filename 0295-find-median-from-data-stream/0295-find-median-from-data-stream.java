class MedianFinder {
    PriorityQueue<Integer> maxheap; 
    PriorityQueue<Integer> minheap; 
    public MedianFinder() {
        maxheap =  new PriorityQueue(Collections.reverseOrder());
        minheap =  new PriorityQueue();  

    }
    public void addNum(int num) {
        if(maxheap.isEmpty() || maxheap.peek() >= num){
            maxheap.add(num);
        }
        else
            minheap.add(num);
        // either both the heap will have equaal numbers or maxheap will have one element extra
        if(maxheap.size() > minheap.size()+1) minheap.add(maxheap.poll());
        else if(maxheap.size()<minheap.size()) maxheap.add(minheap.poll());
    }
    
    public double findMedian() {
        // we have even no. of element in both heaps, then median will be my avg
        if(maxheap.size() == minheap.size()) return maxheap.peek()/2.0 + minheap.peek()/2.0;
        // as we are keeping one extra element in our maxheap so simply that will be my median
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */