// https://leetcode.com/problems/minimum-time-visiting-all-points/submissions/1111204536/?envType=daily-question&envId=2023-12-03

class MinimumTimeVisitingAllPoints_1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int pre = 0;

        for(int i = 1; i < points.length; i++) {
            ans += Math.max(Math.abs(points[i][0] - points[pre][0]), Math.abs(points[i][1] - points[pre][1]));
            pre = i;
        }

        return ans;
    }
}
