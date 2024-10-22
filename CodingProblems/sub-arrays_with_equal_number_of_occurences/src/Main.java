//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int sameOccurrence(int[] arr, int x, int y) {
        // write code here
        Map<Integer, Integer> count = new HashMap<>();
        int cntDifference = 0;
        int answer = 0;

        count.put(0, 1);

        for (int num : arr) {
            if (num == x) ++cntDifference;
            if (num == y) --cntDifference;
            answer += count.getOrDefault(cntDifference, 0);
            count.put(cntDifference, count.getOrDefault(cntDifference, 0) + 1);
        }

        return answer;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends