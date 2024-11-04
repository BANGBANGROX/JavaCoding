//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        int n = arr.length;
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> numIndices = new HashMap<>();
        Set<List<Integer>> visited = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            numIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int target = -1 * (arr[i] + arr[j]);
                for (int idx : numIndices.getOrDefault(target, new ArrayList<>())) {
                    if (idx != i && idx != j) {
                        List<Integer> currentTriplet = new ArrayList<>(List.of(i, j, idx));
                        Collections.sort(currentTriplet);
                        if (!visited.contains(currentTriplet)) {
                            answer.add(currentTriplet);
                            visited.add(currentTriplet);
                        }
                    }
                }
            }
        }

        answer.sort((a, b) -> {
            if (!Objects.equals(a.get(0), b.get(0))) return a.get(0) - b.get(0);
            if (!Objects.equals(a.get(1), b.get(1))) return a.get(1) - b.get(1);
            return a.get(2) - b.get(2);
        });

        return answer;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            res.sort((a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.isEmpty()) {
                System.out.println("[]");
            }
            for (List<Integer> re : res) {
                for (Integer integer : re) {
                    System.out.print(integer + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends