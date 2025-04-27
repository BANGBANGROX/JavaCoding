import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int countCoveredBuildings(final int n, final int[][] buildings) {
        final Map<Integer, List<Integer>> xCoordinates = new HashMap<>();
        final Map<Integer, List<Integer>> yCoordinates = new HashMap<>();
        int answer = 0;

        for (final int[] building : buildings) {
            final int x = building[0];
            final int y = building[1];
            if (!xCoordinates.containsKey(x)) {
                xCoordinates.put(x, new ArrayList<>(List.of(y, y)));
            } else {
                xCoordinates.get(x).set(0, Math.min(xCoordinates.get(x).get(0), y));
                xCoordinates.get(x).set(1, Math.max(xCoordinates.get(x).get(1), y));
            }
            if (!yCoordinates.containsKey(y)) {
                yCoordinates.put(y, new ArrayList<>(List.of(x, x)));
            } else {
                yCoordinates.get(y).set(0, Math.min(yCoordinates.get(y).get(0), x));
                yCoordinates.get(y).set(1, Math.max(yCoordinates.get(y).get(1), x));
            }

        }

        for (final int[] building : buildings) {
            final int x = building[0];
            final int y = building[1];
            if (xCoordinates.get(x).get(0) < y && xCoordinates.get(x).get(1) > y &&
                    yCoordinates.get(y).get(0) < x && yCoordinates.get(y).get(1) > x) {
                ++answer;
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
           final int n = scanner.nextInt();
           final int m = scanner.nextInt();
           final int[][] buildings = new int[m][2];

           for (int i = 0; i < m; ++i) {
               buildings[i][0] = scanner.nextInt();
               buildings[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().countCoveredBuildings(n, buildings));
       }
       
       scanner.close();
   }
}
