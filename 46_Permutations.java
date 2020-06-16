class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtracking(Arrays.stream(nums).boxed().collect(Collectors.toList())); //convert int[] to List<Integer>
    }
    
    public List<List<Integer>> backtracking(List<Integer> nums){ //given a list, for each num in list, add num to the front of all sublists without num
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        if(nums.size() == 0){ //base case, list containing the empty list
            temp.add(new ArrayList<Integer>());
            return temp;
        }
        for(int i=0; i<nums.size(); i++){
            int currNum = nums.get(i); //current num to exclude from sublist generation
            nums.remove(nums.indexOf(currNum)); //remove current num from list
            List<List<Integer>> sublist = backtracking(nums); //generate sublists without the current num
            for(int j = 0; j < sublist.size(); j++){ //for every sublist without current num
                sublist.get(j).add(0,currNum); //add current num to the front
                temp.add(sublist.get(j)); //add sublist to final result
            }
            nums.add(i,currNum); //restore current num
        }
        return temp;
    }  
}
