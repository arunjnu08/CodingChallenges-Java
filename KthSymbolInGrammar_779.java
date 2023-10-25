/*
https://leetcode.com/problems/k-th-symbol-in-grammar/?envType=daily-question&envId=2023-10-25
*/

class KthSymbolInGrammar_779 {
    public int kthGrammar(int n, int k) {
        while(n > 2 && k > 2) {
            int half_len = (1 << (n - 2));
            if(k > half_len) {
                k -= half_len;
                int one_fourth_len = (half_len >> 1);
                if(k > one_fourth_len) {
                    k -= one_fourth_len;
                } else {
                    k += one_fourth_len;
                }
            }
            n--;
        }
        return k - 1;
    }
}
