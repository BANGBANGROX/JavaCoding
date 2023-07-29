import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<ArrayList<Integer>, Integer> dp;
    private int[] nums1;
    private int[] nums2;
    private int n;

    private int upperBound(int key) {
        int l = 0;
        int r = nums2.length - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums2[mid] <= key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    private int maxArrayIncreasingHandler(int index, int lastValue) {
        if (index == n) return 0;

        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(index, lastValue));

        if (dp.containsKey(key)) return dp.get(key);

        int result = Integer.MAX_VALUE;

        if (nums1[index] > lastValue) {
            result = maxArrayIncreasingHandler(index + 1, nums1[index]);
        }

        int idx = upperBound(lastValue);

        if (idx < nums2.length) {
            int value = maxArrayIncreasingHandler(index + 1, nums2[idx]);
            if (value != Integer.MAX_VALUE) {
                result = Math.min(result, value + 1);
            }
        }

        dp.put(key, result);

        return result;
    }

    public int makeArrayIncreasing(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        n = nums1.length;
        dp = new HashMap<>();

        Arrays.sort(nums2);

        int answer = maxArrayIncreasingHandler(0, -1);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int[] nums1 = new int[m];
            for (int i = 0; i < m; ++i) {
                nums1[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.makeArrayIncreasing(nums1, nums2));
        }

        sc.close();
    }
}
