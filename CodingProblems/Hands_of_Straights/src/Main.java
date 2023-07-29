//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isStraightHand(int n, int groupSize, int[] nums) {
        // code here
        if (groupSize == 1) return true;

        if (n % groupSize != 0) return false;

        TreeMap<Integer, Integer> count = new TreeMap<>();
        int groups = n / groupSize;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < groups; ++i) {
            int first = count.firstKey();
            count.put(first, count.get(first) - 1);
            if (count.get(first) == 0) count.remove(first);
            for (int j = 1; j < groupSize; ++j) {
                if (!count.containsKey(first + 1)) return false;
                ++first;
                count.put(first + 1, count.get(first + 1) - 1);
                if (count.get(first + 1) == 0) count.remove(first + 1);
            }
        }

        return true;
    }
}
