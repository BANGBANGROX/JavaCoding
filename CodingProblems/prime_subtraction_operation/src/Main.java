import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean[] prime;

    private void init() {
        final int MAX_VALUE = 1005;
        prime = new boolean[MAX_VALUE + 1];

        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= MAX_VALUE; ++i) {
            if (prime[i]) {
                for (int j = 2 * i; j <= MAX_VALUE; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    private int findNumber(int num, int lastNum) {
        for (int i = num - 1; i >= 0; --i) {
            if (prime[i]) {
                if (num - i > lastNum) return num - i;
            }
        }

        return -1;
    }

    public boolean primeSubOperation(int[] nums) {
        init();

        int n = nums.length;
        int lastNum = findNumber(nums[0], -1);

        if (lastNum == -1) lastNum = nums[0];

        for (int i = 1; i < n; ++i) {
            int nextNum = findNumber(nums[i], lastNum);
            if (nextNum == -1 && nums[i] <= lastNum) return false;
            lastNum = (nextNum == -1 ? nums[i] : nextNum);
        }

        return true;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().primeSubOperation(nums));
       }
       
       scanner.close();
   }
}
