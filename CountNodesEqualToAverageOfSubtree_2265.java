// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/?envType=daily-question&envId=2023-11-02

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CountNodesEqualToAverageOfSubtree_2265 {
    int res;
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        calculate(root);
        return res;
    }

    private int[] calculate(TreeNode root) {
        if(root == null) {
            return new int[] {0, 0};
        }
        int[] left = calculate(root.left);
        int[] right = calculate(root.right);

        int cnt = 1 + left[0] + right[0];
        int sum = root.val + left[1] + right[1];

        int avg = sum / cnt;
        res += root.val == avg ? 1 : 0;
        return new int[] {cnt, sum};
    }
}
