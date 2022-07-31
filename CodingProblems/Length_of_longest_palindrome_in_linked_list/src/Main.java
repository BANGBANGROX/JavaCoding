//{ Driver Code Starts
import java.util.*;
import java.lang.Math;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node head=null;
            head=insert(head,sc.nextInt());
            for(int i=1;i<n;i++)
                insert(head,sc.nextInt());
            GfG g=new GfG();
            System.out.println(g.maxPalindrome(head));
        }
    }
    public static Node insert(Node head,int val){
        if(head==null)
            return new Node(val);
        head.next=insert(head.next,val);
        return head;
    }
	/*public static void print(Node head){
		while(head!=null){
			System.out.println(head.data);
			head=head.next;
		}
	}*/
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class GfG {
    public int maxPalindrome(Node head) {
        //add code here.
        ArrayList<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.data);
            head = head.next;
        }

        int n = nums.size();
        boolean[][] dp = new boolean[n][n];
        int ans = 1;

        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (len == 1) dp[i][j] = true;
                else if (len == 2) dp[i][j] = Objects.equals(nums.get(i), nums.get(j));
                else dp[i][j] = (Objects.equals(nums.get(i), nums.get(j))) && dp[i + 1][j - 1];
                if (dp[i][j]) ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}