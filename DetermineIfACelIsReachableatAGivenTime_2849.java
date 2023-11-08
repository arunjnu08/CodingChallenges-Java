// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/submissions/1094067817/?envType=daily-question&envId=2023-11-08

class DetermineIfACelIsReachableatAGivenTime_2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy && t == 1) return false;
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }
}
