import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int tallestBillboard(int[] rods) {
        HashMap<Integer, Integer> dp = new HashMap<>();

        dp.put(0, 0);

        for (int rod : rods) {
            HashMap<Integer, Integer> nextDp = new HashMap<>(dp);
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int difference = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - difference;
                int newTaller = nextDp.getOrDefault(difference + rod, 0);
                nextDp.put(difference + rod, Math.max(newTaller, taller + rod));
                int newDifference = Math.abs(shorter + rod - taller);
                int newTaller2 = Math.max(shorter + rod, taller);
                nextDp.put(newDifference, Math.max(newTaller2,
                        nextDp.getOrDefault(newDifference, 0)));
            }
            dp = nextDp;
        }

        return dp.getOrDefault(0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] rods = new int[n];
            for (int i = 0; i < n; ++i) {
                rods[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.tallestBillboard(rods));
        }

        sc.close();
    }
}
