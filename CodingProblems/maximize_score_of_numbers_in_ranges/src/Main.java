import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] start;
    private int d;

    private boolean check(int val) {
        long current = start[0];
        int n = start.length;

        for (int i = 1; i < n; ++i) {
            long next = Math.max(current + val, start[i]);
            if (next > start[i] + d) return false;
            current = next;
        }

        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);

        this.start = start;
        this.d = d;
        int n = start.length;
        int left = 0;
        int right = start[n - 1] - start[0] + d;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] start = new int[n];
           for (int i = 0; i < n; ++i) {
               start[i] = scanner.nextInt();
           }
           int d = scanner.nextInt();

           System.out.println(new Solution().maxPossibleScore(start, d));
       }
       
       scanner.close();
   }
}
