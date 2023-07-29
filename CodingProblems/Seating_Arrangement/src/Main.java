//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String[] s =in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);

            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        int emptySeats = 1;

        for (int i = 0; i < m && n > 0; ++i) {
            if (seats[i] == 0) {
                ++emptySeats;
            }
            else {
                emptySeats = 0;
            }
            if (emptySeats > 2) {
                --n;
                emptySeats = 1;
            }
            if (n <= 0) return true;
        }

        if (emptySeats > 1) --n;

        return n <= 0;
    }
}

