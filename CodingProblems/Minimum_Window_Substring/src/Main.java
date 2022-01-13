import java.util.Scanner;

class Solution {
    private int start, end;
    private final int[] frequency2 = new int[256];

    private boolean compare(int[] frequency1, int[] frequency2) {
        for (int i = 0; i < 256; ++i) {
            if (frequency1[i] < frequency2[i]) return false;
        }

        return true;
    }

    private boolean check(String s, String t, int len) {
        int n = s.length();
        int[] frequency1 = new int[256];
        int l = 0;
        int r = len - 1;

        for (int i = l; i <= r; ++i) {
            ++frequency1[s.charAt(i)];
        }

        while (r < n) {
            if (compare(frequency1, frequency2)) {
                start = l;
                end = r;
                return true;
            }
            --frequency1[s.charAt(l)];
            ++l;
            ++r;
            if (r < n) ++frequency1[s.charAt(r)];
        }

        return false;
    }

    public String minWindow(String s, String t) {
        int low = 1, high = s.length();
        start = end = -1;

        for (int i = 0; i < t.length(); ++i) {
            ++frequency2[t.charAt(i)];
        }

        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            if (check(s, t, mid)) high = mid - 1;
            else low = mid + 1;
        }

        if (start == -1) return "";

        return s.substring(start, end + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            String t = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.minWindow(s, t));
        }

        sc.close();
    }
}
