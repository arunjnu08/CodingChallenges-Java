/*
https://leetcode.com/problems/constrained-subsequence-sum/?envType=daily-question&envId=2023-10-21 
*/

class ConstrainedSubsequenceSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> dq = new LinkedList<>();
        int n = nums.length;

        dq.addFirst(new int[] {nums[n - 1], n - 1});
        int res = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            while(dq.getLast()[1] - i > k) {
                dq.removeLast();
            }

            int sum = nums[i] + Math.max(0, dq.getLast()[0]);

            while(!dq.isEmpty() && sum > dq.getFirst()[0]) {
                dq.removeFirst();
            }

            dq.addFirst(new int[] {sum, i});
            res = Math.max(res, sum);
        }
        return res;
    }
}
