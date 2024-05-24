import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    private LinkedList<Integer> answer;
    private LinkedList<Integer> currentPermutation;
    private boolean[] visited;
    private int[] nums;
    private int minimumScore;
    private int n;

    private void generatePermutations(int currentScore) {
        if (currentScore >= minimumScore) return;

        if (currentPermutation.size() == n) {
            currentScore += Math.abs(currentPermutation.getLast() - nums[currentPermutation.getFirst()]);
            if (currentScore < minimumScore) {
                minimumScore = currentScore;
                answer = new LinkedList<>(currentPermutation);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                int delta = Math.abs(currentPermutation.getLast() - nums[i]);
                visited[i] = true;
                currentPermutation.add(i);
                generatePermutations(currentScore + delta);
                visited[i] = false;
                currentPermutation.pollLast();
            }
        }
    }

    public int[] findPermutation(int[] nums) {
        this.nums = nums;
        n = nums.length;
        answer = new LinkedList<>();
        currentPermutation = new LinkedList<>();
        visited = new boolean[n];
        minimumScore = Integer.MAX_VALUE;

        currentPermutation.add(0);
        visited[0] = true;
        generatePermutations(0);

        return answer.stream().mapToInt(k -> k).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            int[] answer = new Solution().findPermutation(nums);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
