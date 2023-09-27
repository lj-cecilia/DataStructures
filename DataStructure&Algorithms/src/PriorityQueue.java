import java.util.Arrays;

public class PriorityQueue {
    private int[] base = new int[5];
    private int count = 0;

    //add method
    public void add(int value) {
        if (count == base.length) throw new IllegalStateException();
        int i;
        for (i = count - 1; i >= 0; i--) {
            //if greater than the value, then shift one left / upper
            if (base[i] > value) base[i + 1] = base[i];

            //then exit this shifting loop
            else break;
        }
        //we need to increment i value by one; FIXME but why???
        base[i + 1] = value;
        count++;
    }

    //remove method
    public int remove() {
        //when count is 0 and we further call remove, it's time to throw exception
        if (isEmpty()) throw new IllegalStateException();

        //since count is 1 greater than the index, we need count-1
        //then we need count = count - 1 because we remove an element
        //count - 1 ➡️ count = count - 1 ➡️ count-- ➡️ --count
        //in short, we want to decrement value by 1 and before return this value
        return base[--count];
    }

    //isEmpty method
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(base);
    }


}
