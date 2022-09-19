class DinnerPlates {
    ArrayList<ArrayList<Integer>> stacks;
    TreeSet<Integer> leftMost;
    int CAPACITY;
    
    public DinnerPlates(int capacity) {
        stacks = new ArrayList();
        leftMost = new TreeSet();
        CAPACITY = capacity;
    }
    
    public void push(int val) {
        cleanup();
        if(leftMost.size() > 0){
            int index = leftMost.pollFirst();
            while(leftMost.size() > 0 && index == leftMost.first().intValue()){
                leftMost.pollFirst();
            }
            stacks.get(index).add(val);
            if(stacks.get(index).size() < CAPACITY){
                leftMost.add(index);
            }
            return;
        }
        if(stacks.size() == 0 || stacks.get(stacks.size()-1).size() == CAPACITY) stacks.add(new ArrayList());
        int index = stacks.size()-1;
        stacks.get(index).add(val);
    }
    
    public int pop() {
        if(stacks.size() == 0){
            return -1;
        }
        ArrayList<Integer> lastStack = stacks.get(stacks.size()-1);
        int result = lastStack.get(lastStack.size() -1);
        lastStack.remove(lastStack.size() -1);
        cleanup();
        return result;
    }
    
    public int popAtStack(int index) {
        if(stacks.size() == 0 || index >= stacks.size() || index < 0){
            return -1;
        }
        int res = -1;
        if(stacks.get(index).size() > 0){
            res = stacks.get(index).get(stacks.get(index).size()-1); 
            stacks.get(index).remove(stacks.get(index).size()-1); 
            leftMost.add(index);
        }
        cleanup();
        return res;
    }
    private void cleanup(){
        while(stacks.size() > 0){
            if(stacks.get(stacks.size()-1).size() == 0 ){
                stacks.remove(stacks.size()-1);
            } else {
                break;
            }
        }
        while(leftMost.size() > 0 && (leftMost.first() >= stacks.size() 
              || stacks.get(leftMost.first()).size() == CAPACITY)){
                leftMost.pollFirst();
        }
        
    }
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
// Time Complexity : O(n)
// Space Complexity : O(1)