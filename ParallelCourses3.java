/*
https://leetcode.com/problems/parallel-courses-iii/?envType=daily-question&envId=2023-10-18 
*/
class ParallelCourses3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        for(int[] relation : relations) {
            int u = relation[0];
            int v = relation[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        int[] maxMonths = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                maxMonths[i] = time[i - 1];
            }
        }

        while(!q.isEmpty()) {
            int u = q.poll();
            for(int v : graph.get(u)) {
                maxMonths[v] = Math.max(maxMonths[v], maxMonths[u] + time[v - 1]);
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        int res = 0;
        for(int month : maxMonths) {
            res = Math.max(res, month);
        }
        return res;
    }
}
