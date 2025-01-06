//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;

        if (n == 1) return new ArrayList<>();

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int first = arr[left];
        int second = arr[right];
        int minDiff = Math.abs(target - first - second);

        while (left < right) {
            int current = arr[left] + arr[right];
            int currentDiff = Math.abs(target - current);
            if (current > target) {
                if (currentDiff < minDiff) {
                    first = arr[left];
                    second = arr[right];
                    minDiff = currentDiff;
                } else if (currentDiff == minDiff && (arr[right] - arr[left]) > (second - first)) {
                    first = arr[left];
                    second = arr[right];
                }
                --right;
            } else {
                if (currentDiff < minDiff) {
                    first = arr[left];
                    second = arr[right];
                    minDiff = currentDiff;
                } else if (currentDiff == minDiff && (arr[right] - arr[left]) > (second - first)) {
                    first = arr[left];
                    second = arr[right];
                }
                ++left;
            }
        }

        return List.of(first, second);
    }
}