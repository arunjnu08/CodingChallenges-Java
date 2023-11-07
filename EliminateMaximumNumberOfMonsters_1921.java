// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/?envType=daily-question&envId=2023-11-07

class EliminateMaximumNumberOfMonsters_1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for(int i = 0; i < n; i++) {
            dist[i] = (int)Math.ceil((double)dist[i] / speed[i]);
        }
        Arrays.sort(dist);
        int time = 0;
        int res = 0;
        for(int x : dist) {
            x -= time++;
            if(x > 0) res++;
            else break;
        }
        return res;
    }
}
