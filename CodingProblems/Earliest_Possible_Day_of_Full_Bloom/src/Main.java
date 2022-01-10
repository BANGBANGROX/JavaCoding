import java.util.*;

class Solution {
    private static class PAIR {
        public int x, y;
        public PAIR(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<PAIR> flowers = new ArrayList<>();
        int n = plantTime.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            flowers.add(new PAIR(growTime[i], plantTime[i]));
        }

        flowers.sort(Comparator.comparingInt(a -> a.x));

        for (PAIR flower : flowers) {
            ans += Math.max(ans, flower.x) + flower.y;
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
            int[] plantTime = new int[n];
            int[] growthTime = new int[n];
            for (int i = 0; i < n; ++i) plantTime[i] = sc.nextInt();
            for (int j = 0; j < n; ++j) growthTime[j] = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.earliestFullBloom(plantTime, growthTime));
        }

        sc.close();
    }
}
