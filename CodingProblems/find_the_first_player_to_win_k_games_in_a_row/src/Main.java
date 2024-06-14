import java.util.*;

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int cnt = 0;
        int first = 0;

        for (int i = 1; i < n; ++i) {
            if (skills[i] < skills[first]) {
                ++cnt;
            } else {
                cnt = 1;
                first = i;
            }
            if (cnt >= k) return first;
        }

        return first;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] skills = new int[n];
            for (int i = 0; i < n; ++i) {
                skills[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().findWinningPlayer(skills, k));
        }

        sc.close();
    }
}
