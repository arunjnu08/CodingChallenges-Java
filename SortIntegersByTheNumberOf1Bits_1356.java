// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/?envType=daily-question&envId=2023-10-30 

public class SortIntegersByTheNumberOf1Bits_1356 {
    public int[] sortByBits(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int s, int e) {
        if(s == e) return;
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    private void merge(int[] arr, int s, int mid, int e) {
        int[] temp = new int[e - s + 1];
        int p1 = s, p2 = mid + 1, inx = 0;
        while(p1 <= mid || p2 <= e) {
            if(p1 > mid) {
                while(p2 <= e) {
                    temp[inx++] = arr[p2++];
                }
            } else if(p2 > e) {
                while(p1 <= mid) {
                    temp[inx++] = arr[p1++];
                }
            } else if(compare(arr[p1], arr[p2]) <= 0) {
                temp[inx++] = arr[p1++];
            } else {
                temp[inx++] = arr[p2++];
            }
        }
        inx = s;
        for(int x : temp) {
            arr[inx++] = x;
        }
    }

    private int compare(int a, int b) {
        int cnt_a = bitCount(a);
        int cnt_b = bitCount(b);
        return cnt_a == cnt_b ? a - b : cnt_a - cnt_b;
    }

    private int bitCount(int n) {
        int cnt = 0;
        while(n > 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1356 obj = new LeetCode1356();
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8};
        int[] res = obj.sortByBits(arr);

        for(int x : res) {
            System.out.print(x + "  ");
        }
        System.out.println();
    }
}
