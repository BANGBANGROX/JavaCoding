//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }
            Complete obj = new Complete();
            int ans = obj.save_gotham(arr, sizeOfArray);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Complete {
    // Function for finding maximum and value pair
    public int save_gotham(int[] nums, int n) {
        //Complete the function
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        final int MOD = (int) 1e9 + 7;

        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && st.peek() <= nums[i]) st.pop();
            if (!st.isEmpty()) {
                ans = (ans + st.peek()) % MOD;
            }
            st.push(nums[i]);
        }

        return (int) ans;
    }
}


