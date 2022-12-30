import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int[] cycleLengthQueries(int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int result = 1;
            while (a != b) {
                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                a /= 2;
                ++result;
            }
            ans.add(result);
        }

        return ans.stream().mapToInt(a -> a).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] queries = new int[n][2];
            for (int i = 0; i < n; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.cycleLengthQueries(queries);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
