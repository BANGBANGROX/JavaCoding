import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> answer = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        List<List<Integer>> robots = new ArrayList<>();
        int n = positions.length;

        for (int i = 0; i < n; ++i) {
            robots.add(List.of(i, positions[i]));
        }

        robots.sort(Comparator.comparingInt(a -> a.get(1)));

        for (int i = 0; i < n; ++i) {
            int idx = robots.get(i).get(0);
            if (directions.charAt(idx) == 'R') {
                stack.add(idx);
            } else {
                while (!stack.isEmpty() && healths[idx] > 0) {
                    int lastIdx = stack.getLast();
                    int healthDiff = healths[idx] - healths[lastIdx];
                    if (healthDiff > 0) {
                        healths[lastIdx] = 0;
                        --healths[idx];
                        stack.pollLast();
                    } else if (healthDiff < 0) {
                        healths[idx] = 0;
                        --healths[lastIdx];
                    } else {
                        healths[idx] = healths[lastIdx] = 0;
                        stack.pollLast();
                    }
                }
            }
        }

        for (int health : healths) {
            if (health > 0) {
                answer.add(health);
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] positions = new int[n];
            for (int i = 0; i < n; ++i) {
                positions[i] = scanner.nextInt();
            }
            int[] healths = new int[n];
            for (int i = 0; i < n; ++i) {
                healths[i] = scanner.nextInt();
            }
            String directions = scanner.next();

            System.out.println(new Solution().survivedRobotsHealths(positions, healths, directions));
        }

        scanner.close();
    }
}
