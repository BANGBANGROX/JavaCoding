import java.util.Scanner;

class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int onesCount = 0;
        int zeroesCount = 0;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                ++zeroesCount;
            }
            else {
                while (i < n && s.charAt(i) == '1') {
                    ++onesCount;
                    ++i;
                    if (zeroesCount >= onesCount) {
                        ans = Math.max(ans, 2 * onesCount);
                    }
                }
                zeroesCount = 0;
                onesCount = 0;
                if (i < n) ++zeroesCount;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
