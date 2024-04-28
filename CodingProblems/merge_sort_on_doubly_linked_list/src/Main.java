//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    private void merge(ArrayList<Integer> nums, int left, int mid, int right) {
        ArrayList<Integer> tempNums = new ArrayList<>();
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (nums.get(i) < nums.get(j)) {
                tempNums.add(nums.get(i));
                ++i;
            }
            else {
                tempNums.add(nums.get(j));
                ++j;
            }
        }

        while (i <= mid) {
            tempNums.add(nums.get(i));
            ++i;
        }

        while (j <= right) {
            tempNums.add(nums.get(j));
            ++j;
        }

        for (i = left; i <= right; ++i) {
            nums.set(i, tempNums.get(i - left));
        }
    }

    private void mergeSort(ArrayList<Integer> nums, int left, int right) {
        if (left < right) {
            int mid = (left + ((right - left) >> 1));
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    // Function to sort the given doubly linked list using Merge Sort.
    public Node sortDoubly(Node head) {
        // add your code here
        ArrayList<Integer> nums = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            nums.add(temp.data);
            temp = temp.next;
        }

        mergeSort(nums, 0, nums.size() - 1);

        int itr = 0;
        temp = head;

        while (temp != null) {
            temp.data = nums.get(itr);
            ++itr;
            temp = temp.next;
        }

        return head;
    }
}