import java.util.Arrays;

public class Stack {
    //we dont need constructor since we are base the stack on the array
    //array is reference type variable, so we can declare it directly inside the class
    int[] base = new int[5];
    int count = 0; //count variable keeps record of the numbers of objects stored

    //push method
    public void push(int value) {
        //if array is full, then stack overflow error
        if (count == base.length) throw new StackOverflowError();

        //else assign value to the index position
        base[count] = value;
        count++;
    }

    //pop method
    public int pop() {
        //if array is empty, throw illegal statement error
        if (count == 0) throw new IllegalStateException();

        //else return the value and set the index position as 0
        int value = base[count - 1];
        base[count - 1] = 0;
        count--;
        return value;
    }

    //peek method
    public int peek() {
        //if array is empty, throw illegal statement error
        if (count == 0) throw new IllegalStateException();

        //else return the value and set the index position as 0
        int value = base[count - 1];
        return value;
    }

    //isEmpty method
    public boolean isEmpty() {
        return count == 0; //if count is 0, then it's empty, else not empty
    }

    @Override
    public String toString() {
        int[] arrayContent = Arrays.copyOfRange(base, 0, count);
        return Arrays.toString(arrayContent);
    }




}
