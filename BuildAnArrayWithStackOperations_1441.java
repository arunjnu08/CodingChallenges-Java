// https://leetcode.com/problems/build-an-array-with-stack-operations/description/?envType=daily-question&envId=2023-11-03

class BuildAnArrayWithStackOperations_1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int num = 1;

        for(int x : target) {
            while(true) {
                res.add("Push");
                if(num == x) {
                    break;
                } else {
                    res.add("Pop");
                }
                num++;
            }
            num++;
        }
        return res;
    }
}
