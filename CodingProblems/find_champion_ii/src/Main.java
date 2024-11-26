import java.util.Scanner;

class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        int answer = -1;

        for (int[] edge : edges) {
            ++inDegree[edge[1]];
        }

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                if (answer == -1) {
                    answer = i;
                } else {
                    return -1;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int m = scanner.nextInt();
           int[][] edges = new int[m][2];
           for (int i = 0; i < m; ++i) {
               edges[i][0] = scanner.nextInt();
               edges[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().findChampion(n, edges));
       }
       
       scanner.close();
   }
}
