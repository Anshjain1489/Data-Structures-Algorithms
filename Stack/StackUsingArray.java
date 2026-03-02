package dsa.Stack;

public class StackUsingArray {

    static class Stack {
        int[] arr;
        int top;
        int capacity;

        Stack(int size) {
            capacity = size;
            arr = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = data;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (isEmpty()) return -1;
            return arr[top];
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}