import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n;
            n = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);


            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.min_operations(n, arr, brr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private void rotate(int[] nums, int start, int end) {
        for (int i = start; i < end; ++i) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }

    public int min_operations(int n, int[] arr, int[] brr) {
        // code here
        int answer = 0;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (arr[start] == brr[start]) {
                ++start;
            }
            else rotate(arr, start, end);
            ++answer;
        }

        return answer;
    }
}
