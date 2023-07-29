//{ Driver Code Starts
// Initial Template for Java

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[] a = new char[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.next().charAt(0);
            }
            Solution obj = new Solution();
            int ans = obj.leastInterval(n, k, a);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[] taskFrequency;
    private int[] allocatedTime;

    private int getPossibleToCompleteTask(int currentTime) {
        int maximumFrequency = 0;
        int task = -1;

        for (int i = 0; i < taskFrequency.length; ++i) {
            if (maximumFrequency < taskFrequency[i] && allocatedTime[i] <= currentTime) {
                task = i;
                maximumFrequency = taskFrequency[i];
            }
        }

        return task;
    }

    public int leastInterval(int n, int k, char[] tasks) {
        // code here
        taskFrequency = new int[26];
        allocatedTime = new int[26];
        int cnt = 0;
        int time = 0;

        for (char ch : tasks) {
            ++taskFrequency[ch - 'A'];
        }

        while (cnt < n) {
            int task = getPossibleToCompleteTask(time);
            if (task != -1) {
                --taskFrequency[task];
                allocatedTime[task] = time + k + 1;
                ++cnt;
            }
            ++time;
        }

        return time;
    }
}
