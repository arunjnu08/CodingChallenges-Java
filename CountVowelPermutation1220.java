// https://leetcode.com/problems/count-vowels-permutation/?envType=daily-question&envId=2023-10-28

class CountVowelPermutation1220 {
    public int countVowelPermutation(int n) {
        // here 0, 1, 2, 3, 4 indexes are associated with a, e, i, o, u respectivelly.
        long[] dp1 = new long[5];
        long[] dp2 = new long[5];
        Arrays.fill(dp1, 1L);
        long sum = 5;
        int MOD = 1000000007;

        for(int i = 2; i <= n; i++) {
            dp2[0] = dp1[1] % MOD;
            dp2[1] = (dp1[0] + dp1[2]) % MOD;
            dp2[2] = (dp1[0] + dp1[1] + dp1[3] + dp1[4]) % MOD;
            dp2[3] = (dp1[2] + dp1[4]) % MOD;
            dp2[4] = dp1[0] % MOD;
            sum = 0;
            for(long x : dp2) {
                sum = (sum + x) % MOD;
            }
            sum = sum % MOD;
            dp1 = dp2;
            dp2 = new long[5];
            // System.out.println("sum = " + sum);
        }
        return (int)sum;
    }
}
