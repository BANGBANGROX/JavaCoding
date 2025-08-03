import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(final int[][] mat, final int[][] opr) {
        // code here
        final int m = mat.length;
        final int n = mat[0].length;
        final ArrayList<ArrayList<Integer>> differenceMatrix = new ArrayList<>();
        final ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i <= m; ++i) {
            final ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j <= n; ++j) {
                row.add(0);
            }

            differenceMatrix.add(row);
        }

        for (final int[] current : opr) {
            final int v = current[0];
            final int r1 = current[1];
            final int c1 = current[2];
            final int r2 = current[3];
            final int c2 = current[4];

            differenceMatrix.get(r1).set(c1, differenceMatrix.get(r1).get(c1) + v);
            differenceMatrix.get(r2 + 1).set(c2 + 1, differenceMatrix.get(r2 + 1).get(c2 + 1) + v);
            differenceMatrix.get(r1).set(c2 + 1, differenceMatrix.get(r1).get(c2 + 1) - v);
            differenceMatrix.get(r2 + 1).set(c1, differenceMatrix.get(r2 + 1).get(c1) - v);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                differenceMatrix.get(i).set(j, differenceMatrix.get(i).get(j - 1) + differenceMatrix.get(i).get(j));
            }
        }

        for (int j = 0; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                differenceMatrix.get(i).set(j, differenceMatrix.get(i - 1).get(j) + differenceMatrix.get(i).get(j));
            }
        }

        for (int i = 0; i < m; ++i) {
            final ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; ++j) {
                row.add(mat[i][j] + differenceMatrix.get(i).get(j));
            }

            answer.add(row);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int m = scanner.nextInt();
           final int n = scanner.nextInt();
           final int[][] mat = new int[m][n];
           for (int i = 0; i < m; ++i) {
               for (int j = 0; j < n; ++j) {
                   mat[i][j] = scanner.nextInt();
               }
           }
           final int q = scanner.nextInt();
           final int[][] opr = new int[q][4];
           for (int i = 0; i < q; ++i) {
               for (int j = 0; j < 4; ++j) {
                   opr[i][j] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().applyDiff2D(mat, opr));
       }
       
       scanner.close();
   }
}
