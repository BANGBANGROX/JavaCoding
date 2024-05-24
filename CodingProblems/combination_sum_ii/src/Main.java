//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private HashSet<List<Integer>> visited;
    private List<List<Integer>> answer;
    private int[] nums;
    private int n;

    private void generateCombinations(int index, int remainingSum, LinkedList<Integer> currentCombination) {
        if (remainingSum == 0) {
            if (!visited.contains(currentCombination)) {
                answer.add(new ArrayList<>(currentCombination));
                visited.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        if (index >= n) return;


        if (remainingSum >= nums[index]) {
            currentCombination.add(nums[index]);
            generateCombinations(index + 1, remainingSum - nums[index], currentCombination);
            currentCombination.pollLast();
        }

        generateCombinations(index + 1, remainingSum, currentCombination);
    }

    public List<List<Integer>> CombinationSum2(int[] nums, int n, int k) {
        // Code Here.
        Arrays.sort(nums);

        this.n = n;
        this.nums = nums;
        answer = new ArrayList<>();
        visited = new HashSet<>();

        generateCombinations(0, k, new LinkedList<>());

        return answer;
    }
}
