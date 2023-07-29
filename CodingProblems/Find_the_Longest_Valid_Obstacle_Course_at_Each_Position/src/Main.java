import java.util.Scanner;

class Solution {
    private int lowerBound(int right, int key, int[] buffer) {
        if (right == 0) return 0;

        int left = 0;

        while (left < right) {
            int mid = (left + ((right - left) >> 1));
            if (buffer[mid] >= key) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int lisIndex = 0;
        int[] answer = new int[n];
        int[] lis = new int[n];

        for (int i = 0; i < n; ++i) {
            int idx = lowerBound(lisIndex, obstacles[i], lis);
            if (idx == lisIndex) ++lisIndex;
            answer[i] = idx + 1;
            lis[idx] = obstacles[i];
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] obstacles = new int[n];
            for (int i = 0; i < n; ++i) {
                obstacles[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] answer = solution.longestObstacleCourseAtEachPosition(obstacles);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
