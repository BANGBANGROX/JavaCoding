import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] nums;
    private int[] sortedNums;
    private int n;

    private int[] rotate(int pos) {
        int[] next = new int[n];
        int itr = 0;
        int start = pos;

        while (start < n) {
            next[itr] = sortedNums[start];
            ++itr;
            ++start;
        }

        start = 0;

        while (start < pos) {
            next[itr] = sortedNums[start];
            ++itr;
            ++start;
        }

        return next;
    }

    private boolean compare(int[] rotatedArray) {
        for (int i = 0; i < n; ++i) {
            if (rotatedArray[i] != nums[i]) return false;
        }

        return true;
    }

    public boolean check(int[] nums) {
        n = nums.length;
        sortedNums = new int[n];
        this.nums = nums;

        System.arraycopy(nums, 0, sortedNums, 0, n);

        Arrays.sort(sortedNums);

        for (int pos = 0; pos < n; ++pos) {
            if (compare(rotate(pos))) return true;
        }

        return false;
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

           System.out.println(new Solution().check(nums));
       }
       
       scanner.close();
   }
}
