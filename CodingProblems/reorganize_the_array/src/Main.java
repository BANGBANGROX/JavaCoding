//{ Driver Code Starts

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
        int n = arr.size();
        Set<Integer> numsSet = new HashSet<>(arr);

        for (int i = 0; i < n; ++i) {
            if (!numsSet.contains(i)) {
                arr.set(i, -1);
            } else {
                arr.set(i, i);
            }
        }

        return arr;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends