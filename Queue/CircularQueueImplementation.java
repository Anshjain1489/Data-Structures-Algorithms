package dsa.Queue;

public class CircularQueueImplementation {

    static class CircularQueue {
        int arr[];
        int size;
        int front;
        int rear;

        public CircularQueue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        // Check Empty
        public boolean isEmpty() {
            return front == -1;
        }

        // Check Full
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add Element
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }

            // First element
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove Element
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = arr[front];

            // If only one element
            if (rear == front) {
                rear = -1;
                front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // Peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.remove());
        System.out.println(q.remove());

        q.add(6);
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}