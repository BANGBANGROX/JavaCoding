import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private int[] inDegree;
    private int[] depth;
    private int[] favorite;
    private int n;

    private void computeDepth() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            int next = favorite[node];
            depth[next] = Math.max(depth[next], depth[node] + 1);
            --inDegree[next];
            if (inDegree[next] == 0) {
                q.add(next);
            }
        }
    }

    public int maximumInvitations(int[] favorite) {
        n = favorite.length;
        inDegree = new int[n];
        depth = new int[n];
        this.favorite = favorite;
        int maxCycleLength = 0;
        int twoCycleInvitations = 0;

        for (int j : favorite) {
            ++inDegree[j];
        }

        Arrays.fill(depth, 1);
        computeDepth();

        for (int person = 0; person < n; ++person) {
            if (inDegree[person] == 0) continue;
            int currentCycleLength = 0;
            int current = person;
            while (inDegree[current] > 0) {
                ++currentCycleLength;
                --inDegree[current];
                current = favorite[current];
            }
            if (currentCycleLength == 2) {
                twoCycleInvitations += (depth[person] + depth[favorite[person]]);
            } else {
                maxCycleLength = Math.max(maxCycleLength, currentCycleLength);
            }
        }

        return Math.max(maxCycleLength, twoCycleInvitations);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] favorite = new int[n];
           for (int i = 0; i < n; ++i) {
               favorite[i] = scanner.nextInt();
           }

           System.out.println(new Solution().maximumInvitations(favorite));
       }
       
       scanner.close();
   }
}
