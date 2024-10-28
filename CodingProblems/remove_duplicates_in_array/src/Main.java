//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

            v = new Solution().removeDuplicate(arr);

            for (Integer integer : v) System.out.print(integer + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> removeDuplicate(int[] arr) {
        // code here
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[101];

        for (int num : arr) {
            if (!visited[num]) {
                answer.add(num);
                visited[num] = true;
            }
        }

        return answer;
    }
}
