class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict); //convert list to set
        boolean[] dp = new boolean[s.length()+1]; 
        dp[0] = true;
        for(int len = 1; len < (s.length() + 1); len++){
            for(int i = 0; i< len; i++){ 
                if(dp[i] && set.contains(s.substring(i,len))){ 
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
