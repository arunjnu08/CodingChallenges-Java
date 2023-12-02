// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/?envType=daily-question&envId=2023-12-02

class FindWordsThatCanBeFormedByCharacters_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] char_freq = new int[26];
        for(char ch : chars.toCharArray()) char_freq[ch - 'a']++;

        int ans = 0;

        for(String word : words) {
            int[] freq = new int[26];
            for(char c : word.toCharArray()) freq[c - 'a']++;
            boolean flag = true;
            for(int i = 0; i < 26; i++) {
                if(freq[i] > char_freq[i]) {
                    flag = false;
                    break;
                }
            }
            ans += flag ? word.length() : 0;
        }
        return ans;
    }
}
