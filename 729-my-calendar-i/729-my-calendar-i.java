class MyCalendar {

    private TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>(); 
    }

    
    public boolean book(int start, int end) {
//         for(Integer val : map.keySet()){
//             if(val<end && map.get(val)>start){
//                 return false;
//             }
//         }
        
//         map.put(start,end);
        
//         return true;
        
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        
        int activeBooking = 0;
        for(int evnt:map.values()){
            activeBooking+=evnt;
            if(activeBooking>1){
                map.put(start,map.getOrDefault(start,0)-1);
                map.put(end,map.getOrDefault(end,0)+1);
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */