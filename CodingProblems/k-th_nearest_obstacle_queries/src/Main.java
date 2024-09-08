import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        assert k > 0;

        int q = queries.length;
        int[] answer = new int[q];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int distance = Math.abs(query[0]) + Math.abs(query[1]);
            if (pq.size() == k) {
                if (distance < pq.peek()) {
                    pq.poll();
                    pq.add(distance);
                }
            } else {
                pq.add(distance);
            }
            answer[i] = pq.size() == k ? pq.peek() : -1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int q = scanner.nextInt();
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; ++i) {
                queries[i][0] = scanner.nextInt();
                queries[i][1] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            int[] answer = new Solution().resultsArray(queries, k);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
