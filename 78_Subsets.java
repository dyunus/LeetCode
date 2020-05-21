class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        
        int fixLength = 1 << nums.length; //Ex: if nums is of length 3, fixLength is the binary string 1000
        
        for(int i = 0; i < Math.pow(2,nums.length); i++){
            String bitMask = Integer.toBinaryString(fixLength | i).substring(1); //bitwise OR with fixLength to create the bitmask for each element of the powerset, substring removes the leading 1 
            ArrayList<Integer> subset = new ArrayList<Integer>();
            
            for(int j = 0; j < nums.length; j++){ //slide mask over nums to create new subset
                if(bitMask.charAt(j) == '1'){
                    subset.add(nums[j]);
                }
            }
            subsetList.add(subset);
        }
        return subsetList;
    }
}
