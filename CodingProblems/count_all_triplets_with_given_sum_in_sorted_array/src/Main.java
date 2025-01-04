//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        int n = arr.length;

        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; ++i) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) - 1);
            for (int j = 0; j < i; ++j) {
                int remaining = target - arr[i] - arr[j];
                answer += count.getOrDefault(remaining, 0);
            }
        }

        return answer;
    }
}