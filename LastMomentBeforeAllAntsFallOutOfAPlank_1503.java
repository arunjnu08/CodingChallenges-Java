// https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/?envType=daily-question&envId=2023-11-04

class LastMomentBeforeAllAntsFallOutOfAPlank_1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int left_max = 0, right_min = n + 1;
        for(int inx : left) {
            left_max = Math.max(left_max, inx);
        }

        for(int inx : right) {
            right_min = Math.min(right_min, inx);
        }

        return Math.max(left_max, n - right_min);
    }
}
