//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

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
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> maxCombinations(int n, int k, int[] nums1, int[] nums2) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] != a[0] ? b[0] - a[0] :
                        a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = n - 1; i >= 0; --i) {
            pq.add(new int[]{nums1[i] + nums2[n - 1], i, n - 1});
        }

        while (k > 1) {
            int[] arr = pq.poll();
            assert arr != null;
            answer.add(arr[0]);
            pq.add(new int[]{nums1[arr[1]] + nums2[arr[2] - 1], arr[1], arr[2] - 1});
            --k;
        }

        answer.add(Objects.requireNonNull(pq.poll())[0]);

        return answer;
    }
}
