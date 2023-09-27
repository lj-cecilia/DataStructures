public class ArrayQueueImplementation {
    public static void main(String[] agrs) {
        ArrayQueue aq = new  ArrayQueue(5);
        aq.enqueue(10);
        aq.enqueue(20);
        aq.enqueue(30);
        System.out.println(aq.dequeue());
        System.out.println(aq.dequeue());
        aq.enqueue(40);
        aq.enqueue(50);
        aq.enqueue(60);
        aq.enqueue(70);
        aq.dequeue();
        aq.enqueue(80);
        System.out.println(aq.isFull());
        System.out.println(aq);
    }
}
