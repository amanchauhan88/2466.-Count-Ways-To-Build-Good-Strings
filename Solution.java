class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        
        // Base case: one way to construct an empty string
        dp[0] = 1;
        
        // Build dp array
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
        }
        
        // Sum up the counts for lengths between low and high
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }
        
        return result;
    }
}
