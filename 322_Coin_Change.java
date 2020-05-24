class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; //dummy value to use Math.min and keep track of invalid inputs
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int currAmount = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= currAmount ){ //don't check if the coin is greater than current amount
                    dp[currAmount] = Math.min(dp[currAmount], dp[currAmount-coin] + 1);
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
