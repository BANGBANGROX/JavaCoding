import java.util.Scanner;

class Solution {
    private int calculateTime(String[] garbage, int[] travel, String g) {
        int n = garbage.length;
        int lastIdx = 0;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (garbage[i].contains(g)) lastIdx = i;
        }

        for (int i = 0; i < garbage[0].length(); ++i) {
            if (garbage[0].charAt(i) == g.charAt(0)) ++ans;
        }

        for (int i = 1; i <= lastIdx; ++i) {
            ans += travel[i - 1];
            for (char ch: garbage[i].toCharArray()) {
                if (ch == g.charAt(0)) ++ans;
            }
        }

        return ans;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        return calculateTime(garbage, travel, "P") + calculateTime(garbage, travel, "G")
                + calculateTime(garbage, travel, "M");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] garbage = new String[n];
            for (int i = 0; i < n; ++i) {
                garbage[i] = sc.next();
            }
            int[] travel = new int[n - 1];
            for (int i = 1; i < n; ++i) {
                travel[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.garbageCollection(garbage, travel));
        }

        sc.close();
    }
}
