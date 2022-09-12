import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        int n = properties.length;
        int maxVal = Integer.MIN_VALUE;

        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        for (int i = n - 1; i >= 0; --i) {
            if (properties[i][1] < maxVal) ++ans;
            maxVal = Math.max(maxVal, properties[i][1]);
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
            int[][] properties = new int[n][2];
            for (int i = 0; i < n; ++i) {
                properties[i][0] = sc.nextInt();
                properties[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.numberOfWeakCharacters(properties));
        }

        sc.close();
    }
}
