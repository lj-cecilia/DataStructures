public class StackImplementation {
    public static void main(String[] args) {
        //test the stack class
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());


    }


}
