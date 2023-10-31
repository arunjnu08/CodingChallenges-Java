// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/?envType=daily-question&envId=2023-10-31

class FindTheOriginalArrayOfPrefixXor_2433 {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        arr[0] = pref[0];

        for(int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }
        return arr;
    }
}
