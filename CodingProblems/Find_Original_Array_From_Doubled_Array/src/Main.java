import java.util.Scanner;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        if ((n & 1) > 0) return new int[]{};

        final int MAX_N = (int) 1e5 + 5;
        int[] count = new int[MAX_N];
        int[] ans = new int[n / 2];
        int j = 0;

        for (int x: changed) {
            ++count[x];
        }

        for (int i = 0; i < MAX_N; ++i) {
            while (count[i] > 0 && i * 2 < MAX_N && count[i * 2] > 0) {
                --count[i];
                --count[i * 2];
                if (count[i * 2] < 0) return new int[]{};
                ans[j++] = i;
            }
        }

        for (int i = 0; i < MAX_N; ++i) {
            if (count[i] != 0) return new int[]{};
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] changed = new int[n];
            for (int i = 0; i < n; ++i) {
                changed[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.findOriginalArray(changed);
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
