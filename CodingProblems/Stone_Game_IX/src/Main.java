import java.util.Scanner;

class Solution {
    private boolean stoneGameIXUtil(int x, int[] stones) {
        int[] count = new int[3];
        int n = stones.length;
        int sum = 0;
        int res = 0;

        for (int stone : stones) {
            ++count[stone % 3];
        }

        if (count[x] == 0) return false;

        sum += x;
        ++res;
        --count[x];

        while (sum % 3 != 0) {
            if (sum == 1) {
                if (count[1] > 0) {
                    ++sum;
                    --count[1];
                }
                else if (count[0] > 0) {
                    --count[0];
                }
                else break;
            }
            else if (sum == 2) {
                if (count[2] > 0) {
                    sum = 1;
                    --count[2];
                }
                else if (count[0] > 0) {
                    --count[0];
                }
                else break;
            }
            ++res;
        }

        return res != n && res % 2 == 1;
    }

    public boolean stoneGameIX(int[] stones) {
          return stoneGameIXUtil(1, stones) || stoneGameIXUtil(2, stones);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] stones = new int[n];
            for (int i = 0; i < n; ++i) {
                stones[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.stoneGameIX(stones));
        }

        sc.close();
    }
}
