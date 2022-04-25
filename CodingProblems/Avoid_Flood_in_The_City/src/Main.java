import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> filledLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int n = rains.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            if (rains[i] > 0) {
                ans[i] = -1;
                if (!filledLakes.containsKey(rains[i])) {
                    filledLakes.put(rains[i], i);
                }
                else {
                    int idx = filledLakes.get(rains[i]);
                    if (dryDays.higher(idx) == null) return new int[]{};
                    else {
                        int val = dryDays.higher(idx);
                        ans[val] = rains[idx];
                        dryDays.remove(val);
                    }
                    filledLakes.put(rains[i], i);
                }
            }
            else dryDays.add(i);
        }

        for (int i = 0; i < n; ++i) {
            if (ans[i] == 0) ans[i] = 1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] rains = new int[n];
            for (int i = 0; i < n; ++i) {
                rains[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.avoidFlood(rains);
            for (int i = 0; i < n; ++i) {
                System.out.print(ans[i] + " ");
            }
        }

        sc.close();
    }
}
