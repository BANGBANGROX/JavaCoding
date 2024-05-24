import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int findIndexLessThanEqualTo(ArrayList<Integer> defaultingIndices, int lower) {
        int left = 0;
        int right = defaultingIndices.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (defaultingIndices.get(mid) >= lower) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result != -1 ? defaultingIndices.get(result) : -1;
    }

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        boolean[] answer = new boolean[q];
        ArrayList<Integer> defaultingIndices = new ArrayList<>();

        for (int i = 1; i < n; ++i) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                defaultingIndices.add(i);
            }
        }

        for (int i = 0; i < q; ++i) {
            int lower = queries[i][0] + 1;
            int upper = queries[i][1];
            int idx = findIndexLessThanEqualTo(defaultingIndices, lower);
            answer[i] = (idx == -1 || idx > upper);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int q = sc.nextInt();
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }

            boolean[] answer = new Solution().isArraySpecial(nums, queries);
            for (boolean x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
