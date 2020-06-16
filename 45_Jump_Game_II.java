class Solution {
    public int jump(int[] nums) {
        int jumps = 0; 
        int currentEnd = 0; //the current limit index reachable without another jump
        int currentFar = 0; //the farthest index that can be reached so far
        int end = nums.length-1;
        
        for(int i=0; i< end; i++){ 
            currentFar = Math.max(currentFar, nums[i] + i); //update the current farthest if needed based on current index
            if(currentFar >= end){ //if the end is reachable
                jumps++; //jump to the end
                break;
            }
            if(i == currentEnd){ //reached the maximum index possible without another jump
                currentEnd = currentFar; //update the next maximum possible index reachable with the currentfarthest index reached
                jumps++; //jump beyond the current end
            }
        }
        return jumps;
    }
}
