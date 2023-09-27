public class PriorityQueueImplementation {
    public static void main(String[] args) {
        //test the PriorityQueue object
        //priorityQueue deal with the element with larger value
        PriorityQueue queue = new PriorityQueue();
        queue.add(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(6);
        System.out.println(queue);

        //remove the largest first because it prioritizes larger value
        while (!queue.isEmpty()) System.out.print(queue.remove() + " " );


    }
}
