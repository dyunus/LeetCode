class Solution {
    public int[] productExceptSelf(int[] nums) { //first calculate product of left to index, then multiply product of right of index
        int[] res = new int[nums.length]; 
        res[0] = 1; //index 0 has no numbers to the left
        for(int i = 1; i < nums.length; i++){ //for each number, store the running left product sum
            res[i] = nums[i-1]*res[i-1];
        }
        int right = 1; //there is no number to the right of the last elment
        for(int i = nums.length-1; i>=0; i--){ //for each number from right to left
            res[i] *= right; //multiply by the running right product sum
            right *= nums[i]; //update the right product sum
        }
        return res;
    }
}
//Time Complexity: O(n), Space Complexity: O(1) when excluding output array 


/* Alternate solution: Time Complexity & Space Complexity: O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];   
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i =1; i < nums.length; i++){
            left[i] = nums[i-1]*left[i-1];
        }
        for(int i = nums.length - 2; i>=0; i--){
            right[i] = nums[i+1] * right[i+1];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
*/
