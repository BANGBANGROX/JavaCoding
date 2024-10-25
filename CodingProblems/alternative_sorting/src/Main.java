//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v;
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().alternateSort(arr);

            for (Integer integer : v) System.out.print(integer + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> alternateSort(int[] arr) {
        // Your code goes here
        int left = 0;
        int right = arr.length - 1;
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(arr);

        while (left < right) {
            answer.add(arr[right]);
            answer.add(arr[left]);
            ++left;
            --right;
        }

        if (left == right) answer.add(arr[left]);

        return answer;
    }
}
