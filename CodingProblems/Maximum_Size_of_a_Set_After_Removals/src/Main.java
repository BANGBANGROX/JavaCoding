import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
         HashSet<Integer> s1 = new HashSet<>();
         HashSet<Integer> s2 = new HashSet<>();
         HashSet<Integer> s3 = new HashSet<>();

         for (int num : nums1) {
             s1.add(num);
             s3.add(num);
         }

         for (int num : nums2) {
             s2.add(num);
             s3.add(num);
         }

         return Math.min(Math.min(s1.size(), nums1.length / 2) +
                 Math.min(s2.size(), nums2.length / 2), s3.size());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            assert n % 2 == 0;
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumSetSize(nums1, nums2));
        }

        sc.close();
    }
}
