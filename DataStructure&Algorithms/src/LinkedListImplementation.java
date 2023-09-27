import java.util.Arrays;

public class LinkedListImplementation {
    public static void main(String[] args) {
        //declare a new object can also be written as the following
        //since the java compiler will detect the type after the new keyword
        var variable = new LinkedList();
        LinkedList list = new LinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        //test the indexOf method, other values are contained in the list while 40 is not
        System.out.println(list.indexOf(30));
        //get -1 since we don't have 40 in our LinkedList list
        System.out.println(list.indexOf(40)); //return -1
        System.out.println(list.contains(40)); //return false
        System.out.println(list.shortVersionContains(10)); // a short smart method but also doing contains function

        //check to array method
        int[] array = list.toArray();
        for (int i: array) System.out.print(i + " "); //use enhanced for loop
        System.out.println();

        //test the getKthNodeFromTheEnd
        System.out.println("Get kth Node: " + list.getKthFromTheEnd(1));

        //check reverse method
        list.reverse();
        int[] a = list.toArray();
        System.out.println("Reversed: " + Arrays.toString(a));

        /*
        //test the removeLast and removeFirst method using debugger, and they are working just fine
        list.removeLast();
        list.removeFirst();
        list.removeFirst();
         */
    }
}
