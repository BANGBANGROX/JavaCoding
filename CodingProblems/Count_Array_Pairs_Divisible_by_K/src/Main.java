import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int findGCD(int a, int b) {
       if (b == 0) return a;

       return findGCD(b, a % b);
    }

    public long countPairs(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer,Integer> gcdFrequency = new HashMap<>();

        for (int num : nums) {
            int gcd = findGCD(num, k);
            for (int numGCD : gcdFrequency.keySet()) {
                if (((long)gcd * numGCD) % k == 0) ans += gcdFrequency.get(numGCD);
            }
            gcdFrequency.put(gcd, gcdFrequency.getOrDefault(gcd, 0) + 1);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countPairs(nums, k));
        }

        sc.close();
    }
}
