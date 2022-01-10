import java.util.Scanner;

class Solution {
    public int numTrees(int n) {
        long ans = 1;

        for (int i = 1; i <= n; ++i) {
            ans *= (n + i);
            ans /= i;
        }
        ans /= (n + 1);

        return (int)ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.numTrees(n));
        }

        sc.close();
    }
}
