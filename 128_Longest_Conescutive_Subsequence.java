class Solution {
    public int longestConsecutive(int[] nums) {
        //create HashSet to store set of numbers 
        HashSet<Integer> set = new HashSet<Integer>();      
        for(int num : nums){
            set.add(num);
       
        }        
       
        int longestStreak = 0;
        
        for(int num : nums){
           
            if(!set.contains(num-1)){ //only iterate if the number is the beginning of a consecutive sequence
                int currentStreak = 1;
                int currentNum = num;
                
                while(set.contains(currNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n) 
