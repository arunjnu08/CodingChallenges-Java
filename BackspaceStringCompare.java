/*
* https://leetcode.com/problems/backspace-string-compare/?envType=daily-question&envId=2023-10-19
* */

class LeetCode844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int cnt;

        while (i >= 0 && j >= 0) {
            cnt = 0;
            while(i >= 0) {
                if(s.charAt(i) == '#') {
                    cnt++;
                } else {
                    cnt--;
                    if(cnt < 0) break;
                }
                i--;
            }

            cnt = 0;
            while (j >= 0) {
                if(t.charAt(j) == '#') {
                    cnt++;
                } else {
                    cnt--;
                    if(cnt < 0) break;
                }
                j--;
            }

            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if((i < 0 && j >= 0) || (i >= 0 && j < 0)) {
                return false;
            }

            i--; j--;
        }

        cnt = 0;
        while (i >= 0) {
            if(s.charAt(i) == '#') {
                cnt++;
            } else {
                cnt--;
                if(cnt < 0) break;
            }
            i--;
        }

        cnt = 0;
        while (j >= 0) {
            if(t.charAt(j) == '#') {
                cnt++;
            } else {
                cnt--;
                if(cnt < 0) break;
            }
            j--;
        }

        return (i <0 && j < 0);
    }

    public static void main(String[] args) {
        LeetCode844 obj = new LeetCode844();
        String s = "ef";
        String t = "####ef";

        System.out.println(obj.backspaceCompare(s, t));
    }
}
