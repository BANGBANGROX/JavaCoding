import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    private int[][] items;
    private int n;

    private int findIndex(int maxPrice) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (items[mid][0] <= maxPrice) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        n = items.length;
        int q = queries.length;
        int[] answer = new int[q];
        this.items = items;

        for (int i = 1; i < n; ++i) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        for (int i = 0; i < q; ++i) {
            int idx = findIndex(queries[i]);
            answer[i] = (idx != -1 ? items[idx][1] : 0);
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
           int[][] items = new int[n][2];
           for (int i = 0; i < n; ++i) {
               items[i][0] = scanner.nextInt();
               items[i][1] = scanner.nextInt();
           }
           int q = scanner.nextInt();
           int[] queries = new int[q];
           for (int i = 0; i < q; ++i) {
               queries[i] = scanner.nextInt();
           }

           int[] answer = new Solution().maximumBeauty(items, queries);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
