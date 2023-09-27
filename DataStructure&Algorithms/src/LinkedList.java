import java.util.NoSuchElementException;

public class LinkedList {
    //the node class is inside the linkedlist class because it's part of the linkedlist's basic implementation
    public class Node {
        private int value;
        private Node next;
        //constructor
        public Node(int value) {
            this.value = value;
        }
    }

    //two nodes that keeps track of the beginning and the end of the LinkedList
    private Node first;
    private Node last;
    private int size;

    //addLast method of LinkedList
    public void addLast(int value) {
        Node node = new Node(value);
        //check to see if the list is empty
        //if empty, set both the first and last node to the new node we created
        if (isEmpty())
            first = last = node;
        //if not empty, we set the last node's next pointer to this new node, link them together
        else {
            last.next = node;//先让最后一个node指向新nod，把他们串珠子一样连接起来
            last = node;//再把last node 改名update成新的node
        }
        size++;
    }

    //addFirst method of LinkedList
    public void addFirst(int value) {
        Node node = new Node(value);
        //check to see if the list is empty
        //if empty, set the first and last node to the new node we created
        if (isEmpty()) {
            first = last = node;
        }
        //if not empty, we set the node as the first node by making its next as the first, link them together
        else {
            node.next = first; //先让新的node指向firs，把node串在第一个珠子更前面
            first = node;//再把first node 改名update成新的node
        }
        size++;
    }

    //isEmpty method
    public boolean isEmpty() {
        /*if (first == null)
            return true;
        else return false;*/
        //简写成
        return first == null; //this is either true or false
    }

    //indexOf method of LinkedList
    public int indexOf(int targetValue) {
        int index = 0;
        Node current = first; //start from the first node and loop through the entire LinkedList
        while (current != null) {//check to see the LinkedList until reach the end
            if (current.value == targetValue) return index;
            //renew the pointer current to the next one in each iteration
            current = current.next;
            //update the index
            index++;
        }
        return -1;
    }

    //contains method of LinkedList
    public boolean contains(int targetValue) {
        if (isEmpty()) return false;

        Node current = first;
        while (current != null) {
            if (current.value == targetValue) return true;
            current = current.next;
        }
        return false;
    }

    //amazing shortened contains method using another written method
    public boolean shortVersionContains(int targetValue) {
        return indexOf(targetValue) != -1;//if the index of the value isn't -1, then we know the list contains it
    }

    //get previous node method
    public Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    //removeFrist method
    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    //removeLast method
    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        Node previous = getPrevious(last);
        previous.next = null;
        last = previous;
        size--;
    }

    //size method, O( 1 )
    public int size() {
        return size;
    }

    //convert LinkedList to array
    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while(current != null) {
            array[index] = current.value;
            index++;
            //above 2 lines can be abbreviated as array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    //reverse the LinkedList
    public void reverse() {
        if (size() == 0 || size() == 1) return;

        Node prev = first;
        Node current = first.next;
        while (current != null) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        last = first;
        first.next = null;
        first = prev;
    }

    //kth node from the end function in one pass, using two pointers
    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();

        Node a = first;
        Node b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            //if b reaches null, then b has traversed through the list
            //k value is larger than the size of the list, which is invalid
            if (b == null) throw new IllegalArgumentException();
        }
        while (b != last) { // b isn't the last node instead of isn't the null
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

}
