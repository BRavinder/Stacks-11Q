class FreqStack {
        HashMap<Integer,Integer>map;
        HashMap<Integer,Stack<Integer>> st;
        int x=0;
    public FreqStack() {
       map=new HashMap<>();
        st=new HashMap<>();
    }
    
    public void push(int val) {
        if(!map.containsKey(val)) map.put(val,1);
        else map.put(val,map.get(val)+1);
        
        if(map.get(val) >x) x=map.get(val);
        
        if(!st.containsKey(map.get(val))){
            st.put(map.get(val),new Stack<>());
            
            }
          
        st.get(map.get(val)).push(val);
         
            
            
        }
    
    public int pop() {
        int y=0;
       if(st.size()>0 ){
           y=st.get(x).pop();
           map.put(y,map.get(y)-1);
           if(st.get(x).size()==0) x--;
       } 
     
        return y;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */