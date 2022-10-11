import java.util.Scanner;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        int prevIndex = 0;

        for (int i = 1; i < n; ++i) {
            if (colors.charAt(i) != colors.charAt(prevIndex)) {
                prevIndex = i;
            }
            else {
                if (neededTime[prevIndex] < neededTime[i]) {
                    ans += neededTime[prevIndex];
                    prevIndex = i;
                }
                else ans += neededTime[i];
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
            String colors = sc.next();
            int n = sc.nextInt();
            int[] neededTime = new int[n];
            for (int i = 0; i < n; ++i) {
                neededTime[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.minCost(colors, neededTime));
        }

        sc.close();
    }
}
