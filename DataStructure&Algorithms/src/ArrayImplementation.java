public class ArrayImplementation {
    public static void main(String[] agrs) {
        Array numbers = new Array(1);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        numbers.removeAt(0);

        numbers.print();

    }
}
