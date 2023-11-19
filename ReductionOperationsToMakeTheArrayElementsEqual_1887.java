// https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/?envType=daily-question&envId=2023-11-19

class ReductionOperationsToMakeTheArrayElementsEqual_1887 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int inx = nums.length - 1;
        int ans = 0;
        int ele = nums[inx];

        while(inx >= 0) {
            if(ele == nums[0]) break;
            if(ele != nums[inx]) {
                ans += nums.length - inx - 1;
                ele = nums[inx];
            }
            inx--;
        }
        return ans;
    }
}
