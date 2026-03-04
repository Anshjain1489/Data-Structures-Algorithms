package dsa.Queue;

import java.util.Stack;

public class QueueUsingTwoStacks {

    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.pop();
        }
        public int peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return s1.peek();
        }

        public boolean isEmpty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(10);
        q.add(20);
        q.add(30);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}