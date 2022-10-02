import java.util.Scanner;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int totalSetBits = 0;
        int[] bits = new int[32];
        int ans = 0;

        while (num2 > 0) {
            if ((num2 & 1) > 0) ++totalSetBits;
            num2 /= 2;
        }

        for (int i = 31; i >= 0 && totalSetBits > 0; --i) {
            if ((num1 & (1 << i)) == 0) continue;
            bits[i] = 1;
            --totalSetBits;
        }

        for (int i = 0; i < 32 && totalSetBits > 0; ++i) {
            if (bits[i] == 0) {
                bits[i] = 1;
                --totalSetBits;
            }
        }

        for (int i = 31; i >= 0; --i) {
            ans = ans * 2 + bits[i];
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimizeXor(num1, num2));
        }

        sc.close();
    }
}
