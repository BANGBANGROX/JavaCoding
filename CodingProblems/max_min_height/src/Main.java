import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] arr;
    private int k;
    private int w;

    public int maxMinHeight(final int[] arr, final int k, final int w) {
        // code here
        this.arr = arr;
        this.k = k;
        this.w = w;
        final int minValue = Arrays.stream(arr).min().getAsInt();
        int left = minValue;
        int right = minValue + k;
        int answer = -1;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(final int target) {
        int netIncrease = 0;
        int daysNeeded = 0;
        final int n = arr.length;
        final int[] difference = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            netIncrease += difference[i];
            int currentHeight = arr[i] + netIncrease;
            if (currentHeight < target) {
                int diff = target - currentHeight;
                daysNeeded += diff;
                if (daysNeeded > k) {
                    return false;
                }
                difference[i] += diff;
                netIncrease += diff;
                difference[Math.min(i + w, n)] -= diff;
            }
        }

        return true;
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
           final int k = scanner.nextInt();
           final int w = scanner.nextInt();

           System.out.println(new Solution().maxMinHeight(arr, k, w));
       }
       
       scanner.close();
   }
}
