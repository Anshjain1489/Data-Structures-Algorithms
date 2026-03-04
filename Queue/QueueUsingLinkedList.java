package dsa.Queue;

public class QueueUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node front = null;
        Node rear = null;

        // Check if empty
        public boolean isEmpty() {
            return front == null && rear == null;
        }

        // Add element (Enqueue)
        public void add(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        // Remove element (Dequeue)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = front.data;
            front = front.next;

            // If queue becomes empty
            if (front == null) {
                rear = null;
            }

            return result;
        }

        // Peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return front.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}