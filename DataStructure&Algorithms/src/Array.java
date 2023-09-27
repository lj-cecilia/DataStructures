public class Array {
    //initialize an array that can't be accessed outside this class
    private int[] items;

    //initialize an integer keep track of the spots that actually holds a value instead of the array size
    //int count is default 0, and we increment it every time we insert a new value
    private int count;

    //then in the constructor we actually define the array
    public Array(int length) {
        items = new int[length];
    }

    //loop through the array positions that hold a value(count)
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    //insert method
    public void insert(int value) {
        //if array is full, resize it
        if (count == items.length) {
            //create a new array twice of original size
            //copy all the elements to the new array
            //let the name items point to the new array
            int[] backup = new int[2 * items.length];
            for (int i = 0; i < count; i++) {
                backup[i] = items[i];
            }
            items = backup;
        }
        //if not full, then simply add the item after the last position that holds a value
        items[count] = value;
        count++;

    }

    //removeAt method
    public void removeAt(int index) {
        //check if index is valid, if not, throw an exception
        //if valid, then shift the items to the left for one position
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        //shift the elements after index by 1
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        //decrement the count by 1 since remove 1 element
        count--;
    }

    //indexOf method, runtime complexity O( n )
    public int indexOf(int value) {
        //if we find it, return the index of that value
        //if we couldn't find it, return -1
        for (int i = 0; i < count; i++) {
            if (items[i] == value) return i;
        }
        return -1;
    }


}
