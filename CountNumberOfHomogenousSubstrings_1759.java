// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/?envType=daily-question&envId=2023-11-09

class CountNumberOfHomogenousSubstrings_1759 {
    public int countHomogenous(String s) {
        int res = 0;
        int mod = 1000000007;

        int inx = 0;
        int n = s.length();
        while(inx < n) {
            int cnt = 0;
            while(inx + cnt < n && s.charAt(inx + cnt) == s.charAt(inx)) {
                cnt++;
            }
            long cur_total = ((long)cnt * (cnt + 1) / 2) % mod;
            res = (res + (int)cur_total) % mod;
            inx += cnt;
        }
        return res;
    }
}
