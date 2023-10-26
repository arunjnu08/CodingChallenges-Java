/*
https://leetcode.com/problems/binary-trees-with-factors/description/?envType=daily-question&envId=2023-10-26
*/

class BinaryTreesWithFactors823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, 1L);
        }
        long res = 0L;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int x = arr[j];
                int y = arr[i] / arr[j];
                if(y < x) break;
                if(arr[i] % arr[j] == 0 && map.containsKey(y)) {
                    long val = map.get(arr[i]) + (x == y ? 1 : 2) * map.get(x) * map.get(y);
                    val %= MOD;
                    map.put(arr[i], val);
                }
            }
        }
        // System.out.println(map);
        for(int key : arr) {
            res += map.get(key);
            res %= MOD;
        }
        return (int)(res % MOD);
    }
}
