import java.util.Scanner;

class Solution {
    private int lowerBound(int[] nums, int left, int right, int key) {
        int result = right + 1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (nums[mid] >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public long[] countKConstraintSubstrings(String s, int k,
                                             int[][] queries) {
        int n = s.length();
        int q = queries.length;
        long[] answer = new long[q];
        int[] lastIndex = new int[n];
        long[] lengthPrefixSum = new long[n];
        int left = 0;
        int onesCnt = 0;
        int zeroesCnt = 0;

        for (int right = 0; right < n; ++right) {
            if (s.charAt(right) == '0') {
                ++zeroesCnt;
            } else {
                ++onesCnt;
            }
            while (zeroesCnt > k && onesCnt > k) {
                if (s.charAt(left) == '0') {
                    --zeroesCnt;
                } else {
                    --onesCnt;
                }
                ++left;
            }
            lastIndex[right] = left;
            lengthPrefixSum[right] = right - left + 1;
        }

        for (int i = 1; i < n; ++i) {
            lengthPrefixSum[i] += lengthPrefixSum[i - 1];
        }

        for (int i = 0; i < q; ++i) {
            int leftEnd = queries[i][0];
            int rightEnd = queries[i][1];
            int idx = lowerBound(lastIndex, leftEnd, rightEnd, leftEnd);
            long result = (lengthPrefixSum[rightEnd] - (idx > 0 ? lengthPrefixSum[idx - 1] : 0));
            idx -= leftEnd;
            result += (long) idx * (idx + 1) / 2;
            answer[i] = result;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           String s = scanner.next();
           int k = scanner.nextInt();
           int q = scanner.nextInt();
           int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           long[] answer = new Solution().countKConstraintSubstrings(s, k, queries);
           for (long x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
   }
}
