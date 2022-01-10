import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
           int m = triangle.size();
           List<Integer> dp = triangle.get(m - 1);

           for (int i = m - 2; i >= 0; --i) {
               List<Integer> newState = new ArrayList<>();
               int n = dp.size();
               for (int j = 0; j < n - 1; ++j) {
                   newState.add(triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j + 1)));
               }
               dp = newState;
           }

           return dp.get(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            List<List<Integer>> triangle = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                List<Integer> currentList = new ArrayList<>();
                for (int j = 0; j <= i; ++j) {
                    int x = sc.nextInt();
                    currentList.add(x);
                }
                triangle.add(currentList);
            }

            Solution obj = new Solution();
            System.out.println(obj.minimumTotal(triangle));
        }

        sc.close();
    }
}
