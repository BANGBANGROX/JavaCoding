import java.util.*;

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Queue<Integer> q = new LinkedList<>();
        int[] changes = {jug1Capacity, jug2Capacity, -1 * jug1Capacity, -1 * jug2Capacity};
        HashSet<Integer> visited = new HashSet<>();

        if (jug1Capacity + jug2Capacity < targetCapacity) return false;

        visited.add(0);
        q.add(0);

        while (!q.isEmpty()) {
            int currentFilled = q.poll();
            if (currentFilled == targetCapacity) return true;
            for (int i = 0; i < 4; ++i) {
                int newFilled = currentFilled + changes[i];
                if (newFilled >= 0 && newFilled <= (jug1Capacity + jug2Capacity)
                        && !visited.contains(newFilled)) {
                    visited.add(newFilled);
                    q.add(newFilled);
                }
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int jug1Capacity = sc.nextInt();
            int jug2Capacity = sc.nextInt();
            int targetCapacity = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
        }

        sc.close();
    }
}
