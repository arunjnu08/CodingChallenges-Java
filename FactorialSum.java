import java.util.*;

class FactorialSum {
    public static int factorialSum(int array_length, List<Integer> arr) {
        Set<Integer>[] fact = new HashSet[10];
        calculateFact(fact);
        int ans = 0;
        
        for(int num : arr) {
            if(isValid(num, fact)) {
                // System.out.println("num = " + num);
                ans++;
            }
        }
        return ans;
    }
    
    private static void calculateFact(Set<Integer>[] fact) {
        int mul = 1;
        for(int i = 1; i <= 9; i++) {
            mul *= i;
            int temp = mul;
            fact[i] = new HashSet<>();
            
            while(temp > 0) {
                fact[i].add(temp % 10);
                temp = temp / 10;
            }
        }
    }
    
    private static boolean isValid(int num, Set<Integer>[] fact) {
        int temp = num;
        int sum = 0;
        
        while(temp > 9) {
            while(temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            temp = sum;
            sum = 0;
        }
        sum = temp;
        temp = num;
        
        while(temp > 0) {
            if(!fact[sum].contains(temp % 10)) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        List<Integer> list = new ArrayList<>();
        list.add(310);
        list.add(845);
        list.add(360);
        list.add(122);
        list.add(123456789);
        list.add(11111);
        System.out.println(factorialSum(5, list));
    }
}
