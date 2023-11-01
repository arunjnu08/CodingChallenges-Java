// https://leetcode.com/problems/find-mode-in-binary-search-tree/?envType=daily-question&envId=2023-11-01

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
class FindModeInBinarySearchTree_501 {
    int pre = -1;
    int cnt = 0;
    int max = 0;
    List<Integer> res;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);

        if(cnt == max) {
            res.add(pre);
        } else if(cnt > max) {
            res.clear();
            res.add(pre);
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);

        if(cnt == 0) {
            pre = root.val;
            cnt++;
        } else if(root.val == pre) {
            cnt++;
        } else {
            if(cnt == max) {
                res.add(pre);
            } else if(cnt > max) {
                max = cnt;
                res.clear();
                res.add(pre);
            }
            pre = root.val;
            cnt = 1;
        }
        dfs(root.right);
    }
}
