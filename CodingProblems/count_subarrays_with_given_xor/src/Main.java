//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] s = br.readLine().split(" ");
            int[] arr = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int[] arr, int k) {
        // code here
        Map<Integer, Long> count = new HashMap<>();
        int runningXor = 0;
        long answer = 0;

        for (int num : arr) {
            runningXor ^= num;
            if (runningXor == k) {
                ++answer;
            }
            answer += count.getOrDefault(runningXor ^ num, 0L);
            count.put(runningXor, count.getOrDefault(runningXor, 0L) + 1);
        }

        return answer;
    }
}