import java.util.Scanner;

class Solution {
    public long minEnd(int n, int x) {
        final int MAX_BITS = 64;
        int[] bits = new int[MAX_BITS];
        int bitCounter = 0;
        long answer = 0;

        --n;

        for (int i = 0; i < MAX_BITS; ++i) {
            if ((x & (1L << i)) > 0) {
                bits[i] = 1;
            }
        }

        for (int i = 0; i < MAX_BITS; ++i) {
            if (bits[i] == 0) {
                if ((n & (1L << bitCounter)) > 0) {
                    bits[i] = 1;
                }
                ++bitCounter;
            }
        }

        for (int i = 0; i < MAX_BITS; ++i) {
            if (bits[i] == 1) {
                answer |= (1L << i);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            System.out.println(new Solution().minEnd(n, x));
        }

        sc.close();
    }
}
