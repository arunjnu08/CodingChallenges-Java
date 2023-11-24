// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/?envType=daily-question&envId=2023-11-24

class MaximumNumberOfCoinsYouCanGet_1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int l = 0, r = n - 2;
        int ans = 0;
        while(l < r) {
            ans += piles[r];
            l++;
            r -= 2;
        }
        return ans;
    }
}
