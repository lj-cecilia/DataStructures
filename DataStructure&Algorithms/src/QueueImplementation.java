import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementation {
    //static method so can be used without instantiation
    public static void reverse(Queue<Integer> queue) {
        Stack stack = new Stack();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
    //use the regular queue and the QueueWithTwoStacks
    public static void main(String[] args) {
        //build a regular queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        //test the reverse method
        System.out.println("Original: " + queue);
        reverse(queue);
        System.out.println("Reversed: " + queue);


    }

}
