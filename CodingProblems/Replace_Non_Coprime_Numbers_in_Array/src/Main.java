import java.util.*;

class Solution {
    private int findGCD(int a, int b) {
        if (b == 0) return a;

        return findGCD(b, a % b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
         LinkedList<Integer> ans = new LinkedList<>();

         for (int num : nums) {
             while (true) {
                 int last = ans.size() == 0 ? 1 : ans.getLast();
                 int gcd = findGCD(last, num);
                 if (gcd == 1) break;
                 if (ans.size() > 0) ans.removeLast();
                 long product = (long)num * last;
                 product /= gcd;
                 num = (int)product;
             }
             ans.add(num);
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

            Solution solution = new Solution();
            System.out.println(solution.replaceNonCoprimes(nums));
        }

        sc.close();
    }
}
