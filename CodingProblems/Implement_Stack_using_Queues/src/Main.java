import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1, q2;

    public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            return;
        }

        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        Queue<Integer> q3 = q1;
        q1 = q2;
        q2 = q3;
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }

        return q1.poll();
    }

    public int top() {
       if (q1.isEmpty()) {
           return -1;
       }

       return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
