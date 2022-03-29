import java.util.Scanner;

class Solution {
    private boolean isBinarySearchUseful(int[] nums, int start, int key) {
       return nums[start] != key;
    }

    private boolean existsInFirst(int[] nums, int start, int key) {
        return nums[start] <= key;
    }

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + ((end - start) >> 1));
            if (nums[mid] == target) return true;
            if (!isBinarySearchUseful(nums, start, nums[mid])) {
                ++start;
                continue;
            }
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);
            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) {
                if (pivotArray) start = mid + 1;
                else end = mid - 1;
            }
            else {
                if (nums[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
