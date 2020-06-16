class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        backtracking(res, new ArrayList(), candidates, target, 0);
        return res;
    }
    
    public void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int currTarget, int startIndex){
        if(currTarget < 0){ //if the current track resulted in a negative number, it is not a valid solution, return
            return;
        }
        else if(currTarget == 0){ //if the current track is equal to the target, add to the result list
            list.add(new ArrayList(tempList));
        }
        else{ //if the target has not yet been reached, continue search
            for(int i = startIndex; i < candidates.length; i++){
                tempList.add(candidates[i]); //add new candidate to list
                backtracking(list,tempList,candidates, currTarget-candidates[i], i); //continue search with new target equal to target - new candidate, startIndex remains the same since the same candidate can be chosen unlimited times
                tempList.remove(tempList.size()-1); //remove candidate to try remaining candidates
            }
        }
    }
}
