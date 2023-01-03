import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> primeFactors = new HashSet<>();

        for (int num : nums) {
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    primeFactors.add(i);
                    while (num % i == 0) num /= i;
                }
            }
            if (num > 1) primeFactors.add(num);
        }

        return primeFactors.size();
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
            System.out.println(solution.distinctPrimeFactors(nums));
        }

        sc.close();
    }
}
