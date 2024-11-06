import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int countSetBits(int num) {
        int result = 0;

        while (num > 0) {
            if ((num & 1) > 0) {
                ++result;
            }
            num >>= 1;
        }

        return result;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left;
            --right;
        }
    }

    public boolean canSortArray(int[] nums) {
        int[] tempArray = Arrays.copyOf(nums, nums.length);
        int n = tempArray.length;

        Arrays.sort(tempArray);

        for (int i = 0; i < n; ++i) {
            if (tempArray[i] == nums[i]) continue;
            int requiredSetBitCnt = countSetBits(tempArray[i]);
            int idx = -1;
            for (int j = i; j < n; ++j) {
                int cnt = countSetBits(nums[j]);
                if (cnt != requiredSetBitCnt) return false;
                if (tempArray[i] == nums[j]) {
                    idx = j;
                    break;
                }
            }
            reverse(nums, i, idx);
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

           System.out.println(new Solution().canSortArray(nums));
       }
       
       scanner.close();
   }
}
