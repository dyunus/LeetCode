class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; //only one way to make a tree of 0 nodes
        dp[1] = 1; //only one way tp make a tree of 1 node
        for(int num =2; num<= n; num++){ //fill dp array for by trying all num from 1..n
            for(int root=1; root <= num; root++){ //for each num, try making 1..num the root 
                dp[num] += dp[root-1] * dp[num-root]; //the number of trees made for each root is calculated by calculcating the product of number of ways to make the left and right subtrees respectively. dp[root-1] is the left subtree and dp[num-root] is the right subtree
            }
        }
        return dp[n];
    }
}
