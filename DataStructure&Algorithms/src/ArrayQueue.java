import java.util.Arrays;

public class ArrayQueue {
    private int[] base; //Queue is created based on the array
    private int Front = 0; //help navigate where to remove / dequeue
    private int Rear = 0; //help navigate where to add / enqueue
    private int count = 0; //count the numbers of elements stored, if = the size then full, if = 0 then empty

    //constructor
    public ArrayQueue (int size) {
        base = new int[size];
    }

    //enqueue method
    public void enqueue(int value) {
        //if the queue is full, you can't add more
        if (count == base.length) throw new IllegalStateException();

        //not full, then add new element at the back
        base[Rear] = value;
        Rear = (Rear + 1) % 5; //circular array so modulo operator to get remainder of the index divide by size
        count++; //update count
    }
    public int dequeue() {
        //if it's empty, you cant remove
        if (count == 0) throw new IllegalStateException();

        //not empty, then return the element at the front
        int returnValue = base[Front]; //store the value because next will update the index
        base[Front] = 0; //change the value to 0 as if it's not there
        Front = (Front + 1) % 5; //circular array with modulo operator
        count--; //update count
        return returnValue;
    }
    public int peek() {
        return base[Front];
    } //get a look of the value at the front
    public boolean isEmpty() {
        return count == 0;
    } //if count is 0
    public boolean isFull() {
        return count == base.length;
    } //if count is the size of array

    @Override
    public String toString() {
        return Arrays.toString(base);
    }

}
