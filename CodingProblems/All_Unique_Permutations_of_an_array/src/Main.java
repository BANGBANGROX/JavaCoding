//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");

            ArrayList<Integer> arr = new ArrayList<>();

            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr);
            for (ArrayList<Integer> re : res) {
                for (int j = 0; j < n; j++) {
                    System.out.print(re.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            ++l;
            --r;
        }
    }

    private boolean nextPermutation(int[] nums) {
        int n = nums.length;

        if (n == 1) return false;

        int last = n - 2;

        while (last >= 0 && nums[last + 1] <= nums[last]) --last;

        if (last < 0) return false;

        int nextGreater = n - 1;

        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > nums[last]) {
                nextGreater = i;
                break;
            }
        }

        int temp = nums[last];
        nums[last] = nums[nextGreater];
        nums[nextGreater] = temp;

        reverse(nums, last + 1, n - 1);

        return true;
    }

    public ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr) {
        // code here
        int[] nums = arr.stream().mapToInt(a -> a).toArray();
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        do {
            ArrayList<Integer> current = new ArrayList<>();
            for (int x : nums) {
                current.add(x);
            }
            if (!visited.contains(current)) {
                ans.add(new ArrayList<>(current));
                visited.add(current);
            }
        } while (nextPermutation(nums));

        return ans;
    }
}