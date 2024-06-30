import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private static class Pair {
        int first;
        char second;

        Pair(int first, char second) {
            this.first = first;
            this.second = second;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -1 * x.first));
        StringBuilder answer = new StringBuilder();

        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }
        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }
        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        while (pq.size() > 1) {
            Pair first = pq.poll();
            Pair second = pq.poll();
            assert first != null;
            assert second != null;
            if (first.first >= 2) {
                answer.append(first.second).append(first.second);
                first.first -= 2;
            } else {
                answer.append(first.second);
                --first.first;
            }
            if (second.first >= 2 && second.first >= first.first) {
                answer.append(second.second).append(second.second);
                second.first -= 2;
            } else {
                answer.append(second.second);
                --second.first;
            }
            if (first.first > 0) {
                pq.add(first);
            }
            if (second.first > 0) {
                pq.add(second);
            }
        }

        if (pq.isEmpty()) return answer.toString();

        if (pq.peek().first > 1) {
            answer.append(pq.peek().second).append(pq.peek().second);
        } else {
            answer.append(pq.peek().second);
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            System.out.println(new Solution().longestDiverseString(a, b, c));
        }

        scanner.close();
    }
}
