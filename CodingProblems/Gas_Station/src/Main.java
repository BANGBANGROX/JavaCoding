import java.util.Scanner;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n = gas.length;
         int candidateIndex = 0;
         int net = 0;

         for (int i = 0; i < n; ++i) {
             net += (gas[i] - cost[i]);
             if (net < 0) {
                 candidateIndex = i + 1;
                 net = 0;
             }
         }

         if (candidateIndex == n) return -1;

         int ind = candidateIndex;
         boolean started = false;
         net = 0;

         while (ind != candidateIndex || !started) {
             started = true;
             net += (gas[ind] - cost[ind]);
             if (net < 0) return -1;
             ind = (ind + 1) % n;
         }

         return candidateIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] gas = new int[n];
            for (int i = 0; i < n; ++i) {
                gas[i] = sc.nextInt();
            }
            int[] cost = new int[n];
            for (int i = 0; i < n; ++i) {
                cost[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.canCompleteCircuit(gas, cost));
        }

        sc.close();
    }
}
