import java.util.Stack;

public class StackDerivedFunction {
    //valid parenthesis function
    public static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch =='<') stack.push('>');
            else if (ch =='(') stack.push(')');
            else if (ch =='[') stack.push(']');
            else if (stack.pop() != ch) return false;
        }
        return stack.isEmpty();
    }

    //balanced string function
    public static boolean balancedString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (isLeft(ch))
                stack.push(ch);
            if (isRight(ch)) {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (bracketsMatch(top, ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private static boolean bracketsMatch(char left, char right) {
        return ((left == '>' && right != '<')
                || (left == ')' && right != '(')
                || (left == ']' && right != '[')
                || (left == '}' && right != '{'));
    }
    private static boolean isLeft(char ch) {
        return (ch == '<' || ch == '(' || ch == '[' || ch == '{');
    }
    private static boolean isRight(char ch) {
        return (ch == '>' || ch == ')' || ch == ']' || ch == '}');
    }

    public static void main(String[] args) {
        //test if the string contains valid parenthesis
        //TODO the valid parenthesis and balanced string has a difference
        //TODO implement both
        String a = "<(([]<>))>";
        System.out.print("Valid Parenthesis ");
        System.out.println(validParenthesis(a));
        System.out.print("Balanced String ");
        System.out.println(balancedString(a));

        //reverse a string with stack
        Stack<Character> stack = new Stack<>();
        String before = "香里七";
        for (char ch : before.toCharArray()) stack.push(ch);
        //StringBuffer is modifiable string
        //function append to add
        StringBuffer after = new StringBuffer();
        while (!stack.empty()) after.append(stack.pop());
        System.out.println(after);
    }
}
