class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min=new PriorityQueue<>();
        max=new PriorityQueue<>((a,b)->{return b-a;});    
    }
    
    public void addNum(int num) {
        if(max.isEmpty())
            min.add(num);
        else{
            if(num<max.peek()){
                max.add(num);
            }
            else{
                min.add(num);
            }
        }
        if(max.size()>min.size()+1){
            min.add(max.poll());
        }
        else if(min.size()>max.size()){
            max.add(min.poll());
        }    
    }
    
    public double findMedian() {
        return (min.size()==max.size())?((double)(max.peek()+min.peek())/2):max.peek();    
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */