import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] arr;
    private int k;

    public int kokoEat(final int[] arr, final int k) {
        // code here
        this.arr = arr;
        this.k = k;
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(final int s) {
        int totalHours = 0;

        for (final int num : arr) {
            totalHours += (int) Math.ceil((double) num / s);
            if (totalHours > k) {
                return false;
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

           System.out.println(new Solution().kokoEat(arr, k));
       }
       
       scanner.close();
   }
}
