// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/submissions/1095703202/?envType=daily-question&envId=2023-11-10

class RestoreTheArrayFromAdjacentPairs_1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int ele = 0;
        for(int key : map.keySet()) {
            if(map.get(key).size() == 1) {
                ele = key;
                break;
            }
        }
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        int inx = 0;

        int pre = ele;
        while(inx < n) {
            res[inx++] = ele;
            for(int nxt : map.get(ele)) {
                if(nxt != pre) {
                    pre = ele;
                    ele = nxt;
                    break;
                }
            }
        }
        return res;
    }
}
