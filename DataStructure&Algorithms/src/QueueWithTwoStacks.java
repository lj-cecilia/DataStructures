import java.util.Stack;

public class QueueWithTwoStacks {
    //use two stacks to mimic the First In First Out rule of queue
    private Stack<Integer> stack1 = new Stack<>(); //add the values to stack1
    private Stack<Integer> stack2 = new Stack<>(); //remove the values from stack2

    //enqueue method
    //O( 1 ) simple add
    public void enqueue(int value) {
        //push the value to stack1, easy
        stack1.push(value);
    }

    //dequeue method
    //need to transfer the values from one stack to another
    //O ( n )
    public int dequeue() {
        //if both stacks are empty means that the queue is empty
        if (stack1.isEmpty() && stack2.isEmpty()) throw new IllegalStateException();

        //when it comes to remove
        //if stack2 is empty, pop all the values from stack1 to stack2
        moveStack1ToStack2();

        //return whatever stack2 pop
        return stack2.pop();
    }

    //peek method
    public int peek() {
        //if both stacks are empty means that the queue is empty
        if (stack1.isEmpty() && stack2.isEmpty()) throw new IllegalStateException();

        //when it comes to remove
        //if stack2 is empty, pop all the values from stack1 to stack2
        moveStack1ToStack2();

        //return whatever stack2 peek
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
    }

    //TODO notice how both pop method and peek method share the codes
    //TODO both of them share important codes of transfer elements from stack1 to stack2
    //TODO if there are repeated codes in the methods, that could be a good time to do refactoring
}
