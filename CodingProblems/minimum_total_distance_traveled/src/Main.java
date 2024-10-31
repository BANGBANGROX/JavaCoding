import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Solution {
    private List<Integer> factoryPositions;
    private List<Integer> robotPositions;
    private long[][] dp;

    private long minimumTotalDistanceHandler(int robotIdx,
                                             int factoryIdx) {
        if (robotIdx == robotPositions.size()) return 0;

        if (factoryIdx == factoryPositions.size()) return (long) 1e12;

        if (dp[robotIdx][factoryIdx] != -1) return dp[robotIdx][factoryIdx];

        long take = Math.abs(factoryPositions.get(factoryIdx) - robotPositions.get(robotIdx)) +
                minimumTotalDistanceHandler(robotIdx + 1, factoryIdx + 1);
        long skip = minimumTotalDistanceHandler(robotIdx, factoryIdx + 1);

        return dp[robotIdx][factoryIdx] = Math.min(take, skip);
    }

    public long minimumTotalDistance(List<Integer> robot,
                                     int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        robotPositions = robot;
        factoryPositions = new ArrayList<>();

        for (int[] currentFactory : factory) {
            for (int i = 0; i < currentFactory[1]; ++i) {
                factoryPositions.add(currentFactory[0]);
            }
        }

        dp = new long[robotPositions.size()][factoryPositions.size()];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minimumTotalDistanceHandler(0, 0);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int robotCnt = scanner.nextInt();
           List<Integer> robot = new ArrayList<>();
           for (int i = 0; i < robotCnt; ++i) {
               robot.add(scanner.nextInt());
           }
           int factoryCnt = scanner.nextInt();
           int[][] factory = new int[factoryCnt][2];
           for (int i = 0; i < factoryCnt; ++i) {
               factory[i][0] = scanner.nextInt();
               factory[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().minimumTotalDistance(robot, factory));
       }
       
       scanner.close();
   }
}
