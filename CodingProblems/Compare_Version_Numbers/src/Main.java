import java.util.Scanner;

class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();

        for (int i = 0, j = 0; i < m || j < n; ++i, ++j) {
            int currentRevision1 = 0;
            int currentRevision2 = 0;
            while (i < m && version1.charAt(i) != '.') {
                currentRevision1 = currentRevision1 * 10 + (version1.charAt(i) - '0');
                ++i;
            }
            while (j < n && version2.charAt(j) != '.') {
                currentRevision2 = currentRevision2 * 10 + (version2.charAt(j) - '0');
                ++j;
            }
            if (currentRevision1 > currentRevision2) return 1;
            if (currentRevision2 > currentRevision1) return -1;
        }

        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String version1 = sc.next();
            String version2 = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.compareVersion(version1, version2));
        }

        sc.close();
    }
}
