import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        final int TOTAL_TIME = 24 * 60;
        int firstTime = Integer.MAX_VALUE;
        int lastTime = Integer.MIN_VALUE;
        int answer = Integer.MAX_VALUE;
        int previousTime = 0;
        boolean[] visited = new boolean[TOTAL_TIME];

        for (String timePoint : timePoints) {
            String[] splitTime = timePoint.split(":");
            int hours = Integer.parseInt(splitTime[0]);
            int minutes = Integer.parseInt(splitTime[1]);
            int totalTime = hours * 60 + minutes;
            if (visited[totalTime]) return 0;
            visited[totalTime] = true;
        }

        for (int currentTime = 0; currentTime < TOTAL_TIME; ++currentTime) {
            if (visited[currentTime]) {
                if (firstTime != Integer.MAX_VALUE) {
                    answer = Math.min(answer, currentTime - previousTime);
                }
                firstTime = Math.min(firstTime, currentTime);
                lastTime = Math.max(lastTime, currentTime);
                previousTime = currentTime;
            }
        }

        answer = Math.min(answer, TOTAL_TIME - lastTime + firstTime);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           List<String> timePoints = new ArrayList<>();
           for (int i = 0; i < n; ++i) {
               timePoints.add(scanner.next());
           }

           System.out.println(new Solution().findMinDifference(timePoints));
       }
       
       scanner.close();
   }
}
