import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int a;
    private int b;
    private int c;

    public ArrayList<Integer> sortArray(final int[] nums, final int a, final int b, final int c) {
        // Code here
        final int n = nums.length;
        int left = 0;
        int right = n - 1;
        int itr = (a >= 0 ? 0 : n - 1);
        this.a = a;
        this.b = b;
        this.c = c;
        final int[] result = new int[n];
        final ArrayList<Integer> answer = new ArrayList<>();

        while (left <= right) {
            int val1 = getValue(nums[left]);
            int val2 = getValue(nums[right]);
            if (a >= 0) {
                if (val1 <= val2) {
                    result[itr] = val2;
                    --right;
                } else {
                    result[itr] = val1;
                    ++left;
                }
                --itr;
            } else {
                if (val1 <= val2) {
                    result[itr] = val1;
                    ++left;
                } else {
                    result[itr] = val2;
                    --right;
                }
                ++itr;
            }
        }

        for (final int val : result) {
            answer.add(val);
        }

        return answer;
    }

    private int getValue(final int x) {
        return a * x * x + b * x + c;
    }
}
