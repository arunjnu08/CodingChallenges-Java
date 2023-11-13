// https://leetcode.com/problems/bus-routes/description/?envType=daily-question&envId=2023-11-12

class BusRoutes_815 {
    List<List<Integer>> graph = new ArrayList<>();
    Set<Integer> sourceRoutes, targetRoutes;

    private void createGraph(int[][] routes) {
        for(int i = 0; i < routes.length; i++) {
            for(int j = i + 1; j < routes.length; j++) {
                if(haveCommonStop(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
    }

    private boolean haveCommonStop(int[] route1, int[] route2) {
        int p1 = 0, p2 = 0;
        while(p1 < route1.length && p2 < route2.length) {
            if(route1[p1] == route2[p2]) return true;

            if(route1[p1] < route2[p2]) p1++;
            else p2++;
        }
        return false;
    }

    private void getSourceAndTargetRoutes(int[][] routes, int source, int target) {
        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                if(stop == source) sourceRoutes.add(i);
                if(stop == target) targetRoutes.add(i);
            }
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        sourceRoutes = new HashSet<>();
        targetRoutes = new HashSet<>();

        for(int i = 0; i < routes.length; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }

        createGraph(routes);
        getSourceAndTargetRoutes(routes, source, target);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        for(int route : sourceRoutes) {
            q.offer(route);
            vis.add(route);
        }
        int count = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int route = q.poll();
                if(targetRoutes.contains(route)) return count;

                for(int nxtRoute : graph.get(route)) {
                    if(!vis.contains(nxtRoute)) {
                        vis.add(nxtRoute);
                        q.offer(nxtRoute);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
