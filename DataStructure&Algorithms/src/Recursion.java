public class Recursion{
    public static void main(String[] args) {
        System.out.println(Factorial(5));
    }

    public static int Factorial(int number) {
        //base case for recursion
        if (number == 0) return 1;

        return number * Factorial(number - 1);
    }
}
