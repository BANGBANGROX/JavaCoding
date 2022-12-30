import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int ans = 0;
        int n = rocks.length;

        for (int i = 0; i < n; ++i) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);

        for (int i = 0; i < n; ++i) {
            if (capacity[i] > additionalRocks) break;
            else {
                ++ans;
                additionalRocks -= capacity[i];
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
            int n = sc.nextInt();
            int[] capacity = new int[n];
            for (int i = 0; i < n; ++i) {
                capacity[i] = sc.nextInt();
            }
            int[] rocks = new int[n];
            for (int i = 0; i < n; ++i) {
                rocks[i] = sc.nextInt();
            }
            int additionalRocks = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maximumBags(capacity, rocks, additionalRocks));
        }

        sc.close();
    }
}
