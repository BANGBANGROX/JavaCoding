import java.util.Scanner;

class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length, maxPro = 1, minPro = 1, ans = Integer.MIN_VALUE;

       for (int i = 0; i < n; ++i) {
           if (nums[i] < 0) {
               int temp = minPro;
               minPro = maxPro;
               maxPro = temp;
           }
           maxPro = Math.max(nums[i], nums[i] * maxPro);
           minPro = Math.min(nums[i], nums[i] * minPro);
           ans = Math.max(ans, maxPro);
       }

       return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.maxProduct(nums));

        sc.close();
    }
}
