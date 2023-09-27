import java.util.HashMap;

public class HashMapImplementation {
    public static void main(String[] args) {
        String testI = "bbca";
        String testII = "a green apple";
        System.out.println(firstRepeatedCharacter(testI));
        System.out.println(firstNonRepeatedCharacter(testII));
    }

    public static Character firstRepeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.get(a) != null) return a;
            map.put(s.charAt(i), i);
        }
        return null;
    }

    public static Character firstNonRepeatedCharacter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (map.containsKey(ch)) { //map contains this character, then we increment by 1
                int count = map.get(ch);
                map.put(ch, count + 1); }
            else map.put(ch, 1); //map doesn't contains this character, we put them in there first time and assign 1 to the count

            /*TODO exactly same function as above with a Ternary Operator----------
            int count = map.containsKey(ch) ? map.get(ch) : 0; //get the count values by checking if if exists, decide whether it's 0
            map.put(ch, count + 1); //increment the count by 1 since it appears */
        }
        for (Character ch : s.toCharArray())
            if (map.get(ch) == 1) return ch;

        return Character.MIN_VALUE;
    }

}
