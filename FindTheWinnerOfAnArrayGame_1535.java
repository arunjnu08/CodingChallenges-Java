// https://leetcode.com/problems/find-the-winner-of-an-array-game/description/?envType=daily-question&envId=2023-11-05

class FindTheWinnerOfAnArrayGame_1535 {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int win = 0;
        int max = 0;
        for(int i = 1; i < n; i++) {
            if(arr[max] < arr[i]) {
                win = 0;
                max = i;
            }
            if(++win == k) return arr[max];
        }
        return arr[max];
    }
}
