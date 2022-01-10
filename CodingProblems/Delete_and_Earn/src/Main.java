import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int[] include = new int[maxVal + 1];
        int[] exclude = new int[maxVal + 1];
        int[] freq = new int[maxVal + 1];

        for (int i = 0; i < n; ++i) {
            ++freq[nums[i]];
        }

        for (int i = 1; i <= maxVal; ++i) {
            include[i] = exclude[i - 1] + i * freq[i];
            exclude[i] = Math.max(exclude[i - 1], include[i - 1]);
        }

        return Math.max(include[maxVal], exclude[maxVal]);
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
        System.out.println(obj.deleteAndEarn(nums));

        sc.close();
    }
}
