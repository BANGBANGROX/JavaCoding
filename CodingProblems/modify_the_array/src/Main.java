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

            v = new Solution().modifyAndRearrangeArr(arr);

            for (Integer integer : v) System.out.print(integer + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> modifyAndRearrangeArr(int[] arr) {
        // Complete the function
        int n = arr.length;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (arr[i] > 0) {
                if (i + 1 < n && arr[i] == arr[i + 1]) {
                    answer.add(arr[i] * 2);
                    ++i;
                } else {
                    answer.add(arr[i]);
                }
            }
        }

        int zeroesCnt = n - answer.size();

        while (zeroesCnt > 0) {
            answer.add(0);
            --zeroesCnt;
        }

        return answer;
    }
}
