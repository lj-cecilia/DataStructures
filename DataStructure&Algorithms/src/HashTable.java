import java.util.LinkedList;

public class HashTable {

    //the entry interface is the sub implementation of HashTable
    //basically it contains two things, the key and the value in the HashTable
    private class Entry{
        private int key;
        private String value;
        //constructor
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    //array of LinkedList is where we store everything, a lot of things
    private LinkedList<Entry>[] entries = new LinkedList[5];


    //put method
    //decide where to put the new value by the key inside the entry
    public void put(int key, String value) {
        int index = hash(key);
        //if there isn't such an LinkedList at the index in this array, we create a new LinkedList
        if (entries[index] == null) entries[index] = new LinkedList<>();

        //then add this entry object to the LinkedList at index position
        for (Entry littleEntry : entries[index]) {
            //if they have the same key, we need to update the value
            if (littleEntry.key == key) {
                littleEntry.value = value;
                return;//exit this method because done with updating the value
                //so we don't need to create a new entry and add to the LinekdList
            }
        }
        //LinkedList has no previous entry of same key, thus initiate one
        Entry entry = new Entry(key, value);
        //add it at the end of the LinkedList, the linkedList is presented as entries[index]
        //because entries is made of LinkedList contains entry
        entries[index].addLast(entry);
    }

    //get method
    //the key is actually used twice, first to determine the position of the LinkedList, second is the key in the entry
    public String get(int key) {
        //use key to locate the LinkedList
        int index = hash(key);
        LinkedList<Entry> targetList = entries[index];
        //linkedList might be null and get an exception, so here with the if statement we rule it out
        if (targetList != null) {
            //loop through the linkedList
            for (Entry littleEntry : targetList) {
                //use key to find the target entry pair that contains both the key and the value
                if (littleEntry.key == key) return littleEntry.value;
            }
        }
        return null;
    }

    //remove method
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> targetList = entries[index];
        //didn't find element in the linkedList at corresponding index, throw exception
        if (targetList == null) throw new IllegalStateException();

        //loop through the linkedList
        for (Entry littleEntry : targetList) {
            //use key to find the target entry pair that contains both the key and the value
            if (littleEntry.key == key) {
                targetList.remove(littleEntry);
                return;
            }
        }
        //didn't find entry at corresponding key, throw exception
        throw new IllegalStateException();
    }

    //private because it's implementation detail of the function put
    private int hash(int key) {
        //if the key is super large, we can still fit it in the entry array
        return key % entries.length;
    }

}
