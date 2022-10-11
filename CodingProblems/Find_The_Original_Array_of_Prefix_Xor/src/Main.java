import java.util.Scanner;

class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];

        ans[0] = pref[0];

        for (int i = 1; i < n; ++i) {
            ans[i] = pref[i] ^ pref[i - 1];
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
            int[] pref = new int[n];
            for (int i = 0; i < n; ++i) {
                pref[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.findArray(pref);
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
