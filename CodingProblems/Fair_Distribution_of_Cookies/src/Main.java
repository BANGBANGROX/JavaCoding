import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] cookies;
    private int[] distribute;
    private int n;
    private int k;

    private int dfs(int index, int remainingCount) {
        if (n - index < remainingCount) return Integer.MAX_VALUE;

        if (index == n) {
            return Arrays.stream(distribute).max().getAsInt();
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < k; ++i) {
            remainingCount -= (distribute[i] == 0 ? 1 : 0);
            distribute[i] += cookies[index];
            answer = Math.min(answer, dfs(index + 1, remainingCount));
            distribute[i] -= cookies[index];
            remainingCount += (distribute[i] == 0 ? 1 : 0);
        }

        return answer;
    }

    public int distributeCookies(int[] cookies, int k) {
         this.cookies = cookies;
         distribute = new int[k];
         n = cookies.length;
         this.k = k;

         return dfs(0, k);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] cookies = new int[n];
            for (int i = 0; i < n; ++i) {
                cookies[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.distributeCookies(cookies, k));
        }

        sc.close();
    }
}
