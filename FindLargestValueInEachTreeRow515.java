/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2023-10-24
*/

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
class FindLargestValueInEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }
            }

            res.add(max);
        }
        return res;
    }
}
