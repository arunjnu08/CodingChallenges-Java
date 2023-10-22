/*
https://leetcode.com/problems/maximum-score-of-a-good-subarray/description/?envType=daily-question&envId=2023-10-22
*/

class MaximumScoreOfAGoodSubarray1793 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int p1 = k - 1, p2 = k + 1;
        int min = nums[k];
        int cnt = 1;
        int max_val = nums[k];

        while(p1 >= 0 || p2 < n) {
            int val = 0;
            if(p2 == n) {
                min = Math.min(min, nums[p1--]);
            } else if(p1 < 0 || nums[p1] < nums[p2]) {
                min = Math.min(min, nums[p2++]);
            } else {
                min = Math.min(min, nums[p1--]);
            }
            cnt++;
            val = min * cnt;
            max_val = Math.max(max_val, val);
        }
        return max_val;
    }
}
