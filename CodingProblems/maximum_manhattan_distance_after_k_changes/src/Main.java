import java.util.Map;
import java.util.Scanner;

class Solution {
    public int maxDistance(final String s, final int k) {
        int answer = 0;
        final int[] distance = new int[4];
        final Map<Character, Integer> directionToIndexMap = Map.of(
                'N', 0,
                'S', 1,
                'E', 2,
                'W', 3
        );

        for (final char ch : s.toCharArray()) {
            ++distance[directionToIndexMap.get(ch)];
            final int times1 = Math.min(Math.min(distance[0], distance[1]), k);
            final int times2 = Math.min(Math.min(distance[2], distance[3]), k - times1);
            answer = Math.max(answer, getDistance(distance[0], distance[1], times1) +
                    getDistance(distance[2], distance[3], times2));
        }

        return answer;
    }

    private int getDistance(final int dis1, final int dis2, final int times) {
        return Math.abs(dis1 - dis2) + times * 2;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maxDistance(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
