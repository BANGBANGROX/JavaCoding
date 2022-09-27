class MyCircularQueue {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private final int maxCapacity;
    private int currentCapacity;

    public MyCircularQueue(int k) {
        maxCapacity = k;
        currentCapacity = 0;
        head = tail = null;
    }

    public boolean enQueue(int value) {
        if (currentCapacity == maxCapacity) return false;

        if (head == null) {
            head = new ListNode(value);
            tail = head;
            head.next = head;
        } else {
            ListNode newNode = new ListNode(value);
            tail.next = newNode;
            tail = tail.next;
            newNode.next = head;
        }

        ++currentCapacity;

        return true;
    }

    public boolean deQueue() {
        if (currentCapacity == 0) return false;

        if (currentCapacity == 1) {
            head = tail = null;
            currentCapacity = 0;
            return true;
        }

        head = head.next;
        tail.next = head;
        --currentCapacity;

        return true;
    }

    public int Front() {
        if (currentCapacity == 0) return -1;

        return head.val;
    }

    public int Rear() {
        if (currentCapacity == 0) return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        return currentCapacity == 0;
    }

    public boolean isFull() {
        return currentCapacity == maxCapacity;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isFull());
    }
}
