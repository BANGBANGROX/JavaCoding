//{ Driver Code Starts

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -1 *
                a.getFirst()));
        int n = points.length;
        int[][] answer = new int[k][2];

        for (int i = 0; i < n; ++i) {
            int[] point = points[i];
            int currentDistance = point[0] * point[0] + point[1] * point[1];
            if (pq.size() < k) {
                pq.add(List.of(currentDistance, i));
            } else {
                List<Integer> top = pq.poll();
                assert top != null;
                if (top.getFirst() > currentDistance) {
                    pq.add(List.of(currentDistance, i));
                } else {
                    pq.add(top);
                }
            }
        }

        while (!pq.isEmpty()) {
            int idx = pq.poll().get(1);
            answer[k - pq.size() - 1] = points[idx].clone();
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends