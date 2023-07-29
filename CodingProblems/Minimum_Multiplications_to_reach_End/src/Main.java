//{ Driver Code Starts
// Initial Template for Java

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimumMultiplications(int[] nums, int start, int end) {
        // Your code here
        if (start == end) return 0;

        int answer = 0;
        final int MOD = 1_000_00;
        Queue<Integer> numsQueue = new LinkedList<>();
        HashSet<Integer> visitedNumsSet = new HashSet<>();

        numsQueue.add(start);

        while (!numsQueue.isEmpty()) {
            int n = numsQueue.size();
            for (int i = 0; i < n; ++i) {
                assert numsQueue.peek() != null;
                int current = numsQueue.poll();
                for (int num : nums) {
                    int next = (current * num) % MOD;
                    if (next == end) return answer + 1;
                    if (!visitedNumsSet.contains(next)) {
                        visitedNumsSet.add(next);
                        numsQueue.add(next);
                    }
                }
            }
            ++answer;
        }

        return -1;
    }
}
