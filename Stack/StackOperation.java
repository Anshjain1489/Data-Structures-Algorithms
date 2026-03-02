package dsa.Stack;

import java.util.Stack;

public class StackOperation {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            stack.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!stack.isEmpty()) {
            char curr = stack.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void stockSpan(int[] stock, int[] span) {
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for (int i = 1; i < stock.length; i++) {
            int currPrice = stock[i];
            while (!stack.isEmpty() && currPrice > stock[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHeight = stack.peek();
                span[i] = i - prevHeight;
            }
            stack.push(i);
        }
    }

    public static boolean isValid(String str){
        Stack <Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else{
                if (st.isEmpty()) {
                    return false;
                }
                if ((st.peek() == '(' && ch == ')')||(st.peek() == '{' && ch == '}')||(st.peek() == '[' && ch == ']')) {
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        pushAtBottom(stack, 0);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        String str = "anshjain";
        String result = reverseString(str);
        System.out.println(result);

        int[] stock = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stock.length];
        stockSpan(stock, span);
        for (int i : span) {
            System.out.print(i + " ");
        }
        System.out.println();
        int []arr = {3,7,5,2,4};
        int []nextGreater = new int[arr.length];
        Stack <Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }

        for (int i : nextGreater) {
            System.out.print(i+" ");
        }
        System.out.println();

        String brackets = "({})[]";
        System.out.println(isValid(brackets));
    }
}

// next Greater Right = index start with length-1
// next Greater left = index start with 0
// next Smaller Right = check >= or index start with length-1
// next Smaller left  = check >= or index start with 0
