// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/submissions/1096481801/?envType=daily-question&envId=2023-11-11

class Graph {
    List<List<Pair<Integer, Integer>>> list;

    public Graph(int n, int[][] edges) {
        list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        list.get(edge[0]).add(new Pair<>(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        int[] costs = new int[list.size()];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[node1] = 0;
        pq.offer(new Pair<>(node1, 0));
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> u = pq.poll();
            int curNode = u.getKey();
            int curCost = u.getValue();
            if(curCost > costs[curNode]) {
                continue;
            }
            if(curNode == node2) return curCost;
            for(Pair<Integer, Integer> v : list.get(curNode)) {
                int nxtNode = v.getKey();
                int nxtCost = v.getValue();
                int newCost = curCost + nxtCost;
                
                if(newCost < costs[nxtNode]) {
                    costs[nxtNode] = newCost;
                    pq.offer(new Pair<>(nxtNode, newCost));
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
