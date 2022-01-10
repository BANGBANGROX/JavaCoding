import java.util.Scanner;

class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;

        for (int len = 1; len <= k; ++len) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return len;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int k = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.smallestRepunitDivByK(k));
        }

        sc.close();
    }
}
