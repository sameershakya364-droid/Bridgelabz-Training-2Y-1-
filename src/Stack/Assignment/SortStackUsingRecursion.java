package src.Stack.Assignment;

import java.util.Stack;

public class SortStackUsingRecursion {
    static void insertSorted(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, value);
        stack.push(top);
    }

    static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int value = stack.pop();
        sort(stack);
        insertSorted(stack, value);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        sort(stack);
        System.out.println(stack);
    }
}
