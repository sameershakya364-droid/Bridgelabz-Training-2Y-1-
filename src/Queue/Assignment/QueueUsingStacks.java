package src.Queue.Assignment;

import java.util.Stack;
import java.util.NoSuchElementException;

public class QueueUsingStacks {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    void enqueue(int value) {
        input.push(value);
    }

    int dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) output.push(input.pop());
        }
        if (output.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return output.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
    }
}
