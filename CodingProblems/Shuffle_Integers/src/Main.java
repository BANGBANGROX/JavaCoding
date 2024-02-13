//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// } Driver Code Ends
//User function Template for Java





class  Solution {
    void shuffleArray(long[] nums, int n) {
        // Your code goes here
        for (int i = 0; i < n; ++i) {
            nums[i] *= 10000;
        }

        int j = 1;

        for (int i = n / 2; i < n; ++i) {
            nums[j] += nums[i] / 10000;
            j += 2;
        }

        j = 0;

        for (int i = 0; i < n / 2; ++i) {
            nums[j] += nums[i] / 10000;
            j += 2;
        }

        for (int i = 0; i < n; ++i) {
            nums[i] %= 10000;
        }
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new  Solution();
            //ArrayList<Long> ans=
            ob.shuffleArray(a,n);
            // System.out.println(ob.shuffleArray(a,n));
            for (int i = 0; i < n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }
    }
}


// } Driver Code Ends