public class HashTableImplementation {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.put(6, "A"); //index 1
        table.put(8, "B"); //index 3
        table.put(11, "C"); //index 1
        table.put(6, "A+"); //index 1
        table.remove(6);
        System.out.println(table.get(10));
    }
}
