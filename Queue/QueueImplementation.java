package dsa.Queue;

public class QueueImplementation {
    static class Queue {
        int arr[];
        int size;
        int rear;
        int front;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = 0;
        }

        public boolean isEmpty() {
            return rear < front;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int result = arr[front];
            front++;
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}