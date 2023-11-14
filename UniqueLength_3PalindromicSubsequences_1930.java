// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2023-11-14

class UniqueLength_3PalindromicSubsequences_1930 {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for(int i = 0; i < n; i++) {
            int inx = s.charAt(i) - 'a';
            if(first[inx] == -1) {
                first[inx] = i;
            }
            last[inx] = i;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(first[i] == -1) continue;

            Set<Character> between = new HashSet<>();
            for(int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }
            count += between.size();
        }
        return count;
    }
}
