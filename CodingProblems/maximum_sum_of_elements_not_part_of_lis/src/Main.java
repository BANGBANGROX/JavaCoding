import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int nonLisMaxSum(int[] arr) {
        // code here
        final int n = arr.length;
        final int[] lisSum = new int[n + 1];
        final List<Integer> dp = new ArrayList<>();;

        for (int num : arr) {
            final int idx;

            if (dp.isEmpty() || dp.get(dp.size() - 1) < num) {
                dp.add(num);
                idx = dp.size() - 1;
            } else {
                idx = lowerBound(dp, num);
                dp.set(idx, num);
            }

            lisSum[idx + 1] = lisSum[idx] + num;
        }

        return Arrays.stream(arr).sum() - lisSum[dp.size()];
    }

    private int lowerBound(final List<Integer> list, final int key) {
        int left = 0;
        int right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (list.get(mid) >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] arr = new int[n];
           for (int i = 0; i < n; ++i) {
               arr[i] = scanner.nextInt();
           }

           System.out.println(new Solution().nonLisMaxSum(arr));
       }
       
       scanner.close();
   }
}
