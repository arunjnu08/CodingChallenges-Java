// https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/?envType=daily-question&envId=2023-11-25

class SumOfAbsoluteDifferencesInASortedArray_1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        for(int x : nums) right += x;

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = (nums[i] * i - left) + (right - nums[i] * (n - i));
            left += nums[i];
            right -= nums[i];
        }
        return ans;
    }
}
