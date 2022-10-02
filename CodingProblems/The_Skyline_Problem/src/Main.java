import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         List<List<Integer>> ans = new ArrayList<>();
         ArrayList<ArrayList<Integer>> xAndH = new ArrayList<>();
         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

         for (int[] building: buildings) {
             int x = building[0];
             int y = building[1];
             int h = building[2];
             xAndH.add(new ArrayList<>(Arrays.asList(x, -1 * h)));
             xAndH.add(new ArrayList<>(Arrays.asList(y, h)));
         }

        xAndH.sort((a, b) -> !Objects.equals(a.get(0), b.get(0)) ?
                a.get(0) - b.get(0) : a.get(1) - b.get(1));

         pq.add(0);
         int previousMax = 0;

         for (ArrayList<Integer> b: xAndH) {
             int x = b.get(0);
             int h = b.get(1);
             if (h < 0) pq.add(-1 * h);
             else {
                 pq.remove(h);
             }
             assert pq.peek() != null;
             int currentMax = pq.peek();
             if (currentMax != previousMax) {
                 ans.add(new ArrayList<>(Arrays.asList(x, currentMax)));
                 previousMax = currentMax;
             }
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
            int[][] buildings = new int[n][3];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 3; ++j) {
                    buildings[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.getSkyline(buildings));
        }

        sc.close();
    }
}
