package dsa.Queue;

import java.util.*;

public class InterleaveQueue {

    public static void interleave(Queue<Integer> q) {

        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even");
            return;
        }

        int halfSize = q.size() / 2;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first half into stack
        for (int i = 0; i < halfSize; i++) {
            stack.push(q.remove());
        }

        // Step 2: Push stack elements back to queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move first half to rear
        for (int i = 0; i < halfSize; i++) {
            q.add(q.remove());
        }

        // Step 4: Push first half into stack again
        for (int i = 0; i < halfSize; i++) {
            stack.push(q.remove());
        }

        // Step 5: Interleave
        while (!stack.isEmpty()) {
            q.add(stack.pop());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        interleave(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}