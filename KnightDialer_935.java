// https://leetcode.com/problems/knight-dialer/description/?envType=daily-question&envId=2023-11-27

class KnightDialer_935 {
    public int knightDialer(int n) {
        if(n == 1) return 10;
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        int MOD = 1000000007;

        int[][] jumps = new int[][] {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}
        };

        for(int i = 2; i <= n; i++) {
            int[] dp1 = new int[10];
            for(int j = 0; j < 10; j++) {
                for(int num : jumps[j]) {
                    dp1[j] = (dp1[j] + dp[num]) % MOD;
                }
            }
            dp = dp1;
        }
        int ans = 0;
        for(int cnt : dp) {
            ans = (ans + cnt) % MOD;
        }
        return ans;
    }
}
