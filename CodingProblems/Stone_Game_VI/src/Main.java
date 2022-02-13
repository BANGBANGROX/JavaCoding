import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static class Stone {
        int sum;
        int index;
        public Stone(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int aliceScore = 0;
        int bobScore = 0;
        boolean turn = true;
        Stone[] stones = new Stone[n];

        for (int i = 0; i < n; ++i) {
            stones[i] = new Stone(aliceValues[i] + bobValues[i], i);
        }

        Arrays.sort(stones,(a, b) -> (b.sum - a.sum));

        for (Stone stone : stones) {
            if (turn) {
                aliceScore += aliceValues[stone.index];
            }
            else {
                bobScore += bobValues[stone.index];
            }
            turn = !turn;
        }

        return Integer.compare(aliceScore, bobScore);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] aliceValues = new int[n];
            for (int i = 0; i < n; ++i) {
                aliceValues[i] = sc.nextInt();
            }
            int[] bobValues = new int[n];
            for (int i = 0; i < n; ++i) {
                bobValues[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.stoneGameVI(aliceValues, bobValues));
        }

        sc.close();
    }
}
