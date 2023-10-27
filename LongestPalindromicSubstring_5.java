/*
https://leetcode.com/problems/longest-palindromic-substring/?envType=daily-question&envId=2023-10-27
*/

class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int min_left = -1, max_right = -1, max = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int left = i, right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            int len = right - left - 1;
            if(len > max) {
                max = len;
                min_left = left;
                max_right = right;
            }

            left = i - 1; right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--; right++;
            }
            len = right - left - 1;
            if(len > max) {
                max = len;
                min_left = left;
                max_right = right;
            }
        }
        return s.substring(min_left + 1, max_right);
    }
}
