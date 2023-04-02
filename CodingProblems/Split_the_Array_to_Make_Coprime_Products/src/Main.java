import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int findValidSplit(int[] nums) {
        final int MAX_N = 1_000_005;
        int[] lastIndex = new int[MAX_N];
        int n = nums.length;
        HashSet<Integer> primeFactors = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
                if (num % j == 0) {
                    lastIndex[j] = i;
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }
            if (num > 1) lastIndex[num] = 1;
        }

        for (int i = 0; i < n - 1; ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
                if (num % j == 0) {
                    primeFactors.add(j);
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }
            if (num > 1) {
                primeFactors.add(num);
            }

        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
