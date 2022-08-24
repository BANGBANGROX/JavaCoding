import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    private boolean check(int start, String stamp, char[] targetArray) {
        int m = stamp.length();
        boolean res = false;

        for (int i = 0; i < m; ++i) {
            if (targetArray[start + i] == '?') continue;
            res = true;
            if (stamp.charAt(i) != targetArray[start + i]) return false;
        }

        return res;
    }

    public int[] movesToStamp(String stamp, String target) {
        int m = stamp.length();
        int n = target.length();
        int remaining = n;
        ArrayList<Integer> ans = new ArrayList<>();
        char[] targetArray = target.toCharArray();

        while (remaining > 0) {
            boolean flag = false;
            for (int i = 0; i < n - m + 1; ++i) {
                if (check(i, stamp, targetArray)) {
                    flag = true;
                    ans.add(i);
                    for (int j = 0; j < m; ++j) {
                        if (targetArray[i + j] != '?') {
                            targetArray[i + j] = '?';
                            --remaining;
                        }
                    }
                }
            }
            if (!flag) return new int[]{};
        }

        Collections.reverse(ans);
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); ++i) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String stamp = sc.next();
            String target = sc.next();

            Solution solution = new Solution();
            int[] ans = solution.movesToStamp(stamp, target);
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
