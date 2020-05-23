class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, runningSum = 0;
        HashMap<Integer,Integer> prevSums = new HashMap<Integer,Integer>();
        prevSums.put(0,1);
        for(int num: nums){
            runningSum += num;
            if(prevSums.containsKey(runningSum - k)){ //if a previous sum is the running sum minus the target sum, then a target sum subarray exists (the elements after the previous sum up until the end of the running sum)
                count+= prevSums.get(runningSum - k); //add how many times the target sum has appeared thus far
            }
            prevSums.put(runningSum,prevSums.getOrDefault(runningSum,0)+1); //add/increment the current running sum to the dictionary of previous sums 
        }
        return count;
    }
}
