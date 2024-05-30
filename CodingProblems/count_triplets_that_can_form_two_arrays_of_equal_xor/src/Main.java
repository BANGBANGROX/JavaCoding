import java.util.Scanner;

class Solution {
    public int countTriplets(int[] nums) {
        int answer = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int xor1 = nums[i];
            for (int j = i + 1; j < n; ++j) {
                xor1 ^= nums[j];
                int xor2 = nums[j];
                for (int k = j; k < n; ++k) {
                    xor2 ^= nums[k];
                    if (xor1 == xor2) {
                        ++answer;
                    }
                }
            }
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
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            System.out.println(new Solution().countTriplets(nums));
        }

        sc.close();
    }
}
