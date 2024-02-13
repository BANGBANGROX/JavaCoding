import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int binarySearchUpperBound(int[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int result = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] <= key) {
                l = mid + 1;
            }
            else {
                result = mid;
                r = mid - 1;
            }
        }

        return result;
    }

    private int binarySearchLowerBound(int[] nums, int key) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int result = n;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums[mid] < key) {
                l = mid + 1;
            }
            else {
                result = mid;
                r = mid - 1;
            }
        }

        return result;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = people.length;
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int[] answer = new int[m];

        for (int i = 0; i < n; ++i) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < m; ++i) {
            answer[i] = binarySearchUpperBound(start, people[i]) -
                    binarySearchLowerBound(end, people[i]);
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
            int[][] flowers = new int[n][2];
            for (int i = 0; i < n; ++i) {
                flowers[i][0] = sc.nextInt();
                flowers[i][1] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] people = new int[m];
            for (int i = 0; i < m; ++i) {
                people[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] answer = solution.fullBloomFlowers(flowers, people);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
