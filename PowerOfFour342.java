/*
https://leetcode.com/problems/power-of-four/?envType=daily-question&envId=2023-10-23
*/

class PowerOfFour342 {
    public boolean isPowerOfFour(int n) {
        while(n > 0) {
            if(n == 1) return true;
            if((n & 3) != 0) return false;
            n = (n >> 2);
        }
        return false;
    }
}
