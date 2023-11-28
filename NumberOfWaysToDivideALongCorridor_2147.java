// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/description/?envType=daily-question&envId=2023-11-28

class NumberOfWaysToDivideALongCorridor_2147 {
    public int numberOfWays(String corridor) {
        int s = 0, n = corridor.length(), s_cnt = 0;
        while(s < n && s_cnt != 2) {
            if(corridor.charAt(s) == 'S') {
                s_cnt++;
            }
            s++;
        }
        if(s_cnt != 2) return 0;
        if(s == n) return 1;

        int MOD = 1000000007;
        long ans = 1L;

        while(s < n) {
            int p_cnt = 0;
            s_cnt = 0;
            while(s < n && corridor.charAt(s) == 'P') {
                p_cnt++;
                s++;
            }
            if(s == n) break;
            ans = (ans * (p_cnt + 1)) % MOD;

            while(s < n && s_cnt != 2) {
                if(corridor.charAt(s) == 'S') {
                    s_cnt++;
                }
                s++;
            }
            if(s_cnt != 2) return 0;
        }
        return (int)ans;
    }
}
