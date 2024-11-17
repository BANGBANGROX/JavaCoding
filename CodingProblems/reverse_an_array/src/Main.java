//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] str = br.readLine().split(" ");
            int[] arr = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public void reverseArray(int[] arr) {
        // code here
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            arr[left] = arr[left] + arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];
            ++left;
            --right;
        }
    }
}