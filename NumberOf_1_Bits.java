// https://leetcode.com/problems/number-of-1-bits/description/?envType=daily-question&envId=2023-11-29

public class NumberOf_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt++;
            n = (n & (n - 1));
        }
        return cnt;
    }
}
