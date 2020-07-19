/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0 , nums.length -1);
    }
    
    public TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi-lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo,mid-1);
        root.right = helper(nums, mid+1,hi);
        return root;
    }
}


/*
[-10,-3,0,5,9]
lo: 0   hi: 4
0
lo: 0   hi: 1
-10
lo: 0   hi: -1
lo: 1   hi: 1     <---------- this is why lo > hi and NOT lo >= hi, 
-3
lo: 1   hi: 0
lo: 2   hi: 1
lo: 3   hi: 4
*/
