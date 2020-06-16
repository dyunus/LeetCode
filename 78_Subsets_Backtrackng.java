class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtracking(list, new ArrayList(), nums, 0);
        return list;
    }
    
    public void backtracking(List<List<Integer>> list, List<Integer> tempList,int[] nums, int start){
        list.add(new ArrayList(tempList)); //add list so far (ex:add the base case [] initially or add [1,2] before making the recursive call for [1,2,3])
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);//add an additional number to the subset
            backtracking(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1); //remove the current number (ex: completed [1,2], remove 2 and try [1,3] next iteration)
        }
    }
}
