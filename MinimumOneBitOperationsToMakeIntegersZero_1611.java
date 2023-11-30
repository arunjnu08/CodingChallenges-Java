// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/?envType=daily-question&envId=2023-11-30

class MinimumOneBitOperationsToMakeIntegersZero_1611 {
    public int minimumOneBitOperations(int n) {
        int ans = 0, cnt = 0;
        while(n > 0) {
            cnt++;
            if((n & 1) == 1) {
                ans = (1 << cnt) - 1 - ans;
            }
            n = (n >> 1);
        }
        return ans;
    }
}
