package dsa.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Push (O(n))
        public void push(int data) {

            // Step 1: Add to q2
            q2.add(data);

            // Step 2: Move all elements from q1 → q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            // Step 3: Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // Pop (O(1))
        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.remove();
        }

        // Peek (O(1))
        public int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return q1.peek();
        }

        public boolean isEmpty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}