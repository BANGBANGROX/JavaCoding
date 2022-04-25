import java.util.Scanner;

class Solution {
    private int findMaxElementIndex(int[] nums) {
        int n = nums.length;
        int maxNum = nums[0];
        int index = 0;

        for (int i = 1; i < n; ++i) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
        }

        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int l = 0;
        int r = m - 1;

        if (m == 1) return new int[]{0, findMaxElementIndex(mat[0])};

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int index = findMaxElementIndex(mat[mid]);
            if (mid == 0) {
                if (mat[mid][index] > mat[mid + 1][index]) return new int[]{mid, index};
                l = mid + 1;
            }
            else if (mid == m - 1) {
                if (mat[mid][index] > mat[mid - 1][index]) return new int[]{mid, index};
                r = mid - 1;
            }
            else {
                if (mat[mid][index] > mat[mid + 1][index] && mat[mid][index] > mat[mid - 1][index])
                    return new int[]{mid, index};
                else if (mat[mid][index] < mat[mid + 1][index]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return new int[]{-1 , -1};
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] mat = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    mat[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            int[] ans = solution.findPeakGrid(mat);
            System.out.println(ans[0] + " " + ans[1]);
        }

        sc.close();
    }
}
