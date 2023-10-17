/*
https://leetcode.com/problems/validate-binary-tree-nodes/?envType=daily-question&envId=2023-10-17
*/
class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] par = new int[n];
        Arrays.fill(par, -1);

        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1) {
                if(par[leftChild[i]] == -1) {
                    par[leftChild[i]] = i;
                } else {
                    return false;
                }
            }

            if(rightChild[i] != -1) {
                if(par[rightChild[i]] == -1) {
                    par[rightChild[i]] = i;
                } else {
                    return false;
                }
            }
        }
        
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(par[i] == -1) {
                if(root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }
        if(root == -1) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(root);
        vis[root] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            int left = leftChild[node];
            int right = rightChild[node];

            if(left != -1) {
                if(vis[left]) return false;
                q.offer(left);
                vis[left] = true;
            }

            if(right != -1) {
                if(vis[right]) return false;
                q.offer(right);
                vis[right] = true;
            }
        }
        for(boolean v : vis) {
            if(!v) return false;
        }
        return true;
    }
}
