// https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2023-11-13

class SortVowelsInAString_2785 {
    public String sortVowels(String s) {
        char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> vowel_cnts = new HashMap<>();
        for(char vowel : vowels) vowel_cnts.put(vowel, 0);
        for(char c : s.toCharArray()) {
            if(vowel_cnts.containsKey(c)) {
                vowel_cnts.put(c, vowel_cnts.get(c) + 1);
            }
        }
        int inx = 0;
        for(char vowel : vowels) {
            if(vowel_cnts.get(vowel) == 0) {
                inx++;
            } else {
                break;
            }
        }

        char[] res = s.toCharArray();
        for(int i = 0; i < res.length; i++) {
            if(vowel_cnts.containsKey(res[i])) {
                res[i] = vowels[inx];
                vowel_cnts.put(vowels[inx], vowel_cnts.get(vowels[inx]) - 1);

                while(inx < vowels.length && vowel_cnts.get(vowels[inx]) == 0) {
                    inx++;
                }
            }
        }
        return String.valueOf(res);
    }
}
