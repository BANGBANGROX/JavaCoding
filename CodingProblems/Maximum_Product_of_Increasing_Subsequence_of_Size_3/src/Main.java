// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


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
            int N = Integer.parseInt(element[0]);
            int[] arr = new int[N];
            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<N;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans;
            ans = obj.maxProductSubsequence(arr, N);
            if(ans.get(0) == -1)
                System.out.println("Not Present");
            else{
                for(int i: ans)
                    System.out.print(i + " ");
                System.out.println();
            }

        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> maxProductSubsequence (int[] arr, int n) {
        //Complete the function
        TreeSet<Integer> st = new TreeSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lsl = new int[n];
        int[] lgr = new int[n];
        long product = 0;

        lsl[0] = lgr[n - 1] = -1;

        st.add(arr[0]);

        for (int i = 1; i < n; ++i) {
           if (st.lower(arr[i]) != null) lsl[i] = st.lower(arr[i]);
           else lsl[i] = -1;
           st.add(arr[i]);
        }

        int maxElement = arr[n - 1];

        for (int i = n - 2; i >= 0; --i) {
            lgr[i] = arr[i] < maxElement ? maxElement : -1;
            maxElement = Math.max(maxElement, arr[i]);
        }

        for (int i = 1; i < n - 1; ++i) {
           int a = lsl[i];
           int b = arr[i];
           int c = lgr[i];
           if (a != -1 && c != -1) {
               if (product < (long)a * b * c) {
                   product = (long)a * b * c;
                   ans = new ArrayList<>(Arrays.asList(a, b, c));
               }
           }
        }

        if (ans.isEmpty()) ans.add(-1);

        return ans;
    }
}

