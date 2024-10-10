//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public int maxDistance(int[] nums) {
        // Code here
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int n = nums.length;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            if (!firstIndex.containsKey(nums[i])) {
                firstIndex.put(nums[i], i);
            }
            lastIndex.put(nums[i], i);
        }

        for (Map.Entry<Integer, Integer> entry : firstIndex.entrySet()) {
            int num = entry.getKey();
            int first = entry.getValue();
            int last = lastIndex.get(num);
            answer = Math.max(answer, last - first);
        }

        return answer;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends