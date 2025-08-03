import java.util.Scanner;

class Solution {
    private int[][] fruits;
    private int n;

    public int maxTotalFruits(final int[][] fruits, final int startPos, final int k) {
        this.fruits = fruits;
        n = fruits.length;
        int answer = 0;

        for (int i = 1; i < n; ++i) {
            fruits[i][1] += fruits[i - 1][1];
        }

        for (int d = 0; d <= k; ++d) {
            {
                final int left = startPos - d;
                final int right = startPos + k - 2 * d;
                final int idx1 = getIndexGreaterThanEqualToIdx(left);
                final int idx2 = getIndexLesserThanEqualToIdx(right);

                if (left > right) {
                    continue;
                }

                if (idx1 <= idx2) {
                    answer = Math.max(answer, fruits[idx2][1] - (idx1 > 0 ? fruits[idx1 - 1][1] : 0));
                }
            }

            {
                final int left = startPos - (k - 2 * d);
                final int right = startPos + d;

                if (left > right) {
                    continue;
                }

                final int idx1 = getIndexGreaterThanEqualToIdx(left);
                final int idx2 = getIndexLesserThanEqualToIdx(right);

                if (idx1 <= idx2) {
                    answer = Math.max(answer, fruits[idx2][1] - (idx1 > 0 ? fruits[idx1 - 1][1] : 0));
                }
            }
        }

        return answer;
    }

    private int getIndexGreaterThanEqualToIdx(final int idx) {
        int left = 0;
        int right = n - 1;
        int result = n;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));

            if (fruits[mid][0] >= idx) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int getIndexLesserThanEqualToIdx(final int idx) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            final int mid = (left + ((right - left) >> 1));

            if (fruits[mid][0] <= idx) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
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
           final int[][] fruits = new int[n][2];
           for (int i = 0; i < n; ++i) {
               fruits[i][0] = scanner.nextInt();
               fruits[i][1] = scanner.nextInt();
           }
           final int startPos = scanner.nextInt();
           final int k = scanner.nextInt();

           System.out.println(new Solution().maxTotalFruits(fruits, startPos, k));
       }
       
       scanner.close();
   }
}
