class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); //ensures that numbers that a num is divsiible by appear to the left
        int max = Integer.MIN_VALUE; //used to track the largest subset
        int index = -1; //used to keep track of the largest subset 
        int[] parents = new int[nums.length]; //used to connect divisible elements 
        int[] dp = new int[nums.length]; //used to keep track of subset sizes
        Arrays.fill(dp,1); //all numbers are divislbe by themselves
        Arrays.fill(parents,-1); //no parents by default
        
        for(int currNum=0; currNum< nums.length; currNum++){ //for each number
            for(int leftNum = currNum-1; leftNum>=0; leftNum--){ //check all the left numbers 
                if((nums[currNum] % nums[leftNum] == 0) && (dp[leftNum] + 1 > dp[currNum])){ //if divisible by left num, and left num has a larger subset, "add" that large subset to self 
                    dp[currNum] = dp[leftNum] + 1; //current subset is equal to the current num UNION the left num's subset 
                    parents[currNum] = leftNum; //link currNum and the max num it is divisible by throught he parent array 
                }
            }
            if(dp[currNum] > max){ //update the max variable if the current subset is the largest
                max = dp[currNum];
                index = currNum;
            }
        }
        
        List<Integer> res = new ArrayList(); 
        while(index != -1){ //trace back the subset through the parent variable
            res.add(nums[index]);
            index = parents[index];
        }
        return res;
    }
}
